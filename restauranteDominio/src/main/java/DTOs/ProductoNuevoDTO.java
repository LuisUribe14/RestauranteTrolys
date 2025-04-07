package DTOs;

import enums.estadoProducto;
import enums.tipoProducto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author daniel
 */
public class ProductoNuevoDTO {
    
    private String nombre;
    private Double precio;
    private tipoProducto tipo;
    private estadoProducto estado;
    private List<ProductoIngredienteNuevoDTO> ingredientes;

    public ProductoNuevoDTO() {
    }

    public ProductoNuevoDTO(String nombre, Double precio, tipoProducto tipo, estadoProducto estado) {
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
        this.estado = estado;
        this.ingredientes = new ArrayList();
    }

    public ProductoNuevoDTO(String nombre, Double precio, tipoProducto tipo, estadoProducto estado, List<ProductoIngredienteNuevoDTO> ingredientes) {
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
        this.estado = estado;
        this.ingredientes = ingredientes;
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

    public List<ProductoIngredienteNuevoDTO> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<ProductoIngredienteNuevoDTO> ingredientes) {
        this.ingredientes = ingredientes;
    }

    @Override
    public String toString() {
        return "ProductoNuevoDTO{" + "nombre=" + nombre + ", precio=" + precio + ", tipo=" + tipo + ", estado=" + estado + '}';
    }
    
}
