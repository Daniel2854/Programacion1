package co.edu.uniquindio.poo.proyectofinal.banco.model.puntos;

import co.edu.uniquindio.poo.proyectofinal.banco.model.dominio.Cliente;
import co.edu.uniquindio.poo.proyectofinal.banco.model.transacciones.Transaccion;

public interface IEstrategiaPuntuacion {
    int calcularPuntos(Transaccion transaccion, Cliente cliente);
}
