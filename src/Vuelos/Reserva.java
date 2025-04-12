package Vuelos;

public class Reserva {
    public String origen, destino, dia, hora;
    public int asiento;
    public Vuelos.Vuelo vuelo;

    public Reserva(String origen, String destino, String dia, String hora, int asiento, Vuelos.Vuelo vuelo) {
        this.origen = origen;
        this.destino = destino;
        this.dia = dia;
        this.hora = hora;
        this.asiento = asiento;
        this.vuelo = vuelo;
    }
}