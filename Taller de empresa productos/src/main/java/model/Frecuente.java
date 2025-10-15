package model;

public class Frecuente extends Cliente{

    private int puntosFidelidad;
    private double descuento = 0.5;

    public Frecuente(String nombre, String identificacion, String direccion, Empresa ownedByEmpresa, int puntosFidelidad) {
        super(nombre, identificacion, direccion, ownedByEmpresa);
        this.puntosFidelidad = 0;
    }

    public int getPuntosFidelidad() {
        return puntosFidelidad;
    }
    public void setPuntosFidelidad(int puntosFidelidad) {
        this.puntosFidelidad = puntosFidelidad;
    }
    public double getDescuento() {
        return descuento;
    }
    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    @Override
    public double calcularDescuento(double total) {
        return total * 0.05;
    }
}
