package model;

import java.util.Arrays;

public class Mascota {
    private String idMascota;
    private String nombreMascota;
    private String especieMascota;
    private String razaMascota;
    private short edadMascota;
    private String colorMascota;
    private float pesoMascota;
    private String[] enfermedadesMascota;

    public Mascota(String idMascota, String nombreMascota, String especieMascota,
                   String razaMascota, short edadMascota, String colorMascota,
                   float pesoMascota) {
        this.idMascota = idMascota;
        this.nombreMascota = nombreMascota;
        this.especieMascota = especieMascota;
        this.razaMascota = razaMascota;
        this.edadMascota = edadMascota;
        this.colorMascota = colorMascota;
        this.pesoMascota = pesoMascota;
        this.enfermedadesMascota = new String[5];
    }

    public String getIdMascota() {
        return idMascota;
    }
    public void setIdMascota(String nuevoIdMascota) {
        this.idMascota = nuevoIdMascota;
    }
    public String getNombreMascota() {
        return nombreMascota;
    }
    public void setNombreMascota(String nuevoNombreMascota) {
        this.nombreMascota = nuevoNombreMascota;
    }
    public String getEspecieMascota() {
        return especieMascota;
    }
    public void setEspecieMascota(String nuevaEspecieMascota) {
        this.especieMascota = nuevaEspecieMascota;
    }
    public String getRazaMascota() {
        return razaMascota;
    }
    public void setRazaMascota(String nuevaRazaMascota) {
        this.razaMascota = nuevaRazaMascota;
    }
    public short getEdadMascota() {
        return edadMascota;
    }
    public void setEdadMascota(short nuevaEdadMascota) {
        this.edadMascota = nuevaEdadMascota;
    }
    public String getColorMascota() {
        return colorMascota;
    }
    public void setColorMascota(String nuevoColorMascota) {
        this.colorMascota = nuevoColorMascota;
    }
    public float getPesoMascota() {
        return pesoMascota;
    }
    public void setPesoMascota(float nuevoPesoMascota) {
        this.pesoMascota = nuevoPesoMascota;
    }
    public String[] getEnfermedades() {
        return enfermedadesMascota;
    }
    public void setEnfermedades(String[] nuevasEnfermedades) {
        this.enfermedadesMascota = nuevasEnfermedades;
    }

    public void mostrarInformacion() {
        System.out.println("Id: " + idMascota);
        System.out.println("Nombre: " + nombreMascota);
        System.out.println("Especie: " + especieMascota);
        System.out.println("Raza: " + razaMascota);
        System.out.println("Edad: " + edadMascota + " años");
        System.out.println("Color: " + colorMascota);
        System.out.println("Peso: " + pesoMascota);
        System.out.println("Enfermedades: " + Arrays.toString(enfermedadesMascota));

    }
}
