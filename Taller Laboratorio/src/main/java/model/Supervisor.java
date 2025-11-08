package model;

import java.util.ArrayList;

public class Supervisor extends Empleado {

    private double bono;
    private ArrayList<Vigilante> listaVigilantes;

     public Supervisor(String nombre, String documento, Turno turno, double salarioBase, Empresa empresa, double bono) {
         super(nombre, documento, turno, salarioBase, empresa);
         if(bono < 0) {
             throw new IllegalArgumentException("el bono no puede ser negativo");
         }
         this.bono = bono;
         this.listaVigilantes = new ArrayList<>();
     }

     @Override
     public double calcularSalarioTotal(int horasExtra, double valorHora) {
         return salarioBase + (horasExtra*valorHora) + bono;
     }

    @Override
    public String toString() {
        return "Supervisor{" +
                "bono=" + bono +
                ", listaVigilantes=" + listaVigilantes +
                '}';
    }
}
