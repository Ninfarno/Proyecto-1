package Menu;

import java.util.Scanner;

import Errores.ErroresPersonalizados.*;
import InicioSesion.*;
import Ticket.*;
import Vuelos.*;
import Utilidades.*;

public class MenuCliente {
    private static Scanner scanner = new Scanner(System.in);

    public static boolean Menu() {
        int OpcionN;
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

        String Codigo = Clientes.Codigo();
        Clientes NuevoCliente = new Clientes(Nombre, Edad, Codigo);

        System.out.println("Cliente registrado!! \nSeleccione una opcion:");
        System.out.print("1. Ver vuelos.\n" +
                "2. Reservar vuelo \n" +
                "3. Cambiar vuelo \n" +
                "4. Salir \n" +
                ": ");
        while (true) {
            String Opcion = scanner.nextLine().trim();
            try {
                OpcionN = Integer.parseInt(Opcion);
                if (OpcionN < 1 || OpcionN > 4) {
                    throw new ValorInvalido("Selecciona una opción válida");
                }
                break;
            } catch (NumberFormatException e) {
                String OpcionE = Opcion.toUpperCase().replaceAll("\\s", "");
                switch (OpcionE) {
                    case "VERVUELOS":
                        OpcionN = 1;
                        break;
                    case "RESERVARVUELO":
                        OpcionN = 2;
                        break;
                    case "CAMBIARVUELO":
                        OpcionN = 3;
                        break;
                    case "SALIR":
                    case "EXIT":
                        OpcionN = 4;
                        break;
                    default:
                        System.out.println("Error!!: Selecciona una opción válida");
                        continue;
                }
                break;
            } catch (ValorInvalido e) {
                System.out.println("Error!!: " + e.getMessage());
            }
        }

        switch (OpcionN) {
            case 1:
                MostrarVuelos.mostrarFormateado();
                return true;
            case 2:
                MostrarVuelos.mostrarFormateado();
                Reservas.reservarDesdeTexto(NuevoCliente, false);
                return true;
            case 3:
                Reservas.mostrarReservasDelCliente(NuevoCliente);
                Reservas.cambiarReserva(NuevoCliente);
                return true;
            case 4:
                DarTicket.generarTickets(NuevoCliente);
                ArchivoUtil.guardarGeneral("Cliente", NuevoCliente.Archivo());
                scanner.close();
                return true;
        }
        return false;
    }
}
