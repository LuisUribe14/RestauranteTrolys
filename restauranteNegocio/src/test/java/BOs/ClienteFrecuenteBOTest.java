/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package BOs;

import DTOs.ClienteFrecuenteDTO;
import entidades.ClienteFrecuente;
import exception.NegocioException;
import exception.PersistenciaException;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author multaslokas33
 */
public class ClienteFrecuenteBOTest {

//    private ClienteFrecuenteBO clienteBO;
//
//    @BeforeEach
//    public void setUp() {
//        clienteBO = new ClienteFrecuenteBO();
//    }
//
//    @Test
//    public void testRegistrarClienteValido() throws PersistenciaException, NegocioException {
//        ClienteFrecuenteDTO cliente = new ClienteFrecuenteDTO();
//        cliente.setNombre("polar");
//        cliente.setApellidoPaterno("panda");
//        cliente.setApellidoMaterno("pardo");
//        cliente.setTelefono("1234567890");
//        cliente.setCorreo("polar@gmail.com");
//
//        cliente = clienteBO.registrarClienteFrecuente(cliente);
//
//        System.out.println("Cliente registrado: " + cliente.getNombre());
//
//        assertNotNull(cliente.getId(), "El cliente 1 no fue registrado correctamente.");
//    }
//
//    @Test
//    public void testFiltrarClientesPorNombre() throws PersistenciaException, NegocioException {
//        ClienteFrecuenteDTO clienteDTO = new ClienteFrecuenteDTO();
//        clienteDTO.setNombre("Cristoper");
//        clienteDTO.setApellidoPaterno("soto");
//        clienteDTO.setApellidoMaterno("vasquez");
//        clienteDTO.setCorreo("cris@gmail.com");
//        clienteDTO.setTelefono("1029543097");
//
//        clienteDTO = clienteBO.registrarClienteFrecuente(clienteDTO);
//
//        System.out.println("Cliente registrado: " + clienteDTO.getNombre());
//
//        assertNotNull(clienteDTO.getId(), "El cliente 1 no fue registrado correctamente.");
//
//        List<ClienteFrecuenteDTO> filtrados = clienteBO.buscarClientesFrecuentes("Cris", null, null);
//
//        assertNotNull(filtrados, "La lista de clientes filtrados no debe ser nula");
//        assertTrue(filtrados.size() >= 1, "Debe encontrar al menos un cliente con ese nombre.");
//
//        for (ClienteFrecuenteDTO cliente : filtrados) {
//            System.out.println("Cliente encontrado: "
//                    + "Nombre: " + cliente.getNombre() + " "
//                    + "Apellido Paterno: " + cliente.getApellidoPaterno() + " "
//                    + "Apellido Materno: " + cliente.getApellidoMaterno() + ", "
//                    + "Correo: " + cliente.getCorreo() + ", "
//                    + "Teléfono: " + cliente.getTelefono() + ", "
//                    + "Visitas: " + cliente.getVisitas() + ", "
//                    + "Puntos: " + cliente.getPuntos() + ", "
//                    + "Total Gastado: " + cliente.getTotalGastado());
//            assertTrue(cliente.getNombre().toLowerCase().contains("cristoper"),
//                    "El nombre del cliente no contiene el nombre proporcionado.");
//        }
//    }
//
//    @Test
//    public void testFiltrarClientesPorNombreYCorreo() throws PersistenciaException, NegocioException {
//        ClienteFrecuenteDTO clienteDTO = new ClienteFrecuenteDTO();
//        clienteDTO.setNombre("Eduardo");
//        clienteDTO.setApellidoPaterno("mendez");
//        clienteDTO.setApellidoMaterno("lopez");
//        clienteDTO.setCorreo("eduardo@gmail.com");
//        clienteDTO.setTelefono("0932634811");
//
//        clienteDTO = clienteBO.registrarClienteFrecuente(clienteDTO);
//
//        System.out.println("Cliente registrado: " + clienteDTO.getNombre());
//
//        assertNotNull(clienteDTO.getId(), "El cliente 1 no fue registrado correctamente.");
//
//        List<ClienteFrecuenteDTO> filtrados = clienteBO.buscarClientesFrecuentes("Eduardo", null, "eduardo@gmail.com");
//
//        assertNotNull(filtrados, "La lista de clientes filtrados no debe ser nula");
//        assertTrue(filtrados.size() >= 1, "Debe encontrar al menos un cliente con ese nombre.");
//
//        for (ClienteFrecuenteDTO cliente : filtrados) {
//            System.out.println("Cliente encontrado: "
//                    + "Nombre: " + cliente.getNombre() + " "
//                    + "Apellido Paterno: " + cliente.getApellidoPaterno() + " "
//                    + "Apellido Materno: " + cliente.getApellidoMaterno() + ", "
//                    + "Correo: " + cliente.getCorreo() + ", "
//                    + "Teléfono: " + cliente.getTelefono() + ", "
//                    + "Visitas: " + cliente.getVisitas() + ", "
//                    + "Puntos: " + cliente.getPuntos() + ", "
//                    + "Total Gastado: " + cliente.getTotalGastado());
//            assertTrue(cliente.getNombre().toLowerCase().contains("eduardo"),
//                    "El nombre del cliente no contiene el nombre proporcionado.");
//        }
//    }
//
//    @Test
//    public void testFiltrarClientesPorTelefono() throws PersistenciaException, NegocioException {
//        ClienteFrecuenteDTO clienteDTO = new ClienteFrecuenteDTO();
//        clienteDTO.setNombre("Laura");
//        clienteDTO.setApellidoPaterno("vega");
//        clienteDTO.setApellidoMaterno("uribe");
//        clienteDTO.setCorreo("laura@gmail.com");
//        clienteDTO.setTelefono("2365490568");
//
//        clienteDTO = clienteBO.registrarClienteFrecuente(clienteDTO);
//
//        System.out.println("Cliente registrado: " + clienteDTO.getNombre());
//
//        List<ClienteFrecuenteDTO> filtrados = clienteBO.buscarClientesFrecuentes(null, "2365490568", null);
//
//        assertNotNull(filtrados, "La lista de clientes filtrados no debe ser nula");
//        assertEquals(1, filtrados.size(), "Debe encontrar al menos un cliente con ese nombre.");
//
//        for (ClienteFrecuenteDTO cliente : filtrados) {
//            System.out.println("Cliente encontrado: "
//                    + "Nombre: " + cliente.getNombre() + " "
//                    + "Apellido Paterno: " + cliente.getApellidoPaterno() + " "
//                    + "Apellido Materno: " + cliente.getApellidoMaterno() + ", "
//                    + "Correo: " + cliente.getCorreo() + ", "
//                    + "Teléfono: " + cliente.getTelefono() + ", "
//                    + "Visitas: " + cliente.getVisitas() + ", "
//                    + "Puntos: " + cliente.getPuntos() + ", "
//                    + "Total Gastado: " + cliente.getTotalGastado());
//        }
//    }

}

//    @Test
//    public void testObtenerTodosClientesFrecuentes() throws NegocioException {
//        ClienteFrecuenteBO bo = new ClienteFrecuenteBO();
//
//        List<ClienteFrecuenteDTO> clientes = bo.obtenerTodosClientesFrecuentes();
//
//        assertNotNull(clientes);
//        assertFalse(clientes.isEmpty(), "La lista de clientes no debería estar vacía");
//
//        for (ClienteFrecuenteDTO cliente : clientes) {
//            System.out.println(cliente);
//            assertNotNull(cliente.getNombre());
//            assertNotNull(cliente.getApellidoPaterno());
//        }
//    }
