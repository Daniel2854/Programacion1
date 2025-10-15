package model;

public class Corporativo extends Cliente{

    private String nit;
    private double descuentoNegociado;

    public Corporativo(String nombre, String identificacion, String direccion, String nit, Empresa ownedByEmpresa, double descuentoNegociado) {
        super(nombre, identificacion, direccion,  ownedByEmpresa);
        this.nit = nit;
        this.descuentoNegociado = descuentoNegociado;
    }

    public String getNit() {
        return nit;
    }
    public void setNit(String nit) {
        this.nit = nit;
    }
    public double getDescuentoNegociado() {
        return descuentoNegociado;
    }
    public void setDescuentoNegociado(double descuentoNegociado) {
        this.descuentoNegociado = descuentoNegociado;
    }

    @Override
    public double calcularDescuento(double total) {
        return total * 0.05;
    }
}
