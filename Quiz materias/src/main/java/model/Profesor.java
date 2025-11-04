package model;

public abstract class Profesor {
    private String nombre;
    private String apellidos;
    private String identificacion;
    private String titulo;
    private double añosExperiencia;

    public Profesor(String nombre, String apellidos ,String identificacion, String titulo, double añosExperiencia) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.titulo = titulo;
        this.añosExperiencia = añosExperiencia;
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
    public String getIdentificacion() {
        return identificacion;
    }
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public double getAñosExperiencia() {
        return añosExperiencia;
    }
    public void setAñosExperiencia(double añosExperiencia) {
        this.añosExperiencia = añosExperiencia;
    }
}
