package Menu;

import InicioSesion.*;

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
                MenuCliente.Menu();
                break;
        }
    }
}
