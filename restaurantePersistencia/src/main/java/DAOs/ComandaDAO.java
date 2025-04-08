package DAOs;

import conexion.Conexion;
import entidades.Comanda;
import exception.PersistenciaException;
import interfaces.IComandaDAO;
import javax.persistence.EntityManager;

/**
 *
 * @author daniel
 */
public class ComandaDAO implements IComandaDAO{

    private static ComandaDAO comandaDAO;
    
    private ComandaDAO() {
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
            Conexion.cerrar();
        }
    }
    
}
