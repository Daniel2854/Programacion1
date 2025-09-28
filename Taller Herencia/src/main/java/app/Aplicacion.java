package app;

import model.CuentaAhorro;

public class Aplicacion {
    public static void main(String[] args) {

        // 1. Crear una cuenta de ahorros
        CuentaAhorro cuentaAhorro = new CuentaAhorro(1200000.0f, 8.0f);

        // 2. Consigna una cantidad de dinero a la cuenta
        System.out.println(cuentaAhorro.consignar(350000.0f));

        // 3. Se hacen 5 retiros para generar una comisión mensual
        System.out.println(cuentaAhorro.retirar(15000.0f));
        System.out.println(cuentaAhorro.retirar(30000.0f));
        System.out.println(cuentaAhorro.retirar(20000.0f));
        System.out.println(cuentaAhorro.retirar(35000.0f));
        System.out.println(cuentaAhorro.retirar(25000.0f));

        // 4. Genera el extracto mensual
        cuentaAhorro.extractoMensual();

        // 1. Imprime la información de la cuenta y los procesos que ha tenido
        cuentaAhorro.imprimirAtributos();


    }
}
