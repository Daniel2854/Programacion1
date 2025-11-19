package co.edu.uniquindio.poo.proyectofinal.banco.model.transacciones;

import co.edu.uniquindio.poo.proyectofinal.banco.model.dominio.CuentaVirtual;
import co.edu.uniquindio.poo.proyectofinal.banco.model.puntos.EstrategiaRetiro;
import co.edu.uniquindio.poo.proyectofinal.banco.model.soporte.ResultadoVerificacion;

public class Retiro extends Transaccion {

    public Retiro(CuentaVirtual origen, double monto) {
        super(origen, null, monto);
        this.estrategia = new EstrategiaRetiro();
    }

    @Override
    public boolean ejecutar() {
        ResultadoVerificacion rv = verificador.verificar(this);
        if (!rv.valido()) {
            System.out.println("Error: " + rv.mensaje());
            return false;
        }
        cuentaOrigen.retirar(monto);
        return true;
    }

    @Override
    public String enviarNotificacion() {
        return "Retiro de " + (int) monto + " en cuenta " + cuentaOrigen.getNumeroCuenta();
    }
}
