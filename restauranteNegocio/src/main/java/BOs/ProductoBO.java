package BOs;

import DAOs.ProductoDAO;
import DTOs.ProductoIngredienteNuevoDTO;
import DTOs.ProductoNuevoDTO;
import DTOs.ProductoViejoDTO;
import entidades.Producto;
import entidades.ProductoIngrediente;
import exception.NegocioException;
import exception.PersistenciaException;
import java.util.ArrayList;
import java.util.List;
import mapper.ProductoIngredienteMapper;
import mapper.ProductoMapper;

/**
 *
 * @author daniel
 */
public class ProductoBO {
    
    private ProductoDAO productoDAO = ProductoDAO.getInstancia();
    private static ProductoBO productoBO;

    private ProductoBO() {
    }
    
    public static ProductoBO getInstancia() {
        if (productoBO == null) {
            productoBO = new ProductoBO();
        }
        return productoBO;
    }
    
    public boolean registrarProducto(ProductoNuevoDTO productoNuevoDTO) throws NegocioException {
        if (productoNuevoDTO.getEstado() == null) {
            throw new NegocioException("El estado no puede estar vacío.");
        }
        if (productoNuevoDTO.getIngredientes().isEmpty()) {
            throw new NegocioException("El Producto tiene que tener ingredientes.");
        }
        if (productoNuevoDTO.getNombre() == null) {
            throw new NegocioException("El nombre no puede estar vacío.");
        }
        if (productoNuevoDTO.getPrecio() == null) {
            throw new NegocioException("El precio no puede estar vacío.");
        }
        if (productoNuevoDTO.getTipo() == null) {
            throw new NegocioException("El tipo no puede estar vacío.");
        }
        
        Producto producto = ProductoMapper.toEntity(productoNuevoDTO);
        
        List<ProductoIngredienteNuevoDTO> ingredientesDTO = productoNuevoDTO.getIngredientes();
        List<ProductoIngrediente> ingredientes = new ArrayList();
        
        for (ProductoIngredienteNuevoDTO ingredienteDTO : ingredientesDTO) {
            ProductoIngrediente ingrediente = ProductoIngredienteMapper.toEntity(ingredienteDTO);
            ingrediente.setProducto(producto);
            ingredientes.add(ingrediente);
        }
        
        producto.setIngredientes(ingredientes);
        
        try{
            Producto productoGuardado = ProductoDAO.getInstancia().registrarProducto(producto);
            
            if (productoGuardado.getId() == null) {
                return true;
            } else {
                return false;
            }
        } catch(PersistenciaException e) {
            throw new NegocioException("Error al registrar Producto.");
        }
    }
    
    public boolean actualizarEstado(ProductoViejoDTO productoViejoDTO) throws NegocioException {
        if (productoViejoDTO.getEstado() == null) {
             throw new NegocioException("Error, el estado no puede estar vacío.");
        }
        
        Producto producto = ProductoMapper.toEntity(productoViejoDTO);
        
        try {
            boolean exito = ProductoDAO.getInstancia().actualizarProducto(producto);
            
            if (exito) {
                return true;
            } else {
                return false;
            }
        } catch(PersistenciaException e) {
            throw new NegocioException("Error al actualizar Estado.");
        }
    }
    
    public List<ProductoViejoDTO> obtenerTodos() throws NegocioException {
        try {
            List<Producto> productos = ProductoDAO.getInstancia().obtenerTodos();
            List<ProductoViejoDTO> productosDTO = new ArrayList();
            
            for (Producto producto : productos) {
                productosDTO.add(ProductoMapper.toViejoDTO(producto));
            }
            
            return productosDTO;
        } catch(PersistenciaException e) {
            throw new NegocioException("Error al consultar los Productos");
        }
    }
}
