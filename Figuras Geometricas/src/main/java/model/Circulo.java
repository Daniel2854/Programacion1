package model;

/**
 * Representa un circulo.
 * Implementa Figura.
 *
 * @author Daniel Gil Fino
 */
public class Circulo implements Figura {
    private double radio;

    /**
     * Constructor de la clase Automovil.
     * @param radio
     */
    public Circulo(double radio) {
        this.radio = radio;
    }
    /**
     * Métodos para optener y asignar radio.
     */
    public double getRadio() {
        return radio;
    }
    public void setRadio(double radio) {
        this.radio = radio;
    }


    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }
    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }
    @Override
    public String toString() {
        return "Círculo (radio = " + radio + ")";
    }
}
