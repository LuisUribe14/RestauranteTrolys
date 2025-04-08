package interfaces;

import exception.PersistenciaException;

/**
 *
 * @author daniel
 */
public interface IMesaDAO {
    
    public boolean registrarCantidadMesas(Integer cantidad) throws PersistenciaException;
}
