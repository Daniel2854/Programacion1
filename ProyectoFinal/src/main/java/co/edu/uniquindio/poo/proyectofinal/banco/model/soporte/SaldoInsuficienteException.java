package co.edu.uniquindio.poo.proyectofinal.banco.model.soporte;

public class SaldoInsuficienteException extends RuntimeException{
    public SaldoInsuficienteException(String message) {
        super(message);
    }
}