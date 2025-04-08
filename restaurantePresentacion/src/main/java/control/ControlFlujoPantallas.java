/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import interfaces.AgregarIngrediente;
import interfaces.Inicio;
import interfaces.MenuAdministrador;

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
}
