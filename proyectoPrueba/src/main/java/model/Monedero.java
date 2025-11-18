package model;

public class Monedero {
    private String nombre;
    private double saldo;
    private TipoMonedero tipoMonedero;
    private CuentaVirtual ownedByCuentaVirtual;

    public Monedero(String nombre, TipoMonedero tipo, CuentaVirtual ownedByCuentaVirtual) {
        this.nombre = nombre;
        this.tipoMonedero = tipo;
        this.saldo = 0;
        this.ownedByCuentaVirtual = ownedByCuentaVirtual;
    }

    public String getNombre() { return nombre; }
    public TipoMonedero getTipoMonedero() { return tipoMonedero; }
    public double getSaldo() { return saldo; }

    public void depositar(double monto) {
        if (monto <= 0) throw new MontoInvalidoException("Monto debe ser positivo");
        saldo += monto;
    }

    public void retirar(double monto) {
        if (monto <= 0) throw new MontoInvalidoException("Monto debe ser positivo");
        if (saldo < monto) throw new SaldoInsuficienteException("Saldo insuficiente");
        saldo -= monto;
    }

}
