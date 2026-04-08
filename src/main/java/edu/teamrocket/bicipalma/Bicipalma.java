package edu.teamrocket.bicipalma;

public class Bicipalma {

    public static void main(String[] args) {
        
        Estacion estacion = new Estacion(1, "Plaza de España", 6);

        System.out.println("--- Estado inicial ---");
        estacion.consultarEstacion();

        int[] bicicletasIds = {100, 101, 102};
        System.out.println("\n--- Anclando bicicletas ---");
        for (int id : bicicletasIds) {
            Bicicleta bici = new Bicicleta(id);
            estacion.anclarBicicleta(bici);
        }

        System.out.println("\nAnclajes libres: " + estacion.anclajesLibres());

        System.out.println("\n--- Retirada de bicicleta ---");
        TarjetaUsuario tarjeta = new TarjetaUsuario("ABC-123", true);
        
        estacion.retirarBicicleta(tarjeta);

        System.out.println("\n--- Estado final ---");
        estacion.consultarEstacion();
    }
}
