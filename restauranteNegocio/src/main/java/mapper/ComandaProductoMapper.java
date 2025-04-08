package mapper;

import DTOs.ComandaProductoNuevaDTO;
import entidades.ComandaProducto;

/**
 *
 * @author daniel
 */
public class ComandaProductoMapper {
    
    public static ComandaProducto toEntity(ComandaProductoNuevaDTO comandaProductoNuevaDTO) {
        if (comandaProductoNuevaDTO == null) {
            return null;
        }
        return new ComandaProducto(
                comandaProductoNuevaDTO.getCantidadRequerida(),
                comandaProductoNuevaDTO.getPrecioProducto(),
                comandaProductoNuevaDTO.getComentario()
        );
    }
}
