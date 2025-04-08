package DTOs;

/**
 *
 * @author daniel
 */
public class MesaViejaDTO {
    
    private Long id;
    private Integer numero;

    public MesaViejaDTO() {
    }

    public MesaViejaDTO(Long id, Integer numero) {
        this.id = id;
        this.numero = numero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "MesaViejaDTO{" + "id=" + id + ", numero=" + numero + '}';
    }
    
}
