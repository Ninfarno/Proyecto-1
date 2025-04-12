package InicioSesion;

import java.util.*;
import Vuelos.*;

public class Clientes {
    private String nombre;
    private int edad;
    private String codigo;
    private List<Reserva> reservas = new ArrayList<>();

    public Clientes(String nombre, int edad, String codigo) {
        this.nombre = nombre;
        this.edad = edad;
        this.codigo = codigo;
    }

    public static String Codigo(){

        StringBuilder Codigo = new StringBuilder();
        for (int i = 0; i < 10; i++) {
             Codigo.append((int)(Math.random()*10));
        }

        return Codigo.toString();
    }

    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Edad: " + edad + ", Código Cliente: " + codigo;
    }

    public String Archivo(){
        StringBuilder AddCliente = new StringBuilder();
        AddCliente.append("Cliente: ").append(nombre).append("\n");
        AddCliente.append("Edad: ").append(edad).append("\n");
        AddCliente.append("Codigo: ").append(codigo).append("\n");
        AddCliente.append("Reservas: ").append(reservas.size()).append("\n");

        if(reservas.isEmpty()){
            AddCliente.append("No hay reservas");
        } else {
            for(Reserva reserva: reservas){
                AddCliente.append(reserva.toString());
            }
        }
        AddCliente.append("---------------------------------------------------------\n");
        return AddCliente.toString();
    }
}