package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Factura {

    private String codigo;
    private LocalDate fecha;
    private Cliente cliente;
    private ArrayList<DetalleFactura> listaDetallesFactura;
    private Empresa ownedByEmpresa;

    public Factura(String codigo, LocalDate fecha, Cliente cliente, Empresa ownedByEmpresa) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.cliente = cliente;
        this.listaDetallesFactura = new ArrayList<>();
        this.ownedByEmpresa = ownedByEmpresa;
    }

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public ArrayList<DetalleFactura> getListaDetallesFactura() {
        return listaDetallesFactura;
    }
    public void setListaDetallesFactura(ArrayList<DetalleFactura> listaDetallesFactura) {
        this.listaDetallesFactura = listaDetallesFactura;
    }
    public Empresa getOwnedByEmpresa() {
        return ownedByEmpresa;
    }
    public void setOwnedByEmpresa(Empresa ownedByEmpresa) {
        this.ownedByEmpresa = ownedByEmpresa;
    }

    public void agregarDetalle(DetalleFactura detalleFactura) {
        listaDetallesFactura.add(detalleFactura);
    }

    public double calcularTotalFactura() {
        double totalSinDescuento = 0;
        for (DetalleFactura aux : listaDetallesFactura) {
            totalSinDescuento += aux.calcularSubtotal();
        }
        double descuento = cliente.calcularDescuento(totalSinDescuento);
        return totalSinDescuento - descuento;
    }
}
