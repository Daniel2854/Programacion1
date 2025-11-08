package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Equipo implements Auditable {
    private String codigo;
    private String tipo;
    private Estado estado;
    private double valorReposicion;
    private Empresa empresa;

    public Equipo(String codigo, String tipo, Estado estado, double valorReposicion, Empresa empresa) {
        if (valorReposicion < 0) {
            throw new IllegalArgumentException("El valor de reposicion no puede ser menor a 0");
        }
        this.codigo = Objects.requireNonNull(codigo, "el codigo es obligatorio");
        this.tipo = tipo;
        this.estado = estado;
        this.valorReposicion = valorReposicion;
        this.empresa = empresa;
    }

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public Estado getEstado() {
        return estado;
    }
    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    public double getValorReposicion() {
        return valorReposicion;
    }
    public void setValorReposicion(double valor) {
        this.valorReposicion = valor;
    }
    public Empresa getEmpresa() {
        return empresa;
    }
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public void registrarNovedad(Novedad novedad) {

    }

    @Override
    public ArrayList<Novedad> obtenerNovedades(LocalDate desde, LocalDate hasta) {
        ArrayList<Novedad> novedades = new ArrayList<>();
        return novedades;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "codigo='" + codigo + '\'' +
                ", tipo='" + tipo + '\'' +
                ", estado='" + estado + '\'' +
                ", valor=" + valorReposicion +
                ", empresa=" + empresa +
                '}';
    }
}
