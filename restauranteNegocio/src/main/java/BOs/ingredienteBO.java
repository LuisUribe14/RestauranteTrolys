/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import DAOs.ingredienteDao;
import entidades.Ingrediente;
import exception.PersistenciaException;

/**
 *
 * @author chris
 */
public class ingredienteBO {

    private ingredienteDao dao = ingredienteDao.getInstancia();

    /**
     *  Utilizamos el patron Singleton para evitar duplicados y varias instancias
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
}
