package model;

import java.time.LocalDateTime;

public abstract class Transaccion implements INotificable {
    protected final double monto;
    protected final LocalDateTime fecha;
    protected final CuentaVirtual cuentaOrigen;
    protected final CuentaVirtual cuentaDestino;
    protected final VerificadorTransaccion verificador;

    protected Transaccion(CuentaVirtual origen, CuentaVirtual destino, double monto) {
        this.cuentaOrigen = origen;
        this.cuentaDestino = destino;
        this.monto = monto;
        this.fecha = LocalDateTime.now();
        this.verificador = new VerificadorTransaccion();
    }

    public double getMonto() {
        return monto;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public CuentaVirtual getCuentaOrigen() {
        return cuentaOrigen;
    }

    public CuentaVirtual getCuentaDestino() {
        return cuentaDestino;
    }

    public abstract boolean ejecutar();

    @Override
    public abstract String enviarNotificacion();

    public TipoTransaccion getTipo() {
        if (this instanceof Deposito) return TipoTransaccion.DEPOSITO;
        if (this instanceof Retiro) return TipoTransaccion.RETIRO;
        if (this instanceof Transferencia) return TipoTransaccion.TRANSFERENCIA;
        return null;
    }
}