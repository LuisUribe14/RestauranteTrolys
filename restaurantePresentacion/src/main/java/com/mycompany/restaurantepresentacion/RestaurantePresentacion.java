/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.restaurantepresentacion;

import BOs.ingredienteBO;
import DAOs.ingredienteDao;
import entidades.Ingrediente;
import enums.unidadMedida;
import exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author chris
 */
public class RestaurantePresentacion {

    public static void main(String[] args) throws PersistenciaException {
//        ingredienteBO ingredientebo = ingredienteBO.getInstancia();
//        
//        ingredienteDao ingredienteDAO = ingredienteDao.getInstancia();
//
//        try {
//            // Buscar ingrediente en la BD por nombre y unidad de medida
//            Ingrediente ingrediente = ingredienteDAO.obtenerIngrediente("papas", unidadMedida.GRAMOS);
//
//            if (ingrediente == null) {
//                System.out.println("Ingrediente no encontrado en la base de datos.");
//                return;
//            }
//
//            // Descontar stock del ingrediente encontrado
//            ingredientebo.descontarStock(ingrediente, 2);
//            System.out.println("Stock actualizado: " + ingrediente.getStock());
//
//        } catch (PersistenciaException e) {
//            System.out.println("Error al obtener el ingrediente: " + e.getMessage());
//        }

        ingredienteBO ingredientebo = ingredienteBO.getInstancia();

        // Probar agregar ingrediente
//        try {
//            Ingrediente nuevo = new Ingrediente();
//            nuevo.setNombre("tomate");
//            nuevo.setUnidadMedida(unidadMedida.GRAMOS);
//            nuevo.setStock(100);
//
//            ingredientebo.agregarIngrediente(nuevo);
//            System.out.println("Ingrediente agregado correctamente.");
//        } catch (PersistenciaException e) {
//            System.out.println("Error al agregar ingrediente: " + e.getMessage());
//        }
        // Probar búsqueda por nombre o unidad de medida
        try {
            System.out.println("\n--- Búsqueda por filtro 'gramos' ---");
            List<Ingrediente> resultados = ingredientebo.buscarIngredientes("GRAMOS");
            for (Ingrediente ing : resultados) {
                System.out.println("Encontrado: " + ing.getNombre() + " - " + ing.getUnidadMedida() + " - Stock: " + ing.getStock());
            }
        } catch (PersistenciaException e) {
            System.out.println("Error al buscar ingredientes: " + e.getMessage());
        }

        // Probar descuento de stock
        try {
            Ingrediente ingrediente = ingredienteDao.getInstancia().obtenerIngrediente("papas", unidadMedida.GRAMOS);
            if (ingrediente != null) {
                ingredientebo.descontarStock(ingrediente, 1);
                System.out.println("\nStock descontado correctamente. Nuevo stock: " + ingrediente.getStock());

                ingredientebo.eliminarIngredientePorNombreYUnidad("papas", unidadMedida.PIEZAS);
                System.out.println("Ingrediente eliminado correctamente.");
            } else {
                System.out.println("Ingrediente no encontrado.");
            }
        } catch (PersistenciaException e) {
            System.out.println("Error al descontar stock: " + e.getMessage());
        }

    }
}
