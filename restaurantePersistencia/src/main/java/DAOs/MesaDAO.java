package DAOs;

import conexion.Conexion;
import entidades.Mesa;
import exception.PersistenciaException;
import interfaces.IMesaDAO;
import javax.persistence.EntityManager;

/**
 *
 * @author daniel
 */
public class MesaDAO implements IMesaDAO{
    
    public static MesaDAO mesaDAO;
    
    private MesaDAO() {
    }
    
    public static MesaDAO getInstancia() {
        if (mesaDAO == null) {
            mesaDAO = new MesaDAO();
        }
        return mesaDAO;
    }

    @Override
    public boolean registrarCantidadMesas(Mesa mesa) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();      
        try {
            em.getTransaction().begin();
            em.persist(mesa);
            em.getTransaction().commit();
            
            return true;
        } catch(Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al registrar Mesas");
        } finally {
            em.close();
        }
    }
}
