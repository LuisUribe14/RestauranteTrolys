package DAOs;

import conexion.Conexion;
import entidades.Ingrediente;
import enums.unidadMedida;
import exception.PersistenciaException;
import interfaces.Iingrediente;
import java.util.ArrayList;
import java.util.List;
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
     *
     * @return la instanica del videojuego y la unica
     */
    public static ingredienteDao getInstancia() {
        if (instanceIngredienteDao == null) {
            instanceIngredienteDao = new ingredienteDao();
        }
        return instanceIngredienteDao;
    }

    /**
     * Metodo para poder agregar un ingrediente de tipo ingrediente que manda
     *
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
     * Metodo al caul mandamos a llamar cada vez que querramos validar si un
     * ingrediente hace conicidenica con uno ya existebte
     *
     * @param nombre
     * @param unidadMedida
     * @return Verdadero si no hay ingrediente con el nombre y unidad igualfalso
     * en caso contrario
     */
    @Override
    public boolean existeIngrediente(String nombre, unidadMedida unidadMedida) {
        EntityManager em = Conexion.crearConexion();
        try {
            TypedQuery<Ingrediente> query = em.createQuery(
                    "SELECT i FROM Ingrediente i WHERE i.nombre = :nombre AND i.unidadMedida = :unidadMedida", Ingrediente.class);
            query.setParameter("nombre", nombre);
            query.setParameter("unidadMedida", unidadMedida);
            return !query.getResultList().isEmpty();
        } finally {
            em.close();
        }
    }

    /**
     * Actualiza el stock de un ingrediente que mandamos como
     * parametro para actualizarlo
     *
     * @param ingrediente
     * @throws PersistenciaException
     */
    @Override
    public void actualizarIngrediente(Ingrediente ingrediente) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            em.merge(ingrediente);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo actualizar el ingrediente.");
        } finally {
            em.close();
        }
    }

    /**
     * Metodo que obtiene el ingrediente con el que encontro Que recibe como
     * parametro el nombre y la unidad para buscarlo
     *
     * @param nombre
     * @param unidadMedida
     * @return El ingredeinte encontrado
     * @throws PersistenciaException
     */
    @Override
    public Ingrediente obtenerIngrediente(String nombre, unidadMedida unidadMedida) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            TypedQuery<Ingrediente> query = em.createQuery(
                    "SELECT i FROM Ingrediente i WHERE i.nombre = :nombre AND i.unidadMedida = :unidadMedida", Ingrediente.class);
            query.setParameter("nombre", nombre);
            query.setParameter("unidadMedida", unidadMedida);

            List<Ingrediente> resultados = query.getResultList();
            return resultados.isEmpty() ? null : resultados.get(0);

        } catch (Exception e) {
            //em.getTransaction().rollback();
            throw new PersistenciaException("No se puedo obtener el ingrediente");
        } finally {
            em.close();
        }
    }

//    /**
//     * Metodo que recibe como parametro una variable de tipo String y trata de
//     * buscar coincidencias en la base de datos con el parametro que recibe
//     *
//     * @param filtro
//     * @return Una lista de tipo ingredientes con las coincidencias
//     * @throws PersistenciaException
//     */
//    //OPCION 2 buscarlos o solo por nombre o unidad, y no pedir los 2 parametros 
//    @Override
//    public List<Ingrediente> buscarPorNombreOUm(String filtro) throws PersistenciaException {
//        EntityManager em = Conexion.crearConexion();
//        try {
//            TypedQuery<Ingrediente> query = em.createQuery(
//                    "SELECT i FROM Ingrediente i WHERE LOWER(i.nombre) LIKE LOWER(:filtro) "
//                    + "OR LOWER(CONCAT('', i.unidadMedida)) LIKE LOWER(:filtro)", Ingrediente.class);
//            query.setParameter("filtro", "%" + filtro + "%");
//
//            return query.getResultList();
//        } catch (Exception e) {
//            throw new PersistenciaException("Error al buscar ingredientes por nombre o unidad de medida", e);
//        } finally {
//            em.close();
//        }
//    }

    @Override
    public void eliminarIngredientePorNombreYUnidad(String nombre, unidadMedida unidad) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            TypedQuery<Ingrediente> query = em.createQuery(
                    "SELECT i FROM Ingrediente i WHERE i.nombre = :nombre AND i.unidadMedida = :unidad",
                    Ingrediente.class);
            query.setParameter("nombre", nombre);
            query.setParameter("unidad", unidad);

            List<Ingrediente> ingredientes = query.getResultList();

            if (ingredientes.isEmpty()) {
                throw new PersistenciaException("No se encontró un ingrediente con ese nombre y unidad");
            }

            Ingrediente ingrediente = ingredientes.get(0);

            if (ingrediente.getProductos() != null && !ingrediente.getProductos().isEmpty()) {
                throw new PersistenciaException("No se puede eliminar el ingrediente porque está asociado a productos");
            }

            em.getTransaction().begin();
            em.remove(em.merge(ingrediente));
            em.getTransaction().commit();

        } catch (Exception e) {
            throw new PersistenciaException("Error al eliminar el ingrediente", e);
        } finally {
            em.close();
        }
    }

    public List<Ingrediente> obtenerTodos() throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            return em.createQuery("SELECT i FROM Ingrediente i", Ingrediente.class).getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener la lista de ingredientes.", e);
        }
    }

    /**
     * Filtro
     * @param nombre
     * @param unidad
     * @return
     * @throws PersistenciaException 
     */
    public List<Ingrediente> filtrarIngredientes(String nombre, String unidad) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        List<Ingrediente> resultados = new ArrayList<>();

        try {
            StringBuilder jpql = new StringBuilder("SELECT i FROM Ingrediente i WHERE 1=1");

            if (nombre != null && !nombre.trim().isEmpty()) {
                jpql.append(" AND LOWER(i.nombre) LIKE :nombre");
            }
            if (unidad != null && !unidad.trim().isEmpty()) {
                jpql.append(" AND LOWER(i.unidadMedida) LIKE :unidad");
            }

            TypedQuery<Ingrediente> query = em.createQuery(jpql.toString(), Ingrediente.class);

            if (nombre != null && !nombre.trim().isEmpty()) {
                query.setParameter("nombre", "%" + nombre.toLowerCase() + "%");
            }
            if (unidad != null && !unidad.trim().isEmpty()) {
                query.setParameter("unidad", "%" + unidad.toLowerCase() + "%");
            }

            resultados = query.getResultList();
            return resultados;
        } catch (Exception e) {
            throw new PersistenciaException("Error al filtrar ingredientes.", e);
        } finally {
            em.close();
        }
    }
    
    public List<Ingrediente> obtenerIngredientesRegistrados() throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            String jpql = "SELECT i FROM Ingrediente i";
            TypedQuery query = em.createQuery(jpql, Ingrediente.class);
            query.setMaxResults(5);
            
            return query.getResultList();
        } catch(Exception e) {
            throw new PersistenciaException("Error al consultar la Lista de Ingredientes");
        } finally {
            em.close();
        }
    }

}
