package model;

import java.time.LocalDate;
import java.util.ArrayList;

public interface Auditable {

    void registrarNovedad(Novedad novedad);

    //Consulta filtrada por rango.
    ArrayList<Novedad> obtenerNovedades(LocalDate desde, LocalDate hasta);
}
