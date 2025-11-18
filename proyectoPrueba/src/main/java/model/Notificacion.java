package model;

import java.util.Observable;
import java.util.Observer;

public class Notificacion implements Observador {
    private String ultimoMensaje;

    @Override
    public void actualizar(String mensaje) {
        this.ultimoMensaje = mensaje;
    }

    public String getUltimoMensaje() { return ultimoMensaje; }
}
