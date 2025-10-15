package model;

import java.util.ArrayList;

public abstract class Cliente{
    protected String nombre;
    protected String identificacion;
    protected String direccion;
    protected Empresa ownedByEmpresa;

    public Cliente(String nombre, String identificacion, String direccion, Empresa ownedByEmpresa) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.direccion = direccion;
        this.ownedByEmpresa = ownedByEmpresa;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getIdentificacion() {
        return identificacion;
    }
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public Empresa getOwnedByEmpresa() {
        return ownedByEmpresa;
    }
    public void setOwnedByEmpresa(Empresa ownedByEmpresa) {
        this.ownedByEmpresa = ownedByEmpresa;
    }

    public abstract double calcularDescuento(double total);

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", identificacion='" + identificacion + '\'' +
                ", direccion='" + direccion + '\'' +
                ", ownedByEmpresa=" + ownedByEmpresa +
                '}';
    }
}
