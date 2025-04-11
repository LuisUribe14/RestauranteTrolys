/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import DAOs.ClienteFrecuenteDAO;
import DTOs.ClienteFrecuenteDTO;
import entidades.ClienteFrecuente;
import exception.NegocioException;
import exception.PersistenciaException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import mapper.ClienteFrecuenteMapper;

/**
 *
 * @author multaslokas33
 */
public class ClienteFrecuenteBO {

    private static ClienteFrecuenteBO clienteFrecuenteBO;
    private final ClienteFrecuenteDAO clienteFrecuenteDAO;
    private final ClienteFrecuenteMapper clienteFrecuenteMapper;

    ClienteFrecuenteBO() {
        this.clienteFrecuenteDAO = ClienteFrecuenteDAO.getInstancia();
        this.clienteFrecuenteMapper = new ClienteFrecuenteMapper();
    }

    public static ClienteFrecuenteBO getInstancia() {
        if (clienteFrecuenteBO == null) {
            clienteFrecuenteBO = new ClienteFrecuenteBO();
        }
        return clienteFrecuenteBO;
    }

    public ClienteFrecuenteDTO registrarClienteFrecuente(ClienteFrecuenteDTO clienteDTO) throws PersistenciaException, NegocioException {

        if (clienteDTO == null) {
            throw new NegocioException("El cliente no puede ser nulo.");
        }

        if (clienteDTO.getNombre() == null || clienteDTO.getNombre().trim().isEmpty()) {
            throw new NegocioException("El nombre es obligatorio.");
        }

        String nombre = clienteDTO.getNombre().trim();

        if (!nombre.matches("^[a-zA-Z]+$")) {
            throw new NegocioException("El nombre solo debe contener letras.");
        }

        if (nombre.length() > 100) {
            throw new NegocioException("El nombre no puede tener más de 100 caracteres.");
        }

        if (clienteDTO.getApellidoPaterno() == null || clienteDTO.getApellidoPaterno().trim().isEmpty()) {
            throw new NegocioException("El apellido paterno es obligatorio.");
        }

        String apellidoPaterno = clienteDTO.getApellidoPaterno().trim();

        if (!apellidoPaterno.matches("^[a-zA-Z]+$")) {
            throw new NegocioException("El apellido paterno solo debe contener letras.");
        }

        if (apellidoPaterno.length() > 100) {
            throw new NegocioException("El apellido paterno no puede tener más de 100 caracteres.");
        }

        String apellidoMaterno = clienteDTO.getApellidoMaterno().trim();

        if (!apellidoMaterno.matches("^[a-zA-Z]+$")) {
            throw new NegocioException("El apellido materno solo debe contener letras.");
        }
        
        if (apellidoMaterno.length() > 100) {
            throw new NegocioException("El apellido paterno no puede tener más de 100 caracteres.");
        }

        if (clienteDTO.getTelefono() == null || clienteDTO.getTelefono().trim().isEmpty()) {
            throw new NegocioException("El teléfono es obligatorio.");
        }
        if (!esTelefonoValido(clienteDTO.getTelefono())) {
            throw new NegocioException("El número de teléfono no es válido debe tener 10 numeros.");
        }

        if (clienteDTO.getCorreo() != null && !clienteDTO.getCorreo().trim().isEmpty()) {
            if (!esCorreoValido(clienteDTO.getCorreo())) {
                throw new NegocioException("El correo electrónico no tiene un formato válido.");
            }
        }

        if (clienteDTO.getFechaRegistro() == null) {
            clienteDTO.setFechaRegistro(LocalDate.now());
        }

        ClienteFrecuente cliente = clienteFrecuenteMapper.toEntity(clienteDTO);

        ClienteFrecuente clienteRegistrado = clienteFrecuenteDAO.registrarClienteFrecuente(cliente);

        ClienteFrecuenteDTO clienteRegistradoDTO = clienteFrecuenteMapper.toDTO(clienteRegistrado);

        clienteRegistradoDTO.setVisitas(clienteFrecuenteDAO.calcularVisitas(clienteRegistrado));
        clienteRegistradoDTO.setPuntos(clienteFrecuenteDAO.calcularPuntos(clienteRegistrado));
        clienteRegistradoDTO.setTotalGastado(clienteFrecuenteDAO.calcularTotalGastado(clienteRegistrado));

        if (clienteRegistradoDTO.getVisitas() < 0) {
            clienteRegistradoDTO.setVisitas(0);
        }
        if (clienteRegistradoDTO.getPuntos() < 0) {
            clienteRegistradoDTO.setPuntos(0);
        }
        if (clienteRegistradoDTO.getTotalGastado() < 0) {
            clienteRegistradoDTO.setTotalGastado(0.0);
        }

        return clienteRegistradoDTO;
    }

    public List<ClienteFrecuenteDTO> buscarClientesFrecuentes(String nombre, String telefono, String correo) throws PersistenciaException, NegocioException {
//        if (nombre != null && nombre.trim().isEmpty()) {
//            throw new NegocioException("El nombre no puede ser vacío.");
//        }
//        if (telefono != null && telefono.trim().isEmpty()) {
//            throw new NegocioException("El teléfono no puede ser vacío.");
//        }
//        if (correo != null && correo.trim().isEmpty()) {
//            throw new NegocioException("El correo no puede ser vacío.");
//        }

        List<ClienteFrecuente> clientes = clienteFrecuenteDAO.filtrarClientesFrecuentes(nombre, telefono, correo);
        List<ClienteFrecuenteDTO> clienteDTOs = new ArrayList<>();

        for (ClienteFrecuente cliente : clientes) {
            ClienteFrecuenteDTO clienteDTO = clienteFrecuenteMapper.toDTO(cliente);
            clienteDTO.setVisitas(clienteFrecuenteDAO.calcularVisitas(cliente));
            clienteDTO.setPuntos(clienteFrecuenteDAO.calcularPuntos(cliente));
            clienteDTO.setTotalGastado(clienteFrecuenteDAO.calcularTotalGastado(cliente));
            clienteDTOs.add(clienteDTO);
        }

        return clienteDTOs;
    }

    public ClienteFrecuenteDTO obtenerClienteFrecuentePorId(Long id) throws PersistenciaException, NegocioException {
        ClienteFrecuente cliente = clienteFrecuenteDAO.obtenerClienteFrecuentePorId(id);
        if (cliente == null) {
            throw new NegocioException("Cliente no encontrado");
        }

        ClienteFrecuenteDTO clienteDTO = clienteFrecuenteMapper.toDTO(cliente);
        clienteDTO.setVisitas(clienteFrecuenteDAO.calcularVisitas(cliente));
        clienteDTO.setPuntos(clienteFrecuenteDAO.calcularPuntos(cliente));
        clienteDTO.setTotalGastado(clienteFrecuenteDAO.calcularTotalGastado(cliente));

        if (clienteDTO.getVisitas() < 0) {
            clienteDTO.setVisitas(0);
        }
        if (clienteDTO.getPuntos() < 0) {
            clienteDTO.setPuntos(0);
        }
        if (clienteDTO.getTotalGastado() < 0) {
            clienteDTO.setTotalGastado(0.0);
        }

        return clienteDTO;
    }

    private boolean esTelefonoValido(String telefono) {
        return telefono != null && telefono.matches("\\d{10}");
    }

    private boolean esCorreoValido(String correo) {
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return correo != null && correo.matches(regex);
    }

    public List<ClienteFrecuenteDTO> obtenerTodosClientesFrecuentes() throws NegocioException {
        try {
            List<ClienteFrecuente> clientes = clienteFrecuenteDAO.obtenerTodosLosClientesFrecuentes();
            return clientes.stream()
                    .map(cliente -> ClienteFrecuenteMapper.toDTO((ClienteFrecuente) cliente))
                    .collect(Collectors.toList());
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener los clientes frecuentes", e);
        }
    }
}
