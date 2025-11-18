package model;

public class SistemaPuntos {
    private int puntos;

    public int getPuntos() { return puntos; }

    public void acumular(int puntos) {
        if (puntos > 0) this.puntos += puntos;
    }

    public void reversar(int puntos) {
        this.puntos = Math.max(0, this.puntos - Math.max(0, puntos));
    }
}
