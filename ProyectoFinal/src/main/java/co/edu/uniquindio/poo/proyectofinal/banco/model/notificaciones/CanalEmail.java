package co.edu.uniquindio.poo.proyectofinal.banco.model.notificaciones;

public class CanalEmail implements CanalNotificacion {
    @Override public void enviar(String destino, String mensaje) {
        System.out.println("[EMAIL] a " + destino + ": " + mensaje);
    }
}
