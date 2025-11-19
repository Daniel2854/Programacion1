package co.edu.uniquindio.poo.proyectofinal.banco.model.servicios;

import co.edu.uniquindio.poo.proyectofinal.banco.model.dominio.Cliente;
import co.edu.uniquindio.poo.proyectofinal.banco.model.notificaciones.CanalNotificacion;

import java.util.ArrayList;
import java.util.List;

public class Notificador {

    private List<CanalNotificacion> listaCanales = new ArrayList<>();

    public void agregarCanal(CanalNotificacion canal) {
        listaCanales.add(canal);
    }

    public void notificarCliente(Cliente cliente, String mensaje) {
        for (CanalNotificacion c : listaCanales) {
            c.enviar(cliente.getId(), mensaje);
        }
    }
}
