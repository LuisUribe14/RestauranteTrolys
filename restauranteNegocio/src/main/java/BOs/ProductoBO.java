package BOs;

import DAOs.ProductoDAO;
import DTOs.ProductoIngredienteNuevoDTO;
import DTOs.ProductoNuevoDTO;
import DTOs.ProductoViejoDTO;
import entidades.Producto;
import entidades.ProductoIngrediente;
import enums.tipoProducto;
import exception.NegocioException;
import exception.PersistenciaException;
import interfaces.IProductoDAO;
import java.util.ArrayList;
import java.util.List;
import mapper.ProductoIngredienteMapper;
import mapper.ProductoMapper;

/**
 *
 * @author daniel
 */
public class ProductoBO {
    
    private IProductoDAO productoDAO = ProductoDAO.getInstancia();
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
        for (ProductoIngredienteNuevoDTO ingrediente : productoNuevoDTO.getIngredientes()) {
            if (ingrediente.getCantidadRequerida() == null || ingrediente.getCantidadRequerida() == 0) {
                throw new NegocioException("Error, la cantidad no debe estar vacía.");
            }
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
            Producto productoGuardado = productoDAO.registrarProducto(producto);
            
            if (productoGuardado.getId() != null) {
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
            boolean exito = productoDAO.actualizarProducto(producto);
            
            if (exito) {
                return true;
            } else {
                return false;
            }
        } catch(PersistenciaException e) {
            throw new NegocioException("Error al actualizar Estado.");
        }
    }
    
    public List<ProductoViejoDTO> obtenerProductosDisponibles() throws NegocioException {
        try {
            List<Producto> productos = productoDAO.obtenerProductosDisponibles();
            List<ProductoViejoDTO> productosDTO = new ArrayList();
            
            for (Producto producto : productos) {
                productosDTO.add(ProductoMapper.toViejoDTO(producto));
            }
            
            return productosDTO;
        } catch(PersistenciaException e) {
            throw new NegocioException("Error al consultar los Productos");
        }
    }
    
    public List<ProductoViejoDTO> obtenerProductosFiltrados(String nombre, tipoProducto tipo) throws NegocioException {
        List<ProductoViejoDTO> productosDTO = new ArrayList();
        try {
            List<Producto> productos = productoDAO.obtenerProductosFiltrados(nombre, tipo);
            
            for (Producto producto: productos) {
                ProductoViejoDTO productoDTO = ProductoMapper.toViejoDTO(producto);
                productosDTO.add(productoDTO);
            }
            
            return productosDTO;
        } catch(PersistenciaException e) {
            throw new NegocioException("Error al consultar Productos.");
        }
    }
}
