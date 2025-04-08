package mapper;

import DTOs.MesaViejaDTO;
import entidades.Mesa;

/**
 *
 * @author daniel
 */
public class MesaMapper {
    
    public static Mesa toEntity(MesaViejaDTO mesaViejaDTO) {
        if (mesaViejaDTO == null) {
            return null;
        }
        return new Mesa(
                mesaViejaDTO.getId(),
                mesaViejaDTO.getNumero()
        );
    }
    
    public static MesaViejaDTO toViejoDTO(Mesa mesa) {
        if (mesa == null) {
            return null;
        }
        return new MesaViejaDTO(
                mesa.getId(),
                mesa.getNumero()
        );
    }
}
