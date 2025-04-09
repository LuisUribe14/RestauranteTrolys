package interfaces;

import entidades.Producto;
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
}