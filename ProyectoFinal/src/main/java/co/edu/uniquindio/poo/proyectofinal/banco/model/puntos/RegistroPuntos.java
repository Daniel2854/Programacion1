package co.edu.uniquindio.poo.proyectofinal.banco.model.puntos;

import co.edu.uniquindio.poo.proyectofinal.banco.model.dominio.Cliente;

public class RegistroPuntos {
    private Cliente cliente;

    public RegistroPuntos(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void registrar(int puntos) {
        cliente.setPuntos(cliente.getPuntos() + Math.max(0, puntos));
        cliente.actualizarRango();
    }

    @Override
    public String toString() {
        return "RegistroPuntos{" +
                "cliente=" + cliente +
                '}';
    }
}
