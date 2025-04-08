/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.restaurantepersistencia;

import DAOs.ClienteFrecuenteDAO;
import DAOs.ComandaDAO;
import entidades.ClienteFrecuente;
import entidades.Comanda;
import enums.estadoComanda;
import exception.PersistenciaException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author multaslokas33
 */
public class RestaurantePersistencia {

    public static void main(String[] args) throws PersistenciaException {

        ClienteFrecuenteDAO dao = new ClienteFrecuenteDAO();
        ComandaDAO d = new ComandaDAO();

        ClienteFrecuente cliente1 = new ClienteFrecuente();
        cliente1.setNombre("crit");
        cliente1.setApellidoPaterno("buelna");
        cliente1.setApellidoMaterno("uribe");
        cliente1.setCorreo("crit@gmail.com");
        cliente1.setTelefono("62222442");
        
        ClienteFrecuente cliente2 = new ClienteFrecuente();
        cliente2.setNombre("daniel");
        cliente2.setApellidoPaterno("alvarez");
        cliente2.setApellidoMaterno("rosas");
        cliente2.setCorreo("daniel@gmail.com");
        cliente2.setTelefono("9292822");

        try {
            cliente1 = dao.registrarClienteFrecuente(cliente1);
            cliente2 = dao.registrarClienteFrecuente(cliente2);
            System.out.println("Cliente registrado exitosamente con ID: " + cliente1.getId()); // Agrega un mensaje de confirmación
        } catch (PersistenciaException e) {
            System.out.println("Error al registrar al cliente: " + e.getMessage());
        }

        Comanda comanda = new Comanda();
        comanda.setEstado(estadoComanda.ENTREGADO);
        comanda.setFechaYHora(LocalDateTime.now());
        comanda.setTotalVenta(100.0);
        comanda.setFolio("AB1");
        comanda.setCliente(cliente1);

        try {
            d.registrarComanda(comanda);
            System.out.println("Comanda Registrada");
        } catch (PersistenciaException e) {
            System.out.println("Error al registrar la comanda: " + e.getMessage());
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

        try {
            List<ClienteFrecuente> clientesFiltrados = dao.filtrarClientesFrecuentes("crit", null, null);
            System.out.println("Clientes filtrados por nombre:");
            for (ClienteFrecuente c : clientesFiltrados) {
                System.out.println(c.getNombreCompleto() + " - " + c.getCorreo());
            }
        } catch (PersistenciaException e) {
            System.out.println("Error al obtener los clientes frecuentes: " + e.getMessage());
        }
        
        try {
            List<ClienteFrecuente> clientesFiltrados = dao.filtrarClientesFrecuentes(null, "62222442", null);
            System.out.println("Clientes filtrados por telefono:");
            for (ClienteFrecuente c : clientesFiltrados) {
                System.out.println(c.getNombreCompleto() + " - " + c.getCorreo());
            }
        } catch (PersistenciaException e) {
            System.out.println("Error al obtener los clientes frecuentes: " + e.getMessage());
        }
        
        try {
            List<ClienteFrecuente> clientesFiltrados = dao.filtrarClientesFrecuentes(null, null, "crit");
            System.out.println("Clientes filtrados por correo:");
            for (ClienteFrecuente c : clientesFiltrados) {
                System.out.println(c.getNombreCompleto() + " - " + c.getCorreo());
            }
        } catch (PersistenciaException e) {
            System.out.println("Error al obtener los clientes frecuentes: " + e.getMessage());
        }
        
        try {
            List<ClienteFrecuente> clientesFiltrados = dao.filtrarClientesFrecuentes("daniel", "9292822", null);
            System.out.println("Clientes filtrados por nombre y telefono:");
            for (ClienteFrecuente c : clientesFiltrados) {
                System.out.println(c.getNombreCompleto() + " - " + c.getCorreo());
            }
        } catch (PersistenciaException e) {
            System.out.println("Error al obtener los clientes frecuentes: " + e.getMessage());
        }
    }
}
