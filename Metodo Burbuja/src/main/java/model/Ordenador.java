package model;

import java.util.List;

public class Ordenador {
    public static void burbujaPorEdad(List<Persona> personas) {
        int n = personas.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                Persona actual = personas.get(j);
                Persona siguiente = personas.get(j + 1);
                if (actual.edad() > siguiente.edad()) {
                    personas.set(j, siguiente);
                    personas.set(j + 1, actual);
                }
            }
        }
    }
}
