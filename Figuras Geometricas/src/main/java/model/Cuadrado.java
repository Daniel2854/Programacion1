package model;

/**
 * Representa un cuadrado.
 * Implementa Figura.
 *
 * @author Daniel Gil Fino
 */
public class Cuadrado implements Figura {
    private double lado;

    /**
     * Constructor de la clase Automovil.
     * @param lado
     */
    public Cuadrado(double lado) {
        this.lado = lado;
    }

    /**
     * Métodos para optener y asignar lado.
     */
    public double getLado() {
        return lado;
    }
    public void setLado(double lado) {
        this.lado = lado;
    }

    @Override
    public double calcularArea() {
        return lado * lado;
    }
    @Override
    public double calcularPerimetro() {
        return 4 * lado;
    }
    @Override
    public String toString() {
        return "Cuadrado (lado = " + lado + ")";
    }

}
