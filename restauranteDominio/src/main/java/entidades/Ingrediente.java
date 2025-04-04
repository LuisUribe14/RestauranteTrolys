/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import enums.unidadMedida;
import java.io.Serializable;
import java.util.List;
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
@Table(name = "Ingredientes")
public class Ingrediente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nombre", nullable = false, length = 200)
    private String nombre;
    @Column(name = "unidad_medida", nullable = false, length = 10)
    private unidadMedida unidadMedida;
    @Column(name = "stock", nullable = false)
    private Integer stock;

    @OneToMany(mappedBy = "ingrediente")
    private List<ProductoIngrediente> productos;

    public Ingrediente() {
    }

    public Ingrediente(Long id, String nombre, unidadMedida unidadMedida, Integer stock, List<ProductoIngrediente> productos) {
        this.id = id;
        this.nombre = nombre;
        this.unidadMedida = unidadMedida;
        this.stock = stock;
        this.productos = productos;
    }

    public Ingrediente(String nombre, unidadMedida unidadMedida, Integer stock, List<ProductoIngrediente> productos) {
        this.nombre = nombre;
        this.unidadMedida = unidadMedida;
        this.stock = stock;
        this.productos = productos;
    }

    public Ingrediente(String nombre, unidadMedida unidadMedida, Integer stock) {
        this.nombre = nombre;
        this.unidadMedida = unidadMedida;
        this.stock = stock;
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public unidadMedida getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(unidadMedida unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public List<ProductoIngrediente> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoIngrediente> productos) {
        this.productos = productos;
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
        if (!(object instanceof Ingrediente)) {
            return false;
        }
        Ingrediente other = (Ingrediente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ingrediente{" + "id=" + id + ", nombre=" + nombre + ", unidadMedida=" + unidadMedida + ", stock=" + stock + ", productos=" + productos + '}';
    }
    
}

