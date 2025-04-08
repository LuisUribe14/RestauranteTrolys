package DTOs;

/**
 *
 * @author daniel
 */
public class ComandaProductoNuevaDTO {
    
    private Integer cantidadRequerida;
    private Double precioProducto;
    private String comentario;
    private ProductoViejoDTO producto;

    public ComandaProductoNuevaDTO() {
    }

    public ComandaProductoNuevaDTO(Integer cantidadRequerida, Double precioProducto, String comentario, ProductoViejoDTO producto) {
        this.cantidadRequerida = cantidadRequerida;
        this.precioProducto = precioProducto;
        this.comentario = comentario;
        this.producto = producto;
    }

    public Integer getCantidadRequerida() {
        return cantidadRequerida;
    }

    public void setCantidadRequerida(Integer cantidadRequerida) {
        this.cantidadRequerida = cantidadRequerida;
    }

    public Double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(Double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public ProductoViejoDTO getProducto() {
        return producto;
    }

    public void setProducto(ProductoViejoDTO producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "ComandaProductoNuevaDTO{" + "cantidadRequerida=" + cantidadRequerida + ", precioProducto=" + precioProducto + ", comentario=" + comentario + '}';
    }
    
}
