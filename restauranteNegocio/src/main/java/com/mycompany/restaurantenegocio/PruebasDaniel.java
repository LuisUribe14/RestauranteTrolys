package com.mycompany.restaurantenegocio;

import BOs.ProductoBO;
import DTOs.IngredienteViejoDTO;
import DTOs.ProductoIngredienteNuevoDTO;
import DTOs.ProductoNuevoDTO;
import conexion.Conexion;
import entidades.Ingrediente;
import enums.estadoProducto;
import enums.tipoProducto;
import exception.NegocioException;
import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import mapper.ingredienteMapper;

/**
 *
 * @author daniel
 */
public class PruebasDaniel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NegocioException {
        EntityManager em = Conexion.crearConexion();
        IngredienteViejoDTO ingredienteViejoDTO = ingredienteMapper.toViejoDTO(em.find(Ingrediente.class, 1L));
        ProductoIngredienteNuevoDTO productoIngredienteNuevoDTO = new ProductoIngredienteNuevoDTO(10.00, ingredienteViejoDTO);
        List<ProductoIngredienteNuevoDTO> ingredientesDTO = Arrays.asList(productoIngredienteNuevoDTO);
        ProductoNuevoDTO productoNuevoDTO = new ProductoNuevoDTO("Pizza", 10.00, tipoProducto.PLATILLO, estadoProducto.DISPONIBLE, ingredientesDTO);
        ProductoBO.getInstancia().registrarProducto(productoNuevoDTO);
    }
    
}
