package model;

import java.util.ArrayList;

public class Cuenta {
    private String titular;
    private String numeroCuenta;
    private double saldo;

    public Cuenta(String titular, String numeroCuenta, double saldoInicial) {
        this.titular = titular;
        this.numeroCuenta = numeroCuenta;

        if (saldoInicial < 0) {
            throw new IllegalArgumentException("Saldo inicial negativo");
        }
        this.saldo = saldoInicial;
    }

    public String getTitular() {
        return titular;
    }
    public void setTitular(String titular) {
        this.titular = titular;
    }
    public String getNumeroCuenta() {
        return numeroCuenta;
    }
    public void serNumeroCuenta(String nuevoNumeroCuenta) {
        this.numeroCuenta = nuevoNumeroCuenta;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double nuevoSaldo) {
        this.saldo = nuevoSaldo;
    }

    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
        } else  {
            throw new IllegalArgumentException("el monto no puede ser menor o igual que 0");
        }
    }

    public void retirar(double monto) {
        if (monto > 0 && saldo >= monto) {
            saldo -= monto;
        } else {
            throw new IllegalArgumentException("el monto a retirar no puede ser mayor al saldo");
        }
    }



    @Override
    public String toString() {
        return "Cuenta{" +
                "titular='" + titular + '\'' +
                ", numeroCuenta='" + numeroCuenta + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}
