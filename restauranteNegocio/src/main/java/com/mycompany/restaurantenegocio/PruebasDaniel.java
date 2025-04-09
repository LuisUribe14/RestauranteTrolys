package com.mycompany.restaurantenegocio;

import BOs.ComandaBO;
import BOs.MesaBO;
import BOs.ProductoBO;
import DTOs.ClienteFrecuenteViejoDTO;
import DTOs.ComandaNuevaDTO;
import DTOs.ComandaProductoNuevaDTO;
import DTOs.IngredienteViejoDTO;
import DTOs.MesaViejaDTO;
import DTOs.ProductoIngredienteNuevoDTO;
import DTOs.ProductoNuevoDTO;
import DTOs.ProductoViejoDTO;
import conexion.Conexion;
import entidades.ClienteFrecuente;
import entidades.Ingrediente;
import entidades.Mesa;
import entidades.Producto;
import enums.estadoComanda;
import enums.estadoProducto;
import enums.tipoProducto;
import exception.NegocioException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import mapper.ClienteFrecuenteMapper;
import mapper.MesaMapper;
import mapper.ProductoMapper;
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
//        IngredienteViejoDTO ingredienteViejoDTO = ingredienteMapper.toViejoDTO(em.find(Ingrediente.class, 1L));
//        ProductoIngredienteNuevoDTO productoIngredienteNuevoDTO = new ProductoIngredienteNuevoDTO(10.00, ingredienteViejoDTO);
//        List<ProductoIngredienteNuevoDTO> ingredientesDTO = Arrays.asList(productoIngredienteNuevoDTO);
//        ProductoNuevoDTO productoNuevoDTO = new ProductoNuevoDTO("Pizza", 10.00, tipoProducto.PLATILLO, estadoProducto.DISPONIBLE, ingredientesDTO);
//        ProductoBO.getInstancia().registrarProducto(productoNuevoDTO);

//        ProductoViejoDTO productoViejoDTO = ProductoMapper.toViejoDTO(em.find(Producto.class, 2L));
//        productoViejoDTO.setEstado(estadoProducto.NO_DISPONIBLE);
//        ProductoBO.getInstancia().actualizarEstado(productoViejoDTO);

//        System.out.println(ProductoBO.getInstancia().obtenerTodos());

        // COMANDAS
//        System.out.println(ComandaBO.getInstancia().generarFolio(LocalDateTime.now()));
//        MesaBO.getInstancia().registrarCantidadMesas(20);

//        ClienteFrecuenteViejoDTO cliente = ClienteFrecuenteMapper.toViejoDTO(em.find(ClienteFrecuente.class, 1L));
//        MesaViejaDTO mesa = MesaMapper.toViejoDTO(em.find(Mesa.class, 5L));
//        ProductoViejoDTO producto = ProductoMapper.toViejoDTO(em.find(Producto.class, 1L));
//        ComandaProductoNuevaDTO comandaDTO = new ComandaProductoNuevaDTO(2, 100.00, "si", producto);
//        List<ComandaProductoNuevaDTO> productos = Arrays.asList(comandaDTO);
//        ComandaNuevaDTO comanda = new ComandaNuevaDTO(estadoComanda.ENTREGADO, cliente, mesa, productos);
//        ComandaBO.getInstancia().registrarComanda(comanda);

        System.out.println(ProductoBO.getInstancia().obtenerProductosFiltrados("", null));
//        System.out.println(ProductoBO.getInstancia().obtenerProductosDisponibles());
    }
    
}
