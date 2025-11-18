package model;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GestorTransacccion implements IEstrategiaPuntuacion {
    private String criterioOrdenamiento;
    private String algoritmoOrdenamiento;
    private boolean ordenAscendente;
    private List<Transacccion> listaTransacciones;

    @Override
    public int calcularPuntuacion(Transaccion transaccion) {
        int puntos = 0;

        if (transaccion instanceof Deposito) {
            puntos = (int) (transaccion.getMonto() / 100);
        } else if (transaccion instanceof Retiro) {
            puntos = (int) (transaccion.getMonto() / 200);
        } else if (transaccion instanceof Transferencia) {
            puntos = (int) (transaccion.getMonto() / 100);
        } else if (transaccion instanceof TransaccionProgramada) {
            puntos = 5;
        }
        return puntos;
    }

    public List<TransaccionProgramada> ordenarPorFecha(List<TransaccionProgramada> lista) {
        Collections.sort(lista, Comparator.comparing(TransaccionProgramada::getFechaEjecucion));
        return lista;
    }
}
