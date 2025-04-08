package DAOs;

import conexion.Conexion;
import entidades.Comanda;
import exception.PersistenciaException;
import interfaces.IComandaDAO;
import javax.persistence.EntityManager;
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

    @Override
    public int obtenerCantidadComandas() throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            String jpql = "SELECT COUNT(c.id) FROM Comanda c";
            TypedQuery query = em.createQuery(jpql, Comanda.class);
            return query.getFirstResult();
        } catch(Exception e) {
            throw new PersistenciaException("Error al consultar cantidad de Comandas");
        } finally {
            em.close();
        }
    }

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
    
}
