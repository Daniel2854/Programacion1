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

    // CRUD para Cliente
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

    public boolean actualizarCliente(String identificacion, Cliente nuevoCliente) {
        for (int i = 0; i < listaClientes.size(); i++) {
            if (listaClientes.get(i).getIdentificacion().equals(identificacion)) {
                listaClientes.set(i, nuevoCliente);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarCliente(String identificacion) {
        return listaClientes.removeIf(c -> c.getIdentificacion().equals(identificacion));
    }

    // CRUD para Producto
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

    public boolean actualizarProducto(String codigo, Producto nuevoProducto) {
        for (int i = 0; i < listaProductos.size(); i++) {
            if (listaProductos.get(i).getCodigo().equals(codigo)) {
                listaProductos.set(i, nuevoProducto);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarProducto(String codigo) {
        return listaProductos.removeIf(p -> p.getCodigo().equals(codigo));
    }

    // CRUD para Factura
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

    public boolean actualizarFactura(String codigo, Factura nuevaFactura) {
        for (int i = 0; i < listaFacturas.size(); i++) {
            if (listaFacturas.get(i).getCodigo().equals(codigo)) {
                listaFacturas.set(i, nuevaFactura);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarFactura(String codigo) {
        return listaFacturas.removeIf(f -> f.getCodigo().equals(codigo));
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "nombre='" + nombre + '\'' +
                ", nit='" + nit + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", listaProductos=" + listaProductos +
                ", listaClientes=" + listaClientes +
                ", listaFacturas=" + listaFacturas +
                '}';
    }
}
