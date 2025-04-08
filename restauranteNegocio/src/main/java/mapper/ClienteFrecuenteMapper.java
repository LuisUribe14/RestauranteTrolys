/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapper;

import DTOs.ClienteFrecuenteDTO;
import DTOs.ClienteFrecuenteViejoDTO;
import entidades.Cliente;
import entidades.ClienteFrecuente;

/**
 *
 * @author multaslokas33
 */
public class ClienteFrecuenteMapper {

    public static ClienteFrecuenteDTO toDTO(ClienteFrecuente clienteFrecuente) {
        if (clienteFrecuente == null) {
            return null;
        }

        String nombreCompleto = clienteFrecuente.getNombreCompleto();

        return new ClienteFrecuenteDTO(
                nombreCompleto, 
                clienteFrecuente.getTelefono(),
                clienteFrecuente.getCorreo(),
                clienteFrecuente.getFechaRegistro(),
                clienteFrecuente.getVisitas(),
                clienteFrecuente.getTotalGastado(),
                clienteFrecuente.getPuntos()
        );
    }
    
    public static ClienteFrecuente toEntity(ClienteFrecuenteDTO dto) {
        if (dto == null) {
            return null;
        }

        ClienteFrecuente clienteFrecuente = new ClienteFrecuente();

        // Aquí asignamos los valores del DTO a la entidad
        String[] nombreParts = dto.getNombreCompleto().split(" ");

        clienteFrecuente.setNombre(nombreParts[0]);
        clienteFrecuente.setApellidoPaterno(nombreParts.length > 1 ? nombreParts[1] : "");
        clienteFrecuente.setApellidoMaterno(nombreParts.length > 2 ? nombreParts[2] : null);

        clienteFrecuente.setTelefono(dto.getTelefono());
        clienteFrecuente.setCorreo(dto.getCorreo());
        clienteFrecuente.setFechaRegistro(dto.getFechaRegistro());
        clienteFrecuente.setVisitas(dto.getVisitas());
        clienteFrecuente.setTotalGastado(dto.getTotalGastado());
        clienteFrecuente.setPuntos(dto.getPuntos());

        return clienteFrecuente;
    }
    
    public static ClienteFrecuente toEntity(ClienteFrecuenteViejoDTO clienteFrecuenteViejoDTO) {
        if (clienteFrecuenteViejoDTO == null) {
            return null;
        }
        return new ClienteFrecuente(
                clienteFrecuenteViejoDTO.getId(),
                clienteFrecuenteViejoDTO.getNombre(),
                clienteFrecuenteViejoDTO.getApellidoPaterno(),
                clienteFrecuenteViejoDTO.getApellidoMaterno(),
                clienteFrecuenteViejoDTO.getTelefono(),
                clienteFrecuenteViejoDTO.getCorreo(),
                clienteFrecuenteViejoDTO.getFechaRegistro()
        );
    }
}
