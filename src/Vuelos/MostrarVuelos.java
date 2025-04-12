package Vuelos;

import java.util.*;

public class MostrarVuelos {

    public static void mostrarFormateado() {
        for (int i = 0; i < Vuelos.listaVuelos.size(); i++) {
            Vuelos.Vuelo vuelo = Vuelos.listaVuelos.get(i);
            System.out.println((i + 1) + ": " + vuelo.origen + " --> " + vuelo.destino);

            for (Map.Entry<String, List<String>> entrada : vuelo.horarios.entrySet()) {
                String dia = entrada.getKey();
                List<String> horas = entrada.getValue();
                System.out.println(dia + ":");

                for (String hora : horas) {
                    System.out.print("[" + hora + "]: ");
                    for (int a = 0; a < vuelo.asientos.length; a++) {
                        if ((a + 1) % 4 == 1 && a != 0) System.out.print("\n         "); // salto de fila

                        if (vuelo.asientos[a]) {
                            System.out.print("[*] ");
                        } else {
                            System.out.printf("[%d] ", a + 1);
                        }
                    }
                    System.out.println("\n");
                }
            }
        }
    }

}
