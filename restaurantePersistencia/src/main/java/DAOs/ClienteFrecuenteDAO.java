/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import ENcriptador.Encriptador;
import conexion.Conexion;
import entidades.ClienteFrecuente;
import enums.estadoComanda;
import exception.PersistenciaException;
import interfaces.IClienteFrecuente;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author multaslokas33
 */
public class ClienteFrecuenteDAO implements IClienteFrecuente {

    private static ClienteFrecuenteDAO clienteFrecuenteDAO;

    public ClienteFrecuenteDAO() {
    }

    public static ClienteFrecuenteDAO getInstancia() {
        if (clienteFrecuenteDAO == null) {
            clienteFrecuenteDAO = new ClienteFrecuenteDAO();
        }
        return clienteFrecuenteDAO;
    }

//    @Override
//    public void registrarComanda(Comanda comanda) throws PersistenciaException {
//        EntityManager em = Conexion.crearConexion();
//        try {
//            // iniciamos la transacción
//            em.getTransaction().begin();
//            // guardamos al cliente en la base de datos
//            em.persist(comanda);
//            // ya nomas confirmamos la transacción
//            em.getTransaction().commit();
//        } catch (Exception e) {
//            if (em.getTransaction().isActive()) {
//                // y en caso de error revertimos 
//                em.getTransaction().rollback();
//            }
//            throw new PersistenciaException("Error al registrar la comanda");
//        } finally {
//            Conexion.cerrarConexion(em);
//        }
//    }
    @Override
    // metodo para registrar un cliente frecuente en la base de datos
    public ClienteFrecuente registrarClienteFrecuente(ClienteFrecuente cliente) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();

            // Encriptamos el teléfono antes de persistir
            if (cliente.getTelefono() != null && !cliente.getTelefono().isEmpty()) {
                try {
                    String telefonoEncriptado = Encriptador.encrypt(cliente.getTelefono());
                    cliente.setTelefono(telefonoEncriptado);
                } catch (Exception e) {
                    throw new PersistenciaException("Error al encriptar el teléfono del cliente.", e);
                }
            }

            em.persist(cliente); // guardamos el cliente
            em.getTransaction().commit(); // y confirmamos la transacción

            return cliente;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo registrar el cliente frecuente.", e);
        } finally {
            Conexion.cerrarConexion(em);
        }
    }

    @Override
    // este metodo obtiene todos los clientes frecuentes de la base de datos (pero jamas lo use para algo solo lo tengo por si se necesta)
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
    // este metodo obtiene un cliente frecuente por su ID (tampoco lo use pero no estaria mal tenerlo)
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
    // aqui calculamos la cantidad de visitas en comandas realizadas por un cliente
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
    // aqui este metodo calcula el total de dinero gastado por el cliente con comandas entregadas
    public Double calcularTotalGastado(ClienteFrecuente cliente) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            String query = "SELECT SUM(c.totalVenta) FROM Comanda c "+ "WHERE c.cliente.id = :clienteId AND c.estado = :estado";

            Double totalGastado = em.createQuery(query, Double.class)
                    .setParameter("clienteId", cliente.getId())
                    .setParameter("estado", estadoComanda.ENTREGADO) 
                    .getSingleResult();

            return totalGastado != null ? totalGastado : 0.0;
        } catch (Exception e) {
            throw new PersistenciaException("Error al calcular el total gastado del cliente", e);
        } finally {
            Conexion.cerrarConexion(em);
        }
    }

    @Override
    // aqui calculamos los puntos del cliente con base en el total gastado (1 punto por cada 20 pesos)
    public Integer calcularPuntos(ClienteFrecuente cliente) throws PersistenciaException {
        double totalGastado = calcularTotalGastado(cliente);
        // cada 20 pesos equivalen a 1 punto
        int puntos = (int) (totalGastado / 20);
        return puntos;
    }

//    @Override
//    public boolean compararSiYaExisteTelefono(String telefonoEncriptado) {
//        EntityManager em = Conexion.crearConexion();
//        try {
//            TypedQuery<Long> query = em.createQuery(
//                    "SELECT COUNT(c) FROM Cliente c WHERE c.telefono = :telefono", Long.class);
//            query.setParameter("telefono", telefonoEncriptado);
//            return query.getSingleResult() > 0;
//        } finally {
//            Conexion.cerrarConexion(em);
//        }
//    }
    
    
    @Override
    // filtramos clientes frecuentes por nombre, teléfono ya encriptado aun que se desencripta para mostrarse en pantallas y correo
    public List<ClienteFrecuente> filtrarClientesFrecuentes(String nombre, String telefono, String correo) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        List<ClienteFrecuente> resultados = new ArrayList<>();

        try {
            StringBuilder jpql = new StringBuilder("SELECT c FROM ClienteFrecuente c WHERE 1=1");

            // Agregar condiciones dinámicas a la consulta
            if (nombre != null && nombre.trim().length() >= 2) {
                jpql.append(" AND (LOWER(c.nombre) LIKE :nombre OR LOWER(c.apellidoPaterno) LIKE :nombre OR LOWER(c.apellidoMaterno) LIKE :nombre)");
            }
            if (correo != null && correo.trim().length() >= 2) {
                jpql.append(" AND LOWER(c.correo) LIKE :correo");
            }
            if (telefono != null && !telefono.trim().isEmpty()) {
                jpql.append(" AND c.telefono = :telefono");
            }

            // Preparar la consulta
            TypedQuery<ClienteFrecuente> query = em.createQuery(jpql.toString(), ClienteFrecuente.class);

            // Establecer parámetros de la consulta
            if (nombre != null && nombre.trim().length() >= 2) {
                query.setParameter("nombre", nombre.toLowerCase() + "%");
            }
            if (correo != null && correo.trim().length() >= 2) {
                query.setParameter("correo", "%" + correo.toLowerCase() + "%");
            }
            if (telefono != null && !telefono.trim().isEmpty()) {
                try {
                    String telefonoEncriptado = Encriptador.encrypt(telefono.trim());
                    query.setParameter("telefono", telefonoEncriptado);
                } catch (Exception e) {
                    throw new PersistenciaException("Error al encriptar el número de teléfono.", e);
                }
            }

            // Ejecutar la consulta y obtener los resultados
            resultados = query.getResultList();

            // Procesar los resultados y realizar los cálculos necesarios
            for (ClienteFrecuente cliente : resultados) {
                // Desencriptar el teléfono del cliente
                try {
                    cliente.setTelefono(Encriptador.decrypt(cliente.getTelefono())); // Desencriptar el teléfono
                } catch (Exception e) {
                    cliente.setTelefono("Error al desencriptar");
                }

                // Calcular atributos derivados
                calcularTotalGastado(cliente);
                calcularVisitas(cliente);
                calcularPuntos(cliente);
            }

            return resultados;

        } catch (Exception e) {
            throw new PersistenciaException("Error al filtrar los clientes frecuentes.", e);
        } finally {
            Conexion.cerrarConexion(em);
        }
    }

    @Override
    // este es lo mismo que filtrar de clientes frecuentes pero ahora se cambia el parametro por visitas minimas
    public List<ClienteFrecuente> filtrarClientesPorNombreYVisitas(String nombre, Integer visitasMinimas) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        List<ClienteFrecuente> resultados = new ArrayList<>();

        try {
            StringBuilder jpql = new StringBuilder("SELECT c FROM ClienteFrecuente c WHERE 1=1");

            if (nombre != null && nombre.trim().length() >= 2) {
                jpql.append(" AND (LOWER(c.nombre) LIKE :nombre OR LOWER(c.apellidoPaterno) LIKE :nombre OR LOWER(c.apellidoMaterno) LIKE :nombre)");
            }

            TypedQuery<ClienteFrecuente> query = em.createQuery(jpql.toString(), ClienteFrecuente.class);

            if (nombre != null && nombre.trim().length() >= 2) {
                query.setParameter("nombre", nombre.toLowerCase() + "%"); // solo nombres que comiencen con ese valor
            }

            resultados = query.getResultList();

            // Calcular visitas y filtrar por visitas mínimas
            List<ClienteFrecuente> filtrados = new ArrayList<>();
            for (ClienteFrecuente cliente : resultados) {
                int visitas = calcularVisitas(cliente);
                if (visitasMinimas == null || visitas >= visitasMinimas) {
                    cliente.setVisitas(visitas);
                    cliente.setTotalGastado(calcularTotalGastado(cliente));
                    cliente.setPuntos(calcularPuntos(cliente));
                    cliente.setFechaUltimaComanda(obtenerFechaUltimaComanda(cliente));
                    filtrados.add(cliente);
                }
            }

            return filtrados;
        } catch (Exception e) {
            throw new PersistenciaException("Error al filtrar clientes por nombre y visitas.", e);
        } finally {
            Conexion.cerrarConexion(em);
        }
    }
    
    @Override
    // aqui obtenemos la fecha de la última comanda de un cliente esto nos sirve para el reporte
    public LocalDateTime obtenerFechaUltimaComanda(ClienteFrecuente cliente) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();

        try {
            TypedQuery<LocalDateTime> query = em.createQuery(
                    "SELECT MAX(c.fechaYHora) FROM Comanda c WHERE c.cliente.id = :clienteId", LocalDateTime.class);
            query.setParameter("clienteId", cliente.getId());

            return query.getSingleResult();
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener la fecha de la última comanda.", e);
        } finally {
            Conexion.cerrarConexion(em);
        }
    }

}