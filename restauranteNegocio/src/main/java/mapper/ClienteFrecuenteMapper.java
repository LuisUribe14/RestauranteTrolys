/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapper;

import DTOs.ClienteFrecuenteDTO;
import entidades.Cliente;
import entidades.ClienteFrecuente;

/**
 *
 * @author multaslokas33
 */
public class ClienteFrecuenteMapper {

    public static ClienteFrecuenteDTO toClienteFrecuenteDTO(ClienteFrecuente cliente, Integer visitas, Double totalGastado, Integer puntos) {
        if (cliente == null) {
            return null;
        }

        String nombreCompleto = cliente.getNombre() + " "
                + cliente.getApellidoPaterno()
                + (cliente.getApellidoMaterno() != null ? " " + cliente.getApellidoMaterno() : "");

        return new ClienteFrecuenteDTO(
                nombreCompleto,
                cliente.getTelefono(),
                cliente.getCorreo(),
                cliente.getFechaRegistro(),
                visitas,
                totalGastado,
                puntos
        );
    }
}
