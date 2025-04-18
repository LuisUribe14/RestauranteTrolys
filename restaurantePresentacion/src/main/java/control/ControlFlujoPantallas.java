/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import DTOs.IngredienteViejoDTO;
import DTOs.MesaViejaDTO;
import DTOs.ProductoIngredienteNuevoDTO;
import Pantallas.moduloProductos.FrmAñadirIngredientes;
import Pantallas.moduloProductos.FrmProductosRegistrados;
import Pantallas.moduloProductos.FrmRegistrarProductos;
import interfaces.AgregarIngrediente;
import interfaces.ClientesComanda;
import interfaces.ClientesDisponibles;
import interfaces.Comandas;
import interfaces.ComandasAbiertas;
import interfaces.Inicio;
import interfaces.MenuAdministrador;
import interfaces.MesasDisponibles;
import interfaces.ProductosDisponibles;
import interfaces.RegistrarCliente;
import interfaces.RegistrarIngrediente;
import interfaces.ReporteClientes;
import interfaces.ReporteComandas;
import interfaces.Reportes;
import java.util.ArrayList;
import java.util.List;

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
    
    public void abrirFrmAñadirIngredientes(List<ProductoIngredienteNuevoDTO> ingredientes) {
        new FrmAñadirIngredientes(ingredientes).setVisible(true);
    }
    
    public void abrirFrmRegistrarProducto(List<ProductoIngredienteNuevoDTO> ingredientes) {
        new FrmRegistrarProductos(ingredientes).setVisible(true);
    }
    
    public void abrirFrmProductosRegistrados() {
        new FrmProductosRegistrados().setVisible(true);
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
    
    public void abrirPantallaInicio(){
        Inicio forma = new Inicio();
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
    
    public void abrirComandasAbiertas(){
        ComandasAbiertas forma = new ComandasAbiertas();
        forma.setVisible(true);
    }
    
    public void abrirMesas(){
        MesasDisponibles forma = new MesasDisponibles();
        forma.setVisible(true);
    }
    
    public void abrirProductosDisponibles(MesaViejaDTO mesa){
        ProductosDisponibles forma = new ProductosDisponibles(mesa);
        forma.setVisible(true);
    }
    
    public void abrirComandas(){
        Comandas forma = new Comandas();
        forma.setVisible(true);
    }
    
    public void abrirClientesComandas(){
        ClientesComanda forma = new ClientesComanda();
        forma.setVisible(true);
    }
}
