/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.ClienteFrecuente;
import entidades.Comanda;
import exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author multaslokas33
 */
public interface IClienteFrecuente {
    
    public void registrarComanda(Comanda comanda) throws PersistenciaException;
    
    public ClienteFrecuente registrarClienteFrecuente(ClienteFrecuente cliente) throws PersistenciaException;
    
    public List<ClienteFrecuente> filtrarClientesFrecuentes(String nombre, String telefono, String correo) throws PersistenciaException;
    
    public ClienteFrecuente obtenerClienteFrecuentePorId(Long id) throws PersistenciaException;
    
    public List<ClienteFrecuente> obtenerTodosLosClientesFrecuentes() throws PersistenciaException;
    
    public Integer calcularVisitas(ClienteFrecuente cliente) throws PersistenciaException;
    
    public Double calcularTotalGastado(ClienteFrecuente cliente) throws PersistenciaException;
    
    public Integer calcularPuntos(ClienteFrecuente cliente) throws PersistenciaException;
}
