package app;

import javax.swing.*;

public class Aplicacion {
    public static void main(String[] args) {
        String idMascota = JOptionPane.showInputDialog("Ingrese el id:");
        String nombreMascota = JOptionPane.showInputDialog("Ingrese el nombre:");
        String especieMascota = JOptionPane.showInputDialog("Ingrese la especie:");
        String razaMascota = JOptionPane.showInputDialog("Ingrese la raza:");
        int edadMascota = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad:"));
        String colorMascota = JOptionPane.showInputDialog("Ingrese el color o colores del pelaje, plumaje, caparazón o piel:");
        double pesoMascota = Double.parseDouble(JOptionPane.showInputDialog("Ingrese  el peso:"));
    }
}
