package app;

import model.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Aplicacion {

    public static void main(String[] args) {

        Empresa empresa = new Empresa();

        // Registrar clientes
        Frecuente cf = new Frecuente("Ana", "123", "Calle 1", 100);
        Corporativo cc = new Corporativo("Empresa XYZ", "999", "Av. 9", "890123", 0.10);
        empresa.agregarCliente(cf);
        empresa.agregarCliente(cc);

        // Registrar productos
        Producto p1 = new Alimenticio("A1", "Pan", 3000, LocalDate.of(2025, 11, 30));
        Producto p2 = new Electrodomestico("E1", "Licuadora", 150000, 12);
        empresa.agregarProducto(p1);
        empresa.agregarProducto(p2);

        // Generar factura
        List<Producto> lista = Arrays.asList(p1, p2);
        Factura f = new Factura("F001", LocalDate.now(), cf, lista);
        empresa.agregarFactura(f);

        // Mostrar factura
        System.out.println(f);


    }
}
