import java.util.ArrayList;

// Clase abstracta para productos
abstract class Producto {
    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return this.nombre;
    }

    public double getPrecio() {
        return this.precio;
    }

    // Método abstracto para calcular el impuesto
    public abstract double calcularImpuesto();
}

// Clase para productos de comida
class Comida extends Producto {
    private double impuesto = 0.10; // 10% de impuesto

    public Comida(String nombre, double precio) {
        super(nombre, precio);
    }

    // Implementación del método para calcular el impuesto
    public double calcularImpuesto() {
        return getPrecio() * impuesto;
    }
}

// Clase para productos de bebida
class Bebida extends Producto {
    private double impuesto = 0.15; // 15% de impuesto

    public Bebida(String nombre, double precio) {
        super(nombre, precio);
    }

    // Implementación del método para calcular el impuesto
    public double calcularImpuesto() {
        return getPrecio() * impuesto;
    }
}

// Clase para promociones
interface Promocion {
    public double aplicarDescuento(double precio);
}

// Implementación de una promoción de 10% de descuento
class PromocionDescuento implements Promocion {
    private double descuento = 0.10; // 10% de descuento

    public double aplicarDescuento(double precio) {
        return precio - (precio * descuento);
    }
}

// Clase para el carrito de compras
class Carrito {
    private ArrayList<Producto> productos = new ArrayList<Producto>();
    private Promocion promocion;

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void setPromocion(Promocion promocion) {
        this.promocion = promocion;
    }

    public double calcularTotal() {
        double subtotal = 0;
        for (Producto producto : productos) {
            subtotal += producto.getPrecio() + producto.calcularImpuesto();
        }
        if (promocion != null) {
            subtotal = promocion.aplicarDescuento(subtotal);
        }
        return subtotal;
    }
}

public class PuntoDeVenta {
 public static void main(String[] args) {
        // Creamos algunos productos
        Comida sandwich = new Comida("Sandwich", 5.99);
        Bebida cafe = new Bebida("Café", 2.49);
        Bebida refresco = new Bebida("Refresco", 1.99);

        // Creamos un carrito de compras y agregamos los productos
        Carrito carrito = new Carrito();
        carrito.agregarProducto(sandwich);
        carrito.agregarProducto(cafe);
        carrito.agregarProducto(refresco);

        // Aplicamos una promoción de descuento
        Promocion promocion = new PromocionDescuento();
        carrito.setPromocion(promocion);

        // Calculamos el total y lo mostramos por pantalla
        double total = carrito.calcularTotal();
 }
}
