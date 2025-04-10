package DAOs;

import conexion.Conexion;
import entidades.Producto;
import static enums.estadoProducto.DISPONIBLE;
import enums.tipoProducto;
import exception.PersistenciaException;
import interfaces.IProductoDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

/**
 *
 * @author daniel
 */
public class ProductoDAO implements IProductoDAO{
    
    private static ProductoDAO productoDAO;
    
    private ProductoDAO() {
    }
    
    public static ProductoDAO getInstancia() {
        if (productoDAO == null) {
            productoDAO = new ProductoDAO();
        }
        return productoDAO;
    }

    @Override
    public Producto registrarProducto(Producto producto) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            em.persist(producto);
            em.getTransaction().commit();
            
            return producto;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al registrar Producto");
        } finally {
            em.close();
        }
    }

    @Override
    public boolean actualizarProducto(Producto producto) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            em.merge(producto);
            em.getTransaction().commit();
            
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al actualizar Producto");
        } finally {
            em.close();
        }
    }

    @Override
    public List<Producto> obtenerProductosDisponibles() throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            String jpql = "SELECT p FROM Producto p WHERE p.estado = :estado";
            TypedQuery query = em.createQuery(jpql, Producto.class);
            query.setParameter("estado", DISPONIBLE);
            
            return query.getResultList();
        } catch(Exception e) {
            throw new PersistenciaException("Error al consultar Productos");
        } finally {
            em.close();
        }
    }
    
    @Override
    public List<Producto> obtenerProductosFiltrados(String nombre, tipoProducto tipo) throws PersistenceException {
        EntityManager em = Conexion.crearConexion();
        try {
            String jpql = "SELECT p FROM Producto p "
                    + "WHERE (:nombre IS NULL OR p.nombre LIKE CONCAT(:nombre, '%')) "
                    + "AND (:tipo IS NULL OR p.tipo = :tipo)";
            TypedQuery query = em.createQuery(jpql, Producto.class);
            query.setParameter("nombre", nombre);
            query.setParameter("tipo", tipo);
            
            return query.getResultList();
        } catch(Exception e) {
            throw new PersistenceException("Error al consultar la Lista de Productos");
        } finally {
            em.close();
        }
    }
    
}