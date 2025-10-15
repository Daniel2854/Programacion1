package model;

import java.util.ArrayList;
import java.util.List;

public class DetalleFactura {
    private List<Producto> productos;

    public DetalleFactura(List<Producto> productos) {
        this.productos = productos;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public double calcularSubtotal() {
        double subtotal = 0;
        for (Producto p : productos) {
            subtotal += p.getPrecioUnitario();
        }
        return subtotal;
    }

    @Override
    public String toString() {
        return "DetalleFactura{" +
                "productos=" + productos +
                '}';
    }
}
