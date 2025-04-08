package interfaces;

import entidades.Comanda;
import exception.PersistenciaException;

/**
 *
 * @author daniel
 */
public interface IComandaDAO {
    
    public Comanda registrarComanda(Comanda comanda) throws PersistenciaException;
}
