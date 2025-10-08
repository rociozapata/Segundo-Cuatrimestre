public class Producto {
    private String nombre;
    private Categoria categoria;
    private Double precio;
    private Integer cantidad;

    //constructor
    public Producto (String nombre, Categoria categoria, Double precio, Integer cantidad){
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    //getter y setter
    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCategoria(Categoria categoria){
        this.categoria = categoria;
    }

    public Categoria getCategoria(){
        return this.categoria;
    }

    public void setPrecio (Double precio){
        this.precio = precio;
    }

    public Double getPrecio(){
        return this.precio;
    }

    public void setCantidad(Integer cantidad){
        this.cantidad = cantidad;
    }

    public Integer getCantidad(){
        return this.cantidad;
    }

    public double subTotal(){
        return precio * cantidad;
    }

    


}
