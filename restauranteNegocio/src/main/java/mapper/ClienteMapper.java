/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapper;

import DTOs.ClienteDTO;
import entidades.Cliente;

/**
 *
 * @author multaslokas33
 */
public class ClienteMapper {

    public ClienteDTO toDTO(Cliente cliente) {
        if (cliente == null) {
            return null;
        }

        return new ClienteDTO(
                cliente.getId(),
                cliente.getNombre(),
                cliente.getApellidoPaterno(),
                cliente.getApellidoMaterno(),
                cliente.getTelefono(),
                cliente.getCorreo(),
                cliente.getFechaRegistro(),
                cliente.getComandas()
        );
    }

    public Cliente toEntity(ClienteDTO clienteDTO) {
        if (clienteDTO == null) {
            return null;
        }

        Cliente cliente = new Cliente(
                clienteDTO.getId(),
                clienteDTO.getNombre(),
                clienteDTO.getApellidoPaterno(),
                clienteDTO.getApellidoMaterno(),
                clienteDTO.getTelefono(),
                clienteDTO.getCorreo(),
                clienteDTO.getFechaRegistro(),
                clienteDTO.getComandas()
        );

        return cliente;
    }
}
