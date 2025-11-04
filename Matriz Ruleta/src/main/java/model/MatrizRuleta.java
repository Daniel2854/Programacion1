package model;
/**
 *  Ésta clase representa la matriz que va girando.
 *  No acepta matrices rectangulares.
 *  No realiza giros en espiral (varias capas).
 *
 *  matriz     Almacena los datos originales.
 *  filas      Guarda las dimensiones para facilitar acceso.
 *  columnas   Guarda las dimensiones para facilitar acceso.
 *
 * @author Daniel Gil Fino
 */
public class MatrizRuleta {
    private int[][] matriz;
    private int filas;
    private int columnas;

    /**
     *  Constructor de la clase.
     *
     * Recibe una matriz externa y copia sus valores para modificar la original.
     * Calcula las dimensiones de manera automatica.
     *
     * @param matriz
     */
    public MatrizRuleta(int[][] matriz) {
        this.filas = matriz.length;
        this.columnas = matriz[0].length;
        this.matriz = new int[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                this.matriz[i][j] = matriz[i][j];
            }
        }
    }

    /**
     * Hace que gire la cantidad de giros indicada sólo en sentido horario.
     * Hace uso del método para girar de manera aislada una vez cada parte de la matriz cuadrada.
     *
     * @param cantidadDeGiros
     */
    public void girar(int cantidadDeGiros) {
        for (int giro = 0; giro < cantidadDeGiros; giro++) {
            girarUnaVez();
        }
    }

    /**
     * Crea una copia temporal para evitar sobrescribir datos mientras gira.
     * Mueve los elementos del borde superior, derecho, inferior e izquierdo en orden.
     * Solo gira la capa externa de la matriz.
     */
    private void girarUnaVez() {
        int[][] copia = new int[filas][columnas];

        for (int copiaMatriz = 0; copiaMatriz < filas; copiaMatriz++) {
            for (int j = 0; j < columnas; j++) {
                copia[copiaMatriz][j] = matriz[copiaMatriz][j];
            }
        }

        for (int bordeSuperior = 1; bordeSuperior < columnas; bordeSuperior++) {
            matriz[0][bordeSuperior] = copia[0][bordeSuperior - 1];
        }

        for (int bordeDerecho = 1; bordeDerecho < filas; bordeDerecho++) {
            matriz[bordeDerecho][columnas - 1] = copia[bordeDerecho - 1][columnas - 1];
        }

        for (int bordeInferior = columnas - 2; bordeInferior >= 0; bordeInferior--) {
            matriz[filas - 1][bordeInferior] = copia[filas - 1][bordeInferior + 1];
        }

        for (int bordeIzquierdo = filas - 2; bordeIzquierdo >= 0; bordeIzquierdo--) {
            matriz[bordeIzquierdo][0] = copia[bordeIzquierdo + 1][0];
        }
    }

    /**
     * Recorre la matriz y muestra el estado actual de la matriz.
     */
    public void imprimir() {
        for (int[] fila : matriz) {
            for (int num : fila) {
                System.out.print(num + "\t");
            }
            System.out.println();
        }
    }
}
