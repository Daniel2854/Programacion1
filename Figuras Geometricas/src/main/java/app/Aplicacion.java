package app;

import model.Circulo;
import model.Cuadrado;
import model.Figura;
import model.Triangulo;

import java.util.ArrayList;
import java.util.List;

public class Aplicacion {
    public static void main(String[] args) {
        List<Figura> figuras = new ArrayList<>();
        figuras.add(new Circulo(5));
        figuras.add(new Cuadrado(4));
        figuras.add(new Triangulo(6));

        for (Figura figura : figuras) {
            System.out.println(figura);
            System.out.printf("Área: %.2f\n", figura.calcularArea());
            System.out.printf("Perímetro: %.2f\n\n", figura.calcularPerimetro());
        }

    }
}
