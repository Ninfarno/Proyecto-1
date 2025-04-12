package InicioSesion;

public class EvaluarUsuario {

    public enum TipoUsuario{
        ADMINISTRADOR,
        EMPLEADO,
        CLIENTE
    }

    public static TipoUsuario evaluar(String Usuario){
        //Punto de guardado: Implementar que si el usuario es ADMINISTRADOR O EMPLEADO solicite contraseña y verificar
        if(Administrador.existe(Usuario)){
            return TipoUsuario.ADMINISTRADOR;
        } else if (Empleados.existe(Usuario)){
            return TipoUsuario.EMPLEADO;
        } else {
            return TipoUsuario.CLIENTE;
        }
    }
}