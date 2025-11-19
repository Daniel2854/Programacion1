package co.edu.uniquindio.poo.proyectofinal.banco.model.puntos;

import co.edu.uniquindio.poo.proyectofinal.banco.model.dominio.Cliente;
import co.edu.uniquindio.poo.proyectofinal.banco.model.transacciones.Transaccion;
import co.edu.uniquindio.poo.proyectofinal.banco.model.transacciones.TransaccionProgramada;

public class EstrategiaTransaccionProgramada implements IEstrategiaPuntuacion {
    @Override
    public int calcularPuntos(Transaccion transaccion, Cliente cliente) {
        if (!(transaccion instanceof TransaccionProgramada transaccionProgramada)) {
            return 0;
        }

        IEstrategiaPuntuacion estrategiaBase;
        switch (transaccionProgramada.getTipoTransaccion()) {
            case DEPOSITO -> estrategiaBase = new EstrategiaDeposito();
            case RETIRO -> estrategiaBase = new EstrategiaRetiro();
            case TRANSFERENCIA -> estrategiaBase = new EstrategiaTransferencia();
            default -> throw new UnsupportedOperationException("Tipo no soportado");
        }

        // Delegar cálculo a la estrategia base
        int puntos = estrategiaBase.calcularPuntos(transaccionProgramada, cliente);

        return puntos;
    }
}
