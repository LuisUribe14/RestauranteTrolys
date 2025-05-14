package com.mycompany.restaurantepersistencia;

import DAOs.ComandaDAO;
import DAOs.ProductoDAO;
import conexion.Conexion;
import entidades.Comanda;
import entidades.ComandaProducto;
import entidades.Ingrediente;
import entidades.Producto;
import entidades.ProductoIngrediente;
import enums.estadoProducto;
import enums.tipoProducto;
import enums.unidadMedida;
import exception.PersistenciaException;
import javax.persistence.EntityManager;

/**
 *
 * @author daniel
 */
public class PruebasDaniel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
//        Ingrediente i = new Ingrediente("pan", unidadMedida.GRAMOS, 2);
//        Ingrediente i2 = new Ingrediente("carne", unidadMedida.PIEZAS, 2);
        
        Producto p = new Producto("L", 100.00, tipoProducto.PLATILLO, estadoProducto.DISPONIBLE);
        ProductoIngrediente pi = new ProductoIngrediente(2.00, p, em.find(Ingrediente.class, 1L));
        ProductoIngrediente pi2 = new ProductoIngrediente(1.00, p, em.find(Ingrediente.class, 2L));
        
//        em.getTransaction().begin();
//        em.persist(i);
//        em.persist(i2);
//        em.getTransaction().commit();
        
        p.getIngredientes().add(pi);
        p.getIngredientes().add(pi2);
//        
//        Producto pGuardado = ProductoDAO.getInstancia().registrarProducto(p);
//        System.out.println("ID: " + pGuardado.getId());
//         Producto p2 = new Producto();
//         System.out.println(p2.getId());
       
//        System.out.println(ProductoDAO.getInstancia().obtenerProductosDisponibles());
         
        // COMANDAS
//        System.out.println(ProductoDAO.getInstancia().obtenerProductosFiltrados("Pizza", tipoProducto.PLATILLO));
           
//        Producto producto = em.find(Producto.class, 1L);
//        producto.setEstado(estadoProducto.DISPONIBLE);
//        ProductoDAO.getInstancia().actualizarProducto(producto);

//        System.out.println(ProductoDAO.getInstancia().obtenerProductosRegistrados());
//        System.out.println(ProductoDAO.getInstancia().obtenerProductosIngredientes(13L));
    
//        System.out.println(ProductoDAO.getInstancia().obtenerProducto("h"));
//        System.out.println(ProductoDAO.getInstancia().obtenerProductosDisponibles(null, null));
//        System.out.println(ComandaDAO.getInstancia().obtenerCantidadComandas());
//        Comanda c = em.find(Comanda.class, 1L);
//        c.setTotalVenta(100.0);
//        ComandaDAO.getInstancia().actualizarComanda(c);

//        Comanda c = em.find(Comanda.class, 7L);
//        System.out.println(c.getProductos());
//        ComandaProducto cp = new ComandaProducto(1, 80.0, "comentario", 80.0, c, em.find(Producto.class, 1L));
//        c.getProductos().add(cp);
//        ComandaDAO.getInstancia().actualizarComanda(c);

        System.out.println(ComandaDAO.getInstancia().removerComandaProducto(new ComandaProducto()));
    }
    
}
