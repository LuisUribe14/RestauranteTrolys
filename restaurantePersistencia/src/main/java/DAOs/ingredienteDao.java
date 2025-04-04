/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import conexion.Conexion;
import entidades.Ingrediente;
import exception.PersistenciaException;
import interfaces.Iingrediente;
import javax.persistence.EntityManager;

/**
 *
 * @author chris
 */
public class ingredienteDao implements Iingrediente {

    /*
    Utilizamos el patron Singleton para evitar duplicados y varias instancias 
     */
    private static ingredienteDao instanceIngredienteDao;

    private ingredienteDao() {
    }

    /**
     * Metodo para crear la instanica en dado caso que no haya sido creada, y si
     * ya lo esta retornamos la ya creada
     *
     * @return la instanica del videojuefo y la unica
     */
    public static ingredienteDao getInstancia() {
        if (instanceIngredienteDao == null) {
            instanceIngredienteDao = new ingredienteDao();
        }
        return instanceIngredienteDao;
    }

    @Override
    public void agregarIngrediente(Ingrediente ingrediente) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            em.persist(ingrediente);
            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo");
        } finally {
            em.close();
        }

    }
}
