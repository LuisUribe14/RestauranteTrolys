package BOs;

import DAOs.MesaDAO;
import DTOs.MesaViejaDTO;
import entidades.Mesa;
import exception.NegocioException;
import exception.PersistenciaException;
import interfaces.IMesaDAO;
import java.util.ArrayList;
import java.util.List;
import mapper.MesaMapper;

/**
 *
 * @author daniel
 */
public class MesaBO {

    private IMesaDAO mesaDAO = MesaDAO.getInstancia();
    private static MesaBO mesaBO;

    public MesaBO() {
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
    
    /**
     * Regitra la mesa del parametro
     * 
     * @param mesaDTO
     * @throws NegocioException 
     */
    public void registrarMesa(MesaViejaDTO mesaDTO) throws NegocioException {
        try {
            if (mesaDTO.getNumero() == null || mesaDTO.getNumero() <= 0) {
                throw new NegocioException("El número de mesa debe ser mayor a cero.");
            }

            mesaDAO.registrarMesa(mesaDTO);

        } catch (PersistenciaException e) {
            throw new NegocioException("No se pudo registrar la mesa. " + e.getMessage());
        }
    }

    /**
     * 
     * @return El número de mesas registradas
     * @throws NegocioException 
     */
    public int obtenerCantidadMesasRegistradas() throws NegocioException {
        try {
            return mesaDAO.contarMesas();
        } catch (PersistenciaException e) {
            throw new NegocioException("No se pudo obtener la cantidad de mesas registradas.");
        }
    }
    
    /**
     * 
     * @return La lista de mesas registradas
     * @throws NegocioException 
     */
    public List<MesaViejaDTO> obtenerMesas() throws NegocioException {
        try {
            List<MesaViejaDTO> mesasDTO = new ArrayList();
            List<Mesa> mesas = mesaDAO.obtenerMesas();
            
            for (Mesa mesa : mesas) {
                mesasDTO.add(MesaMapper.toViejoDTO(mesa));
            }
            
            return mesasDTO;
        } catch (PersistenciaException e) {
            throw new NegocioException("No se pudo obtener Lista de Mesas.");
        }
    }

}
