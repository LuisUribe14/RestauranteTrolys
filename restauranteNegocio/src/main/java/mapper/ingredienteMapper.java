/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapper;

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
}
