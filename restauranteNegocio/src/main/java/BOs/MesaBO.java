package BOs;

import DAOs.MesaDAO;
import exception.NegocioException;
import exception.PersistenciaException;
import interfaces.IMesaDAO;

/**
 *
 * @author daniel
 */
public class MesaBO {
    
    private IMesaDAO mesaDAO = MesaDAO.getInstancia();
    private static MesaBO mesaBO;
    
    private MesaBO() {
    }
    
    public MesaBO getInstancia() {
        if (mesaBO == null) {
            return new MesaBO();
        }
        return mesaBO;
    }
    
    public boolean registrarCantidadMesas(Integer cantidad) throws NegocioException {
        if (cantidad == null || cantidad == 0) {
            throw new NegocioException("Error, la cantidad no puede estar vacia.");
        }
        
        try {
            mesaDAO.registrarCantidadMesas(cantidad);
            
            return true;
        } catch(PersistenciaException e) {
            throw new NegocioException("Error al reistrar mesas.");
        }
    }
}
