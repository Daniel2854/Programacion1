package co.edu.uniquindio.poo.proyectofinal.banco.model.servicios;

import co.edu.uniquindio.poo.proyectofinal.banco.model.dominio.Cliente;
import co.edu.uniquindio.poo.proyectofinal.banco.model.transacciones.TransaccionProgramada;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PlanificadorTransacciones {
    private final List<TransaccionProgramada> pendientes = new ArrayList<>();
    private final GestorTransaccion gestor;

    public PlanificadorTransacciones(GestorTransaccion gestor) {
        this.gestor = gestor;
    }
    public void agregar(TransaccionProgramada tp) {
        pendientes.add(tp);
    }

    public void ejecutarPendientes(Cliente cliente) {
        List<TransaccionProgramada> ejecutables = new ArrayList<>();
        for (TransaccionProgramada tp : pendientes) {
            if (!LocalDate.now().isBefore(tp.getFechaEjecucion())) {
                ejecutables.add(tp);
            }
        }
        for (TransaccionProgramada tp : ejecutables) {
            boolean ok = gestor.ejecutarTransaccion(tp, cliente);
            pendientes.remove(tp);
            if (ok && tp.isRecurrente()) {
                TransaccionProgramada siguiente = new TransaccionProgramada(
                        tp.getCuentaOrigen(), tp.getCuentaDestino(), tp.getMonto(),
                        tp.proximaFecha(), true, tp.getFrecuenciaDias(), tp.getTipoTransaccion()
                );
                agregar(siguiente);
            }
        }
    }

    public List<TransaccionProgramada> listarPendientes() { return new ArrayList<>(pendientes); }

}
