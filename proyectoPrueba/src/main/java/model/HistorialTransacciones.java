package model;

import java.util.ArrayList;

public class HistorialTransacciones {
    private final List<Transaccion> transacciones = new ArrayList<>();

    public void registrar(Transaccion t) {
        transacciones.add(t);
        if (t.getCuentaOrigen() != null) t.getCuentaOrigen().registrarTransaccion(t);
        if (t.getCuentaDestino() != null) t.getCuentaDestino().registrarTransaccion(t);
    }

    public List<Transaccion> getTransacciones() { return transacciones; }
}
