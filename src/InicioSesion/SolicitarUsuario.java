package InicioSesion;
import java.util.Scanner;
import Errores.*;

public class SolicitarUsuario {
    static Scanner scanner = new Scanner(System.in);

    public static String Preguntar() {
        System.out.print("Ingrese Usuario: ");
        return scanner.nextLine();
    }

    public static String PedirDatos(String Mensaje) {
        System.out.print(Mensaje);
        return scanner.nextLine();
    }

}
