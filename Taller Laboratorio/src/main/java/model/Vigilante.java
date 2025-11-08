package model;

import java.util.ArrayList;

public class Vigilante extends Empleado{
    private int puesto;
    private Arma arma;

    public Vigilante(String nombre, String documento, Turno turno, double salarioBase,
                     Empresa empresa, int puesto, Arma arma) {
        super(nombre, documento, turno, salarioBase, empresa);
        if (puesto <= 0 || arma == null) {
            throw new IllegalArgumentException("Datos invalidos, puesto no puede ser menor o igual cero, arma es obligatorio");
        }
        this.puesto = puesto;
        this.arma = arma;
    }

    public int getPuesto() {
        return puesto;
    }
    public void setPuesto(int puesto) {
        this.puesto = puesto;
    }
    public Arma getArma() {
        return arma;
    }
    public void setArma(Arma arma) {
        this.arma = arma;
    }

    @Override
    public double calcularSalarioTotal(int horasExtra, double valorHora) {
        return salarioBase + (horasExtra*valorHora);
    }

    @Override
    public String toString() {
        return "Vigilante{" +
                "puesto=" + puesto +
                ", arma=" + arma +
                '}';
    }
}
