/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import interfaces.AgregarIngrediente;
import interfaces.BusquedaIngrediente;
import interfaces.ClientesDisponibles;
import interfaces.Inicio;
import interfaces.MenuAdministrador;
import interfaces.RegistrarCliente;
import interfaces.RegistrarIngrediente;
import interfaces.ReporteClientes;
import interfaces.ReporteComandas;
import interfaces.Reportes;

/**
 *
 * @author chris
 */
public class ControlFlujoPantallas {

    private static ControlFlujoPantallas instancia;

    /**
     * Constructor privado para impedir instanciación externa.
     */
    private ControlFlujoPantallas() {
    }

    /**
     * Devuelve la instancia única del controlador de flujo. Si no existe aún,
     * la crea.
     *
     * @return instancia única del controlador
     */
    public static ControlFlujoPantallas getInstancia() {
        if (instancia == null) {
            instancia = new ControlFlujoPantallas();
        }
        return instancia;
    }
    
    
    public void abrirPantallaPrincipal(){
        Inicio formInicio = new Inicio();
        formInicio.setVisible(true);
    }
    
    public void abrirPantallaAdministrador(){
        MenuAdministrador formMenuAdministrador = new MenuAdministrador();
        formMenuAdministrador.setVisible(true);
       
    }
    
    public void abrirPantallaIngredientes(){
        AgregarIngrediente formAgregarIngrediente = new AgregarIngrediente();
        formAgregarIngrediente.setVisible(true);
    }
    
    public void abrirBuscarIngrediente(){
        BusquedaIngrediente forma = new BusquedaIngrediente();
        forma.setVisible(true);
    }
    
    public void abrirAgregarIngredientes(){
        RegistrarIngrediente forma = new RegistrarIngrediente();
        forma.setVisible(true);
    }
    
    public void abrirClienteDisponible(){
        ClientesDisponibles forma = new ClientesDisponibles();
        forma.setVisible(true);
    }
    
    public void abrirRegistrarCliente(){
        RegistrarCliente forma = new RegistrarCliente();
        forma.setVisible(true);
    }
    
    public void abrirReportes(){
        Reportes forma = new Reportes();
        forma.setVisible(true);
    }
    
    public void abrirReporteCliente(){
        ReporteClientes forma = new ReporteClientes();
        forma.setVisible(true);
    }
    
    public void abrirReporteComandas(){
        ReporteComandas forma = new ReporteComandas();
        forma.setVisible(true);
    }
}
