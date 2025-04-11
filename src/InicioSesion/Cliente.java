package InicioSesion;

public class Cliente {
    private String nombre;
    private int edad;
    private String codigoCliente;

    public Cliente(String nombre, int edad, String codigoCliente) {
        this.nombre = nombre;
        this.edad = edad;
        this.codigoCliente = codigoCliente;
    }

    public static String Codigo(){

        StringBuilder Codigo = new StringBuilder();
        for (int i = 0; i < 10; i++) {
             Codigo.append((int)(Math.random()*10));
        }

        return Codigo.toString();
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Edad: " + edad + ", Código Cliente: " + codigoCliente;
    }
}
