///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package mapper;
//
//import DTOs.ClienteDTO;
//import DTOs.ClienteFrecuenteDTO;
//import entidades.Cliente;
//import entidades.ClienteFrecuente;
//
///**
// *
// * @author multaslokas33
// */
//public class ClienteFrecuenteMapper extends ClienteMapper {
//
//    public ClienteFrecuenteDTO toDTO(ClienteFrecuente clienteFrecuente) {
//        if (clienteFrecuente == null) {
//            return null;
//        }
//
//        ClienteDTO clienteDTO = new ClienteDTO(
//                clienteFrecuente.getId(),
//                clienteFrecuente.getNombre(),
//                clienteFrecuente.getApellidoPaterno(),
//                clienteFrecuente.getApellidoMaterno(),
//                clienteFrecuente.getTelefono(),
//                clienteFrecuente.getCorreo(),
//                clienteFrecuente.getFechaRegistro(),
//                clienteFrecuente.getComandas()
//        );
//
//        return new ClienteFrecuenteDTO(
//                clienteFrecuente.getVisitas(),
//                clienteFrecuente.getPuntos(),
//                clienteFrecuente.getTotalGastado(),
//                clienteDTO.getId(),
//                clienteDTO.getNombre(),
//                clienteDTO.getApellidoPaterno(),
//                clienteDTO.getApellidoMaterno(),
//                clienteDTO.getTelefono(),
//                clienteDTO.getCorreo(),
//                clienteDTO.getFechaRegistro(),
//                clienteDTO.getComandas()
//        );
//    }
//
//    public ClienteFrecuente toEntity(ClienteFrecuenteDTO clienteFrecuenteDTO) {
//        if (clienteFrecuenteDTO == null) {
//            return null;
//        }
//
//        // Crea el Cliente a partir del DTO
//        Cliente cliente = new Cliente();
//        cliente.setId(clienteFrecuenteDTO.getId());
//        cliente.setNombre(clienteFrecuenteDTO.getNombre());
//        cliente.setApellidoPaterno(clienteFrecuenteDTO.getApellidoPaterno());
//        cliente.setApellidoMaterno(clienteFrecuenteDTO.getApellidoMaterno());
//        cliente.setTelefono(clienteFrecuenteDTO.getTelefono());
//        cliente.setCorreo(clienteFrecuenteDTO.getCorreo());
//        cliente.setFechaRegistro(clienteFrecuenteDTO.getFechaRegistro());
//        cliente.setComandas(clienteFrecuenteDTO.getComandas());
//
//        // Crea el ClienteFrecuente y asigna los valores
//        ClienteFrecuente clienteFrecuente = new ClienteFrecuente();
//        clienteFrecuente.setVisitas(clienteFrecuenteDTO.getVisitas() != null ? clienteFrecuenteDTO.getVisitas() : 0);
//        clienteFrecuente.setPuntos(clienteFrecuenteDTO.getPuntos() != null ? clienteFrecuenteDTO.getPuntos() : 0);
//        clienteFrecuente.setTotalGastado(clienteFrecuenteDTO.getTotalGastado() != null ? clienteFrecuenteDTO.getTotalGastado() : 0.0);
//
//        // Asigna todos los atributos del Cliente al ClienteFrecuente
//        clienteFrecuente.setId(cliente.getId());
//        clienteFrecuente.setNombre(cliente.getNombre());
//        clienteFrecuente.setApellidoPaterno(cliente.getApellidoPaterno());
//        clienteFrecuente.setApellidoMaterno(cliente.getApellidoMaterno());
//        clienteFrecuente.setTelefono(cliente.getTelefono());
//        clienteFrecuente.setCorreo(cliente.getCorreo());
//        clienteFrecuente.setFechaRegistro(cliente.getFechaRegistro());
//        clienteFrecuente.setComandas(cliente.getComandas());
//
//        return clienteFrecuente;
//    }
//}
