/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.restaurantepersistencia;

import DAOs.ClienteFrecuenteDAO;
import DAOs.ProductoDAO;
import DAOs.ingredienteDao;
import DTOs.ingredienteNuevoDTO;
import conexion.Conexion;
import entidades.ClienteFrecuente;
import entidades.Ingrediente;
import entidades.Producto;
import entidades.ProductoIngrediente;
import enums.estadoProducto;
import enums.tipoProducto;
import enums.unidadMedida;
import exception.PersistenciaException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author multaslokas33
 */
public class RestaurantePersistencia {

    public static void main(String[] args) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        Ingrediente i = new Ingrediente("pan", unidadMedida.GRAMOS, 2);
        Ingrediente i2 = new Ingrediente("carne", unidadMedida.PIEZAS, 2);
        
        Producto p = new Producto("L", 100.00, tipoProducto.PLATILLO, estadoProducto.DISPONIBLE);
        ProductoIngrediente pi = new ProductoIngrediente(2.00, p, em.find(Ingrediente.class, 1L));
        ProductoIngrediente pi2 = new ProductoIngrediente(1.00, p, em.find(Ingrediente.class, 2L));
        
//        em.getTransaction().begin();
//        em.persist(i);
//        em.persist(i2);
//        em.getTransaction().commit();
        
        p.getIngredientes().add(pi);
        p.getIngredientes().add(pi2);
        
        Producto pGuardado = ProductoDAO.getInstancia().registrarProducto(p);
        System.out.println("ID: " + pGuardado.getId());
    } 
}
