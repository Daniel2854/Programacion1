package app;

import model.MatrizRuleta;

public class Aplicacion {
    public static void main(String[] args) {
       //Matriz de ejemplo
        int[][] datos = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        //Instancia de MatrizRuleta
        MatrizRuleta ruleta = new MatrizRuleta(datos);

        //Muestra la matriz sin ningún giro
        System.out.println("Matriz original:");
        ruleta.imprimir();

        //Realiza el giro de la matriz
        ruleta.girar(1);

        //Muestra la matriz luego del o los giros
        System.out.println("\nMatriz después del giro");
        ruleta.imprimir();
    }
}
