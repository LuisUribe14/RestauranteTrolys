/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author multaslokas33
 */
public class Conexion {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");

    public static EntityManager crearConexion() {
        return emf.createEntityManager();
    }

    public static void cerrarConexion(EntityManager em) {
        if (em != null && em.isOpen()) {
            em.close();
        }
    }
    
    public static void cerrar() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
