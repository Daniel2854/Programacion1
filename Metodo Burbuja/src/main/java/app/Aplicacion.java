package app;

import model.Ordenador;
import model.Persona;

import java.util.ArrayList;
import java.util.List;

public class Aplicacion {
    public static void main(String[] args) {
        List<Persona> lista = new ArrayList<>();
        lista.add(new Persona("Ana", "Salazar", 23, "01", "ana@uqvirtual.edu.co"));
        lista.add(new Persona("Luis", "Herrera", 19, "02", "luis@uqvirtual.edu.co"));
        lista.add(new Persona("Carlos", "Ramirez",23, "03", "carlos@uqvirtual.edu.co"));
        lista.add(new Persona("Daniel", "Fino", 20, "04", "Daniel@uqvirtual.edu.co"));
        lista.add(new Persona("Sofía", "Marín", 18, "05", "sofia@uqvirtual.edu.co"));
        lista.add(new Persona("Sara", "Salazar", 20, "06", "sara@uqvirtual.edu.co"));
        lista.add(new Persona("Jhonatan", "Mosquera", 20, "07", "jhonatan@uqvirtual.edu.co"));
        Ordenador.burbujaPorEdad(lista);

        for (Persona p : lista) {
            System.out.println(p.nombre() + " - " + p.edad());
        }
    }
}
