package DAOs;

import conexion.Conexion;
import entidades.Comanda;
import entidades.ComandaProducto;
import enums.estadoComanda;
import exception.PersistenciaException;
import interfaces.IComandaDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

/**
 *
 * @author daniel
 */
public class ComandaDAO implements IComandaDAO{

    private static ComandaDAO comandaDAO;
    
    public ComandaDAO() {
    }
    
    public static ComandaDAO getInstancia() {
        if (comandaDAO == null) {
            comandaDAO = new ComandaDAO();
        }
        return comandaDAO;
    }
    
    /**
     * 
     * @param comanda
     * @return Regresa la Comanda persistida
     * @throws PersistenciaException 
     */
    @Override
    public Comanda registrarComanda(Comanda comanda) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            em.persist(comanda);
            em.getTransaction().commit();
            
            return comanda;
        } catch(Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Errror al registrar Comanda");
        } finally {
            em.close();
        }
    }

    /**
     * 
     * @return Regresa el número de comandas registradas
     * @throws PersistenciaException 
     */
    @Override
    public Long obtenerCantidadComandas() throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            String jpql = "SELECT COUNT(c.id) FROM Comanda c";
            TypedQuery<Long> query = em.createQuery(jpql, Long.class);
            return query.getSingleResult();
        } catch(Exception e) {
            throw new PersistenciaException("Error al consultar cantidad de Comandas");
        } finally {
            em.close();
        }
    }

    /**
     * 
     * @param comanda
     * @return Regresa True si se actualiza, False si no.
     * @throws PersistenciaException 
     */
    @Override
    public boolean actualizarComanda(Comanda comanda) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            em.merge(comanda);
            em.getTransaction().commit();
            
            return true;
        } catch(Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Errror al actualizar Comanda");
        } finally {
            em.close();
        }
    }
    
    /**
     * 
     * @param estado
     * @return Regresa una lista de Comandas segun su estado.
     * @throws PersistenciaException 
     */
    @Override
    public List<Comanda> obtenerComandasPorEstado(estadoComanda estado) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            String jpql = "SELECT c FROM Comanda c WHERE c.estado = :estado";
            TypedQuery query = em.createQuery(jpql, Comanda.class);
            query.setParameter("estado", estado);
            
            return query.getResultList();
        } catch(Exception e) {
            throw new PersistenciaException("Error al consultar las Comandas.");
        } finally {
            em.close();
        }
    }
    
    public List<ComandaProducto> obtenerComandasProductosPorIdComanda(Long idComanda) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            String jpql = "SELECT cp FROM ComandaProducto cp WHERE cp.comanda.id = :id";
            TypedQuery query = em.createQuery(jpql, ComandaProducto.class);
            query.setParameter("id", idComanda);
            
            return query.getResultList();
        } catch(Exception e) {
            throw new PersistenciaException("No se pudo consultar la lista de ComandaProducto.");
        } finally {
            em.close();
        }
    }
    
    public boolean removerComandaProducto(ComandaProducto comandaProducto) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            em.remove(comandaProducto);
            em.getTransaction().commit();
            
            return true;
        } catch(Exception e) {
            throw new PersistenciaException("");
        } finally {
            em.close();
        }
    }
    
}
