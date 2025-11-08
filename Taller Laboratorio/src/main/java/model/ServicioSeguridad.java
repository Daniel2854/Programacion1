package model;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class ServicioSeguridad implements Auditable, Agendable {
    protected String codigoContrato;
    protected String cliente;
    protected double tarifa;
    protected Estado estado;
    protected ArrayList<Empleado> listaEmpleados = new ArrayList<>();
    protected Empresa empresa;

    public ServicioSeguridad(String codigoContrato, String cliente, double tarifa, Estado estado, Empresa empresa) {
        if(codigoContrato == null || codigoContrato.isBlank() || cliente == null || cliente.isBlank() || estado == null) {
           throw new IllegalArgumentException("Datos invalidos, el contrato, cliente y estado son obligatorios");
        }
        if (tarifa < 0) {
            throw new IllegalArgumentException("la tarifa no puede ser menor a cero");
        }
        this.codigoContrato = codigoContrato;
        this.cliente = cliente;
        this.tarifa = tarifa;
        this.estado = estado;
        this.empresa = empresa;
    }

    public String getCodigoContrato() {
        return codigoContrato;
    }
    public void setCodigoContrato(String codigoContrato) {
        this.codigoContrato = codigoContrato;
    }
    public String getCliente() {
        return cliente;
    }
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    public double getTarifa() {
        return tarifa;
    }
    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }
    public Estado getEstado() {
        return estado;
    }
    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }
    public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }
    public Empresa getEmpresa() {
        return empresa;
    }
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public abstract double calcularCostoMensual(double valorEmpleadoAsignado);

    public void asignarEmpleado(Empleado empleado) {
        listaEmpleados.add(empleado);
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
        return "ServicioSeguridad{" +
                "codigoContrato='" + codigoContrato + '\'' +
                ", cliente='" + cliente + '\'' +
                ", tarifa=" + tarifa +
                ", estado=" + estado +
                '}';
    }
}
