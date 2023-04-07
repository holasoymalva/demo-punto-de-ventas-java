public abstract class Producto {
    private String nombre;
    private double precio;
    private String categoria;

    public Producto(String nombre, double precio, String categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public abstract double calcularImpuesto();

    public abstract double calcularDescuento();
}

public class Bebida extends Producto {
    private String tamanio;

    public Bebida(String nombre, double precio, String categoria, String tamanio) {
        super(nombre, precio, categoria);
        this.tamanio = tamanio;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    @Override
    public double calcularImpuesto() {
        return getPrecio() * 0.16;
    }

    @Override
    public double calcularDescuento() {
        double descuento = 0;
        if (getCategoria().equals("Promocion")) {
            descuento = getPrecio() * 0.10;
        }
        return descuento;
    }
}


public class Comida extends Producto {
    private int calorias;

    public Comida(String nombre, double precio, String categoria, int calorias) {
        super(nombre, precio, categoria);
        this.calorias = calorias;
    }

    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

    @Override
    public double calcularImpuesto() {
        return getPrecio() * 0.16;
    }

    @Override
    public double calcularDescuento() {
        double descuento = 0;
        if (getCategoria().equals("Promocion")) {
            descuento = getPrecio() * 0.20;
        }
        return descuento;
    }
}
