package DAOs;

import DTOs.MesaViejaDTO;
import conexion.Conexion;
import entidades.Mesa;
import exception.PersistenciaException;
import interfaces.IMesaDAO;
import javax.persistence.EntityManager;

/**
 *
 * @author daniel
 */
public class MesaDAO implements IMesaDAO {

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
    public boolean registrarMesa(MesaViejaDTO mesaDTO) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();

            // Conversión de DTO a entidad
            Mesa mesa = new Mesa();
            mesa.setNumero(mesaDTO.getNumero());

            em.persist(mesa);
            em.getTransaction().commit();

            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al registrar mesa");
        } finally {
            em.close();
        }
    }

    @Override
    public int contarMesas() throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            Long total = em.createQuery("SELECT COUNT(m) FROM Mesa m", Long.class).getSingleResult();
            return total.intValue();
        } catch (Exception e) {
            throw new PersistenciaException("Error al contar mesas.");
        } finally {
            em.close();
        }
    }

}
