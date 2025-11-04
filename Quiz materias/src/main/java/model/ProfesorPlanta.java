package model;

public class ProfesorPlanta  extends Profesor{
    private String proyectosInvestigacion;
    private DedicacionTiempo dedicacionTiempo;

    public ProfesorPlanta(String nombre, String apellidos, String idenficacion, String titulo,
                          double añosExpericia, String proyectosInvestigacion, DedicacionTiempo dedicacionTiempo) {
        super(nombre, apellidos, idenficacion, titulo, añosExpericia);
        this.proyectosInvestigacion = proyectosInvestigacion;
        this.dedicacionTiempo = dedicacionTiempo;

    }
}
