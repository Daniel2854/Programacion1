package co.edu.uniquindio.poo.proyectofinal.banco.model.puntos;

import co.edu.uniquindio.poo.proyectofinal.banco.model.soporte.RangoCliente;

public class ReglaPuntos {
    public static double multiplicadorPorRango(RangoCliente rango) {
        return switch (rango) {
            case ORO -> 1.25;
            case PLATA -> 1.10;
            default -> 1.00;
        };
    }
}
