package interfaces;

import entidades.Mesa;
import exception.PersistenciaException;

/**
 *
 * @author daniel
 */
public interface IMesaDAO {
    
    public boolean registrarCantidadMesas(Mesa mesa) throws PersistenciaException;
}
