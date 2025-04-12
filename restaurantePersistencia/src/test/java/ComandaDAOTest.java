/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import DAOs.ComandaDAO;
import conexion.Conexion;
import entidades.Comanda;
import enums.estadoComanda;
import exception.PersistenciaException;
import java.time.LocalDateTime;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author daniel
 */
public class ComandaDAOTest {
    ComandaDAO comandaDAO = ComandaDAO.getInstancia();
    
    @Test
    public void registrarComanda() throws PersistenciaException {
        Comanda comanda = new Comanda("OB-20250401", estadoComanda.ENTREGADO, LocalDateTime.now(), 100.00);
        Comanda comandaGuardada = comandaDAO.registrarComanda(comanda);
        assertTrue(comandaGuardada.getId() != null, "El id debería ser diferente de null.");
    }
    
    @Test
    public void obtenerCantidadComandas() throws PersistenciaException {
        int cantidadComandas = comandaDAO.obtenerCantidadComandas();
        assertTrue(cantidadComandas != 0, "La cantidad no debería ser null.");
    }
    
    @Test
    public void actualizarComanda() throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        Comanda comanda = em.find(Comanda.class, 1L);
        boolean exito = comandaDAO.actualizarComanda(comanda);
        assertTrue(exito != false, "La cantidad no debería ser null.");
    }
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
