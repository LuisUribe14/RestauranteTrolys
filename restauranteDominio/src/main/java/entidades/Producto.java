/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import enums.estadoProducto;
import enums.tipoProducto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author multaslokas33
 */
@Entity
@Table(name = "Productos")
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nombre", unique = true, nullable = false, length = 200)
    private String nombre;
    @Column(name = "precio", nullable = false)
    private Double precio;
    @Column(name = "tipo", nullable = false, length = 100)
    private tipoProducto tipo;
    @Column(name = "estado", nullable = false, length = 100)
    private estadoProducto estado;

    @OneToMany(mappedBy = "producto", cascade = {CascadeType.PERSIST}, orphanRemoval = true)
    private List<ProductoIngrediente> ingredientes;

    @OneToMany(mappedBy = "producto")
    private List<ComandaProducto> comandas;
    
    public Producto() {
    }

    public Producto(Long id, String nombre, Double precio, tipoProducto tipo, estadoProducto estado) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
        this.estado = estado;
        this.ingredientes = new ArrayList();
        this.comandas = new ArrayList();
    }

    public Producto(String nombre, Double precio, tipoProducto tipo, estadoProducto estado, List<ProductoIngrediente> ingredientes) {
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
        this.estado = estado;
        this.ingredientes = ingredientes;
        this.comandas = new ArrayList();
    }
    
    public Producto(String nombre, Double precio, tipoProducto tipo, estadoProducto estado) {
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
        this.estado = estado;
        this.ingredientes = new ArrayList();
        this.comandas = new ArrayList();
    }

    public estadoProducto getEstado() {
        return estado;
    }

    public void setEstado(estadoProducto estado) {
        this.estado = estado;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public tipoProducto getTipo() {
        return tipo;
    }

    public void setTipo(tipoProducto tipo) {
        this.tipo = tipo;
    }

    public List<ProductoIngrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<ProductoIngrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public List<ComandaProducto> getComandas() {
        return comandas;
    }

    public void setComandas(List<ComandaProducto> comandas) {
        this.comandas = comandas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", tipo=" + tipo + ", estado=" + estado + '}';
    }

}
