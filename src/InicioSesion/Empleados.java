package InicioSesion;

import java.util.HashSet;
import java.util.Set;

public class Empleados {
    private static Set<String> listaEmpleados = new HashSet<>();

    static {
        listaEmpleados.add("juan");
        listaEmpleados.add("maria");
    }

    public static boolean existe(String usuario) {
        return listaEmpleados.contains(usuario.toLowerCase());
    }
}
