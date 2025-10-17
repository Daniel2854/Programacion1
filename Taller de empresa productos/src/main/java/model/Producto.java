package model;

public abstract class Producto {

    protected String codigo;
    protected String nombre;
    protected double precioUnitario;
    protected Empresa ownedByEmpresa;

    public Producto(String codigo, String nombre, double precioUnitario, Empresa ownedByEmpresa) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.ownedByEmpresa = ownedByEmpresa;
    }

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getPrecioUnitario() {
        return precioUnitario;
    }
    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
    public Empresa getOwnedByEmpresa() {
        return ownedByEmpresa;
    }
    public void setOwnedByEmpresa(Empresa ownedByEmpresa) {
        this.ownedByEmpresa = ownedByEmpresa;
    }
}
