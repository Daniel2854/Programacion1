package model;

public class ProfesorCatedra extends Profesor{

    private double horasContratadas;
    private String empresaExterna;

    public ProfesorCatedra (String nombre, String apellidos ,String identificacion, String titulo,
                            double añosExperiencia, double horasContratadas, String empresaExterna) {

        super(nombre, apellidos, identificacion, titulo, añosExperiencia);
        this.horasContratadas = horasContratadas;
        this.empresaExterna = empresaExterna;
    }
}
