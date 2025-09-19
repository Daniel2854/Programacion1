package model;

/**
 * Ésta clase representa los monos y hereda de Animal.
 *
 * Aún no se han añadido métodos o atributos exclusivos de esta clase.
 */
public class Mono extends Animal {

    public Mono(String nombre, double peso, String familia, int edad, String idAnimal) {
        super(nombre, peso, familia, edad, idAnimal);
    }

    @Override
    public void hacerSonido() {
        System.out.println(getNombre() + " grita: ¡Uuh uuh aah aah!");
    }

}
