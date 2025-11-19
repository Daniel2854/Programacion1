package co.edu.uniquindio.poo.proyectofinal.banco.model.servicios;

import co.edu.uniquindio.poo.proyectofinal.banco.model.dominio.Cliente;
import co.edu.uniquindio.poo.proyectofinal.banco.model.transacciones.Transaccion;
import co.edu.uniquindio.poo.proyectofinal.banco.model.transacciones.TransaccionProgramada;
import co.edu.uniquindio.poo.proyectofinal.banco.model.notificaciones.CanalEmail;
import co.edu.uniquindio.poo.proyectofinal.banco.model.notificaciones.CanalSMS;
import co.edu.uniquindio.poo.proyectofinal.banco.model.puntos.RegistroPuntos;
import co.edu.uniquindio.poo.proyectofinal.banco.model.soporte.MontoInvalidoException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GestorTransaccion{
    private List<Transaccion> listaTransacciones = new ArrayList<>();
    private Notificador notificador = new Notificador();

    public GestorTransaccion() {
        notificador.agregarCanal(new CanalEmail());
        notificador.agregarCanal(new CanalSMS());
    }

    public boolean ejecutarTransaccion(Transaccion transaccion, Cliente clienteInvolucrado) {
        // Verificación antes
        if (transaccion.getMonto() <= 0) {
            throw new MontoInvalidoException("Monto inválido");
        }

        boolean ok = transaccion.ejecutar();
        if (!ok) {
            return false;
        }

        listaTransacciones.add(transaccion);

        // Notificar según cuentas implicadas
        String mensage = transaccion.enviarNotificacion();
        if (transaccion.getCuentaOrigen() != null && transaccion.getCuentaOrigen().getCliente() != null) {
            notificador.notificarCliente(transaccion.getCuentaOrigen().getCliente(), mensage);
        }
        if (transaccion.getCuentaDestino() != null && transaccion.getCuentaDestino().getCliente() != null) {
            notificador.notificarCliente(transaccion.getCuentaDestino().getCliente(), mensage);
        }

        // Registrar puntos al cliente indicado (control de negocio)
        if (clienteInvolucrado != null) {
            int puntos = transaccion.calcularPuntos(clienteInvolucrado);
            new RegistroPuntos(clienteInvolucrado).registrar(puntos);
        }

        return true;
    }

    public List<Transaccion> getListaTransacciones() {
        return listaTransacciones;
    }

    public List<TransaccionProgramada> ordenarPorFecha(List<TransaccionProgramada> lista) {
        lista.sort(Comparator.comparing(TransaccionProgramada::getFechaEjecucion));
        return lista;
    }
}
