package DTOs;

import enums.estadoProducto;
import enums.tipoProducto;

/**
 *
 * @author daniel
 */
public class ProductoViejoDTO {
    
    private Long id;
    private String nombre;
    private Double precio;
    private tipoProducto tipo;
    private estadoProducto estado;

    public ProductoViejoDTO() {
    }

    public ProductoViejoDTO(Long id, String nombre, Double precio, tipoProducto tipo, estadoProducto estado) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public estadoProducto getEstado() {
        return estado;
    }

    public void setEstado(estadoProducto estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "ProductoViejoDTO{" + "id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", tipo=" + tipo + ", estado=" + estado + '}';
    }
    
}
