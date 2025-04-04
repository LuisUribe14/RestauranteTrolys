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

    private static ingredienteBO instanceIngredienteBO;

    public static ingredienteBO getInstancia() {
        if (instanceIngredienteBO == null) {
            instanceIngredienteBO = new ingredienteBO();
        }
        return instanceIngredienteBO;
    }

    public void agregarIngrediente(Ingrediente ingrediente) throws PersistenciaException {
        
        if (dao.existeIngrediente(ingrediente.getNombre(), ingrediente.getUnidadMedida())) {
            throw new PersistenciaException("Ya existe un ingrediente con el mismo nombre y unidad de medida.");
        }

        
        dao.agregarIngrediente(ingrediente);
    }
}
