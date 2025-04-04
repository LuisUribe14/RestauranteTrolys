/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import conexion.Conexion;
import entidades.Ingrediente;
import enums.unidadMedida;
import exception.PersistenciaException;
import interfaces.Iingrediente;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

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
     * ya esta creado retornamos la ya creada
     * @return la instanica del videojuefo y la unica
     */
    public static ingredienteDao getInstancia() {
        if (instanceIngredienteDao == null) {
            instanceIngredienteDao = new ingredienteDao();
        }
        return instanceIngredienteDao;
    }

    /**
     * Meotodo para poder agregar un ingrediente de tipo ingrediente
     * que manda a llamar al metodo existeIngrediente
     * para poder validar cada vez que se intent agregar un ingrediente nuevo
     * @param ingrediente
     * @throws PersistenciaException
     */
    @Override
    public void agregarIngrediente(Ingrediente ingrediente) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
//        //Al momento de agregar un nuevo ingrediente siempre intentamos vcalidar o comprobar si ya existe
//        if (existeIngrediente(ingrediente.getNombre(), ingrediente.getUnidadMedida())) {
//            throw new PersistenciaException("El ingrediente ya existe con el mismo nombre y unidad de medida.");
//        }
        try {
            em.getTransaction().begin();
            em.persist(ingrediente);
            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo agregar el ingrediente");
        } finally {
            em.close();
        }
    }

    /**
     * Metodo al caul mandamos a llamar cada vez que querramos validar si 
     * un ingrediente hace conicidenica con uno ya existebte
     * @param nombre
     * @param unidadMedida
     * @return Verdadero si no hay ingrediente con el nombre y unidad igualfalso en caso contrario
     */
    @Override
    public boolean existeIngrediente(String nombre, unidadMedida unidadMedida) {
        EntityManager em = Conexion.crearConexion();  // Asegúrate de usar el mismo EntityManager
        try {
            TypedQuery<Ingrediente> query = em.createQuery(
                    "SELECT i FROM Ingrediente i WHERE i.nombre = :nombre AND i.unidadMedida = :unidadMedida", Ingrediente.class);
            query.setParameter("nombre", nombre);
            query.setParameter("unidadMedida", unidadMedida);
            return !query.getResultList().isEmpty();
        } finally {
            em.close();  // No olvides cerrar el EntityManager después de usarlo
        }
    }
    
    public void descontarStock(){
        
    }
}
