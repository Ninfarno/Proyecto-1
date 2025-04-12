package InicioSesion;

import java.util.Scanner;

public class EvaluarUsuario {
    static Scanner scanner = new Scanner(System.in);

    public enum TipoUsuario {
        ADMINISTRADOR,
        EMPLEADO,
        CLIENTE
    }

    public static TipoUsuario evaluar(String Usuario) {
        //Punto de guardado: Implementar que si el usuario es ADMINISTRADOR O EMPLEADO solicite contraseña y verificar
        if (Administrador.existe(Usuario)) {
            for (int i = 0; i < 3; i++) {
                System.out.println("Contraseña: ");
                if (Administrador.validarCredenciales(Usuario, scanner.nextLine())) {
                    return TipoUsuario.ADMINISTRADOR;
                } else {
                    System.out.println("Contraseña incorrecta");
                }
            }
            return null;
        } else if (Empleados.existe(Usuario)) {
            for (int i = 0; i < 3; i++) {
                System.out.println("Contraseña: ");
                if (Empleados.validarCredenciales(Usuario, scanner.nextLine())) {
                    return TipoUsuario.EMPLEADO;
                } else {
                    System.out.println("Contraseña incorrecta");
                }
            }
            return null;
        } else {
            return TipoUsuario.CLIENTE;
        }
    }
}