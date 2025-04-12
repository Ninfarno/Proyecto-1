package Menu;

import InicioSesion.*;
import Ticket.*;

public class MenuPrincipal {

    public static void Menu(String Usuario, EvaluarUsuario.TipoUsuario tipo){
        System.out.println("Bienvenido " + Usuario);
        switch(tipo){
            case ADMINISTRADOR:
                MenuAdministrador.Menu();
                break;
            case EMPLEADO:
                MenuEmpleado.Menu();
                break;
            case CLIENTE:
                boolean Salida = false;
                while (!Salida) {
                    Salida = MenuCliente.Menu();
                }
                System.out.println("Vuelva Pronto!!");
                break;
        }
    }
}
