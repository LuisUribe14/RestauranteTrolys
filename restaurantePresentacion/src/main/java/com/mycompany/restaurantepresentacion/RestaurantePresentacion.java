/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.restaurantepresentacion;

import BOs.ingredienteBO;
import DAOs.ingredienteDao;
import entidades.Ingrediente;
import enums.unidadMedida;
import exception.PersistenciaException;

/**
 *
 * @author chris
 */
public class RestaurantePresentacion {

    public static void main(String[] args) throws PersistenciaException {
        ingredienteBO ingredientebo = ingredienteBO.getInstancia();

        
        Ingrediente ingrediente = new Ingrediente("papas", unidadMedida.PIEZAS, 3);
        ingredientebo.agregarIngrediente(ingrediente);
    }
}
