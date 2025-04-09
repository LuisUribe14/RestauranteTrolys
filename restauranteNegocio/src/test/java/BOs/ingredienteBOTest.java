/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package BOs;

import DTOs.IngredienteViejoDTO;
import DTOs.ingredienteDTO;
import DTOs.ingredienteNuevoDTO;
import enums.unidadMedida;
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
 * @author chris
 */
public class ingredienteBOTest {
    
    public ingredienteBOTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
       private ingredienteBO bo;

    @BeforeEach
    public void setUp() {
        bo = ingredienteBO.getInstancia();  // Inicializar la instancia antes de cada prueba
    }

    @AfterEach
    public void tearDown() {
        // Aquí puedes hacer limpieza después de cada prueba, si es necesario
    }

    /**
     * Test de getInstancia, de la clase ingredienteBO.
     */
    @Test
    public void testGetInstancia() {
        ingredienteBO result = ingredienteBO.getInstancia();
        assertNotNull(result, "La instancia de ingredienteBO no debería ser nula");
    }

    /**
     * Test de agregarIngrediente, de la clase ingredienteBO.
     */
    @Test
    public void testAgregarIngrediente() throws PersistenciaException {
        ingredienteNuevoDTO dto = new ingredienteNuevoDTO("Tomate", unidadMedida.PIEZAS, 10);
        bo.agregarIngrediente(dto);  // Llamamos al método

        
        assertTrue(true);  
    }

    /**
     * Test de agregarIngrediente con un nombre vacío.
     */
    @Test
    public void testAgregarIngredienteConNombreVacio() {
        ingredienteNuevoDTO dto = new ingredienteNuevoDTO("", unidadMedida.PIEZAS, 10);

        PersistenciaException exception = assertThrows(PersistenciaException.class, () -> {
            bo.agregarIngrediente(dto);
        });

        assertEquals("El nombre del ingrediente no puede estar vacío.", exception.getMessage());
    }

    /**
     * Test de descontarStock, de la clase ingredienteBO.
     */
    @Test
    public void testDescontarStock() throws PersistenciaException {
        IngredienteViejoDTO dto = new IngredienteViejoDTO("Tomate", unidadMedida.PIEZAS);
        int cantidad = 5;

        bo.descontarStock(dto, cantidad);  // Llamamos al método

        
        assertTrue(true);  
    }

    /**
     * Test de descontarStock con stock insuficiente.
     */
    @Test
    public void testDescontarStockInsuficiente() {
        IngredienteViejoDTO dto = new IngredienteViejoDTO("Tomate", unidadMedida.PIEZAS);
        int cantidad = 100;  // Suponiendo que el stock actual es insuficiente

        PersistenciaException exception = assertThrows(PersistenciaException.class, () -> {
            bo.descontarStock(dto, cantidad);
        });

        assertEquals("No se puede descontar, stock insuficiente", exception.getMessage());
    }

    /**
     * Test de eliminarIngredientePorNombreYUnidad, de la clase ingredienteBO.
     */
    @Test
    public void testEliminarIngredientePorNombreYUnidad() throws PersistenciaException {
        bo.eliminarIngredientePorNombreYUnidad("Tomate", unidadMedida.PIEZAS);

       
        assertTrue(true);  
    }

    /**
     * Test de eliminarIngredientePorNombreYUnidad con datos inválidos.
     */
    @Test
    public void testEliminarIngredienteConDatosInvalidos() {
        PersistenciaException exception = assertThrows(PersistenciaException.class, () -> {
            bo.eliminarIngredientePorNombreYUnidad("", null);  // Datos inválidos
        });

        assertEquals("Nombre o unidad de medida inválidos", exception.getMessage());
    }

    /**
     * Test de obtenerTodosDTO, de la clase ingredienteBO.
     */
    @Test
    public void testObtenerTodosDTO() throws PersistenciaException {
        List<ingredienteDTO> result = bo.obtenerTodosDTO();

        
        assertNotNull(result, "La lista de ingredientes no debe ser nula");
        assertFalse(result.isEmpty(), "La lista de ingredientes no debe estar vacía");
    }

    /**
     * Test de filtrarIngredientesDTO, de la clase ingredienteBO.
     */
    @Test
    public void testFiltrarIngredientesDTO() throws PersistenciaException {
        List<ingredienteDTO> result = bo.filtrarIngredientesDTO("Tomate", "PIEZAS");

        
        assertNotNull(result, "La lista filtrada no debe ser nula");
        assertFalse(result.isEmpty(), "La lista filtrada no debe estar vacía");
    }
    
}
