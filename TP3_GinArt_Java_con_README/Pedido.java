import java.util.ArrayList;

public class Pedido {
    private Cliente cliente;
    private ArrayList<Producto> productos = new ArrayList<>();

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public double calcularTotal() {
        return productos.stream().mapToDouble(Producto::getPrecio).sum();
    }

    @Override
    public String toString() {
        return "Pedido de " + cliente + " - Total: $" + calcularTotal();
    }
}