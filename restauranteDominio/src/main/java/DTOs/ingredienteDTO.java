/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import enums.unidadMedida;

/**
 *
 * @author chris
 */
public class ingredienteDTO {
    
    private String nombre;
    private unidadMedida unidadMedida;
    private Integer stock;

    public ingredienteDTO(String nombre, unidadMedida unidadMedida, Integer stock) {
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

    @Override
    public String toString() {
        return "ingredienteDTO{" + "nombre=" + nombre + ", unidadMedida=" + unidadMedida + ", stock=" + stock + '}';
    }
    
    
}
