package model;

import java.util.ArrayList;

public record CarreraUniversitaria(String nombre, int creditos,
                                   ArrayList<Profesor> listaProfesores,
                                   ArrayList<Materia> listaMaterias,
                                   ArrayList<Estudiante> listaEstudiantes) {
}
