/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import DAOs.ingredienteDao;
import entidades.Ingrediente;
import enums.unidadMedida;
import exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author chris
 */
public class ingredienteBO {

    private ingredienteDao dao = ingredienteDao.getInstancia();

    /**
     * Utilizamos el patron Singleton para evitar duplicados y varias instancias
     */
    private static ingredienteBO instanceIngredienteBO;

    /**
     * Metodo para crear la instanica en dado caso que no haya sido creada, y si
     * ya esta creado retornamos la ya creada
     *
     * @return
     */
    public static ingredienteBO getInstancia() {
        if (instanceIngredienteBO == null) {
            instanceIngredienteBO = new ingredienteBO();
        }
        return instanceIngredienteBO;
    }

    /**
     * Metodo que primero tiene que pasar por las validaciones y que manda a
     * llamar al metodo existeIngrediente, para corroborar que al momento de
     * agregar un ingrediente no se se repita su nombre y tu tipo de unidad
     *
     * @param ingrediente
     * @throws PersistenciaException
     */
    public void agregarIngrediente(Ingrediente ingrediente) throws PersistenciaException {

        if (dao.existeIngrediente(ingrediente.getNombre(), ingrediente.getUnidadMedida())) {
            throw new PersistenciaException("Ya existe un ingrediente con el mismo nombre y unidad de medida.");
        }
        if (ingrediente.getNombre() == null || ingrediente.getNombre().trim().isEmpty()) {
            throw new PersistenciaException("El nombre del ingrediente no puede estar vacío.");
        }

        if (ingrediente.getUnidadMedida() == null) {
            throw new PersistenciaException("Debe seleccionar una unidad de medida.");
        }

        if (ingrediente.getStock() < 0) {
            throw new PersistenciaException("El stock no puede ser negativo.");
        }
        if (ingrediente.getNombre().length() > 100) {
            throw new PersistenciaException("El nombre del ingrediente es demasiado largo. Máximo 100 caracteres.");
        }

        if (!ingrediente.getNombre().matches("[a-zA-ZÁÉÍÓÚÑáéíóúñ\\s]+")) {
            throw new PersistenciaException("El nombre del ingrediente solo debe contener letras y espacios.");
        }

        if (ingrediente.getStock() > 99999) {
            throw new PersistenciaException("El stock no puede ser mayor a 99,999.");
        }

        if (ingrediente.getUnidadMedida() == null) {
            throw new PersistenciaException("Debe seleccionar una unidad de medida válida.");
        }

        //                                        _______
        //NECECTIO QUE AGREGUES MAS validaciones |<.> <.>|
        //                                       |___-___|
        dao.agregarIngrediente(ingrediente);
    }

    /**
     * Metodo en el que validamos que validamos si se puede descontar el stock,
     * en caso de que no mnadamos una exception de que no se puede descontar
     *
     * @param ingrediente
     * @param cantidad
     * @throws PersistenciaException
     */
    public void descontarStock(Ingrediente ingrediente, int cantidad) throws PersistenciaException {
        if (ingrediente.getStock() < cantidad) {
            throw new PersistenciaException("No se puede descontar, stock insuficiente");
        }
        ingrediente.setStock(ingrediente.getStock() - cantidad);
        dao.actualizarIngrediente(ingrediente);
    }

    public List<Ingrediente> buscarIngredientes(String filtro) throws PersistenciaException {
        return dao.buscarPorNombreOUm(filtro);
    }

    public void eliminarIngredientePorNombreYUnidad(String nombre, unidadMedida unidad) throws PersistenciaException {
        try {
            if (nombre == null || nombre.trim().isEmpty() || unidad == null) {
                throw new PersistenciaException("Nombre o unidad de medida inválidos");
            }

            dao.eliminarIngredientePorNombreYUnidad(nombre.trim(), unidad);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
    }

}
