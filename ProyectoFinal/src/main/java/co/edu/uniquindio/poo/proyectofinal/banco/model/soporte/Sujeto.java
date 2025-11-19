package co.edu.uniquindio.poo.proyectofinal.banco.model.soporte;

import co.edu.uniquindio.poo.proyectofinal.banco.model.notificaciones.Observador;

import java.util.List;

public interface Sujeto {
    void suscribir(Observador obs);
    void desuscribir(Observador obs);
    void notificar(String mensaje);
    List<Observador> getObservadores();
}
