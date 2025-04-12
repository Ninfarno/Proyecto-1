package Ticket;

import java.util.*;
import InicioSesion.Clientes;

public class DarTicket {
    public static void generarTickets(Clientes cliente) {
        List<TicketInfo> ticketsCliente = SolicitarTicket.obtenerTickets(cliente);

        if (ticketsCliente.isEmpty()) {
            System.out.println("No tienes vuelos reservados.");
            return;
        }

        System.out.println("<-- TUS TICKETS -->");
        for(TicketInfo ticket: ticketsCliente){
            System.out.println(ticket.toString());
        }
    }
}
