package model;

/**
 * Ésta clase representa los elefantes y hereda de Animal.
 *
 * Aún no se han añadido métodos o atributos exclusivos de esta clase.
 */
public class Elefante extends Animal {

    public Elefante(String nombre, double peso, String familia, int edad, String idAnimal) {
        super(nombre, peso, familia, edad, idAnimal);
    }

    @Override
    public void hacerSonido() {
        System.out.println(getNombre() + " barrita: ¡Prrrruuuuuh!");
    }
}
