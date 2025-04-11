package InicioSesion;

public class EvaluarUsuario {

    public enum TipoUsuario{
        ADMINISTRADOR,
        EMPLEADO,
        CLIENTE
    }

    public static TipoUsuario evaluar(String Usuario){
        if(Administrador.existe(Usuario)){
            return TipoUsuario.ADMINISTRADOR;
        } else if (Empleados.existe(Usuario)){
            return TipoUsuario.EMPLEADO;
        } else {
            return TipoUsuario.CLIENTE;
        }
    }
}