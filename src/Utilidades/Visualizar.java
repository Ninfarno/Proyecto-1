package Utilidades;

import java.io.*;

public class Visualizar {
    public static void Runtime() {
        File archivo = new File("Usuarios.dat");

        if (!archivo.exists()) {
            System.out.println("El archivo Usuarios.dat no existe.");
            return;
        }

        System.out.println("--- Contenido de Usuarios.dat ---");
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el archivo:");
            e.printStackTrace();
        }
    }
}
