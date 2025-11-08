package model;

import java.time.LocalDate;

public class AgendaItem {
    private LocalDate fecha;
    private String descripcion;

    public AgendaItem(LocalDate fecha, String descripcion) {
        if (fecha == null || descripcion.isBlank()) {
            throw new IllegalArgumentException("Datos invalidos, los campos son obligatorios");
        }
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "AgendaItem{" +
                "fecha=" + fecha +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
