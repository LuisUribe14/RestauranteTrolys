/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
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
@Table(name = "ClienteFrecuente")
@PrimaryKeyJoinColumn(name = "cliente_id")
public class clientesFrecuentes extends Cliente {

    @Transient
    private Integer visitas;
    @Transient
    private Integer puntos;
    @Transient
    private Double totalGastado;

    public clientesFrecuentes() {
    }

    public clientesFrecuentes(int visitas, int puntos, double totalGastado) {
        this.visitas = visitas;
        this.puntos = puntos;
        this.totalGastado = totalGastado;
    }

    public clientesFrecuentes(int visitas, int puntos, double totalGastado, Long id, String nombre, String apellidoPaterno, String apellidoMaterno, String telefono, String correo, Date fechaRegistro) {
        super(id, nombre, apellidoPaterno, apellidoMaterno, telefono, correo, fechaRegistro);
        this.visitas = visitas;
        this.puntos = puntos;
        this.totalGastado = totalGastado;
    }

    public clientesFrecuentes(int visitas, int puntos, double totalGastado, String nombre, String apellidoPaterno, String apellidoMaterno, String telefono, String correo, Date fechaRegistro) {
        super(nombre, apellidoPaterno, apellidoMaterno, telefono, correo, fechaRegistro);
        this.visitas = visitas;
        this.puntos = puntos;
        this.totalGastado = totalGastado;
    }
    
    public int getVisitas() {
        return visitas;
    }

//    public void setVisitas(int visitas) {
//        this.visitas = visitas;
//    }

    public int getPuntos() {
        return puntos;
    }

//    public void setPuntos(int puntos) {
//        this.puntos = puntos;
//    }

    public double getTotalGastado() {
        return totalGastado;
    }

//    public void setTotalGastado(double totalGastado) {
//        this.totalGastado = totalGastado;
//    }

    @Override
    public String toString() {
        return "clientesFrecuentes{" + "visitas=" + visitas + ", puntos=" + puntos + ", totalGastado=" + totalGastado + '}';
    }
  
}