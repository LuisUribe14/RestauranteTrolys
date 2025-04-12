/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package DAOs;

import entidades.ClienteFrecuente;
import entidades.Comanda;
import enums.estadoComanda;
import exception.PersistenciaException;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
//    private ComandaDAO comandaDAO;
//
//    @BeforeEach
//    public void setUp() {
//
//        clienteDAO = ClienteFrecuenteDAO.getInstancia();
//        comandaDAO = ComandaDAO.getInstancia();
//    }
//
//    @Test
//    public void testRegistrarCliente() throws PersistenciaException {
//        ClienteFrecuente cliente = new ClienteFrecuente();
//        cliente.setNombre("pedro");
//        cliente.setApellidoPaterno("mclofin");
//        cliente.setApellidoMaterno("González");
//        cliente.setCorreo("pedro@gmail.com");
//        cliente.setTelefono("6115282083");
//        cliente.setFechaRegistro(LocalDate.now());
//
//        cliente = clienteDAO.registrarClienteFrecuente(cliente);
//
//        assertNotNull(cliente.getId(), "El cliente 1 no fue registrado correctamente.");
//    }
//
//    @Test
//    public void testRegistrarComanda() throws PersistenciaException {
//        ClienteFrecuente cliente = new ClienteFrecuente();
//        cliente.setNombre("fernanado");
//        cliente.setApellidoPaterno("sanchez");
//        cliente.setApellidoMaterno("Lopez");
//        cliente.setCorreo("fer@gmail.com");
//        cliente.setTelefono("0009191827");
//
//        cliente = clienteDAO.registrarClienteFrecuente(cliente);
//
//        Comanda c1 = new Comanda();
//        c1.setCliente(cliente);
//        c1.setEstado(estadoComanda.ENTREGADO);
//        c1.setFechaYHora(LocalDateTime.now());
//        c1.setTotalVenta(200.0);
//        c1.setFolio("CMD-A1");
//
//        comandaDAO.registrarComanda(c1);
//
//        Double gasto = clienteDAO.calcularTotalGastado(cliente);
//        Integer visitas = clienteDAO.calcularVisitas(cliente);
//        Integer puntos = clienteDAO.calcularPuntos(cliente);
//
//        assertEquals(200.0, gasto);
//        assertEquals(1, visitas);
//        assertEquals(10, puntos);
//    }
//
//    @Test
//    public void testFiltrarClientesFrecuentes() throws PersistenciaException {
//        ClienteFrecuente cliente1 = new ClienteFrecuente();
//        cliente1.setNombre("fabian");
//        cliente1.setApellidoPaterno("hinijoza");
//        cliente1.setApellidoMaterno("moreno");
//        cliente1.setCorreo("faian@gmail.com");
//        cliente1.setTelefono("5151234567");
//        clienteDAO.registrarClienteFrecuente(cliente1);
//
//        ClienteFrecuente cliente2 = new ClienteFrecuente();
//        cliente2.setNombre("ramses");
//        cliente2.setApellidoPaterno("sauseda");
//        cliente2.setApellidoMaterno("rubio");
//        cliente2.setCorreo("ramses@gmail.com");
//        cliente2.setTelefono("5255761021");
//        clienteDAO.registrarClienteFrecuente(cliente2);
//        
//        ClienteFrecuente cliente3 = new ClienteFrecuente();
//        cliente3.setNombre("gael");
//        cliente3.setApellidoPaterno("armendariz");
//        cliente3.setApellidoMaterno("lopez");
//        cliente3.setCorreo("gael@gmail.com");
//        cliente3.setTelefono("6321039238");
//        clienteDAO.registrarClienteFrecuente(cliente3);
//
//        List<ClienteFrecuente> resultadoNombre = clienteDAO.filtrarClientesFrecuentes("fab", null, null);
//        assertFalse(resultadoNombre.isEmpty(), "No se encontraron clientes con nombre similar a 'fab'");
//        assertTrue(resultadoNombre.stream().anyMatch(c -> c.getNombre().toLowerCase().startsWith("fab")), "No se encontró coincidencia en nombre");
//
//        // Buscar por correo
//        List<ClienteFrecuente> resultadoCorreo = clienteDAO.filtrarClientesFrecuentes(null, null, "ramses");
//        assertFalse(resultadoCorreo.isEmpty(), "No se encontraron clientes con correo 'ramses'");
//
//        // Buscar por teléfono
//        List<ClienteFrecuente> resultadoTelefono = clienteDAO.filtrarClientesFrecuentes(null, "6321039238", null);
//        assertEquals(1, resultadoTelefono.size(), "No se encontró al cliente con ese teléfono");
//        assertEquals("gael", resultadoTelefono.get(0).getNombre(), "El cliente encontrado no es el esperado");
//
//        // Buscar combinando nombre y correo
//        List<ClienteFrecuente> resultadoCombinado = clienteDAO.filtrarClientesFrecuentes("ramses", null, "ramses");
//        assertEquals(1, resultadoCombinado.size(), "No se encontró el cliente esperado con nombre y correo combinados");
//    }
//    
//    solo hice estos metodos pq son los que realmente uso 
}
