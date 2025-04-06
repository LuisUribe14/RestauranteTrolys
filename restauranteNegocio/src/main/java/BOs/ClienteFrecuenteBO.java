/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import DAOs.ClienteFrecuenteDAO;
import entidades.ClienteFrecuente;
import exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author multaslokas33
 */
public class ClienteFrecuenteBO {

    private ClienteFrecuenteDAO dao = ClienteFrecuenteDAO.getInstancia();

    private static ClienteFrecuenteBO iBO;

    public static ClienteFrecuenteBO getInstancia() {
        if (iBO == null) {
            iBO = new ClienteFrecuenteBO();
        }
        return iBO;
    }

    public ClienteFrecuente registrarClienteFrecuente(ClienteFrecuente cliente) throws PersistenciaException {
        // Validar que los campos esenciales no estén vacíos
        if (cliente == null) {
            throw new PersistenciaException("El cliente no puede ser nulo.");
        }
        if (cliente.getNombre() == null || cliente.getNombre().isEmpty()) {
            throw new PersistenciaException("El nombre del cliente es obligatorio.");
        }
        if (cliente.getTelefono() == null || cliente.getTelefono().isEmpty()) {
            throw new PersistenciaException("El teléfono del cliente es obligatorio.");
        }
        return dao.registrarClienteFrecuente(cliente);
    }

    public List<ClienteFrecuente> filtrarClientesFrecuentes(String nombre, String correo, String telefono) throws PersistenciaException {
        if (telefono != null && !telefono.isEmpty()) {
            if (!telefono.matches("^[0-9]+$")) {
                throw new PersistenciaException("El teléfono solo puede contener números");
            }
        }
        return dao.filtrarClientesFrecuentes(nombre, correo, telefono);
    }
}
