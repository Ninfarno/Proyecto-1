package Utilidades;

import java.io.*;
import java.util.*;

import static InicioSesion.Administrador.*;

public class ArchivoUtil {

    public interface Registrable {
        String getTipo();               // Cliente, Empleado, etc.
        String toStringArchivo();       // Representación del objeto para guardar
    }

    public static void guardarGeneral(String tipo, String contenido) {
        String nombreArchivo = "Usuarios.dat";

        try (FileWriter fw = new FileWriter(nombreArchivo, true)) {
            fw.write(tipo + ";" + contenido + "\n");
        } catch (IOException e) {
            System.out.println("Error al guardar los datos: " + e.getMessage());
        }
    }

    public static List<String> leerPorTipo(String tipo) {
        List<String> resultados = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("Usuarios.dat"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.startsWith(tipo + ";")) {
                    resultados.add(linea);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultados;
    }

    public static void cargarDesdeArchivo(Map<String, String> Tipo) {
        try (BufferedReader br = new BufferedReader(new FileReader("Usuarios.dat"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.startsWith("Administrador")) {
                    String[] partes = linea.split(";");
                    if (partes.length == 3) {
                        String usuario = partes[1].trim().toLowerCase();
                        String contraseña = partes[2].trim();
                        Tipo.put(usuario, contraseña);
                    }
                } else if (linea.startsWith("Empleado")){
                    String[] partes = linea.split(";");
                    if(partes.length == 3){
                        String usuario = partes[1].trim().toLowerCase();
                        String contraseña = partes[2].trim();
                        Tipo.put(usuario, contraseña);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar Usuario: " + e.getMessage());
        }
    }
}