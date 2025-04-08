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
            return new MesaDAO();
        }
        return mesaDAO;
    }

    @Override
    public boolean registrarCantidadMesas(Integer cantidad) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        if (cantidad > 20) {
            throw new PersistenciaException("Error, la cantidad no puede ser mayor a 20");
        }
        
        try {
            em.getTransaction().begin();
            for (Integer i = 0; i < cantidad; i++) {
                Mesa mesa = new Mesa(i);
                em.persist(i);
            }
            em.getTransaction().commit();
            
            return true;
        } catch(Exception e) {
            throw new PersistenciaException("Error al registrar Mesas");
        } finally {
            Conexion.cerrar();
        }
    }
}
