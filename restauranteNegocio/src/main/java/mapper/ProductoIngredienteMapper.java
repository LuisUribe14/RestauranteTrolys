package mapper;

import DTOs.ProductoIngredienteNuevoDTO;
import entidades.ProductoIngrediente;

/**
 *
 * @author daniel
 */
public class ProductoIngredienteMapper {
    
    public static ProductoIngrediente toEntity(ProductoIngredienteNuevoDTO productoIngredienteNuevoDTO) {
        if (productoIngredienteNuevoDTO == null) {
            return null;
        }
        return new ProductoIngrediente(
                productoIngredienteNuevoDTO.getCantidadRequerida(),
                ingredienteMapper.toEntity(productoIngredienteNuevoDTO.getIngrediente())
        );
    }
}
