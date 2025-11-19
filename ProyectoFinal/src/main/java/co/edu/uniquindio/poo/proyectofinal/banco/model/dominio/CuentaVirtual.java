package co.edu.uniquindio.poo.proyectofinal.banco.model.dominio;

import co.edu.uniquindio.poo.proyectofinal.banco.model.soporte.MontoInvalidoException;
import co.edu.uniquindio.poo.proyectofinal.banco.model.soporte.SaldoInsuficienteException;
import co.edu.uniquindio.poo.proyectofinal.banco.model.transacciones.Transaccion;

import java.util.ArrayList;
import java.util.List;

public class CuentaVirtual {
    private final String numeroCuenta;
    private double saldo;
    private List<Monedero> listaMonederos = new ArrayList<>();
    private List<Transaccion> listaTransacciones = new ArrayList<>();
    private Cliente cliente;

    public CuentaVirtual(String numeroCuenta, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldoInicial;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public void setListaMonederos(List<Monedero> listaMonederos) {
        this.listaMonederos = listaMonederos;
    }
    public void setListaTransacciones(List<Transaccion> listaTransacciones) {
        this.listaTransacciones = listaTransacciones;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public void depositar(double monto) {
        if (monto <= 0) {
            throw new MontoInvalidoException("Monto debe mayor a cero");
        }
        saldo += monto;
    }

    public void retirar(double monto) {
        if (monto <= 0) {
            throw new MontoInvalidoException("Monto debe ser positivo");
        }
        if (saldo < monto) {
            throw new SaldoInsuficienteException("Saldo insuficiente");
        }
        saldo -= monto;
    }

    public void agregarMonedero(Monedero m) {
        listaMonederos.add(m);
    }
    public List<Monedero> getListaMonederos() {
        return listaMonederos;
    }

    public void registrarTransaccion(Transaccion t) {
        listaTransacciones.add(t);
    }
    public List<Transaccion> getListaTransacciones() {
        return listaTransacciones;
    }

    @Override
    public String toString() {
        return "CuentaVirtual{" +
                "numeroCuenta='" + numeroCuenta + '\'' +
                ", saldo=" + saldo +
                ", listaMonederos=" + listaMonederos +
                ", listaTransacciones=" + listaTransacciones +
                ", cliente=" + cliente +
                '}';
    }
}
