package model;

public class RegistroPuntos {
    private final Cliente cliente;

    public RegistroPuntos(Cliente cliente) {
        this.cliente = cliente;
    }

    public void registrar(int puntos) {
        cliente.setPuntos(cliente.getPuntos() + Math.max(0, puntos));
        cliente.actualizarRango();
    }
}
