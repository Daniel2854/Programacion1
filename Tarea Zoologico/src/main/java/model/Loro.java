package model;

/**
 * Ésta clase representa los loros y hereda de Animal.
 *
 * Aún no se han añadido métodos o atributos exclusivos de esta clase.
 */
public class Loro extends Animal {

    public Loro(String nombre, double peso, String familia, int edad, String idAnimal) {
        super(nombre, peso, familia, edad, idAnimal);
    }

    @Override
    public void hacerSonido() {
        System.out.println(getNombre() + " grazna: ¡Prrrr!");
    }
}
