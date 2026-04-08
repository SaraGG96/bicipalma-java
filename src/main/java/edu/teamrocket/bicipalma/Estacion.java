package edu.teamrocket.bicipalma;

public class Estacion {
    private final int id;
    private final String direccion;
    private final Anclajes anclajes;

    public Estacion(int id, String direccion, int numAnclajes) {
        this.id = id;
        this.direccion = direccion;
        this.anclajes = new Anclajes(numAnclajes);
    }

    public int getId() { return id; }
    public String getDireccion() { return direccion; }

    @Override
    public String toString() {
        return String.format("id: %d\ndireccion: %s\nnumeroAnclajes: %d",
                             id, direccion, anclajes.numAnclajes());
    }

    public int anclajesLibres() {
        int libres = 0;
        for (Anclaje anclaje : anclajes.anclajes()) {
            if (!anclaje.isOcupado()) { libres++; }
        }
        return libres;
    }

    public void anclarBicicleta(Movil bici) {
        if (bici == null) {
            return;
        }

        int posicion = anclajes.seleccionarAnclaje();
        if (posicion != -1) {
            anclajes.ocuparAnclaje(posicion, bici);
            mostrarAnclaje(bici, posicion + 1);
        } else {
            System.out.println("No hay anclajes libres.");
        }
    }

    public boolean leerTarjetaUsuario(Autenticacion tarjeta) {
        return tarjeta.isActivada();
    }

    public void retirarBicicleta(Autenticacion tarjeta) {
        if (leerTarjetaUsuario(tarjeta)) {
            // Lógica para buscar una bici y liberarla
            for (int i = 0; i < anclajes.numAnclajes(); i++) {
                if (anclajes.isAnclajeOcupado(i)) {
                    Movil bici = anclajes.getBiciAt(i);
                    anclajes.liberarAnclaje(i);
                    mostrarBicicleta(bici, i + 1);
                    return;
                }
            }
            System.out.println("No hay bicicletas disponibles.");
        } else {
            System.out.println("Tarjeta de usuario no activa.");
        }
    }

    private void mostrarBicicleta(Movil bici, int numeroAnclaje) {
        System.out.println("Bicicleta " + bici.getId() + " retirada del anclaje " + numeroAnclaje);
    }

    private void mostrarAnclaje(Movil bici, int numeroAnclaje) {
        System.out.println("Bicicleta " + bici.getId() + " anclada en el depósito " + numeroAnclaje);
    }

    public void consultarEstacion() {
        System.out.println(this.toString());
        System.out.println("Anclajes libres: " + anclajesLibres());
    }
}
