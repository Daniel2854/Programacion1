package model;

import java.util.ArrayList;
import java.util.List;

public class CuentaVirtual {
    private String numeroCuenta;
    private double saldo;
    private List<Monedero> listaMonederos = new ArrayList<>();
    private List<Transaccion> listaTransacciones = new ArrayList<>();
    private Cliente cliente;

    public CuentaVirtual(String numeroCuenta, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldoInicial;
    }

    public String getNumeroCuenta() { return numeroCuenta; }
    public double getSaldo() { return saldo; }
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public void depositar(double monto) {
        if (monto <= 0) throw new MontoInvalidoException("Monto debe ser positivo");
        saldo += monto;
    }

    public void retirar(double monto) {
        if (monto <= 0) throw new MontoInvalidoException("Monto debe ser positivo");
        if (saldo < monto) throw new SaldoInsuficienteException("Saldo insuficiente");
        saldo -= monto;
    }

    public void agregarMonedero(Monedero m) { listaMonederos.add(m); }
    public List<Monedero> getListaMonederos() { return listaMonederos; }

    public void registrarTransaccion(Transaccion t) { listaTransacciones.add(t); }
    public List<Transaccion> getListaTransacciones() { return listaTransacciones; }
}

}
