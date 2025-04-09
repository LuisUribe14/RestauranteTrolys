package BOs;

import DAOs.MesaDAO;
import entidades.Mesa;
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
    
    public static MesaBO getInstancia() {
        if (mesaBO == null) {
            return new MesaBO();
        }
        return mesaBO;
    }
    
//    public boolean registrarCantidadMesas(Integer cantidad) throws NegocioException {
//        if (cantidad == null || cantidad == 0) {
//            throw new NegocioException("Error, la cantidad no puede estar vacia.");
//        }
//        if (cantidad > 20) {
//            throw new NegocioException("Error, la cantidad no puede ser mayor a 20");
//        }
//        
//        try {
//            for (Integer i = 1; i < cantidad+1; i++) {
//                Mesa mesa = new Mesa(i);
//                mesaDAO.registrarCantidadMesas(mesa);
//            }
//            
//            return true;
//        } catch(PersistenciaException e) {
//            throw new NegocioException("Error al reistrar mesas.");
//        }
//    }
    
}
