package Menu;

import java.util.Scanner;
import Errores.ErroresPersonalizados.*;
import InicioSesion.Cliente;
import InicioSesion.SolicitarUsuario;

public class MenuCliente {
    static Scanner scanner = new Scanner(System.in);

    public static void Menu() {
        System.out.println("Usuario no Registrado");
        String Nombre = SolicitarUsuario.PedirDatos("Ingrese Nombre: ");
        int Edad;
        while (true) {
            try {
                Edad = Integer.parseInt(SolicitarUsuario.PedirDatos("Ingrese su edad: "));
                if (Edad < 0) {
                    throw new FueradeRango("No puedes tener menos de 0 años");
                } else if (Edad < 18) {
                    throw new FueradeRango("Eres menor de edad \nSe requiere que un adulto te acompañe");
                }
                break;
            } catch (FueradeRango | NumberFormatException e) {
                System.out.println("Error!!: " + e.getMessage());
            }
        }

        String Codigo = Cliente.Codigo();
        Cliente nuevoCliente = new Cliente(Nombre, Edad, Codigo);
        System.out.print("Cliente registrado!! \nSelecciones una opcion \n");



    }
}
