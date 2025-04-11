package InicioSesion;

import java.util.HashSet;
import java.util.Set;

public class Administrador {
    private static Set<String> listaAdministradores = new HashSet<>();

    static {
        listaAdministradores.add("admin");
        listaAdministradores.add("superadmin");
    }

    public static boolean existe(String usuario) {
        return listaAdministradores.contains(usuario.toLowerCase());
    }
}
