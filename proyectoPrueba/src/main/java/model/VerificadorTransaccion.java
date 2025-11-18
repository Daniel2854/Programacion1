package model;

public class VerificadorTransaccion {
    public boolean verificar(Transaccion t) {
        if (t.getMonto() <= 0) return false;

        if (t instanceof Retiro) {
            return t.getCuentaOrigen().getSaldo() >= t.getMonto();
        }
        if (t instanceof Transferencia) {
            return t.getCuentaOrigen().getSaldo() >= t.getMonto();
        }
        // Depósito y programada se verifican por monto > 0
        return true;
    }
}
