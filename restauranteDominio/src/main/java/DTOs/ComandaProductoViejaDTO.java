package DTOs;

/**
 *
 * @author daniel
 */
public class ComandaProductoViejaDTO {
    
    private Long id;
    private Integer cantidadRequerida;
    private Double precioProducto;
    private String comentario;
    private Double totalProducto;
    private ProductoViejoDTO producto;

    public ComandaProductoViejaDTO() {
    }

    public ComandaProductoViejaDTO(Long id, Integer cantidadRequerida, Double precioProducto, String comentario, Double totalProducto, ProductoViejoDTO producto) {
        this.id = id;
        this.cantidadRequerida = cantidadRequerida;
        this.precioProducto = precioProducto;
        this.comentario = comentario;
        this.totalProducto = totalProducto;
        this.producto = producto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Double getTotalProducto() {
        return totalProducto;
    }

    public void setTotalProducto(Double totalProducto) {
        this.totalProducto = totalProducto;
    }

    public ProductoViejoDTO getProducto() {
        return producto;
    }

    public void setProducto(ProductoViejoDTO producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "ComandaProductoViejaDTO{" + "id=" + id + ", cantidadRequerida=" + cantidadRequerida + ", precioProducto=" + precioProducto + ", comentario=" + comentario + ", totalProducto=" + totalProducto + '}';
    }
    
}
