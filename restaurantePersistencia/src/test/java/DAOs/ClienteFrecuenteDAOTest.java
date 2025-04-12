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
}
