package Vuelos;

public class Disponibles {
    public static void mostrarDisponibles() {
        for (Vuelos.Vuelo vuelo : Vuelos.listaVuelos) {
            System.out.println("Vuelo: " + vuelo.origen + " → " + vuelo.destino);
            System.out.print("Asientos disponibles: ");
            for (int i = 0; i < vuelo.asientos.length; i++) {
                if (!vuelo.asientos[i]) {
                    System.out.print((i + 1) + " ");
                }
            }
            System.out.println("\n------------------------");
        }
    }
}