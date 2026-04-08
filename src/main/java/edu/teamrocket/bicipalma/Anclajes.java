package edu.teamrocket.bicipalma;

public class Anclajes {
    private final Anclaje[] anclajes;

    public Anclajes(int numAnclajes) {
        this.anclajes = new Anclaje[numAnclajes];
        crearAnclajes();
    }

    private void crearAnclajes() {
        for (int i = 0; i < anclajes.length; i++) {
            anclajes[i] = new Anclaje();
        }
    }

    public Anclaje[] anclajes() {
        return this.anclajes;
    }

    public int numAnclajes() {
        return this.anclajes.length;
    }

    public void ocuparAnclaje(int posicion, Movil bici) {
        this.anclajes[posicion].anclarBici(bici);
    }

    public boolean isAnclajeOcupado(int posicion) {
        return this.anclajes[posicion].isOcupado();
    }

    public void liberarAnclaje(int posicion) {
        this.anclajes[posicion].liberarBici();
    }

    public Movil getBiciAt(int posicion) {
        return this.anclajes[posicion].getBici();
    }

    public int seleccionarAnclaje() {
        for (int i = 0; i < anclajes.length; i++) {
            if (!anclajes[i].isOcupado()) {
                return i;
            }
        }
        return -1; 
    }
}
