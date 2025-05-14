package interfaces;

import entidades.Comanda;
import enums.estadoComanda;
import exception.PersistenciaException;
import java.util.List;
import javax.persistence.PersistenceException;

/**
 *
 * @author daniel
 */
public interface IComandaDAO {
    
    public Comanda registrarComanda(Comanda comanda) throws PersistenciaException;
    
    public Long obtenerCantidadComandas() throws PersistenciaException;
    
    public boolean actualizarComanda(Comanda comanda) throws PersistenciaException;
    
    public List<Comanda> obtenerComandasPorEstado(estadoComanda estado) throws PersistenciaException;
}
