package co.edu.uniquindio.poo.proyectofinal.banco.model.dominio;

import co.edu.uniquindio.poo.proyectofinal.banco.model.transacciones.Transaccion;

import java.util.ArrayList;
import java.util.List;

public class HistorialTransacciones {
    private final List<Transaccion> listaTransacciones = new ArrayList<>();

    public List<Transaccion> getListaTransacciones() {
        return listaTransacciones;
    }

    public void registrar(Transaccion t) {
        listaTransacciones.add(t);
        if (t.getCuentaOrigen() != null) {
            t.getCuentaOrigen().registrarTransaccion(t);
        }
        if (t.getCuentaDestino() != null) {
            t.getCuentaDestino().registrarTransaccion(t);
        }
    }

    @Override
    public String toString() {
        return "HistorialTransacciones{" +
                "listaTransacciones=" + listaTransacciones +
                '}';
    }
}
