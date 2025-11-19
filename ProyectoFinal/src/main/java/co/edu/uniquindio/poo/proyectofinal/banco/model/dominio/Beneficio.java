package co.edu.uniquindio.poo.proyectofinal.banco.model.dominio;

public class Beneficio {
    private String nombre;
    private int costoPuntos;
    private String descripcion;

    public Beneficio(String nombre, int costoPuntos, String descripcion) {
        this.nombre = nombre;
        this.costoPuntos = costoPuntos;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }
    public int getCostoPuntos() {
        return costoPuntos;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setCostoPuntos(int costoPuntos) {
        this.costoPuntos = costoPuntos;
    }

    // Método para canjear beneficio
    public boolean canjear(Cliente cliente) {
        if (cliente.getPuntos() >= costoPuntos) {
            cliente.setPuntos(cliente.getPuntos() - costoPuntos);
            cliente.actualizarRango();
            System.out.println("Beneficio '" + nombre + "' canjeado por " + cliente.getNombre());
            return true;
        }
        System.out.println("No tienes puntos suficientes para '" + nombre + "'");
        return false;
    }

    @Override
    public String toString() {
        return "Beneficio{" +
                "nombre='" + nombre + '\'' +
                ", costoPuntos=" + costoPuntos +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
