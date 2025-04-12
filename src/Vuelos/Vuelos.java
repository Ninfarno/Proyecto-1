package Vuelos;

import java.util.*;

public class Vuelos {
    public static class Vuelo {
        public String origen;
        public String destino;
        public Map<String, List<String>> horarios; // día -> lista de horas
        public boolean[] asientos = new boolean[40]; // false = disponible, true = reservado

        public Vuelo(String origen, String destino, Map<String, List<String>> horarios) {
            this.origen = origen;
            this.destino = destino;
            this.horarios = horarios;
        }
    }

    public static List<Vuelo> listaVuelos = new ArrayList<>();

    static {
        // Inicialización de vuelos
        Map<String, List<String>> horarios1 = new HashMap<>();
        horarios1.put("LUNES", Arrays.asList("08:00", "12:00", "18:00"));
        horarios1.put("VIERNES", Arrays.asList("10:00", "16:00"));

        listaVuelos.add(new Vuelo("Bogotá", "Medellín", horarios1));

        Map<String, List<String>> horarios2 = new HashMap<>();
        horarios2.put("MARTES", Arrays.asList("09:00", "15:00"));
        horarios2.put("SÁBADO", Arrays.asList("13:00", "19:00"));

        listaVuelos.add(new Vuelo("Cali", "Cartagena", horarios2));
    }
}