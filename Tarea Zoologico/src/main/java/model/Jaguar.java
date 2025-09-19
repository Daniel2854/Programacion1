package model;

/**
 * Ésta clase representa los jaguares y hereda de Animal.
 *
 * Aún no se han añadido métodos o atributos exclusivos de esta clase.
 */
public class Jaguar extends Animal {

    public Jaguar(String nombre, double peso, String familia, int edad, String idAnimal ) {
        super(nombre, peso, familia, edad, idAnimal);
    }

    @Override
    public void hacerSonido() {
        System.out.println(getNombre() + " ruge: ¡Roooaaar!");
    }

}
