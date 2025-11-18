package model;

import java.util.List;

public interface Sujeto {
    void suscribir(Observador obs);
    void desuscribir(Observador obs);
    void notificar(String mensaje);
    List<Observador> getObservadores();
}
