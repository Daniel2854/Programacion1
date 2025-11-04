package model;

public class MateriaTeorica extends Materia {
     public MateriaTeorica(String codigo, String nombre, int numeroHoras, int creditos, String semestre,
                           Profesor profesor, CarreraUniversitaria ownedByCarreraUniversitaria) {

         super(codigo, nombre, numeroHoras, creditos, semestre, profesor, ownedByCarreraUniversitaria);
     }
}
