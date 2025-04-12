package InicioSesion;

import Utilidades.ArchivoUtil;

import java.util.*;
import java.io.*;

public class Administrador {
    private static Map<String, String> Administradores = new HashMap<>();
    private static Set<String> Administradores1 = new HashSet<>();

    static {
        Administradores1.add("admin");
    }

    public static boolean existe1(String usuario) {
        return Administradores1.contains(usuario.toLowerCase());
    }

    public static void guardarAdministrador(String usuario, String contrasena) {
        Administradores.put(usuario.toLowerCase(), contrasena);
        ArchivoUtil.guardarGeneral("Administrador", usuario + ";" + contrasena);
    }

    public static boolean existe(String usuario) {
        if (Administradores.isEmpty()) {
            cargarDesdeArchivo();
        }
        return Administradores.containsKey(usuario.toLowerCase());
    }

    public static void cargarDesdeArchivo() {
        try (BufferedReader br = new BufferedReader(new FileReader("Usuarios.dat"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.startsWith("Administrador")) {
                    String[] partes = linea.split(";");
                    if (partes.length == 3) {
                        String usuario = partes[1].trim().toLowerCase();
                        String contrasena = partes[2].trim();
                        Administradores.put(usuario, contrasena);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar administradores: " + e.getMessage());
        }
    }
}
