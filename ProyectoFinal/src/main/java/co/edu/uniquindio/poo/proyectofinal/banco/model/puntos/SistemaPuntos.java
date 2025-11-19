package co.edu.uniquindio.poo.proyectofinal.banco.model.puntos;

public class SistemaPuntos {
    private int puntos;

    public int getPuntos() {
        return puntos;
    }
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public void acumular(int puntos) {
        if (puntos > 0) this.puntos += puntos;
    }

    public void reversar(int puntos) {
        this.puntos = Math.max(0, this.puntos - Math.max(0, puntos));
    }

    @Override
    public String toString() {
        return "SistemaPuntos{" +
                "puntos=" + puntos +
                '}';
    }
}

