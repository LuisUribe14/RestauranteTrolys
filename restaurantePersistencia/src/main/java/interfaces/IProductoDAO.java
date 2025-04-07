package interfaces;

import entidades.Producto;
import enums.estadoProducto;
import exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author daniel
 */
public interface IProductoDAO {
    
    public Producto registrarProducto(Producto producto) throws PersistenciaException;
    
    public boolean actualizarProducto(Producto producto) throws PersistenciaException;
    
    public List<Producto> obtenerTodos() throws PersistenciaException;
}