package model;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Empleado implements Auditable, Agendable {
    protected String nombre;
    protected String documento;
    protected Turno turno;
    protected double salarioBase;
    protected ArrayList<Equipo> listaEquipos = new ArrayList<>();
    protected Empresa empresa;


    public Empleado(String nombre, String documento, Turno turno,double salarioBase, Empresa empresa) {
        if (nombre == null || nombre.isBlank() || documento == null || documento.isBlank()) {
            throw new IllegalArgumentException("Datos invalidos, el nombre y documento son obligatorios");
        };
        if (salarioBase <= 0) {
            throw new IllegalArgumentException("el salario no puede ser menor a 0");
        }
        this.nombre = nombre;
        this.documento = documento;
        this.turno = turno;
        this.salarioBase = salarioBase;
        this.empresa = empresa;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDocumento() {
        return documento;
    }
    public void setDocumento(String documento) {
        this.documento = documento;
    }
    public Turno getTurno() {
        return turno;
    }
    public void setTurno(Turno turno) {
        this.turno = turno;
    }
    public double getSalarioBase() {
        return salarioBase;
    }
    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }
    public ArrayList<Equipo> getListaEquipos() {
        return listaEquipos;
    }
    public void setListaEquipos(ArrayList<Equipo> listaEquipos) {
        this.listaEquipos = listaEquipos;
    }
    public Empresa getEmpresa() {
        return empresa;
    }
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public abstract double calcularSalarioTotal(int horasExtra, double valorHora);

    public void asignarEquipo(Equipo equipo) {
        listaEquipos.add(equipo);
    }

    public void retirarEquipo(String codigo) {
        listaEquipos.removeIf(aux -> aux.getCodigo().equals(codigo));
    }

    public double calcularValorDotacion() {
        return listaEquipos.stream().mapToDouble(Equipo::getValorReposicion).sum();
    }

    @Override
    public void programar(LocalDate fecha, String descripcion) {}

    @Override
    public ArrayList<AgendaItem> obtenerAgenda (LocalDate desde, LocalDate hasta) {
        return null;
    }

    @Override
    public void registrarNovedad(Novedad novedad) {}

    @Override
    public ArrayList<Novedad> obtenerNovedades(LocalDate desde, LocalDate hasta) {
        return null;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", documento='" + documento + '\'' +
                ", turno=" + turno +
                ", salarioBase=" + salarioBase +
                '}';
    }
}
