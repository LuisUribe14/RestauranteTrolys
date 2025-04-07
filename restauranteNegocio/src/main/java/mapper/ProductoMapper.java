package mapper;

import DTOs.ProductoNuevoDTO;
import DTOs.ProductoViejoDTO;
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
    
    public static Producto toEntity(ProductoViejoDTO productoViejoDTO) {
        if (productoViejoDTO == null) {
            return null;
        }
        return new Producto(
                productoViejoDTO.getId(),
                productoViejoDTO.getNombre(),
                productoViejoDTO.getPrecio(),
                productoViejoDTO.getTipo(),
                productoViejoDTO.getEstado()
        );
    }
    
    public static ProductoViejoDTO toViejoDTO(Producto producto) {
        if (producto == null) {
            return null;
        }
        return new ProductoViejoDTO(
                producto.getId(),
                producto.getNombre(),
                producto.getPrecio(),
                producto.getTipo(),
                producto.getEstado()
        );
    }
}
