/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.restaurantepersistencia;

import conexion.Conexion;
import javax.persistence.EntityManager;

/**
 *
 * @author multaslokas33
 */
public class RestaurantePersistencia {

    public static void main(String[] args) {
        EntityManager em = Conexion.crearConexion();
        if (em != null) {
            System.out.println("Conexión exitosa a la base de datos.");
            em.close();
        } else {
            System.out.println("Error al conectar a la base de datos.");
        }

        Conexion.cerrar();
    }
}
