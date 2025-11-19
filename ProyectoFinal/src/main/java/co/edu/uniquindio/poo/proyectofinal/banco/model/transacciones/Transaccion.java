package co.edu.uniquindio.poo.proyectofinal.banco.model.transacciones;

import co.edu.uniquindio.poo.proyectofinal.banco.model.dominio.Cliente;
import co.edu.uniquindio.poo.proyectofinal.banco.model.dominio.CuentaVirtual;
import co.edu.uniquindio.poo.proyectofinal.banco.model.puntos.IEstrategiaPuntuacion;
import co.edu.uniquindio.poo.proyectofinal.banco.model.servicios.VerificadorTransaccion;
import co.edu.uniquindio.poo.proyectofinal.banco.model.soporte.TipoTransaccion;

import java.time.LocalDateTime;

public abstract class Transaccion {
    protected final double monto;
    protected final LocalDateTime fecha;
    protected final CuentaVirtual cuentaOrigen;
    protected final CuentaVirtual cuentaDestino;
    protected final VerificadorTransaccion verificador;
    protected IEstrategiaPuntuacion estrategia;
    protected TipoTransaccion tipoTransaccion;

    protected Transaccion(CuentaVirtual origen, CuentaVirtual destino, double monto) {
        this.cuentaOrigen = origen;
        this.cuentaDestino = destino;
        this.monto = monto;
        this.fecha = LocalDateTime.now();
        this.verificador = new VerificadorTransaccion();
    }

    public VerificadorTransaccion getVerificador() {
        return verificador;
    }
    public IEstrategiaPuntuacion getEstrategia() {
        return estrategia;
    }
    public void setEstrategia(IEstrategiaPuntuacion estrategia) {
        this.estrategia = estrategia;
    }
    public TipoTransaccion getTipoTransaccion() {
        return tipoTransaccion;
    }
    public void setTipoTransaccion(TipoTransaccion tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
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

    public abstract String enviarNotificacion();

    public TipoTransaccion getTipo() {
        if (this instanceof Deposito) {
            return TipoTransaccion.DEPOSITO;
        }
        if (this instanceof Retiro) {
            return TipoTransaccion.RETIRO;
        }
        if (this instanceof Transferencia) {
            return TipoTransaccion.TRANSFERENCIA;
        }
        return null;
    }

    public int calcularPuntos(Cliente cliente) {
        return estrategia == null ? 0 : estrategia.calcularPuntos(this, cliente);
    }

    @Override
    public String toString() {
        return "Transaccion{" +
                "monto=" + monto +
                ", fecha=" + fecha +
                ", cuentaOrigen=" + cuentaOrigen +
                ", cuentaDestino=" + cuentaDestino +
                ", verificador=" + verificador +
                ", estrategia=" + estrategia +
                ", tipoTransaccion=" + tipoTransaccion +
                '}';
    }
}
