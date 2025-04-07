/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author multaslokas33
 */
@Entity
@Table(name = "Comanda_Producto")
public class ComandaProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "cantidad", nullable = false)
    private Integer cantidadRequerida;
    @Column(name = "precio", nullable = false)
    private Double precioProducto;
    @Column(name = "comentario", length = 200)
    private String comentario;
    @Transient
    private String totalProducto;

    @ManyToOne
    @JoinColumn(name = "comanda_id")
    private Comanda comanda;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    public ComandaProducto() {
    }

    public ComandaProducto(Long id, Integer cantidadRequerida, Double precioProducto, String comentario, String totalProducto, Comanda comanda, Producto producto) {
        this.id = id;
        this.cantidadRequerida = cantidadRequerida;
        this.precioProducto = precioProducto;
        this.comentario = comentario;
        this.totalProducto = totalProducto;
        this.comanda = comanda;
        this.producto = producto;
    }

    public ComandaProducto(Integer cantidadRequerida, Double precioProducto, String comentario, String totalProducto, Comanda comanda, Producto producto) {
        this.cantidadRequerida = cantidadRequerida;
        this.precioProducto = precioProducto;
        this.comentario = comentario;
        this.totalProducto = totalProducto;
        this.comanda = comanda;
        this.producto = producto;
    }

    public Integer getCantidadRequerida() {
        return cantidadRequerida;
    }

    public void setCantidadRequerida(Integer cantidadRequerida) {
        this.cantidadRequerida = cantidadRequerida;
    }

    public Double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(Double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Comanda getComanda() {
        return comanda;
    }

    public void setComanda(Comanda comanda) {
        this.comanda = comanda;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTotalProducto() {
        return totalProducto;
    }

    public void setTotalProducto(String totalProducto) {
        this.totalProducto = totalProducto;
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
        if (!(object instanceof ComandaProducto)) {
            return false;
        }
        ComandaProducto other = (ComandaProducto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ComandaProducto{" + "id=" + id + ", cantidadRequerida=" + cantidadRequerida + ", precioProducto=" + precioProducto + ", comentario=" + comentario + ", totalProducto=" + totalProducto + ", comanda=" + comanda + ", producto=" + producto + '}';
    }
    
}
