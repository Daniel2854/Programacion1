package model;

/**
 * Representa un triangulo.
 * Implementa Figura
 *
 * @author Daniel Gil Fino
 */
public class Triangulo implements Figura {
    private double lado;

    /**
     * Constructor de la clase Automovil.
     * @param lado
     */
    public Triangulo(double lado) {
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
        return (Math.sqrt(3) / 4) * lado * lado;
    }
    @Override
    public double calcularPerimetro() {
        return 3 * lado;
    }
    @Override
    public String toString() {
        return "Triángulo equilátero (lado = " + lado + ")";
    }
}

