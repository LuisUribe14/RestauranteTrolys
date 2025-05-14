package DTOs;

import enums.estadoComanda;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author daniel
 */
public class ComandaNuevaDTO {
    
    private estadoComanda estado;
    private ClienteFrecuenteViejoDTO cliente;
    private MesaViejaDTO mesa;
    private List<ComandaProductoNuevaDTO> productos = new ArrayList();

    public ComandaNuevaDTO() {
    }

    public ComandaNuevaDTO(estadoComanda estado, ClienteFrecuenteViejoDTO cliente, MesaViejaDTO mesa, List<ComandaProductoNuevaDTO> productos) {
        this.estado = estado;
        this.cliente = cliente;
        this.mesa = mesa;
        this.productos = productos;
    }

    public estadoComanda getEstado() {
        return estado;
    }

    public void setEstado(estadoComanda estado) {
        this.estado = estado;
    }

    public ClienteFrecuenteViejoDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteFrecuenteViejoDTO cliente) {
        this.cliente = cliente;
    }

    public MesaViejaDTO getMesa() {
        return mesa;
    }

    public void setMesa(MesaViejaDTO mesa) {
        this.mesa = mesa;
    }

    public List<ComandaProductoNuevaDTO> getProductos() {
        return productos;
    }

    public void setProductos(List<ComandaProductoNuevaDTO> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "ComandaNuevaDTO{" + "estado=" + estado + ", totalVenta=" + '}';
    }
    
}
