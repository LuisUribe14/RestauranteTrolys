package DTOs;

import enums.unidadMedida;

/**
 *
 * @author daniel
 */
public class IngredienteViejoDTO {
    
    private Long id;
    private String nombre;
    private unidadMedida unidadMedida;
    private Integer stock;

    public IngredienteViejoDTO() {
    }

    public IngredienteViejoDTO(Long id, String nombre, unidadMedida unidadMedida, Integer stock) {
        this.id = id;
        this.nombre = nombre;
        this.unidadMedida = unidadMedida;
        this.stock = stock;
    }

    public IngredienteViejoDTO(String nombre, unidadMedida unidadMedida) {
        this.nombre = nombre;
        this.unidadMedida = unidadMedida;
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

    @Override
    public String toString() {
        return "IngredienteViejoDTO{" + "id=" + id + ", nombre=" + nombre + ", unidadMedida=" + unidadMedida + ", stock=" + stock + '}';
    }
    
}
