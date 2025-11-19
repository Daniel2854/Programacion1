package co.edu.uniquindio.poo.proyectofinal.banco.model.notificaciones;

public class CanalSMS implements CanalNotificacion {
    @Override public void enviar(String destino, String mensaje) {
        System.out.println("[SMS] a " + destino + ": " + mensaje);
    }
}
