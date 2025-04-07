/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapper;

import DTOs.IngredienteViejoDTO;
import DTOs.ingredienteNuevoDTO;
import entidades.Ingrediente;

/**
 *
 * @author chris
 */
public class ingredienteMapper {
    
    // Convierte de DTO a Entidad para creación
    public static Ingrediente toEntity(ingredienteNuevoDTO dto) {
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setNombre(dto.getNombre());
        ingrediente.setUnidadMedida(dto.getUnidadMedida());
        ingrediente.setStock(dto.getStock());
        return ingrediente;
    }
    
    // Convierte un IngredienteViejoDTO a Ingrediente
    public static Ingrediente toEntity(IngredienteViejoDTO ingredienteViejoDTO) {
        if (ingredienteViejoDTO == null) {
            return null;
        }
        return new Ingrediente(
                ingredienteViejoDTO.getId(),
                ingredienteViejoDTO.getNombre(),
                ingredienteViejoDTO.getUnidadMedida(),
                ingredienteViejoDTO.getStock()
        );
    }
    
    // Convierte un Ingrediente a IngredienteViejoDTO
    public static IngredienteViejoDTO toViejoDTO(Ingrediente ingrediente) {
        if (ingrediente == null) {
            return null;
        }
        return new IngredienteViejoDTO(
                ingrediente.getId(),
                ingrediente.getNombre(),
                ingrediente.getUnidadMedida(),
                ingrediente.getStock()
        );
    }
}
