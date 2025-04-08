/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.restaurantenegocio;

import BOs.ingredienteBO;
import entidades.Ingrediente;
import exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author chris
 */
public class RestauranteNegocio {

    public static void main(String[] args) throws PersistenciaException {
        ingredienteBO bo = ingredienteBO.getInstancia();

        try {
            List<Ingrediente> lista = bo.obtenerTodos(); // Llama al método de negocio

            if (lista.isEmpty()) {
                System.out.println("No hay ingredientes registrados.");
            } else {
                System.out.println("Lista de ingredientes:");
                for (Ingrediente ing : lista) {
                    System.out.println("- " + ing.getNombre()
                            + " | " + ing.getUnidadMedida()
                            + " | Stock: " + ing.getStock());
                }
            }

        } catch (PersistenciaException e) {
            System.out.println("Error al obtener los ingredientes: " + e.getMessage());
        }
    }
}
