package co.edu.uniquindio.poo.proyectofinal.banco.model.notificaciones;

public class CanalWhatsApp implements CanalNotificacion {
    @Override
    public void enviar(String destino, String mensaje) {
        System.out.println("[MENSAJE WHATSAPP] a " + destino + ": " + mensaje);
    }
}
