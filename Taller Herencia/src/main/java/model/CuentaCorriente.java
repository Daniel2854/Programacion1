package model;

/**
 * Representa una cuenta corriente.
 *
 * Ésta clase hereda de la superClase CuentaBancaria.
 * Contiene informacon de sobreGiro.
 *
 * @author Daniel Gil Fino
 */
public class CuentaCorriente extends CuentaBancaria {

    private float sobreGiro = 0;

    /**
     * Constructor para crear una cuenta de ahorros.
     *
     * @param saldo        Cantidad de dinero inicial de la cuenta.
     * @param tasaAnual    Define la tasa de interéses anual de la cuenta.
     */
    public CuentaCorriente(float saldo, float tasaAnual) {
        super(saldo, tasaAnual);
    }

    /**
     * Sobre escribe el método retirar para que si la cantidad a retirar supera el saldo de la cuneta,
     * entonces se realice un saldo con sobre giro y la cuenta quede en saldo negativo, de contrario se hace el retiro normal.
     *
     * @param cantidad    Cantidad de dinero a retirar.
     */
    @Override
    public String retirar(float cantidad) {
        if (cantidad <= 0) {
            return "Cantidad inválida";
        }

        if (cantidad <= saldo) {
            return super.retirar(cantidad); // usa el método heredado
        } else {
            float diferencia = cantidad - saldo;
            saldo = 0;
            sobreGiro += diferencia;
            numeroRetiros++;
            return "Retiro realizado con sobregiro de $" + diferencia;
        }
    }

    /**
     * Sobre escribe el método consignar para que sse cubra el monto del sobre giro por completo o de forma parcial,
     * dependiendo del monto del sobre giro de la consignación, de esta forma si el sobre giro es cero entonces,
     * el dinero llega completo a la cuebta, sino se cubre el sobre giro, si el monto supero el sobre giro la diferencia,
     * quedará en la cuenta, si el sobre giro supera al monto entonce el sobre  giro se reduce la misma cantidad del monto.
     *
     * @param cantidad    Cantidad de dinero a consignar.
     */
    @Override
    public String consignar(float cantidad) {
        if (cantidad <= 0) {
            return "Cantidad inválida";
        }
        String mensaje = super.consignar(cantidad);

        if (sobreGiro > 0) {
            if (cantidad >= sobreGiro) {
                cantidad -= sobreGiro;
                sobreGiro = 0;
                saldo += cantidad;
                mensaje += "Sobre giro cubierto completamente";
            } else {
                sobreGiro -= cantidad;
                mensaje += "Sobre giro reducido a $" + sobreGiro;
            }
        }
        return mensaje;
    }

    /**
     * Genera el extraccto mensual llamando al método de la superClase.
     */
    @Override
    public void extractoMensual() {
        super.extractoMensual();
    }

    /**
     * Imprime los atributos.
     */
    @Override
    public void imprimirAtributos() {
        System.out.println("Saldo: " + saldo);
        System.out.println("Sobregiro: " + sobreGiro);
        System.out.println("Comisión mensual: " + comisionMensual);
        System.out.println("Transacciones: " + (numeroConsignaciones + numeroRetiros));
    }
}
