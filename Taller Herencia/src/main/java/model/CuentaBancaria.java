package model;

/**
 * Representa una clase padre o superClase de cuenta bancaria.
 *
 * Contiene información general del saldo, numero de consignaciones, numero de retiros, la tasa anual y
 * la comison mensual, que heredaran las clases hijas o las subClases.
 *
 * Esta clase actúa como el molde general para los tipos de cuentas bancarias.
 *
 * @author Daniel Gil Fino.
 */
public abstract class CuentaBancaria {
    protected float saldo;
    protected int numeroConsignaciones = 0;
    protected int numeroRetiros = 0;
    protected float tasaAnual;
    protected float comisionMensual = 0;

    /**
     * Constructor que heredan las subClases.
     *
     * @param saldo        la cantidad de dinero inicial de la cuenta.
     * @param tasaAnual    la tasa de interés anual de la cuenta.
     */
    public CuentaBancaria(float saldo, float tasaAnual) {
        this.saldo = saldo;
        this.tasaAnual = tasaAnual;
    }

    /**
     * Todos los métodos getters y setters que heredan las subClases.
     *
     * Obtienen y asignan cada uno de los atributos de la superClase.
     *
     * No sirven para optener atributos individuales de las subClases.
     */
    public float getSaldo() {
        return saldo;
    }
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    public int getNumeroConsignaciones() {
        return numeroConsignaciones;
    }
    public void setNumeroConsignaciones(int numeroConsignaciones) {
        this.numeroConsignaciones = numeroConsignaciones;
    }
    public int getNumeroRetiros() {
        return numeroRetiros;
    }
    public void setNumeroRetiros(int numeroRetiros) {
        this.numeroRetiros = numeroRetiros;
    }
    public float getTasaAnual() {
        return tasaAnual;
    }
    public void setTasaAnual(float tasaAnual) {
        this.tasaAnual = tasaAnual;
    }
    public float getComisionMensual() {
        return comisionMensual;
    }
    public void setComisionMensual(float comisionMensual) {
        this.comisionMensual = comisionMensual;
    }

    /**
     * Consiga un cantidad de dinero dada a la cuenta bancaria.
     *
     * @param cantidad  La cantidad de dinero a ingresar.
     * @return Mensaje que indica si se puede hacer la consignacion o no.
     */
    public String consignar(float cantidad) {
        String mensaje;
        if (cantidad > 0) {
            saldo += cantidad;
            numeroConsignaciones++;
            mensaje = "El dinero fué consignado correctamente";
        } else {
            mensaje = "No se puede ingresar ese valor";
        }
        return mensaje;
    }

    /**
     * Registra un nuevo automóvil si no existe ya en la lista.
     *
     * @param   cantidad La cantidad de dinero que se desea retirar de la cuenta bancaria.
     * @return  Mensaje que indica si se puede hacer el retiro o no.
     */
    public String retirar(float cantidad) {
        String mensaje = "";
        if (cantidad > 0 && cantidad <= saldo) {
            saldo -= cantidad;
            numeroRetiros++;
            mensaje = "El dinero fué retirado correctamente";
        } else {
            mensaje = "No se puede retirar ese valor";
        }
        return mensaje;
    }

    /**
     * Calcula el interes mensual de la cuenta según el saldo y lo deposita en la cuenta automaticcamente.
     */
    public void calcularValorInteresMensual() {
        float interesMensual = (saldo * (tasaAnual / 100)) / 12;
        saldo += interesMensual;
    }

    /**
     * Genera el extracto mensual para agregar los intereses y restar las comisiones del saldo de la cuenta.
     */
    public void extractoMensual() {
        saldo -= comisionMensual;
        calcularValorInteresMensual();
    }

    /**
     * Imprime todos los atributos de la cuenta.
     */

    public void imprimirAtributos() {
        System.out.println("Saldo: " + saldo);
        System.out.println("Consignaciones: " + numeroConsignaciones);
        System.out.println("Retiros: " + numeroRetiros);
        System.out.println("Tasa anual: " + tasaAnual);
        System.out.println("Comisión mensual: " + comisionMensual);
    }
}
