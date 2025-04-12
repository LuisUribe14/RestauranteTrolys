package interfaces;

import DTOs.MesaViejaDTO;
import entidades.Mesa;
import exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author daniel
 */
public interface IMesaDAO {
    
    public boolean registrarMesa(MesaViejaDTO mesaDTO) throws PersistenciaException;
     
    public int contarMesas() throws PersistenciaException;
    
    public List<Mesa> obtenerMesas() throws PersistenciaException;
}
