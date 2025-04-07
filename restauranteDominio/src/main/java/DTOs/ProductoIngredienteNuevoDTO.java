package DTOs;

/**
 *
 * @author daniel
 */
public class ProductoIngredienteNuevoDTO {
    
    private Double cantidadRequerida;
    private ProductoNuevoDTO producto;
    private ingredienteNuevoDTO ingrediente;

    public ProductoIngredienteNuevoDTO() {
    }

    public ProductoIngredienteNuevoDTO(Double cantidadRequerida, ProductoNuevoDTO producto, ingredienteNuevoDTO ingrediente) {
        this.cantidadRequerida = cantidadRequerida;
        this.producto = producto;
        this.ingrediente = ingrediente;
    }

    public Double getCantidadRequerida() {
        return cantidadRequerida;
    }

    public void setCantidadRequerida(Double cantidadRequerida) {
        this.cantidadRequerida = cantidadRequerida;
    }

    public ProductoNuevoDTO getProducto() {
        return producto;
    }

    public void setProducto(ProductoNuevoDTO producto) {
        this.producto = producto;
    }

    public ingredienteNuevoDTO getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(ingredienteNuevoDTO ingrediente) {
        this.ingrediente = ingrediente;
    }

    @Override
    public String toString() {
        return "ProductoIngredienteNuevoDTO{" + "cantidadRequerida=" + cantidadRequerida + ", producto=" + producto + ", ingrediente=" + ingrediente + '}';
    }
    
}
