/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import entidades.Comanda;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 *
 * @author multaslokas33
 */
public class ClienteFrecuenteDTO extends ClienteDTO {

    private Integer visitas;
    private Integer puntos;
    private Double totalGastado;

    public ClienteFrecuenteDTO(Integer visitas, Integer puntos, Double totalGastado) {
        this.visitas = visitas;
        this.puntos = puntos;
        this.totalGastado = totalGastado;
    }

    public ClienteFrecuenteDTO(Integer visitas, Integer puntos, Double totalGastado, Long id, String nombre, String apellidoPaterno, String apellidoMaterno, String telefono, String correo, LocalDate fechaRegistro, List<Comanda> comandas) {
        super(id, nombre, apellidoPaterno, apellidoMaterno, telefono, correo, fechaRegistro, comandas);
        this.visitas = visitas;
        this.puntos = puntos;
        this.totalGastado = totalGastado;
    }

    public ClienteFrecuenteDTO(Integer visitas, Integer puntos, Double totalGastado, String nombre, String apellidoPaterno, String apellidoMaterno, String telefono, String correo, LocalDate fechaRegistro, List<Comanda> comandas) {
        super(nombre, apellidoPaterno, apellidoMaterno, telefono, correo, fechaRegistro, comandas);
        this.visitas = visitas;
        this.puntos = puntos;
        this.totalGastado = totalGastado;
    }

    public ClienteFrecuenteDTO() {
        
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
        return "ClienteFrecuenteDTO{" + "visitas=" + visitas + ", puntos=" + puntos + ", totalGastado=" + totalGastado + '}';
    }

}
