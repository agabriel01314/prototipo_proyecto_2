import java.util.ArrayList;
import java.util.Scanner;

// Clase Medicamento (Modelo)
class Medicamento {
    private String nombre;
    private int cantidad;

    public Medicamento(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void incrementarCantidad(int cantidad) {
        this.cantidad += cantidad;
    }

    public void decrementarCantidad(int cantidad) {
        if (this.cantidad >= cantidad) {
            this.cantidad -= cantidad;
        }
    }

    @Override
    public String toString() {
        return "Medicamento: " + nombre + ", Cantidad: " + cantidad;
    }
}

// Clase Objeto (Modelo)
class Objeto {
    private String nombre;
    private int cantidad;

    public Objeto(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void incrementarCantidad(int cantidad) {
        this.cantidad += cantidad;
    }

    public void decrementarCantidad(int cantidad) {
        if (this.cantidad >= cantidad) {
            this.cantidad -= cantidad;
        }
    }

    @Override
    public String toString() {
        return "Objeto: " + nombre + ", Cantidad: " + cantidad;
    }
}

// Clase InventarioMedicamentos (Modelo)
class InventarioMedicamentos {
    private ArrayList<Medicamento> medicamentos;

    public InventarioMedicamentos() {
        medicamentos = new ArrayList<>();
    }

    public void agregarMedicamento(Medicamento medicamento) {
        medicamentos.add(medicamento);
    }

    public void retirarMedicamento(String nombre, int cantidad) {
        for (Medicamento medicamento : medicamentos) {
            if (medicamento.getNombre().equalsIgnoreCase(nombre)) {
                medicamento.decrementarCantidad(cantidad);
                return;
            }
        }
    }

    public void verInventarioMedicamentos() {
        System.out.println("Inventario de Medicamentos:");
        for (Medicamento medicamento : medicamentos) {
            System.out.println(medicamento.toString());
        }
    }
}

// Clase InventarioObjetos (Modelo)
class InventarioObjetos {
    private ArrayList<Objeto> objetos;

    public InventarioObjetos() {
        objetos = new ArrayList<>();
    }

    public void agregarObjeto(Objeto objeto) {
        objetos.add(objeto);
    }

    public void retirarObjeto(String nombre, int cantidad) {
        for (Objeto objeto : objetos) {
            if (objeto.getNombre().equalsIgnoreCase(nombre)) {
                objeto.decrementarCantidad(cantidad);
                return;
            }
        }
    }

    public void verInventarioObjetos() {
        System.out.println("Inventario de Objetos:");
        for (Objeto objeto : objetos) {
            System.out.println(objeto.toString());
        }
    }
}

// Clase Menu (Vista-Controlador)
class Menu {
    public static int mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nMenú:");
        System.out.println("1. Ingresar Medicamento");
        System.out.println("2. Ingresar Objeto");
        System.out.println("3. Retirar Medicamento");
        System.out.println("4. Retirar Objeto");
        System.out.println("5. Ver Inventario");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        return opcion;
    }

    public static void leerOpcion(InventarioMedicamentos inventarioMedicamentos, InventarioObjetos inventarioObjetos) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int opcion = mostrarMenu();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del medicamento: ");
                    String nombreMedicamento = scanner.next();
                    System.out.print("Ingrese la cantidad de medicamento: ");
                    int cantidadMedicamento = scanner.nextInt();
                    Medicamento medicamento = new Medicamento(nombreMedicamento, cantidadMedicamento);
                    inventarioMedicamentos.agregarMedicamento(medicamento);
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del objeto: ");
                    String nombreObjeto = scanner.next();
                    System.out.print("Ingrese la cantidad de objeto: ");
                    int cantidadObjeto = scanner.nextInt();
                    Objeto objeto = new Objeto(nombreObjeto, cantidadObjeto);
                    inventarioObjetos.agregarObjeto(objeto);
                    break;
                case 3:
                    System.out.print("Ingrese el nombre del medicamento a retirar: ");
                    String nombreMedicamentoRetirar = scanner.next();
                    System.out.print("Ingrese la cantidad de medicamento a retirar: ");
                    int cantidadMedicamentoRetirar = scanner.nextInt();
                    inventarioMedicamentos.retirarMedicamento(nombreMedicamentoRetirar, cantidadMedicamentoRetirar);
                    break;
                case 4:
                    System.out.print("Ingrese el nombre del objeto a retirar: ");
                    String nombreObjetoRetirar = scanner.next();
                    System.out.print("Ingrese la cantidad de objeto a retirar: ");
                    int cantidadObjetoRetirar = scanner.nextInt();
                    inventarioObjetos.retirarObjeto(nombreObjetoRetirar, cantidadObjetoRetirar);
                    break;
                case 5:
                    inventarioMedicamentos.verInventarioMedicamentos();
                    inventarioObjetos.verInventarioObjetos();
                    break;
                case 6:
                    System.out.println("Saliendo del programa.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
    }
}

// Clase HospitalInventarioApp (Controlador)
public class HospitalInventarioApp {
    public static void main(String[] args) {
        InventarioMedicamentos inventarioMedicamentos = new InventarioMedicamentos();
        InventarioObjetos inventarioObjetos = new InventarioObjetos();

        Menu.leerOpcion(inventarioMedicamentos, inventarioObjetos);
    }
}
