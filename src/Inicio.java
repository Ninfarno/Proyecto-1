import InicioSesion.*;
import Menu.*;
import Ticket.*;
import Vuelos.*;

public class Inicio {

    public static void Inicio() {
        String Usuario = SolicitarUsuario.Preguntar();

        EvaluarUsuario.TipoUsuario tipo = EvaluarUsuario.evaluar(Usuario);
        MenuPrincipal.Menu(Usuario, tipo);
    }

}
