/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.restaurantepersistencia;

import DAOs.ClienteFrecuenteDAO;
import entidades.ClienteFrecuente;
import entidades.Comanda;
import enums.estadoComanda;
import exception.PersistenciaException;
import java.time.LocalDate;
import java.util.List;


/**
 *
 * @author multaslokas33
 */
public class RestaurantePersistencia {

    public static void main(String[] args) throws PersistenciaException {
        
        ClienteFrecuenteDAO dao = new ClienteFrecuenteDAO();

        ClienteFrecuente cliente1 = new ClienteFrecuente();
        cliente1.setNombre("crit");
        cliente1.setApellidoPaterno("buelna");
        cliente1.setApellidoMaterno("uribe");
        cliente1.setCorreo("crit@gmail.com");
        cliente1.setTelefono("62222442");
        
        try{
            cliente1 = dao.registrarClienteFrecuente(cliente1);
            System.out.println("Cliente registrado exitosamente con ID: " + cliente1.getId()); // Agrega un mensaje de confirmación
        }catch (PersistenciaException e){
            System.out.println("Error al registrar al cliente: "+ e.getMessage());
        }
        
        Comanda comanda = new Comanda();
        comanda.setEstado(estadoComanda.ENTREGADO);
        comanda.setFechaYHora(LocalDate.now());
        comanda.setTotalVenta(100.0);
        comanda.setFolio("AB1");
        comanda.setCliente(cliente1);
        
        try{
            dao.registrarComanda(comanda);
            System.out.println("Comanda Registrada");
        }catch (PersistenciaException e){
            System.out.println("Error al registrar la comanda: "+ e.getMessage());
        }
        
        Double gastoTotal1 = dao.calcularTotalGastado(cliente1);
        int conteoVisitas1 = dao.calcularVisitas(cliente1);
        int puntos1 = dao.calcularPuntos(cliente1);
        System.out.println("Cliente 1 - " + cliente1.getNombre());
        System.out.println("Gasto Total: " + gastoTotal1);  
        System.out.println("Visitas: " + conteoVisitas1);
        System.out.println("Puntos: " + puntos1);
        
         try {
            List<ClienteFrecuente> clientes = dao.obtenerTodosLosClientesFrecuentes();
            System.out.println("Clientes frecuentes registrados:");
            for (ClienteFrecuente c : clientes) {
                System.out.println(c.getNombre() + " - " + c.getCorreo());
            }
        } catch (PersistenciaException e) {
            System.out.println("Error al obtener los clientes frecuentes: " + e.getMessage());
        }
    }
    
}
