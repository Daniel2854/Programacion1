package co.edu.uniquindio.poo.proyectofinal.banco.model.transacciones;

import co.edu.uniquindio.poo.proyectofinal.banco.model.dominio.CuentaVirtual;
import co.edu.uniquindio.poo.proyectofinal.banco.model.puntos.EstrategiaDeposito;
import co.edu.uniquindio.poo.proyectofinal.banco.model.soporte.ResultadoVerificacion;

public class Deposito extends Transaccion {

    public Deposito(CuentaVirtual destino, double monto) {
        super(null, destino, monto);
        this.estrategia = new EstrategiaDeposito();
    }

    @Override
    public boolean ejecutar() {
        ResultadoVerificacion rv = verificador.verificar(this);
        if (!rv.valido()) {
            System.out.println("Error: " + rv.mensaje());
            return false;
        }
        cuentaDestino.depositar(monto);
        return true;
    }

    @Override
    public String enviarNotificacion() {
        return "Depósito de " + (int) monto + " en cuenta " + cuentaDestino.getNumeroCuenta();
    }
}