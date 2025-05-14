package mapper;

import DTOs.ProductoIngredienteNuevoDTO;
import DTOs.ProductoIngredienteViejoDTO;
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
    
    public static ProductoIngredienteViejoDTO toViejoDTO(ProductoIngrediente productoIngrediente) {
        if (productoIngrediente == null) {
            return null;
        }
        return new ProductoIngredienteViejoDTO(
                productoIngrediente.getId(),
                productoIngrediente.getCantidadRequerida(),
                ingredienteMapper.toViejoDTO(productoIngrediente.getIngrediente())
        );
    }
}
