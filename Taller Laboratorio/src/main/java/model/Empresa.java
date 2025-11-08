package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Representa una Empresa de Seguridad.
 * Contiene información de nombre y contactos, de listas de empleados, equipos, servicios y Novedades
 *
 * @author Daniel Gil Fino
 */
public class Empresa {
    private String nombre;
    private String contacto;
    private String email;
    private ArrayList<Empleado> listaEmpleados;
    private ArrayList<Equipo> listaEquipos;
    private ArrayList<ServicioSeguridad> listaServicios;
    private ArrayList<Novedad> listaNovedades;

    public Empresa(String nombre, String contacto, String email) {
        if (nombre == null || contacto == null || email == null || nombre.isBlank() || contacto.isBlank() || email.isBlank()) {
            throw new IllegalArgumentException("Datos invalidos, todos los campo son obligatorios");
        }
        this.nombre = nombre;
        this.contacto = contacto;
        this.email = email;
        this.listaEmpleados = new ArrayList<>();
        this.listaEquipos = new ArrayList<>();
        this.listaServicios = new ArrayList<>();
        this.listaNovedades = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getContacto() {
        return contacto;
    }
    public void setContacto(String contacto) {
        this.contacto = contacto;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }
    public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }
    public ArrayList<Equipo> getListaEquipos() {
        return listaEquipos;
    }
    public void setListaEquipos(ArrayList<Equipo> listaEquipos) {
        this.listaEquipos = listaEquipos;
    }
    public ArrayList<ServicioSeguridad> getListaServicios() {
        return listaServicios;
    }
    public void setListaServicios(ArrayList<ServicioSeguridad> listaServicios) {
        this.listaServicios = listaServicios;
    }
    public ArrayList<Novedad> getListaNovedades() {
        return listaNovedades;
    }
    public void setListaNovedades(ArrayList<Novedad> listaNovedades) {
        this.listaNovedades = listaNovedades;
    }

    public void registrarEmpleado(Empleado empleado) {
        listaEmpleados.add(empleado);
    }
    public void registrarEquipo(Equipo equipo) {
        listaEquipos.add(equipo);
    }
    public void registrarServicio(ServicioSeguridad servicio) {
        listaServicios.add(servicio);
    }
    public void registrarNovedad(Novedad novedad) {
        listaNovedades.add(novedad);
    }

    public List<Empleado> listarPorTipo(Class<?> tipo) {
        return listaEmpleados.stream().filter(tipo::isInstance).toList();
    }

    public void asignarPersonalYEquipo(ServicioSeguridad servicio, Empleado empleado, Equipo equipo) {
        if (servicio.getEstado().equals(Estado.ACTIVO)) {
            servicio.asignarEmpleado(empleado);
            empleado.asignarEquipo(equipo);
        } else throw new IllegalArgumentException("El servicio debe estar activo");
    }

    public double calcularCostoTotalServicios(double valor) {
        return listaServicios.stream()
                .mapToDouble(s -> s.calcularCostoMensual(valor))
                .sum();
    }

    public Map<Empleado, Double> informeDotacion() {
        return listaEmpleados.stream()
                .collect(Collectors.toMap(e -> e, Empleado::calcularValorDotacion));
    }

    public double gastoTotalEmpresa() {
        double nomina = listaEmpleados.stream().mapToDouble(e -> e.calcularSalarioTotal(0, 0)).sum();
        double recursos = listaEmpleados.stream().mapToDouble(Empleado::calcularValorDotacion).sum();
        return nomina + recursos;
    }

    public List<Novedad> obtenerNovedades(LocalDateTime desde, LocalDateTime hasta) {
        return listaNovedades.stream()
                .filter(n -> !n.fecha().isBefore(desde) && !n.fecha().isAfter(hasta))
                .toList();
    }


    @Override
    public String toString() {
        return "Empresa{" +
                "nombre='" + nombre + '\'' +
                ", contacto='" + contacto + '\'' +
                ", email='" + email + '\'' +
                ", listaEmpleados=" + listaEmpleados +
                ", listaEquipos=" + listaEquipos +
                ", listaServicios=" + listaServicios +
                ", listaNovedades=" + listaNovedades +
                '}';
    }
}
