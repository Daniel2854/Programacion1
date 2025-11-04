package model;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Materia {
    private String codigo;
    private String nombre;
    private int numeroHoras;
    private int creditos;
    private String semestre;
    private Profesor profesor;
    protected ArrayList<Estudiante> estudiantes;
    private CarreraUniversitaria ownedByCarreraUniversitaria;

    public Materia(String codigo, String nombre, int numeroHoras, int creditos, String semestre,
                   Profesor profesor, CarreraUniversitaria ownedByCarreraUniversitaria) {
        if (nombre == null || nombre.isBlank() || codigo == null || codigo.isBlank() || semestre == null || semestre.isBlank() || profesor == null) {
            throw new IllegalArgumentException("Datos invalidos, ingrese bien lo datos");
        }

        this.codigo = Objects.requireNonNull(codigo, "el codigo es obligatorio");
        this.nombre = nombre;
        this.numeroHoras = numeroHoras;
        this.creditos = creditos;
        this.semestre = semestre;
        this.profesor = profesor;
        this.estudiantes = new ArrayList<>();
        this.ownedByCarreraUniversitaria = ownedByCarreraUniversitaria;
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
    public int getNumeroHoras() {
        return numeroHoras;
    }
    public void setNumeroHoras(int numeroHoras) {
        this.numeroHoras = numeroHoras;
    }
    public int getCreditos() {
        return creditos;
    }
    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }
    public String getSemestre() {
        return semestre;
    }
    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }
    public Profesor getProfesor() {
        return profesor;
    }
    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }
    public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }
    public CarreraUniversitaria getOwnedByCarreraUniversitaria() {
        return ownedByCarreraUniversitaria;
    }
    public void setOwnedByCarreraUniversitaria(CarreraUniversitaria ownedByCarreraUniversitaria) {
        this.ownedByCarreraUniversitaria = ownedByCarreraUniversitaria;
    }
}
