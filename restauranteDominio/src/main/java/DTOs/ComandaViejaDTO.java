package DTOs;

import enums.estadoComanda;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author daniel
 */
public class ComandaViejaDTO {
    
    private Long id;
    private String folio;
    private estadoComanda estado;
    private LocalDateTime fechaYHora;
    private Double totalVenta;
    private ClienteFrecuenteViejoDTO cliente;
    private MesaViejaDTO mesa;
    private List<ComandaProductoViejaDTO> productos = new ArrayList();

    public ComandaViejaDTO() {
    }

    public ComandaViejaDTO(Long id, String folio, estadoComanda estado, LocalDateTime fechaYHora, Double totalVenta, ClienteFrecuenteViejoDTO cliente, MesaViejaDTO mesa) {
        this.id = id;
        this.folio = folio;
        this.estado = estado;
        this.fechaYHora = fechaYHora;
        this.totalVenta = totalVenta;
        this.cliente = cliente;
        this.mesa = mesa;
    }

    public ComandaViejaDTO(Long id, String folio, estadoComanda estado, LocalDateTime fechaYHora, Double totalVenta, MesaViejaDTO mesa) {
        this.id = id;
        this.folio = folio;
        this.estado = estado;
        this.fechaYHora = fechaYHora;
        this.totalVenta = totalVenta;
        this.mesa = mesa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public estadoComanda getEstado() {
        return estado;
    }

    public void setEstado(estadoComanda estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(LocalDateTime fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    public Double getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(Double totalVenta) {
        this.totalVenta = totalVenta;
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

    public List<ComandaProductoViejaDTO> getProductos() {
        return productos;
    }

    public void setProductos(List<ComandaProductoViejaDTO> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "ComandaViejaDTO{" + "id=" + id + ", folio=" + folio + ", estado=" + estado + ", fechaYHora=" + fechaYHora + ", totalVenta=" + totalVenta + '}';
    }
    
}
