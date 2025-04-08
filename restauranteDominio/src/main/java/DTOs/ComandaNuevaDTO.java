package DTOs;

import enums.estadoComanda;
import java.time.LocalDate;

/**
 *
 * @author daniel
 */
public class ComandaNuevaDTO {
    
    private String folio;
    private estadoComanda estado;
    private LocalDate fechaYHora;
    private Double totalVenta;
    private ClienteFrecuenteDTO cliente;
}
