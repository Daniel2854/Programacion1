package model;

public class Frecuente extends Cliente{

    private int puntosFidelidad;

    public Frecuente(String nombre, String identificacion, String direccion, Empresa ownedByEmpresa, int puntosFidelidad) {
        super(nombre, identificacion, direccion, ownedByEmpresa);
        this.puntosFidelidad = puntosFidelidad;
    }

    public int getPuntosFidelidad() {
        return puntosFidelidad;
    }
    public void setPuntosFidelidad(int puntosFidelidad) {
        this.puntosFidelidad = puntosFidelidad;
    }

    @Override
    public double calcularDescuento(double totalCompra) {
        return totalCompra * 0.05;
    }
}
