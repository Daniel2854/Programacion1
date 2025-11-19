package co.edu.uniquindio.poo.proyectofinal.banco.model.notificaciones;

public interface CanalNotificacion {
    void enviar(String destino, String mensaje);
}
