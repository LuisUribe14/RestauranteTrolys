/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.Ingrediente;
import enums.unidadMedida;
import exception.PersistenciaException;

/**
 *
 * @author chris
 */
public interface Iingrediente {

    public void agregarIngrediente(Ingrediente ingredeinte) throws PersistenciaException;

    public boolean existeIngrediente(String nombre, unidadMedida unidadMedida);

    public void actualizarIngrediente(Ingrediente ingrediente) throws PersistenciaException;
    
    public Ingrediente obtenerIngrediente(String nombre, unidadMedida unidadMedida) throws PersistenciaException;
}
