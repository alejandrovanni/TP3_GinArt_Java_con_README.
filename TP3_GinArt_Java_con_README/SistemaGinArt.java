import java.util.*;

public class SistemaGinArt {
    private static ArrayList<Cliente> clientes = new ArrayList<>();
    private static ArrayList<Producto> productos = new ArrayList<>();
    private static ArrayList<Pedido> pedidos = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n--- Menú GinArt ---");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Agregar producto");
            System.out.println("3. Realizar pedido");
            System.out.println("4. Mostrar pedidos");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                opcion = 0;
            }

            switch (opcion) {
                case 1 -> registrarCliente();
                case 2 -> agregarProducto();
                case 3 -> realizarPedido();
                case 4 -> mostrarPedidos();
                case 5 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 5);
    }

    private static void registrarCliente() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        clientes.add(new Cliente(nombre, email));
        System.out.println("Cliente registrado.");
    }

    private static void agregarProducto() {
        System.out.print("Nombre del producto: ");
        String nombre = sc.nextLine();
        System.out.print("Precio: ");
        double precio = Double.parseDouble(sc.nextLine());
        productos.add(new Producto(nombre, precio));
        System.out.println("Producto agregado.");
    }

    private static void realizarPedido() {
        if (clientes.isEmpty() || productos.isEmpty()) {
            System.out.println("Debe haber al menos un cliente y un producto.");
            return;
        }
        Cliente cliente = clientes.get(0); // simplificación
        Pedido pedido = new Pedido(cliente);
        for (Producto p : productos) {
            pedido.agregarProducto(p);
        }
        pedidos.add(pedido);
        System.out.println("Pedido realizado.");
    }

    private static void mostrarPedidos() {
        for (Pedido p : pedidos) {
            System.out.println(p);
        }
    }
}