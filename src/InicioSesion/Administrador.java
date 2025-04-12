package InicioSesion;

import Utilidades.ArchivoUtil;

import javax.swing.text.Utilities;
import java.util.*;
import java.io.*;

public class Administrador {
    private static Map<String, String> Administradores = new HashMap<>();

    public static void guardarAdministrador(String usuario, String contrasena) {
        Administradores.put(usuario.toLowerCase(), contrasena);
        ArchivoUtil.guardarGeneral("Administrador", usuario + ";" + contrasena);
    }

    public static boolean existe(String usuario) {
        if (Administradores.isEmpty()) {
            Utilidades.ArchivoUtil.cargarDesdeArchivo(Administradores);
        }
        return Administradores.containsKey(usuario.toLowerCase());
    }

    public static boolean validarCredenciales(String usuario, String contrasena) {
        if (Administradores.isEmpty()) {
            Utilidades.ArchivoUtil.cargarDesdeArchivo(Administradores);
        }
        String guardada = Administradores.get(usuario.toLowerCase());
        return guardada != null && guardada.equals(contrasena);
    }
}
