/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import entidades.Comanda;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 *
 * @author multaslokas33
 */
public class ClienteFrecuenteDTO extends ClienteDTO {

    private Integer visitas = 0;
    private Integer puntos = 0;
    private Double totalGastado = 0.0;
    private LocalDateTime fechaUltimaComanda;

    public ClienteFrecuenteDTO() {
        this.visitas = 0;
        this.puntos = 0;
        this.totalGastado = 0.0;
    }

    public ClienteFrecuenteDTO(Integer visitas, Integer puntos, Double totalGastado) {
        this.visitas = visitas != null ? visitas : 0;
        this.puntos = puntos != null ? puntos : 0;
        this.totalGastado = totalGastado != null ? totalGastado : 0.0;
    }

    public ClienteFrecuenteDTO(Integer visitas, Integer puntos, Double totalGastado, Long id, String nombre,
            String apellidoPaterno, String apellidoMaterno, String telefono,
            String correo, LocalDate fechaRegistro, List<Comanda> comandas) {
        super(id, nombre, apellidoPaterno, apellidoMaterno, telefono, correo, fechaRegistro, comandas);
        this.visitas = visitas != null ? visitas : 0;
        this.puntos = puntos != null ? puntos : 0;
        this.totalGastado = totalGastado != null ? totalGastado : 0.0;
    }

    public ClienteFrecuenteDTO(Integer visitas, Integer puntos, Double totalGastado, Long id, String nombre,
            String apellidoPaterno, String apellidoMaterno, String telefono,
            String correo, LocalDate fechaRegistro, List<Comanda> comandas, LocalDateTime fechaUltimaComanda) {
        super(id, nombre, apellidoPaterno, apellidoMaterno, telefono, correo, fechaRegistro, comandas);
        this.visitas = visitas != null ? visitas : 0;
        this.puntos = puntos != null ? puntos : 0;
        this.totalGastado = totalGastado != null ? totalGastado : 0.0;
        this.fechaUltimaComanda = fechaUltimaComanda != null ? fechaUltimaComanda : LocalDateTime.now();  // Si la fecha es null, se usa la fecha actual
    }

    public LocalDateTime getFechaUltimaComanda() {
        return fechaUltimaComanda;
    }

    public void setFechaUltimaComanda(LocalDateTime fechaUltimaComanda) {
        this.fechaUltimaComanda = fechaUltimaComanda;
    }

    public Integer getVisitas() {
        return visitas;
    }

    public void setVisitas(Integer visitas) {
        this.visitas = visitas != null ? visitas : 0;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos != null ? puntos : 0;
    }

    public Double getTotalGastado() {
        return totalGastado;
    }

    public void setTotalGastado(Double totalGastado) {
        this.totalGastado = totalGastado != null ? totalGastado : 0.0;
    }

    @Override
    public String toString() {
        return "Todos los clientes{"
                + "id=" + getId()
                + ", nombre='" + getNombre() + '\''
                + ", apellidoPaterno='" + getApellidoPaterno() + '\''
                + ", apellidoMaterno='" + getApellidoMaterno() + '\''
                + ", telefono='" + getTelefono() + '\''
                + ", correo='" + getCorreo() + '\''
                + ", visitas=" + visitas
                + ", puntos=" + puntos
                + ", totalGastado=" + totalGastado
                + '}';
    }
}
