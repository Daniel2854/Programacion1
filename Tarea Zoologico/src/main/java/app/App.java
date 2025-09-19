package app;

import model.*;


public class App {
    public static void main(String[] args) {

        // 1. Crea el Zoo.
        Zoo zoologico = new Zoo("Ukumarí", "Pereira");

        // 2. Crea los animales.
        zoologico.registrarAnimal(new Mono("Mono capuchino", 1.6 , "Cebidae", 6, "000123"));
        zoologico.registrarAnimal(new Lobo("Lobo gris", 63.6 , "Cánidos", 12, "002301"));
        zoologico.registrarAnimal(new Jaguar("Panthera onca)", 87.9, "Panterinos", 7, "299012" ));
        zoologico.registrarAnimal(new Elefante("Elefante Africano",6000, "elefántidos", 37, "000017" ));
        zoologico.registrarAnimal(new Loro("Guacamaya azúl", 1.2, "Psittacidae", 3, "097612"));

        // 3. Enseña los sonidos de ls animales.
        System.out.println("\nSonidos de los animales:");
        zoologico.hacerSonidos();

    }
}
