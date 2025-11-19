package co.edu.uniquindio.poo.proyectofinal.banco.model.dominio;

import co.edu.uniquindio.poo.proyectofinal.banco.model.soporte.MontoInvalidoException;
import co.edu.uniquindio.poo.proyectofinal.banco.model.soporte.SaldoInsuficienteException;
import co.edu.uniquindio.poo.proyectofinal.banco.model.soporte.TipoMonedero;

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

    public String getNombre() {
        return nombre;
    }
    public double getSaldo() {
        return saldo;
    }
    public TipoMonedero getTipoMonedero() {
        return tipoMonedero;
    }
    public CuentaVirtual getOwnedByCuentaVirtual() {
        return ownedByCuentaVirtual;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public void setTipoMonedero(TipoMonedero tipoMonedero) {
        this.tipoMonedero = tipoMonedero;
    }
    public void setOwnedByCuentaVirtual(CuentaVirtual ownedByCuentaVirtual) {
        this.ownedByCuentaVirtual = ownedByCuentaVirtual;
    }

    public void depositar(double monto) {
        if (monto <= 0) {
            throw new MontoInvalidoException("Monto debe ser positivo");
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

    public void transferirEntreMonederos(Monedero destino, double monto) {
        if (destino == null) throw new IllegalArgumentException("Monedero destino no puede ser nulo");
        if (monto <= 0) throw new MontoInvalidoException("Monto debe ser positivo");
        if (saldo < monto) throw new SaldoInsuficienteException("Saldo insuficiente");

        this.saldo -= monto;
        destino.depositar(monto);
    }

    @Override
    public String toString() {
        return "Monedero{" +
                "nombre='" + nombre + '\'' +
                ", saldo=" + saldo +
                ", tipoMonedero=" + tipoMonedero +
                ", ownedByCuentaVirtual=" + ownedByCuentaVirtual +
                '}';
    }
}
