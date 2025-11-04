package model;

public class MateriaPractica extends Materia{
    private double horasPractica;
    private int numeroLaboratorios;

    public  MateriaPractica(String codigo, String nombre, int numeroHoras, int creditos, String semestre,
                            Profesor profesor, CarreraUniversitaria ownedByCarreraUniversitaria, double horasPractica,
                            int numeroLaboratorios) {
        super(codigo, nombre, numeroHoras, creditos, semestre, profesor, ownedByCarreraUniversitaria);
        this.horasPractica = horasPractica;
        this.numeroLaboratorios = numeroLaboratorios;
    }
}
