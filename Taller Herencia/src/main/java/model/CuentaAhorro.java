package model;


/**
 * Representa una cuenta de ahorros.
 * Contiene información de estado de cuenta que define si está activa o no con un boolean.
 * Ésta clase hereda de la superClase CuentaBancaria.
 *
 * @author Daniel Gil Fino
 */
public class CuentaAhorro extends CuentaBancaria {

    private boolean estadoCuenta;

    /**
     * Constructor para crear una cuenta de ahorros.
     *
     * @param saldo        Cantidad de dinero inicial de la cuenta.
     * @param tasaAnual    Define la tasa de interéses anual de la cuenta.
     */
    public CuentaAhorro(float saldo, float tasaAnual) {
        super(saldo, tasaAnual);
        verificarEstado();
    }

    /**
     * Define es estado de la cuenta de ahorros.
     * Una cuenta se considera activa si tiene un saldo mayor o igual a diez mil.
     * Se inicializa en el constructor para un mejor funcionamiento del programa.
     */
    private void verificarEstado() {
        estadoCuenta = saldo >= 10000.0f;
    }

    /**
     * Sobre escribe el método consignar de la superClase para adaptarlo a las necesidades de una cuenta de ahorros.
     * Consigna una cantidad de dinero dada sólo sí la cuenta está activa.
     *
     * @param cantidad  La cantidad de dinero que se va consignar.
     */
    @Override
    public String consignar(float cantidad) {
        verificarEstado();
        if (estadoCuenta) {
            return super.consignar(cantidad);
        }
        return "No se puede realizar la consignación, cuenta inactiva";
    }

    /**
     * Sobre escribe el método retirar de la superClase para adaptarlo a las necesidades de una cuenta de ahorros.
     * Retira una cantidad de dinero sólo si la cuenta está activa.
     *
     * @param cantidad  La cantidad de dinero que se desea retirar.
     */
    @Override
    public String retirar(float cantidad) {
        verificarEstado();
        if (estadoCuenta) {
            super.retirar(cantidad);
            return super.retirar(cantidad);
        }
        return "No se puede hacer el retiro, cuenta inactiva";
    }

    /**
     * Obtiene el extractoMensual de la cuenta sólo si está activa.
     *
     * @return Nombre de la fábrica.
     */
    @Override
    public void extractoMensual() {
        if (numeroRetiros > 4) {
            comisionMensual += (numeroRetiros - 4) * 1000;
        }
        super.extractoMensual();
        verificarEstado();
    }

    /**
     * Sobre escribe el método imprimirAtributos de la superClase
     * Imprime los atributos requeridos de la cuenta de ahorros.
     *
     */
    @Override
    public void imprimirAtributos() {
        System.out.println("Saldo: " + saldo);
        System.out.println("Comisión mensual: " + comisionMensual);
        System.out.println("Transacciones: " + (numeroConsignaciones + numeroRetiros));
        System.out.println("Estado de la cuenta: " + (estadoCuenta ? "Activa" : "Inactiva"));
    }
}
