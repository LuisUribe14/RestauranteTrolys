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

    private ClienteFrecuenteBO clienteBO;

    @BeforeEach
    public void setUp() {
        clienteBO = new ClienteFrecuenteBO();
    }

    @Test
    public void testRegistrarClienteValido() throws PersistenciaException {
        ClienteFrecuenteDTO cliente = new ClienteFrecuenteDTO();
        cliente.setNombre("polar");
        cliente.setApellidoPaterno("panda");
        cliente.setApellidoMaterno("pardo");
        cliente.setTelefono("1234567890");
        cliente.setCorreo("polar@gmail.com");

        try {
            ClienteFrecuenteDTO registrado = clienteBO.registrarClienteFrecuente(cliente);
            assertNotNull(registrado.getId());
             assertEquals("polar", registrado.getNombre().trim()); 
        } catch (NegocioException e) {
            fail("No debería lanzar excepción: " + e.getMessage());
        }
    }
}
