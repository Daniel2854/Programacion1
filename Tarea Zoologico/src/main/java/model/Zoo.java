package model;

import java.util.ArrayList;


/**
 * Representa un Zoologico.
 * Contiene información de identificación como nombre, ubicación,
 * así como la lista de animales.
 *
 * Esta clase actúa como el gestor de las clases Animal, Mono, Lobo, Jaguar, Loro, Elefante.
 *
 * @author Daniel Gil Fino
 */
public class Zoo {
    private String nombre;
    private String ubicacion;
    private ArrayList<Animal> listaAnimales;

    /**
     * Constructor para crear una nueva fábrica de autos.
     *
     * @param nombre      Nombre del zoo.
     * @param ubicacion   Ubicación del zoo.
     */
    public Zoo(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.listaAnimales = new ArrayList<>();
    }

    /**
     * Métodos getters y setters para optener y asignar cada atributo de la clase.
     */
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getUbicacion() {
        return ubicacion;
    }
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    public ArrayList<Animal> getListaAnimales() {
        return listaAnimales;
    }
    public void setListaAnimales(ArrayList<Animal> listaAnimales) {
        this.listaAnimales = listaAnimales;
    }

    /**
     * Método para optener un animal de la lista.
     *
     * @param idAnimal
     * @return animalEncontrado
     */
    public Animal buscarAnimal(String idAnimal) {
        Animal animalEncontrado = null;
        for (Animal animalAux : listaAnimales) {
            if (animalAux.getIdAnimal().equals(idAnimal)) {
                animalEncontrado = animalAux;
                break;
            }
        }
        return animalEncontrado;
    }

    /**
     * Método para añadir un animal a la lista de animales.
     *
     * @param nuevoAnimal
     * @return mensaje
     */
    public String registrarAnimal(Animal nuevoAnimal) {
        String mensaje = "";
        Animal animalRegistrado = buscarAnimal(nuevoAnimal.getIdAnimal());
        if (animalRegistrado == null) {
            this.listaAnimales.add(nuevoAnimal);
            mensaje = "Animal añadido correctamente";
        } else {
            mensaje = "Animal ya existe";
        }
        return mensaje;
    }

    /**
     * Método para eliminar un animal de la lista.
     *
     * @param idAnimal
     * @return mensaje
     */
    public String eliminarAnimal(String idAnimal) {
        String mensaje = "";
        Animal animalEliminado = buscarAnimal(idAnimal);
        if (animalEliminado != null) {
            this.listaAnimales.remove(animalEliminado);
            mensaje = "Animal eliminado correctamente";
        } else {
            mensaje = "Animal no existe";
        }
        return mensaje;
    }

    /**
     * Método para editar cada uno de los atributos del animal.
     *
     * @param idAnimal
     * @param nuevoAnimal
     * @return
     */
    public String editarAnimal(String idAnimal, Animal nuevoAnimal) {
        Animal animalEncontrado = buscarAnimal(idAnimal);
        String mensaje = "";

        if( animalEncontrado != null ) {
            animalEncontrado.setNombre(nuevoAnimal.getNombre());
            animalEncontrado.setPeso(nuevoAnimal.getPeso());
            animalEncontrado.setFamilia(nuevoAnimal.getFamilia());
            animalEncontrado.setEdad(nuevoAnimal.getEdad());
            animalEncontrado.setIdAnimal(nuevoAnimal.getIdAnimal());
            mensaje = "Datos del animal editados correctamente ";
        }
        else {
            mensaje = "El id del animal no ha sido encontrado ";
        }
        return mensaje;
    }

    /**
     * Método para enseñar el sonido que hace cada uno de los animales en la lista.
     */
    public void hacerSonidos() {
        for (Animal animalAux : listaAnimales) {
            animalAux.hacerSonido();
        }
    }
}