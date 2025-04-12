package Ticket;

import InicioSesion.Clientes;
import Vuelos.Vuelos.*;

public class TicketInfo {
    private Clientes clientes;
    private Vuelo vuelo;
    private String dia;
    private String hora;
    private int asiento;

    public TicketInfo(Clientes clientes, Vuelo vuelo, String dia, String hora, int asiento) {
        this.clientes = clientes;
        this.vuelo = vuelo;
        this.dia = dia;
        this.hora = hora;
        this.asiento = asiento;
    }

    public Clientes getCliente() {
        return clientes;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public String getDia() {
        return dia;
    }

    public String getHora() {
        return hora;
    }

    public int getAsiento() {
        return asiento;
    }

    @Override
    public String toString() {
        return "Vuelo: " + vuelo.origen + " → " + vuelo.destino + "\n" +
                "Día: " + dia + "\n" +
                "Hora: " + hora + "\n" +
                "Asiento: " + asiento;
    }
}
