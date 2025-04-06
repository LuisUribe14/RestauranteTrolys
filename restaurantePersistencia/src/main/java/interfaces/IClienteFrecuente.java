/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.ClienteFrecuente;
import exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author multaslokas33
 */
public interface IClienteFrecuente {
    
    public ClienteFrecuente registrarClienteFrecuente(ClienteFrecuente cliente) throws PersistenciaException;
    
    public List<ClienteFrecuente> filtrarClientesFrecuentes(String nombre, String correo, String telefono) throws PersistenciaException;
    
    public ClienteFrecuente obtenerClienteFrecuentePorId(Long id) throws PersistenciaException;
    
    public List<ClienteFrecuente> obtenerTodosLosClientesFrecuentes() throws PersistenciaException;
    
    public int calcularVisitas(Long clienteId) throws PersistenciaException;
    
    public double calcularTotalGastado(Long clienteId) throws PersistenciaException;
    
    public int calcularPuntos(Long clienteId) throws PersistenciaException;
}
