package mapper;

import DTOs.ProductoNuevoDTO;
import entidades.Producto;

/**
 *
 * @author daniel
 */
public class ProductoMapper {
    
    public static Producto toEntity(ProductoNuevoDTO productoNuevoDTO) {
        if (productoNuevoDTO == null) {
            return null;
        }
        return new Producto(
                productoNuevoDTO.getNombre(),
                productoNuevoDTO.getPrecio(),
                productoNuevoDTO.getTipo(),
                productoNuevoDTO.getEstado()
        );
    }
}
