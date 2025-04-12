package InicioSesion;

import Utilidades.ArchivoUtil;

import java.util.*;

public class Empleados {
    private static Map<String, String> Empleados = new HashMap<>();

    public static void guardarEmpleado(String usuario, String contraseña){
        Empleados.put(usuario.toLowerCase(), contraseña);
        ArchivoUtil.guardarGeneral("Empleado", usuario + ";" + contraseña);
    }

    public static boolean existe(String usuario) {
        return Empleados.containsKey(usuario.toLowerCase());
    }

    public static boolean validarCredenciales(String usuario, String contrasena) {
        if (Empleados.isEmpty()) { // Asumiendo que usas un Map similar
            Utilidades.ArchivoUtil.cargarDesdeArchivo(Empleados);
        }
        String guardada = Empleados.get(usuario.toLowerCase());
        return guardada != null && guardada.equals(contrasena);
    }
}
