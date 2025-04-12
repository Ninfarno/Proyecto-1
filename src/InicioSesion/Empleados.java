package InicioSesion;

import Utilidades.ArchivoUtil;

import java.util.*;

public class Empleados {
    private static Map<String, String> empleados = new HashMap<>();

    public static void guardarEmpleado(String usuario, String contraseña){
        empleados.put(usuario.toLowerCase(), contraseña);
        ArchivoUtil.guardarGeneral("Empleado", usuario + ";" + contraseña);
    }

    public static boolean existe(String usuario) {
        return empleados.containsKey(usuario.toLowerCase());
    }
}
