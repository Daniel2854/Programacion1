package model;

public class Beneficio {
    private final String nombre;
    private final int costoPuntos;

    public Beneficio(String nombre, int costoPuntos) {
        this.nombre = nombre;
        this.costoPuntos = costoPuntos;
    }

    public String getNombre() { return nombre; }
    public int getCostoPuntos() { return costoPuntos; }

    public boolean canjear(Cliente cliente) {
        if (cliente.getPuntos() >= costoPuntos) {
            cliente.setPuntos(cliente.getPuntos() - costoPuntos);
            cliente.actualizarRango();
            return true;
        }
        return false;
    }
}
