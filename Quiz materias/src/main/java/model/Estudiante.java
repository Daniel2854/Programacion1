package model;

import java.util.ArrayList;

public abstract class Estudiante {
    private String codigo;
    private String identificacion;
    private int edad;
    private String nombre;
    private String apellidos;
    private String semestresCursados;
    private ArrayList<Materia> listaMaterias;
    private Universidad ownedByUniversidad;

    public Estudiante(String codigo, String identificacion, int edad, String nombre, String apellidos, Universidad ownedByUniversidad) {
        this.codigo = codigo;
        this.identificacion = identificacion;
        this.edad = edad;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.ownedByUniversidad = ownedByUniversidad;
        this.listaMaterias = new ArrayList<>();
        if (edad < 0) {
            throw  new IllegalArgumentException("La edad debe ser mayor a 0");
        }
    }

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getIdentificacion() {
        return identificacion;
    }
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getSemestresCursados() {
        return semestresCursados;
    }
    public void setSemestresCursados(String semestresCursados) {
        this.semestresCursados = semestresCursados;
    }
    public ArrayList<Materia> getListaMaterias() {
        return listaMaterias;
    }
    public void setListaMaterias(ArrayList<Materia> listaMaterias) {
        this.listaMaterias = listaMaterias;
    }
    public Universidad getOwnedByUniversidad() {
        return ownedByUniversidad;
    }
    public void setOwnedByUniversidad(Universidad ownedByUniversidad) {
        this.ownedByUniversidad = ownedByUniversidad;
    }
}

