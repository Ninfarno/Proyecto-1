import InicioSesion.*;
import Menu.*;

public class Inicio {
    public static void main(String[] args) {

        String Usuario = SolicitarUsuario.Preguntar();

        EvaluarUsuario.TipoUsuario tipo = EvaluarUsuario.evaluar(Usuario);
        MenuPrincipal.Menu(Usuario, tipo);

    }
}
