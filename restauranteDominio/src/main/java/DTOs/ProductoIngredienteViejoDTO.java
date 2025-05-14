package DTOs;

/**
 *
 * @author daniel
 */
public class ProductoIngredienteViejoDTO {
    
    private Long id;
    private Double cantidadRequerida;
    private IngredienteViejoDTO ingrediente;

    public ProductoIngredienteViejoDTO() {
    }

    public ProductoIngredienteViejoDTO(Long id, Double cantidadRequerida, IngredienteViejoDTO ingrediente) {
        this.id = id;
        this.cantidadRequerida = cantidadRequerida;
        this.ingrediente = ingrediente;
    }

    public ProductoIngredienteViejoDTO(Long id, Double cantidadRequerida) {
        this.id = id;
        this.cantidadRequerida = cantidadRequerida;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getCantidadRequerida() {
        return cantidadRequerida;
    }

    public void setCantidadRequerida(Double cantidadRequerida) {
        this.cantidadRequerida = cantidadRequerida;
    }

    public IngredienteViejoDTO getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(IngredienteViejoDTO ingrediente) {
        this.ingrediente = ingrediente;
    }

    @Override
    public String toString() {
        return "ProductoIngredienteViejoDTO{" + "id=" + id + ", cantidadRequerida=" + cantidadRequerida + '}';
    }
    
}
