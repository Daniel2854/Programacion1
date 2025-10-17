package app;

import model.*;

import java.time.LocalDate;

public class Aplicacion {

    public static void main(String[] args) {

        Empresa empresa1 = new Empresa("Comercializadora UQ", "0923", "Armenia", "3137471106");

        Frecuente cliente1 = new Frecuente("Daniel", "1112389", "calle 21N", empresa1, 763);
        Corporativo cliente2 = new Corporativo("Juan", "0112349", "Avn Sur", "1122", empresa1, 0.8);

        Alimenticio producto1 = new Alimenticio("0001", "Pan tajado", 3500.0, empresa1, LocalDate.of(2025, 12, 15));
        Electrodomestico producto2 = new Electrodomestico("0002", "Nevera", 120000.0, empresa1, 12);
        Alimenticio producto3 = new Alimenticio("0003", "Carne de res", 8250.0, empresa1, LocalDate.of(2026, 1, 17));

        empresa1.agregarProducto(producto1);
        empresa1.agregarProducto(producto2);
        empresa1.agregarProducto(producto3);

        empresa1.agregarCliente(cliente1);
        empresa1.agregarCliente(cliente2);

        DetalleFactura detalleFacturaElectrodomestico = new DetalleFactura();
        detalleFacturaElectrodomestico.agregarProducto(producto2);

        DetalleFactura detalleFacturaAlimenticio = new DetalleFactura();
        detalleFacturaAlimenticio.agregarProducto(producto1);
        detalleFacturaAlimenticio.agregarProducto(producto3);

        Factura factura1 = new Factura("01", LocalDate.of(2025, 10, 14), cliente1, empresa1);

        factura1.agregarDetalle(detalleFacturaElectrodomestico);
        factura1.agregarDetalle(detalleFacturaAlimenticio);

        empresa1.agregarFactura(factura1);

        System.out.println("📄 Factura generada:");
        System.out.println("Número: " + factura1.getCodigo());
        System.out.println("Cliente: " + cliente1.getNombre());
        System.out.println("Total a pagar: $" + factura1.calcularTotalFactura());
    }
}
