package Vuelos;

import java.util.*;

import InicioSesion.*;

public class Reservas {
    private static Scanner scanner = new Scanner(System.in);

    public static void simularReservas() {
        Random rand = new Random();

        for (Vuelos.Vuelo vuelo : Vuelos.listaVuelos) {
            int reservados = 0;

            while (reservados < vuelo.asientos.length) {
                int reservasPorHora = Math.min(5, vuelo.asientos.length - reservados);
                for (int i = 0; i < reservasPorHora; i++) {
                    int asiento;
                    do {
                        asiento = rand.nextInt(vuelo.asientos.length);
                    } while (vuelo.asientos[asiento]);

                    vuelo.asientos[asiento] = true;
                    reservados++;
                }

                // Simula avance de hora
                try {
                    Thread.sleep(500); // para visualización (opcional)
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                if (reservados >= vuelo.asientos.length) break;
            }
        }
    }

    public static void reservarDesdeTexto(Clientes Cliente, boolean esCambio) {

        System.out.print("Introduce tu reserva (Vuelo;Día;Hora;Asiento): ");
        while (true) {
            String Reserva = scanner.nextLine().trim();
            try {
                String[] partes = Reserva.split(";");
                int NumeroVuelo = Integer.parseInt(partes[0]) - 1;
                String dia = partes[1].toUpperCase();
                String hora = partes[2];
                int asiento = Integer.parseInt(partes[3]) - 1;

                if (NumeroVuelo < 0 || NumeroVuelo >= Vuelos.listaVuelos.size()) {
                    System.out.println("Error!!: Vuelo Inexistente");
                    continue;
                }

                Vuelos.Vuelo vuelo = Vuelos.listaVuelos.get(NumeroVuelo);

                if (!vuelo.horarios.containsKey(dia) || !vuelo.horarios.get(dia).contains(hora)) {
                    System.out.println("Error!!: Día u hora inválidos.");
                    continue;
                }

                if (asiento < 0 || asiento >= vuelo.asientos.length || vuelo.asientos[asiento]) {
                    System.out.println("Error!!: Asiento inválido o ya reservado.");
                    continue;
                }

                vuelo.asientos[asiento] = true;

                Reserva nueva = new Reserva(vuelo.origen, vuelo.destino, dia, hora, asiento + 1, vuelo);
                Cliente.agregarReserva(nueva);

                if (esCambio) {
                    System.out.println("Asiento Modificado con exito");
                } else {
                    System.out.println("Asiento reservado con éxito.");
                }

                break;
            } catch (Exception e) {
                System.out.print("Formato inválido!! \nUsa: Vuelo;Día;Hora;Asiento: ");
            }
        }
    }

    public static void mostrarReservasDelCliente(Clientes clientes) {
        if (clientes.getReservas().isEmpty()) {
            System.out.println("No tienes reservas.");
            return;
        }

        System.out.println("Tus reservas:");
        for (int i = 0; i < clientes.getReservas().size(); i++) {
            Reserva r = clientes.getReservas().get(i);
            System.out.printf("%d) Vuelo %s → %s - %s %s, Asiento %d\n",
                    (i + 1), r.origen, r.destino, r.dia, r.hora, r.asiento);
        }
    }

    public static void cambiarReserva(Clientes clientes) {

        Scanner sc = new Scanner(System.in);

        if (clientes.getReservas().isEmpty()) {
            System.out.println("No hay reservas que cambiar.");
            return;
        }

        System.out.print("Número de reserva a cambiar: ");
        int num = Integer.parseInt(sc.nextLine()) - 1;

        if (num < 0 || num >= clientes.getReservas().size()) {
            System.out.println("Opción inválida.");
            return;
        }

        Reserva r = clientes.getReservas().remove(num);
        r.vuelo.asientos[r.asiento - 1] = false; // Liberar asiento

        MostrarVuelos.mostrarFormateado();

        reservarDesdeTexto(clientes, true);
    }
}
