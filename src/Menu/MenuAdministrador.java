package Menu;

import java.util.List;
import java.util.Scanner;

import InicioSesion.*;
import Utilidades.*;

public class MenuAdministrador {
    private static Scanner scanner = new Scanner(System.in);

    public static void Menu() {
        while (true) {
            System.out.println("\n--- Menú Administrador ---");
            System.out.println("1. Ver Archivos");
            System.out.println("2. Ver Empleados");
            System.out.println("3. Ver Clientes");
            System.out.println("4. Agregar Empleado");
            System.out.println("5. Agregar Administrador");
            System.out.println("6. Salir");
            System.out.print(": ");

            String opcion = scanner.nextLine().trim();
            switch (opcion) {
                case "1":
                    Visualizar.Runtime();
                    break;
                case "2":
                    verEmpleados();
                    break;
                case "3":
                    verClientes();
                    break;
                case "4":
                    agregarUsuario("Empleado");
                    break;
                case "5":
                    agregarUsuario("Administrador");
                    break;
                case "6":
                    System.out.println("Saliendo del Menú Administrador...");
                    return;
                default:
                    System.out.println("Opción no válida, intenta nuevamente.");
            }
        }
    }

    private static void verEmpleados() {
        List<String> empleados = ArchivoUtil.leerPorTipo("Empleado");
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
        } else {
            System.out.println("\n--- Lista de Empleados ---");
            empleados.forEach(System.out::println);
        }
    }

    private static void verClientes() {
        List<String> clientes = ArchivoUtil.leerPorTipo("Cliente");
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            System.out.println("\n--- Lista de Clientes ---");
            clientes.forEach(System.out::println);
        }
    }

    private static void agregarUsuario(String tipo) {
        String usuario = SolicitarUsuario.PedirDatos("Ingrese nombre de usuario para nuevo " + tipo + ": ");
        String contrasena = SolicitarUsuario.PedirDatos("Ingrese contraseña para " + usuario + ": ");

        if (tipo.equals("Empleado")) {
            Empleados.guardarEmpleado(usuario, contrasena);
        } else if (tipo.equals("Administrador")) {
            Administrador.guardarAdministrador(usuario, contrasena);
        }
    }
}
