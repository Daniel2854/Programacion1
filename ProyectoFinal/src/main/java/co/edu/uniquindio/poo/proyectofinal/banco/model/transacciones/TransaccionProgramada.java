package co.edu.uniquindio.poo.proyectofinal.banco.model.transacciones;

import co.edu.uniquindio.poo.proyectofinal.banco.model.dominio.CuentaVirtual;
import co.edu.uniquindio.poo.proyectofinal.banco.model.puntos.EstrategiaTransaccionProgramada;
import co.edu.uniquindio.poo.proyectofinal.banco.model.soporte.ResultadoVerificacion;
import co.edu.uniquindio.poo.proyectofinal.banco.model.soporte.TipoTransaccion;

import java.time.LocalDate;

public class TransaccionProgramada extends Transaccion {
    private LocalDate fechaEjecucion;
    private int frecuenciaDias; // si es recurrente, es la frecuenciaDias de los días.
    private boolean esRecurrente;
    private TipoTransaccion tipoTransaccion;
    private boolean ejecutada;
    private int ejecucionesConsecutivas;

    public TransaccionProgramada(CuentaVirtual origen, CuentaVirtual destino, double monto, LocalDate fechaEjecucion,
            boolean esRecurrente, int frecuenciaDias, TipoTransaccion tipoTransaccion
    ) {
        super(origen, destino, monto);
        this.fechaEjecucion = fechaEjecucion;
        this.esRecurrente = esRecurrente;
        this.frecuenciaDias = frecuenciaDias;
        this.tipoTransaccion = tipoTransaccion;
        this.estrategia = new EstrategiaTransaccionProgramada();
    }

    public void setFechaEjecucion(LocalDate fechaEjecucion) {
        this.fechaEjecucion = fechaEjecucion;
    }
    public int getFrecuenciaDias() {
        return frecuenciaDias;
    }
    public void setFrecuenciaDias(int frecuenciaDias) {
        this.frecuenciaDias = frecuenciaDias;
    }
    public boolean isEsRecurrente() {
        return esRecurrente;
    }
    public void setEsRecurrente(boolean esRecurrente) {
        this.esRecurrente = esRecurrente;
    }
    public TipoTransaccion getTipoTransaccion() {
        return tipoTransaccion;
    }
    public void setTipoTransaccion(TipoTransaccion tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }
    public boolean isEjecutada() {
        return ejecutada;
    }
    public void setEjecutada(boolean ejecutada) {
        this.ejecutada = ejecutada;
    }
    public int getEjecucionesConsecutivas() {
        return ejecucionesConsecutivas;
    }
    public void setEjecucionesConsecutivas(int ejecucionesConsecutivas) {
        this.ejecucionesConsecutivas = ejecucionesConsecutivas;
    }
    public LocalDate getFechaEjecucion() {
        return fechaEjecucion;
    }
    public boolean isRecurrente() {
        return esRecurrente;
    }

    public LocalDate proximaFecha() {
        return esRecurrente ? fechaEjecucion.plusDays(frecuenciaDias) : null;
    }

    @Override
    public boolean ejecutar() {
        if (LocalDate.now().isBefore(fechaEjecucion)) return false;
        if (ejecutada) return false;

        ResultadoVerificacion rv = verificador.verificar(this);
        if (!rv.valido()) {
            System.out.println("Error: " + rv.mensaje());
            return false;
        }

        switch (tipoTransaccion) {
            case DEPOSITO -> cuentaDestino.depositar(monto);
            case RETIRO -> cuentaOrigen.retirar(monto);
            case TRANSFERENCIA -> {
                cuentaOrigen.retirar(monto);
                cuentaDestino.depositar(monto);
            }
        }
        ejecutada = true;
        return true;
    }

    @Override
    public String enviarNotificacion() {
        return "Transacción programada (" + tipoTransaccion + ") de " + (int) monto +
                " ejecutada en fecha " + fechaEjecucion +
                " sobre cuenta " + (tipoTransaccion == TipoTransaccion.RETIRO ? cuentaOrigen.getNumeroCuenta()
                : cuentaDestino.getNumeroCuenta());
    }

    @Override
    public String toString() {
        return "TransaccionProgramada{" +
                "fechaEjecucion=" + fechaEjecucion +
                ", frecuenciaDias=" + frecuenciaDias +
                ", esRecurrente=" + esRecurrente +
                ", tipoTransaccion=" + tipoTransaccion +
                ", ejecutada=" + ejecutada +
                ", ejecucionesConsecutivas=" + ejecucionesConsecutivas +
                '}';
    }
}
