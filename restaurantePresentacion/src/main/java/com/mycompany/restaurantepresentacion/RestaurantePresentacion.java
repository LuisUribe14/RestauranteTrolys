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
        
        ingredienteDao ingredienteDAO = ingredienteDao.getInstancia();

        try {
            // Buscar ingrediente en la BD por nombre y unidad de medida
            Ingrediente ingrediente = ingredienteDAO.obtenerIngrediente("papas", unidadMedida.GRAMOS);

            if (ingrediente == null) {
                System.out.println("Ingrediente no encontrado en la base de datos.");
                return;
            }

            // Descontar stock del ingrediente encontrado
            ingredientebo.descontarStock(ingrediente, 2);
            System.out.println("Stock actualizado: " + ingrediente.getStock());

        } catch (PersistenciaException e) {
            System.out.println("Error al obtener el ingrediente: " + e.getMessage());
        }
    }
}
