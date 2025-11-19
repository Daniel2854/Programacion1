package co.edu.uniquindio.poo.proyectofinal.banco.model.servicios;

import co.edu.uniquindio.poo.proyectofinal.banco.model.dominio.Cliente;
import co.edu.uniquindio.poo.proyectofinal.banco.model.soporte.TipoTransaccion;
import co.edu.uniquindio.poo.proyectofinal.banco.model.transacciones.Transaccion;

import java.time.LocalDate;

public class ReporteGasto {
    private final Cliente cliente;
    private final LocalDate fechaInicio;
    private final LocalDate fechaFin;

    public ReporteGasto(Cliente cliente, LocalDate inicio, LocalDate fin) {
        this.cliente = cliente;
        this.fechaInicio = inicio;
        this.fechaFin = fin;
    }

    public double calcularTotalPorTipo(TipoTransaccion tipo) {
        return cliente.getHistorialT().getListaTransacciones().stream()
                .filter(t -> t.getFecha().toLocalDate().isAfter(fechaInicio.minusDays(1))
                        && t.getFecha().toLocalDate().isBefore(fechaFin.plusDays(1)))
                .filter(t -> t.getTipo() == tipo)
                .mapToDouble(Transaccion::getMonto)
                .sum();
    }

    public double calcularTotalGeneral() {
        return cliente.getHistorialT().getListaTransacciones().stream()
                .filter(t -> t.getFecha().toLocalDate().isAfter(fechaInicio.minusDays(1))
                        && t.getFecha().toLocalDate().isBefore(fechaFin.plusDays(1)))
                .mapToDouble(Transaccion::getMonto)
                .sum();
    }

    public void imprimirReporte() {
        System.out.println("=== Reporte de gastos de " + cliente.getNombre() + " ===");
        System.out.println("Periodo: " + fechaInicio + " a " + fechaFin);
        System.out.println("Total depósitos: " + calcularTotalPorTipo(TipoTransaccion.DEPOSITO));
        System.out.println("Total retiros: " + calcularTotalPorTipo(TipoTransaccion.RETIRO));
        System.out.println("Total transferencias: " + calcularTotalPorTipo(TipoTransaccion.TRANSFERENCIA));
        System.out.println("Total general: " + calcularTotalGeneral());
    }

}
