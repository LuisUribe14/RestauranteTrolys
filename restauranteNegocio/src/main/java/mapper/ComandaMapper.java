package mapper;

import DTOs.ComandaNuevaDTO;
import DTOs.ComandaViejaDTO;
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
    
    public static ComandaViejaDTO toViejoDTO(Comanda comanda) {
        if (comanda == null) {
            return null;
        }
        return new ComandaViejaDTO(
                comanda.getId(),
                comanda.getFolio(),
                comanda.getEstado(),
                comanda.getFechaYHora(),
                comanda.getTotalVenta(),
                ClienteFrecuenteMapper.toViejoDTO(comanda.getCliente()),
                MesaMapper.toViejoDTO(comanda.getMesa())
        );
    }
}
