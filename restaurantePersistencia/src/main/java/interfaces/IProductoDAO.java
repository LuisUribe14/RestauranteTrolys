package interfaces;

import entidades.Producto;
import entidades.ProductoIngrediente;
import enums.tipoProducto;
import exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author daniel
 */
public interface IProductoDAO {
    
    public Producto registrarProducto(Producto producto) throws PersistenciaException;
    
    public boolean actualizarProducto(Producto producto) throws PersistenciaException;
    
    public List<Producto> obtenerProductosDisponibles() throws PersistenciaException;
    
    public List<Producto> obtenerProductosFiltrados(String nombre, tipoProducto tipo) throws PersistenciaException;
    
    public List<Producto> obtenerProductosRegistrados() throws PersistenciaException;
    
    public List<ProductoIngrediente> obtenerProductosIngredientes(Long id) throws PersistenciaException;
    
    public Producto obtenerProducto(String nombre) throws PersistenciaException;
    
    public List<Producto> obtenerProductosDisponibles(String nombre, tipoProducto tipo) throws PersistenciaException;
}