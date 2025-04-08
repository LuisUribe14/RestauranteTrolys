/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import enums.estadoComanda;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author multaslokas33
 */
@Entity
@Table(name= "Comandas")
public class Comanda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "folio", unique = true, nullable = false, length = 50)
    private String folio;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false, length = 50)
    private estadoComanda estado;
    @Column(name = "fecha_hora", nullable = false)
    private LocalDateTime fechaYHora;
    @Column(name = "total_Venta", nullable = false)
    private Double totalVenta;
    
    @OneToMany(mappedBy = "comanda")
    private List<ComandaProducto> productos;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "mesa_id")
    private Mesa mesa;

    public Comanda() {
    }

    public Comanda(Long id, String folio, estadoComanda estado, LocalDateTime fechaYHora, Double totalVenta, List<ComandaProducto> productos, Cliente cliente, Mesa mesa) {
        this.id = id;
        this.folio = folio;
        this.estado = estado;
        this.fechaYHora = fechaYHora;
        this.totalVenta = totalVenta;
        this.productos = productos;
        this.cliente = cliente;
        this.mesa = mesa;
    }

    public Comanda(String folio, estadoComanda estado, LocalDateTime fechaYHora, Double totalVenta, List<ComandaProducto> productos, Cliente cliente, Mesa mesa) {
        this.folio = folio;
        this.estado = estado;
        this.fechaYHora = fechaYHora;
        this.totalVenta = totalVenta;
        this.productos = productos;
        this.cliente = cliente;
        this.mesa = mesa;
    }

    public Comanda(String folio, estadoComanda estado, LocalDateTime fechaYHora, Double totalVenta, Cliente cliente, Mesa mesa) {
        this.folio = folio;
        this.estado = estado;
        this.fechaYHora = fechaYHora;
        this.totalVenta = totalVenta;
        this.cliente = cliente;
        this.mesa = mesa;
        this.productos = new ArrayList();
    }

    public Comanda(estadoComanda estado) {
        this.estado = estado;
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
    
    public List<ComandaProducto> getProductos() {
        return productos;
    }

    public void setProductos(List<ComandaProducto> productos) {
        this.productos = productos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(Double totalVenta) {
        this.totalVenta = totalVenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comanda)) {
            return false;
        }
        Comanda other = (Comanda) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Comanda{" + "id=" + id + ", folio=" + folio + ", estado=" + estado + ", fechaYHora=" + fechaYHora + ", totalVenta=" + totalVenta + '}';
    }
    
}