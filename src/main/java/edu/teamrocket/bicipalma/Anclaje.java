package edu.teamrocket.bicipalma;

public class Anclaje {
    private boolean ocupado = false;
    private Movil bici = null;

    public Anclaje() {}

    public boolean isOcupado() {
        return this.ocupado;
    }

    public Movil getBici() {
        return this.bici;
    }

    public void anclarBici(Movil bici) {
        this.bici = bici;
        this.ocupado = true;
    }

    public void liberarBici() {
        this.bici = null;
        this.ocupado = false;
    }

    @Override
    public String toString() {
        return "Ocupado: " + ocupado;
    }
}
