package model;

import java.util.ArrayList;

public class Empresa {
    private String nombre;
    private String nit;
    private String ubicacion;
    private String telefono;
    private ArrayList<Producto> listaProductos;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Factura> listaFacturas;

    public Empresa(String nombre, String nit, String ubicacion, String telefono) {
        this.nombre = nombre;
        this.nit = nit;
        this.ubicacion = ubicacion;
        this.telefono = telefono;
        this.listaProductos = new ArrayList<>();
        this.listaClientes = new ArrayList<>();
        this.listaFacturas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNit() {
        return nit;
    }
    public void setNit(String nit) {
        this.nit = nit;
    }
    public String getUbicacion() {
        return ubicacion;
    }
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }
    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }
    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }
    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }
    public ArrayList<Factura> getListaFacturas() {
        return listaFacturas;
    }
    public void setListaFacturas(ArrayList<Factura> listaFacturas) {
        this.listaFacturas = listaFacturas;
    }

    public void agregarCliente(Cliente cliente) {
        listaClientes.add(cliente);
    }

    public Cliente buscarCliente(String identificacion) {
        for (Cliente aux : listaClientes) {
            if (aux.getIdentificacion().equals(identificacion)) {
                return aux;
            }
        }
        return null;
    }

    public void agregarProducto(Producto producto) {
        listaProductos.add(producto);
    }

    public Producto buscarProducto(String codigo) {
        for (Producto aux : listaProductos) {
            if (aux.getCodigo().equals(codigo)) {
                return aux;
            }
        }
        return null;
    }

    public void agregarFactura(Factura factura) {
        listaFacturas.add(factura);
    }

    public Factura buscarFactura(String codigo) {
        for (Factura f : listaFacturas) {
            if (f.getCodigo().equals(codigo)) {
                return f;
            }
        }
        return null;
    }
}
