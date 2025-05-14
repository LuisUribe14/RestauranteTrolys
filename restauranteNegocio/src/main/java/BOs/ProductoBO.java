package BOs;

import DAOs.ProductoDAO;
import DTOs.ProductoIngredienteNuevoDTO;
import DTOs.ProductoIngredienteViejoDTO;
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
    
    /**
     * Regresa verdadero si el producto se registro con exito
     * 
     * @param productoNuevoDTO
     * @return
     * @throws NegocioException 
     */
    public boolean registrarProducto(ProductoNuevoDTO productoNuevoDTO) throws NegocioException {
        if (productoNuevoDTO.getEstado() == null) {
            throw new NegocioException("El estado no puede estar vacío.");
        }
        if (productoNuevoDTO.getIngredientes().isEmpty()) {
            throw new NegocioException("El Producto tiene que tener ingredientes.");
        }
        if (productoNuevoDTO.getNombre().isEmpty() || productoNuevoDTO.getNombre() == "") {
            throw new NegocioException("El nombre no puede estar vacío.");
        }
        if (productoNuevoDTO.getPrecio() == null || productoNuevoDTO.getPrecio() == 0.00) {
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
    
    /**
     * Regresa verdadero si se actualiza con exito.
     * 
     * @param productoViejoDTO
     * @return
     * @throws NegocioException 
     */
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
    
    /**
     * 
     * @return la lista de ProductoViejoDTO
     * @throws NegocioException 
     */
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
    
    /**
     * 
     * @param nombre
     * @param tipo
     * @return La lista de Productos sehun los filtros
     * @throws NegocioException 
     */
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
    
    /**
     * 
     * @return la lista de productos registrados
     * @throws NegocioException 
     */
    public List<ProductoViejoDTO> obtenerProductosRegistrados() throws NegocioException {
        List<ProductoViejoDTO> productosDTO = new ArrayList();
        try {
            List<Producto> productos = productoDAO.obtenerProductosRegistrados();
            
            for (Producto producto: productos) {
                ProductoViejoDTO productoDTO = ProductoMapper.toViejoDTO(producto);
                productosDTO.add(productoDTO);
            }
            
            return productosDTO;
        } catch(PersistenciaException e) {
            throw new NegocioException("Error al consultar Productos.");
        }
    }
    
    public List<ProductoIngredienteViejoDTO> obtenerProductosIngredientes(Long id) throws NegocioException {
        try {
            List<ProductoIngrediente> productosIngredientes = productoDAO.obtenerProductosIngredientes(id);
            List<ProductoIngredienteViejoDTO> productosIngredientesDTO = new ArrayList();
            
            for (ProductoIngrediente productosIngrediente : productosIngredientes) {
                productosIngredientesDTO.add(ProductoIngredienteMapper.toViejoDTO(productosIngrediente));
            }
            
            return productosIngredientesDTO;
        } catch(PersistenciaException e) {
            throw new NegocioException("No se pudo consultar la lista de ProductoIngrediente.");
        }
    }
    
    public boolean verificarExistenciaProducto(String nombre) throws NegocioException {
        if (nombre == null) {
            throw new NegocioException("El Nombre no puede estar vacío.");
        }
        
        try {
            Producto productoConsultado = productoDAO.obtenerProducto(nombre);
            if (productoConsultado == null) {
                return false;
            } else {
                return true;
            }
        } catch(PersistenciaException e) {
            throw new NegocioException("No se pudo consultar el Producto.");
        }
    }
    
    public List<ProductoViejoDTO> obtenerProductosDisponibles(String nombre, tipoProducto tipo) throws NegocioException {
        List<ProductoViejoDTO> productosDTO = new ArrayList();
        try {
            List<Producto> productos = productoDAO.obtenerProductosDisponibles(nombre, tipo);
            
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
