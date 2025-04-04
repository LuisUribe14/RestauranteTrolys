/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.restaurantepersistencia;

import DAOs.ingredienteDao;
import DTOs.ingredienteNuevoDTO;
import conexion.Conexion;
import enums.unidadMedida;
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

            ingredienteDao dao = ingredienteDao.getInstancia();
            ingredienteNuevoDTO dto = new ingredienteNuevoDTO(
                    "Harina",
                    unidadMedida.Miligramos,
                    25
            );
            em.close();
        } else {
            System.out.println("Error al conectar a la base de datos.");
        }

        Conexion.cerrar();
    }
}
