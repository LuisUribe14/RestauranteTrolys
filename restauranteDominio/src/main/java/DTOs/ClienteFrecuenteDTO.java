/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author multaslokas33
 */
public class ClienteFrecuenteDTO {

    private String nombreCompleto;  
    private String telefono;
    private String correo;
    private LocalDate fechaRegistro;
    private Integer visitas;
    private Double totalGastado;
    private Integer puntos;

    public ClienteFrecuenteDTO() {
    }

    public ClienteFrecuenteDTO(String telefono, String correo, LocalDate fechaRegistro, Integer visitas, Double totalGastado, Integer puntos) {
        this.telefono = telefono;
        this.correo = correo;
        this.fechaRegistro = fechaRegistro;
        this.visitas = visitas;
        this.totalGastado = totalGastado;
        this.puntos = puntos;
    }

    public ClienteFrecuenteDTO(String nombreCompleto, String telefono, String correo, LocalDate fechaRegistro, Integer visitas, Double totalGastado, Integer puntos) {
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.correo = correo;
        this.fechaRegistro = fechaRegistro;
        this.visitas = visitas;
        this.totalGastado = totalGastado;
        this.puntos = puntos;
    }

    public String getNombreCompleto() {
        return nombreCompleto != null ? nombreCompleto : "";  
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getVisitas() {
        return visitas;
    }

    public void setVisitas(Integer visitas) {
        this.visitas = visitas;
    }

    public Double getTotalGastado() {
        return totalGastado;
    }

    public void setTotalGastado(Double totalGastado) {
        this.totalGastado = totalGastado;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }

    @Override
    public String toString() {
        return "ClienteFrecuenteDTO{" + "nombreCompleto=" + nombreCompleto + ", telefono=" + telefono + ", correo=" + correo + ", fechaRegistro=" + fechaRegistro + ", visitas=" + visitas + ", totalGastado=" + totalGastado + ", puntos=" + puntos + '}';
    }
}

