package Ticket;

import java.util.*;
import InicioSesion.*;

public class SolicitarTicket {
    private static final List<TicketInfo> tickets = new ArrayList<>();

    public static void agregarTicket(TicketInfo ticket) {
        tickets.add(ticket);
    }

    public static List<TicketInfo> obtenerTickets(Clientes clientes) {
        List<TicketInfo> resultado = new ArrayList<>();
        for (TicketInfo ticket : tickets) {
            if (ticket.getCliente().getCodigo().equals(clientes.getCodigo())) {
                resultado.add(ticket);
            }
        }
        return resultado;
    }
}