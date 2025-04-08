package mapper;

import DTOs.ComandaNuevaDTO;
import entidades.Comanda;

/**
 *
 * @author daniel
 */
public class ComandaMapper {
    
    public static Comanda toEntity(ComandaNuevaDTO comandaNuevaDTO) {
        if (comandaNuevaDTO == null) {
            return null;
        }
        return new Comanda(
                comandaNuevaDTO.getEstado()
        );
    }
}
