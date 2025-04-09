/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.restaurantenegocio;

import BOs.ingredienteBO;
import DTOs.ingredienteDTO;
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
            List<ingredienteDTO> lista = bo.obtenerTodosDTO(); // Ahora retorna DTOs

            if (lista.isEmpty()) {
                System.out.println("No hay ingredientes registrados.");
            } else {
                System.out.println("Lista de ingredientes:");
                for (ingredienteDTO dto : lista) {
                    System.out.println("- " + dto.getNombre()
                            + " | " + dto.getUnidadMedida()
                            + " | Stock: " + dto.getStock());
                }
            }

        } catch (PersistenciaException e) {
            System.out.println("Error al obtener los ingredientes: " + e.getMessage());
        }

    }
}
