package Streams2;

public class Tienda {
	private String nombre;
    private String producto;
    private int distancia;
    private int precio;

    public Tienda(String nombre, String producto, int distancia, int precio) {
        this.nombre = nombre;
        this.producto = producto;
        this.distancia = distancia;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Tienda{" +
                "nombre='" + nombre + '\'' +
                ", producto='" + producto + '\'' +
                ", distancia=" + distancia +
                ", precio=" + precio +
                '}';
    }
}


