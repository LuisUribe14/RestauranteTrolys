/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.clientesFrecuentes;
import exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author multaslokas33
 */
public interface IClienteFrecuente {
    
    public void registrarClienteFrecuente(clientesFrecuentes cliente) throws PersistenciaException;
    
    public List<clientesFrecuentes> buscarClientesFrecuentes(String nombre, String telefono, String correo) throws PersistenciaException;
    
    public List<clientesFrecuentes> obtenerTodosLosClientesFrecuentes() throws PersistenciaException;
    
    public int calcularVisitas(Long clienteId);
    
    public double calcularTotalGastado(Long clienteId);
    
    public int calcularPuntos(Long clienteId);
}
