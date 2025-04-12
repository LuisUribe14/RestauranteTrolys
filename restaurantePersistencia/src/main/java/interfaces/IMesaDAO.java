package interfaces;

import DTOs.MesaViejaDTO;
import entidades.Mesa;
import exception.PersistenciaException;

/**
 *
 * @author daniel
 */
public interface IMesaDAO {
    
     public boolean registrarMesa(MesaViejaDTO mesaDTO) throws PersistenciaException;
     
    public int contarMesas() throws PersistenciaException;
}
