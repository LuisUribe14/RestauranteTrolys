package BOs;

import DAOs.ProductoDAO;
import DTOs.ProductoNuevoDTO;

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
    
    public ProductoNuevoDTO registrarProducto(ProductoNuevoDTO productoNuevoDTO) {
        return null;
    }
}
