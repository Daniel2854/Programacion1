package model;

public class Electrodomestico extends Producto{

    private int garantia;

    public Electrodomestico(String codigo, String nombre, double precioUnitario, Empresa ownedByEmpresa, int garantia) {
        super(codigo, nombre, precioUnitario,  ownedByEmpresa);
        this.garantia = garantia;
    }

    public int getGarantia() {
        return garantia;
    }
    public void setGarantia(int garantia) {
        this.garantia = garantia;
    }
}
