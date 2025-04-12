import InicioSesion.*;
import Menu.*;

public class Inicio {
    public static void main(String[] args) {
        String Usuario;
        EvaluarUsuario.TipoUsuario tipo;

        while (true) {
            Usuario = SolicitarUsuario.Preguntar();
            tipo = EvaluarUsuario.evaluar(Usuario);

            if(tipo != null){
                break;
            }
            System.out.println("Acceso Denegado!!");
        }
        MenuPrincipal.Menu(Usuario, tipo);
    }
}
