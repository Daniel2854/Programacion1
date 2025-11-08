package model;

import java.time.LocalDate;
import java.util.ArrayList;

public interface Agendable {

    void programar(LocalDate fecha, String descripcion);

    ArrayList<AgendaItem> obtenerAgenda (LocalDate desde, LocalDate hasta);
}
