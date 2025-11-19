package co.edu.uniquindio.poo.proyectofinal.banco.model.notificaciones;

public class Notificacion implements Observador {
    private String ultimoMensaje;

    @Override
    public void actualizar(String mensaje) {
        this.ultimoMensaje = mensaje;
    }

    public String getUltimoMensaje() {
        return ultimoMensaje;
    }
    public void setUltimoMensaje(String ultimoMensaje) {
        this.ultimoMensaje = ultimoMensaje;
    }
}