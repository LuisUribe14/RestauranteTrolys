package DAOs;

import DTOs.MesaViejaDTO;
import conexion.Conexion;
import entidades.Mesa;
import exception.PersistenciaException;
import interfaces.IMesaDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

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

    /**
     * 
     * @param mesaDTO
     * @return regresa Verdadero si se agregaron las 20 mesas.
     * @throws PersistenciaException 
     */
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

    /**
     * 
     * @return La cantidad de mesas registradas.
     * @throws PersistenciaException 
     */
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
    
    /**
     * 
     * @return Una lista Mesa de las mesas registradas.
     * @throws PersistenciaException 
     */
    @Override
    public List<Mesa> obtenerMesas() throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            String jpql = "SELECT m FROM Mesa m";
            TypedQuery query = em.createQuery(jpql, Mesa.class);
            
            return query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener Mesas.");
        } finally {
            em.close();
        }
    }

}
