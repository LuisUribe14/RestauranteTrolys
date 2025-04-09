/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package DAOs;

import entidades.ClienteFrecuente;
import exception.PersistenciaException;
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
public class ClienteFrecuenteDAOTest {
    
//    private ClienteFrecuenteDAO clienteDAO;
//
//    @BeforeEach
//    public void setUp() {
//        // Inicializa el DAO (si es necesario, se puede simular con mocks)
//        clienteDAO = ClienteFrecuenteDAO.getInstancia();
//    }
//    
//    @Test
//    public void testFiltrarClientesPorTelefono() {
//        // Primero, registrar un cliente
//        ClienteFrecuente cliente = new ClienteFrecuente();
//        cliente.setNombre("Carlos");
//        cliente.setApellidoPaterno("González");
//        cliente.setApellidoMaterno("Perez");
//        cliente.setCorreo("carlos.gonzalez@dominio.com");
//        cliente.setTelefono("1234567890");
//
//        try {
//            clienteDAO.registrarClienteFrecuente(cliente);
//
//            // Filtrar clientes por teléfono
//            List<ClienteFrecuente> clientesFiltrados = clienteDAO.filtrarClientesFrecuentes(null, "1234567890", null);
//
//            // Verificar que al menos un cliente ha sido encontrado
//            assertNotNull(clientesFiltrados, "La lista de clientes no debe ser nula.");
//            assertEquals(1, clientesFiltrados.size(), "Los teléfonos deben coincidir.");
//
//        } catch (PersistenciaException e) {
//            fail("Error al filtrar clientes por teléfono: " + e.getMessage());
//        }
//    }
}
