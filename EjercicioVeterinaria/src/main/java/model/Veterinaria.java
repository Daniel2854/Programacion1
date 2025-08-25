package model;

import java.util.ArrayList;

public class Veterinaria {
    private String nombre;
    private String ubicacion;
    private String nit;
    private ArrayList<Mascota> listaMascotas;

    // Constructor
    public Veterinaria(String nombre, String ubicacion, String nit) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.nit = nit;
        this.listaMascotas = new ArrayList<>();
    }

    // Métodos para optener y asignar los atributos de la veterinaria
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;
    }
    public String getUbicacion() {
        return ubicacion;
    }
    public void setUbicacion(String nuevaUbicacion) {
        this.ubicacion = nuevaUbicacion;
    }
    public String getNit() {
        return nit;
    }
    public void setNit(String nuevoNit) {
        this.nit = nuevoNit;
    }
    public ArrayList<Mascota> getListaMascotas() {
        return listaMascotas;
    }
    public void setListaMascotas(ArrayList<Mascota> nuevaListaMascotas) {
        this.listaMascotas = nuevaListaMascotas;
    }

    /**
     * Este método permite registrar a una nueva mascota en la veterinaria
     * @param nuevaMascota
     * @return
     */
    public String crearMascota(Mascota nuevaMascota) {
        String resultado = "";
        Mascota mascotaEncontrada = null;
        mascotaEncontrada = buscarMascota(nuevaMascota.getIdMascota());

        if( mascotaEncontrada == null ) {
            listaMascotas.add(nuevaMascota);
            resultado = "Mascota registrada correctamente";
        }
        else {
            resultado = "la mascota ya está registrada";
        }
        return resultado;
    }

    public Mascota buscarMascota(String idMascota) {
        Mascota mascotaEncontrada = null;

        for (int i = 0; i<listaMascotas.size() && mascotaEncontrada == null; i++) {
            Mascota mascotaAux = listaMascotas.get(i);
            if (mascotaAux.getIdMascota().equals(idMascota)) {
                mascotaEncontrada = mascotaAux;
            }
        }
        return mascotaEncontrada;
    }

    public String eliminarMascota(String idMascota) {
        Mascota mascotaEncontrada = null;
        mascotaEncontrada = buscarMascota(idMascota);

        if (mascotaEncontrada != null) {
            listaMascotas.remove(mascotaEncontrada);
            return "Mascota eliminada";
        }
        else{
            return "El id NO está registrado";
        }
    }

    public String editarMascota(String idMascota, Mascota nuevosDatosMascota) {
     Mascota mascotaEncontrada = null;
     mascotaEncontrada = buscarMascota(idMascota);

     if( mascotaEncontrada != null ) {
         mascotaEncontrada.setIdMascota(nuevosDatosMascota.getIdMascota());
         mascotaEncontrada.setNombreMascota(nuevosDatosMascota.getNombreMascota());
         mascotaEncontrada.setEspecieMascota(nuevosDatosMascota.getEspecieMascota());
         mascotaEncontrada.setRazaMascota(nuevosDatosMascota.getRazaMascota());
         mascotaEncontrada.setEdadMascota(nuevosDatosMascota.getEdadMascota());
         mascotaEncontrada.setColorMascota(nuevosDatosMascota.getColorMascota());
         mascotaEncontrada.setPesoMascota(nuevosDatosMascota.getPesoMascota());
         return  "Mascota editada correctamente";
     }
     else {
         return "El id NO está registrado";
     }
    }
}



///private Mascota buscarMascota2(String idMascota) {
///Mascota mascotaEncontrada = null;
///for (Mascota mascotaAux : listaMascotas) {
///if (mascotaAux.getIdMascota().equals(idMascota)) {
///mascotaEncontrada = mascotaAux;
///}
///}
///return mascotaEncontrada;
///}
