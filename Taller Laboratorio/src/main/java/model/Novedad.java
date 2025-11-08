package model;

import java.time.LocalDateTime;

public record Novedad(String descripcion, String tipo, LocalDateTime fecha, Empresa empresa) {
}
