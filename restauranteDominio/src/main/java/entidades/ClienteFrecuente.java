/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author multaslokas33
 */
@Entity
@DiscriminatorValue("Cliente_Frecuente")
public class ClienteFrecuente extends Cliente implements Serializable{

    @Transient
    private Integer visitas = 0;
    @Transient
    private Integer puntos = 0;
    @Transient
    private Double totalGastado = 0.0;

    public ClienteFrecuente() {
    }

    public ClienteFrecuente(Integer visitas, Integer puntos, Double totalGastado) {
        this.visitas = visitas;
        this.puntos = puntos;
        this.totalGastado = totalGastado;
    }

    public ClienteFrecuente(Integer visitas, Integer puntos, Double totalGastado, Long id, String nombre, String apellidoPaterno, String apellidoMaterno, String telefono, String correo, LocalDate fechaRegistro, List<Comanda> comandas) {
        super(id, nombre, apellidoPaterno, apellidoMaterno, telefono, correo, fechaRegistro, comandas);
        this.visitas = visitas;
        this.puntos = puntos;
        this.totalGastado = totalGastado;
    }

    public ClienteFrecuente(Integer visitas, Integer puntos, Double totalGastado, String nombre, String apellidoPaterno, String apellidoMaterno, String telefono, String correo, LocalDate fechaRegistro, List<Comanda> comandas) {
        super(nombre, apellidoPaterno, apellidoMaterno, telefono, correo, fechaRegistro, comandas);
        this.visitas = visitas;
        this.puntos = puntos;
        this.totalGastado = totalGastado;
    }

    public ClienteFrecuente(Long id, String nombre, String apellidoPaterno, String apellidoMaterno, String telefono, String correo, LocalDate fechaRegistro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Integer getVisitas() {
        return visitas;
    }

    public void setVisitas(Integer visitas) {
        this.visitas = visitas;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }

    public Double getTotalGastado() {
        return totalGastado;
    }

    public void setTotalGastado(Double totalGastado) {
        this.totalGastado = totalGastado;
    }
  
    @Override
    public String toString() {
        return "clientesFrecuentes{" + "visitas=" + visitas + ", puntos=" + puntos + ", totalGastado=" + totalGastado + '}';
    }

}
