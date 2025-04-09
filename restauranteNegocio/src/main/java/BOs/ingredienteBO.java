/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import DAOs.ingredienteDao;
import DTOs.IngredienteViejoDTO;
import DTOs.ingredienteDTO;
import DTOs.ingredienteNuevoDTO;
import entidades.Ingrediente;
import enums.unidadMedida;
import exception.PersistenciaException;
import java.util.ArrayList;
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

    public void agregarIngrediente(ingredienteNuevoDTO dto) throws PersistenciaException {
        if (dto.getNombre() == null || dto.getNombre().trim().isEmpty()) {
            throw new PersistenciaException("El nombre del ingrediente no puede estar vacío.");
        }

        if (dto.getUnidadMedida() == null) {
            throw new PersistenciaException("Debe seleccionar una unidad de medida.");
        }

        if (dto.getStock() == null || dto.getStock() < 0) {
            throw new PersistenciaException("El stock no puede ser negativo.");
        }

        if (dto.getNombre().length() > 100) {
            throw new PersistenciaException("El nombre del ingrediente es demasiado largo. Máximo 100 caracteres.");
        }

        if (!dto.getNombre().matches("[a-zA-ZÁÉÍÓÚÑáéíóúñ\\s]+")) {
            throw new PersistenciaException("El nombre del ingrediente solo debe contener letras y espacios.");
        }

        if (dto.getStock() > 99999) {
            throw new PersistenciaException("El stock no puede ser mayor a 99,999.");
        }

        if (dao.existeIngrediente(dto.getNombre(), dto.getUnidadMedida())) {
            throw new PersistenciaException("Ya existe un ingrediente con el mismo nombre y unidad de medida.");
        }

        // Transformar DTO en entidad
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setNombre(dto.getNombre());
        ingrediente.setUnidadMedida(dto.getUnidadMedida());
        ingrediente.setStock(dto.getStock());

        dao.agregarIngrediente(ingrediente);
    }

    public void descontarStock(IngredienteViejoDTO dto, int cantidad) throws PersistenciaException {
        Ingrediente ing = dao.obtenerIngrediente(dto.getNombre(), dto.getUnidadMedida());

        if (ing == null) {
            throw new PersistenciaException("No se encontró el ingrediente.");
        }

        if (ing.getStock() < cantidad) {
            throw new PersistenciaException("No se puede descontar, stock insuficiente");
        }

        ing.setStock(ing.getStock() - cantidad);
        dao.actualizarIngrediente(ing);
    }

//    public List<Ingrediente> buscarIngredientes(String filtro) throws PersistenciaException {
//        return dao.buscarPorNombreOUm(filtro);
//    }

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

    public List<ingredienteDTO> obtenerTodosDTO() throws PersistenciaException {
        List<Ingrediente> ingredientes = dao.obtenerTodos();
        List<ingredienteDTO> listaDTO = new ArrayList<>();

        for (Ingrediente ing : ingredientes) {
            listaDTO.add(new ingredienteDTO(ing.getNombre(), ing.getUnidadMedida(), ing.getStock()));
        }

        return listaDTO;
    }

    public List<ingredienteDTO> filtrarIngredientesDTO(String nombre, String unidad) throws PersistenciaException {
        List<Ingrediente> ingredientes = dao.filtrarIngredientes(nombre, unidad);
        List<ingredienteDTO> listaDTO = new ArrayList<>();

        for (Ingrediente ing : ingredientes) {
            listaDTO.add(new ingredienteDTO(ing.getNombre(), ing.getUnidadMedida(), ing.getStock()));
        }

        return listaDTO;
    }

}
