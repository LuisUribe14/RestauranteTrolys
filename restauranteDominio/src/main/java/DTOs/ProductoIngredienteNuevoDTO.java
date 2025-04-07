package DTOs;

/**
 *
 * @author daniel
 */
public class ProductoIngredienteNuevoDTO {
    
    private Double cantidadRequerida;
    private IngredienteViejoDTO ingrediente;

    public ProductoIngredienteNuevoDTO() {
    }

    public ProductoIngredienteNuevoDTO(Double cantidadRequerida, IngredienteViejoDTO ingrediente) {
        this.cantidadRequerida = cantidadRequerida;
        this.ingrediente = ingrediente;
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
        return "ProductoIngredienteNuevoDTO{" + "cantidadRequerida=" + cantidadRequerida + ", ingrediente=" + ingrediente + '}';
    }
    
}
