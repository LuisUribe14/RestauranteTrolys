package DAOs;

import conexion.Conexion;
import entidades.ComandaProducto;
import entidades.Producto;
import entidades.ProductoIngrediente;
import static enums.estadoProducto.DISPONIBLE;
import enums.tipoProducto;
import exception.PersistenciaException;
import interfaces.IProductoDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author daniel
 */
public class ProductoDAO implements IProductoDAO{
    
    private static ProductoDAO productoDAO;
    
    private ProductoDAO() {
    }
    
    /**
     * Método para obtener el atributo del singleton
     * @return 
     */
    public static ProductoDAO getInstancia() {
        if (productoDAO == null) {
            productoDAO = new ProductoDAO();
        }
        return productoDAO;
    }

    /**
     * 
     * @param producto
     * @return El Producto registrado
     * @throws PersistenciaException 
     */
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
            System.out.println("Rollback en persist");
            throw new PersistenciaException("Error al registrar Producto");
        } finally {
            em.close();
        }
    }

    /**
     * 
     * @param producto
     * @return Verdadero si se actulizo, falso si no.
     * @throws PersistenciaException 
     */
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
            System.out.println("Rollback en merge");
            throw new PersistenciaException("Error al actualizar Producto");
        } finally {
            em.close();
        }
    }

    /**
     * 
     * @return Una lista de Productos cuyo estado es ACTIVO
     * @throws PersistenciaException 
     */
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
    
    /**
     * 
     * @param nombre
     * @param tipo
     * @return Una lista de Productos cuyos atributos sean nombre y tipo.
     * @throws PersistenciaException 
     */
    @Override
    public List<Producto> obtenerProductosFiltrados(String nombre, tipoProducto tipo) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            String jpql = "SELECT p FROM Producto p "
                    + "WHERE (:nombre IS NULL OR p.nombre LIKE CONCAT(:nombre, '%')) "
                    + "AND (:tipo IS NULL OR p.tipo = :tipo)";
            TypedQuery query = em.createQuery(jpql, Producto.class);
            query.setParameter("nombre", nombre);
            query.setParameter("tipo", tipo);
            query.setMaxResults(5);
            
            return query.getResultList();
        } catch(Exception e) {
            throw new PersistenciaException("Error al consultar la Lista de Productos");
        } finally {
            em.close();
        }
    }
    
    /**
     * 
     * @return Una lista de Productos en general
     * @throws PersistenciaException 
     */
    @Override
    public List<Producto> obtenerProductosRegistrados() throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            String jpql = "SELECT p FROM Producto P";
            TypedQuery query = em.createQuery(jpql, Producto.class);
            query.setMaxResults(5);
            
            return query.getResultList();
        } catch(Exception e) {
            throw new PersistenciaException("Error al consultar la Lista de Productos");
        } finally {
            em.close();
        }
    }
    
    @Override
    public List<ProductoIngrediente> obtenerProductosIngredientes(Long id) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            String jpql = "SELECT new entidades.ProductoIngrediente("
                    + "pi.id, pi.cantidadRequerida, pi.ingrediente) "
                    + "FROM ProductoIngrediente pi WHERE pi.producto.id = :id";
            TypedQuery query = em.createQuery(jpql, ProductoIngrediente.class);
            query.setParameter("id", id);
            
            return query.getResultList();
        } catch(Exception e) {
            throw new PersistenciaException("Error al consultar la Lista de ProductosIngredientes");
        } finally {
            em.close();
        }
    }
    
    @Override
    public Producto obtenerProducto(String nombre) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            String jpql = "SELECT pi FROM Producto pi WHERE "
                    + "pi.nombre = :nombre";
            TypedQuery<Producto> query = em.createQuery(jpql, Producto.class);
            query.setParameter("nombre", nombre);
            query.setMaxResults(1);
            List<Producto> producto = query.getResultList();
            
            if (producto.isEmpty()) {
                return null;
            } else {
                return producto.getFirst();
            }
        } catch(Exception e) {
            throw new PersistenciaException("Error al consultar Producto.");
        } finally {
            em.close();
        }
    }
    
    @Override
    public List<Producto> obtenerProductosDisponibles(String nombre, tipoProducto tipo) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            String jpql = "SELECT p FROM Producto p "
                    + "WHERE (:nombre IS NULL OR p.nombre LIKE CONCAT(:nombre, '%')) "
                    + "AND (:tipo IS NULL OR p.tipo = :tipo) "
                    + "AND p.estado LIKE 'DISPONIBLE'";
            TypedQuery query = em.createQuery(jpql, Producto.class);
            query.setParameter("nombre", nombre);
            query.setParameter("tipo", tipo);
            query.setMaxResults(5);
            
            return query.getResultList();
        } catch(Exception e) {
            throw new PersistenciaException("Error al consultar Productos.");
        } finally {
            em.close();
        }
    }
    
}