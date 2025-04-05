/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import conexion.Conexion;
import entidades.clientesFrecuentes;
import exception.PersistenciaException;
import interfaces.IClienteFrecuente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author multaslokas33
 */
public class ClienteFrecuenteDAO implements IClienteFrecuente {

    private static ClienteFrecuenteDAO icd;

    private ClienteFrecuenteDAO() {
    }

    public static ClienteFrecuenteDAO getInstancia() {
        if (icd == null) {
            icd = new ClienteFrecuenteDAO();
        }
        return icd;
    }

    @Override
    public void registrarClienteFrecuente(clientesFrecuentes cliente) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();

        try {
            // iniciamos la transacción
            em.getTransaction().begin();
            // guardamos al cliente en la base de datos
            em.persist(cliente);
            // ya nomas confirmamos la transacción
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                // y en caso de error revertimos 
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("No se pudo registrar al cliente");
        } finally {
            em.close();
        }
    }

    @Override
    public List<clientesFrecuentes> buscarClientesFrecuentes(String nombre, String telefono, String correo) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            StringBuilder jpql = new StringBuilder("SELECT c FROM Cliente c WHERE 1=1 ");

            if (nombre != null && !nombre.trim().isEmpty()) {
                jpql.append("AND LOWER(CONCAT(c.nombre, ' ', c.apellidoPaterno, ' ', c.apellidoMaterno)) LIKE :nombre ");
            }
            if (telefono != null && !telefono.trim().isEmpty()) {
                jpql.append("AND LOWER(c.telefono) LIKE :telefono ");
            }
            if (correo != null && !correo.trim().isEmpty()) {
                jpql.append("AND LOWER(c.correo) LIKE :correo ");
            }

            TypedQuery<clientesFrecuentes> query = em.createQuery(jpql.toString(), clientesFrecuentes.class);

            if (nombre != null && !nombre.trim().isEmpty()) {
                query.setParameter("nombre", "%" + nombre.toLowerCase() + "%");
            }
            if (telefono != null && !telefono.trim().isEmpty()) {
                query.setParameter("telefono", "%" + telefono.toLowerCase() + "%");
            }
            if (correo != null && !correo.trim().isEmpty()) {
                query.setParameter("correo", "%" + correo.toLowerCase() + "%");
            }

            return query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar clientes por campos", e);
        } finally {
            em.close();
        }
    }

    @Override
    public List<clientesFrecuentes> obtenerTodosLosClientesFrecuentes() throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            // creamos una consulta para obtener todos los clientes frecuentes
            String jpql = "SELECT c FROM clientesFrecuentes c";
            TypedQuery<clientesFrecuentes> query = em.createQuery(jpql, clientesFrecuentes.class);

            // ejecutamos la consulta para que asi devuelva un resultado
            return query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener todos los clientes frecuentes", e);
        } finally {
            em.close();
        }
    }

    @Override
    public int calcularVisitas(Long clienteId) {
        EntityManager em = Conexion.crearConexion();
        String query = "SELECT COUNT(c) FROM Comanda c WHERE c.cliente.id = :clienteId";
        Long visitas = em.createQuery(query, Long.class)
                .setParameter("clienteId", clienteId)
                .getSingleResult();
        em.close();
        return visitas.intValue();
    }

    @Override
    public double calcularTotalGastado(Long clienteId) {
        EntityManager em = Conexion.crearConexion();
        //defino la consulta y utilizo el SUM para sumar todos los valores del total de venta de las comandas del cliete
        String query = "SELECT SUM(c.totalVenta) FROM Comanda c WHERE c.cliente.id = :clienteId";
        //aqui creo y ejecuto la consulta
        Double totalGastado = em.createQuery(query, Double.class)
                .setParameter("clienteId", clienteId)
                .getSingleResult();
        em.close();
        //si el cliente no tiene comandas o no encontramos resultados  retornamos 0.0 como resultado
        return totalGastado != null ? totalGastado : 0.0;
    }

    @Override
    public int calcularPuntos(Long clienteId) {
        double totalGastado = calcularTotalGastado(clienteId);
        // cada 20 pesos equivalen a 1 punto
        int puntos = (int) (totalGastado / 20);  
        return puntos;
    }
}