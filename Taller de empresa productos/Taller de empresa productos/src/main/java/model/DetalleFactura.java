package model;

import java.util.ArrayList;

public class DetalleFactura {
    private ArrayList<Producto> listaProductos = new ArrayList<>();


    public ArrayList<Producto> getProductos() {
        return listaProductos;
    }
    public void setProductos(ArrayList<Producto> nuevaListaProductos) {
        this.listaProductos = nuevaListaProductos;
    }

    public void agregarProducto(Producto producto) {
        listaProductos.add(producto);
    }


    public double calcularSubtotal() {
        double subtotal = 0;
        for (Producto aux : listaProductos) {
            subtotal += aux.getPrecioUnitario();
        }
        return subtotal;
    }
}
