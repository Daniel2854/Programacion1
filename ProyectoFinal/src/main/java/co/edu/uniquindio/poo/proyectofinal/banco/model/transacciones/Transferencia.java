package co.edu.uniquindio.poo.proyectofinal.banco.model.transacciones;

import co.edu.uniquindio.poo.proyectofinal.banco.model.dominio.CuentaVirtual;
import co.edu.uniquindio.poo.proyectofinal.banco.model.puntos.EstrategiaTransferencia;
import co.edu.uniquindio.poo.proyectofinal.banco.model.soporte.ResultadoVerificacion;

public class Transferencia extends Transaccion {

    public Transferencia(CuentaVirtual origen, CuentaVirtual destino, double monto) {
        super(origen, destino, monto);
        this.estrategia = new EstrategiaTransferencia();
    }

    @Override
    public boolean ejecutar() {
        ResultadoVerificacion rv = verificador.verificar(this);
        if (!rv.valido()) {
            System.out.println("Error: " + rv.mensaje());
            return false;
        }
        cuentaOrigen.retirar(monto);
        cuentaDestino.depositar(monto);
        return true;
    }

    @Override
    public String enviarNotificacion() {
        return "Transferencia de " + (int) monto + " de " +
                cuentaOrigen.getNumeroCuenta() + " a " + cuentaDestino.getNumeroCuenta();
    }
}

