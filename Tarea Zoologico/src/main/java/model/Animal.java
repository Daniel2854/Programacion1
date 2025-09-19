package model;

/**
 *Representa los atributos génerales que cada animal va a heredar.
 *
 * Actua como súper clase.
 *
 * @author Daniel Gil Fino
 */
public abstract class Animal {
    private String nombre;
    private double peso;
    private String familia;
    private int edad;
    private String idAnimal;

    /**
     * Constructor de la clse
     *
     * @param nombre     Nombre de cada animal
     * @param peso       Peso de cada animal en kilos
     * @param familia    La famlia a la que ppertenece cada animal
     * @param edad       La edad de cada animal en años.
     * @param idAnimal   El indentificador de cada animal (es único)
     */
    public Animal(String nombre, double peso, String familia, int edad, String idAnimal) {
        this.nombre = nombre;
        this.peso = peso;
        this.familia = familia;
        this.edad = edad;
        this.idAnimal = idAnimal;
    }


    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        if (peso >= 0) {
            this.peso = peso;
        }
    }
    public String getFamilia() {
        return familia;
    }
    public void setFamilia(String familia) {
        this.familia = familia;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        if (edad >= 0) {
            this.edad = edad;
        }
    }
    public String getIdAnimal() {
        return idAnimal;
    }
    public void setIdAnimal(String idAnimal) {
        this.idAnimal = idAnimal;
    }


    public abstract void hacerSonido();

}
