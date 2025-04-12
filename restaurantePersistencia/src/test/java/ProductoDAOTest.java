
import DAOs.ProductoDAO;
import conexion.Conexion;
import entidades.Producto;
import enums.estadoProducto;
import enums.tipoProducto;
import exception.PersistenciaException;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author daniel
 */
public class ProductoDAOTest {
    ProductoDAO productoDAO = ProductoDAO.getInstancia();
    
    @Test
    public void registrarProducto() throws PersistenciaException {
        Producto producto = new Producto("Helado", 20.00, tipoProducto.POSTRE, estadoProducto.DISPONIBLE);
        Producto productoGuardado = productoDAO.registrarProducto(producto);  
        assertTrue(productoGuardado.getId() != null, "El id debería ser diferente de null.");
    }
    
    @Test
    public void actualizarProducto() throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        
        Producto producto = em.find(Producto.class, 1L);
        producto.setEstado(estadoProducto.NO_DISPONIBLE);
        
        boolean exito = ProductoDAO.getInstancia().actualizarProducto(producto);
        
        assertTrue(exito == true,"estadoProducto debería ser diferente de estadoProductoGuardado.");
    }
    
    @Test
    public void obtenerProductosDisponibles() throws PersistenciaException {
        List<Producto> productos = productoDAO.obtenerProductosDisponibles();
        assertTrue(productos != null, "La lista debería ser diferente de null");
    }
    
    @Test
    public void obtenerProductosFiltrados() throws PersistenciaException {
        List<Producto> productos = productoDAO.obtenerProductosFiltrados(null, null);
        assertTrue(productos != null, "La lista debería ser diferente de null");
    }
    
    @Test
    public void obtenerProductosFiltrados_DatosNoNulos() throws PersistenciaException {
        List<Producto> productos = productoDAO.obtenerProductosFiltrados("", tipoProducto.PLATILLO);
        assertTrue(productos != null, "La lista debería ser diferente de null");
    }

//     TODO add test methods here.
//     The methods must be annotated with annotation @Test. For example:
//    
//     @Test
//     public void hello() {}
}
