package Utilidades;

import java.io.*;
import java.util.*;

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
        StringBuilder bloque = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader("Usuarios.dat"))) {
            String linea;
            boolean tipoEncontrado = false;

            while ((linea = br.readLine()) != null) {
                if (linea.startsWith("Tipo: ")) {
                    tipoEncontrado = linea.contains(tipo);
                    bloque = new StringBuilder(); // nuevo bloque
                }

                if (tipoEncontrado) {
                    bloque.append(linea).append("\n");
                }

                if (linea.contains("-----------------------") && tipoEncontrado) {
                    resultados.add(bloque.toString());
                    tipoEncontrado = false;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return resultados;
    }

}