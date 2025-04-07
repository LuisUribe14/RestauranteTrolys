/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import conexion.Conexion;
import entidades.ClienteFrecuente;
import entidades.Comanda;
import exception.PersistenciaException;
import interfaces.IClienteFrecuente;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author multaslokas33
 */
public class ClienteFrecuenteDAO implements IClienteFrecuente {

    @Override
    public void registrarComanda(Comanda comanda) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            // iniciamos la transacción
            em.getTransaction().begin();
            // guardamos al cliente en la base de datos
            em.persist(comanda);
            // ya nomas confirmamos la transacción
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                // y en caso de error revertimos 
                em.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al registrar la comanda");
        } finally {
            Conexion.cerrarConexion(em);
        }
    }
    
    @Override
    public ClienteFrecuente registrarClienteFrecuente(ClienteFrecuente cliente) throws PersistenciaException {
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
            throw new PersistenciaException("Error al registrar el cliente frecuente");
        } finally {
            Conexion.cerrarConexion(em);
        }
        return cliente;
    }

    @Override
    public List<ClienteFrecuente> filtrarClientesFrecuentes(String nombre, String correo, String telefono) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        List<ClienteFrecuente> resultados = new ArrayList<>();

        try {
            StringBuilder jpql = new StringBuilder("SELECT c FROM ClienteFrecuente c WHERE 1=1");

            if (nombre != null && !nombre.trim().isEmpty()) {
                jpql.append(" AND LOWER(CONCAT(c.nombre, ' ', c.apellidoPaterno, ' ', COALESCE(c.apellidoMaterno, ''))) LIKE :nombre");
            }
            if (correo != null && !correo.trim().isEmpty()) {
                jpql.append(" AND LOWER(c.correo) LIKE :correo");
            }
            if (telefono != null && !telefono.trim().isEmpty()) {
                jpql.append(" AND c.telefono LIKE :telefono");
            }

            TypedQuery<ClienteFrecuente> query = em.createQuery(jpql.toString(), ClienteFrecuente.class);

            if (nombre != null && !nombre.trim().isEmpty()) {
                query.setParameter("nombre", "%" + nombre.toLowerCase() + "%");
            }
            if (correo != null && !correo.trim().isEmpty()) {
                query.setParameter("correo", "%" + correo.toLowerCase() + "%");
            }
            if (telefono != null && !telefono.trim().isEmpty()) {
                query.setParameter("telefono", "%" + telefono + "%");
            }

            resultados = query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("No se encontro ningun cliente con estos datos", e);
        } finally {
            Conexion.cerrarConexion(em);
        }

        return resultados;
    }

    @Override
    public List<ClienteFrecuente> obtenerTodosLosClientesFrecuentes() throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            return em.createQuery("SELECT c FROM ClienteFrecuente c", ClienteFrecuente.class)
                    .getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener todos los clientes frecuentes", e);
        } finally {
            Conexion.cerrarConexion(em);
        }
    }

    @Override
    public ClienteFrecuente obtenerClienteFrecuentePorId(Long id) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            return em.find(ClienteFrecuente.class, id);
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener al cliente frecuente", e);
        } finally {
            Conexion.cerrarConexion(em);
        }
    }

    @Override
        public Integer calcularVisitas(ClienteFrecuente cliente) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            String query = "SELECT COUNT(c) FROM Comanda c WHERE c.cliente.id = :clienteId";
            Long visitas = em.createQuery(query, Long.class)
                    .setParameter("clienteId", cliente.getId())
                    .getSingleResult();
            return visitas.intValue();
        } catch (Exception e) {
            throw new PersistenciaException("Error al calcular las visitas del cliente", e);
        } finally {
            Conexion.cerrarConexion(em);
        }
    }

    @Override
    public Double calcularTotalGastado(ClienteFrecuente cliente) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            String query = "SELECT SUM(c.totalVenta) FROM Comanda c WHERE c.cliente.id = :clienteId";
            Double totalGastado = em.createQuery(query, Double.class)
                    .setParameter("clienteId", cliente.getId())
                    .getSingleResult();
            return totalGastado != null ? totalGastado : 0.0;
        } catch (Exception e) {
            throw new PersistenciaException("Error al calcular el total gastado del cliente", e);
        } finally {
            Conexion.cerrarConexion(em);
        }
    }

    @Override
    public Integer calcularPuntos(ClienteFrecuente cliente) throws PersistenciaException {
        double totalGastado = calcularTotalGastado(cliente);
        // cada 20 pesos equivalen a 1 punto
        int puntos = (int) (totalGastado / 20);
        return puntos;
    }
}
