package co.edu.uniquindio.poo.proyectofinal.banco.model.dominio;

import co.edu.uniquindio.poo.proyectofinal.banco.model.servicios.GestorTransaccion;
import co.edu.uniquindio.poo.proyectofinal.banco.model.servicios.PlanificadorTransacciones;
import co.edu.uniquindio.poo.proyectofinal.banco.model.servicios.ReporteGasto;
import co.edu.uniquindio.poo.proyectofinal.banco.model.soporte.TipoTransaccion;
import co.edu.uniquindio.poo.proyectofinal.banco.model.transacciones.*;
import model.transacciones.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nombre;
    private String contacto;
    private String email;
    private String nit;
    private String ubicacionSedeFisica;
    private List<Cliente> listaClientes;
    private List<CuentaVirtual> listaCuentas;
    private List<Beneficio> listaBeneficios;
    private GestorTransaccion gestor;
    private PlanificadorTransacciones planificador;

    public Banco(String nombre, String contacto, String email, String nit,String ubicacionSedeFisica) {
        this.nombre = nombre;
        this.contacto = contacto;
        this.email = email;
        this.nit = nit;
        this.ubicacionSedeFisica = ubicacionSedeFisica;
        this.listaClientes = new ArrayList<>();
        this.listaCuentas = new ArrayList<>();
        this.listaBeneficios = new ArrayList<>();
        this.gestor = new GestorTransaccion();
        this.planificador = new PlanificadorTransacciones(gestor);
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getContacto() {
        return contacto;
    }
    public void setContacto(String contacto) {
        this.contacto = contacto;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getNit() {
        return nit;
    }
    public void setNit(String nit) {
        this.nit = nit;
    }
    public String getUbicacionSedeFisica() {
        return ubicacionSedeFisica;
    }
    public void setUbicacionSedeFisica(String ubicacionSedeFisica) {
        this.ubicacionSedeFisica = ubicacionSedeFisica;
    }
    public List<Cliente> getListaClientes() {
        return listaClientes;
    }
    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }
    public List<CuentaVirtual> getListaCuentas() {
        return listaCuentas;
    }
    public void setListaCuentas(List<CuentaVirtual> listaCuentas) {
        this.listaCuentas = listaCuentas;
    }
    public List<Beneficio> getListaBeneficios() {
        return listaBeneficios;
    }
    public void setListaBeneficios(List<Beneficio> listaBeneficios) {
        this.listaBeneficios = listaBeneficios;
    }
    public GestorTransaccion getGestor() {
        return gestor;
    }
    public void setGestor(GestorTransaccion gestor) {
        this.gestor = gestor;
    }
    public PlanificadorTransacciones getPlanificador() {
        return planificador;
    }
    public void setPlanificador(PlanificadorTransacciones planificador) {
        this.planificador = planificador;
    }


    public void agregarCliente(Cliente cliente) {
        listaClientes.add(cliente);
    }
    public void agregarCuenta(CuentaVirtual cuenta) {
        listaCuentas.add(cuenta);
    }
    public void agregarBeneficio(Beneficio beneficio) {
        listaBeneficios.add(beneficio);
    }

    public Cliente buscarClientePorId(String id) {
        return listaClientes.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public boolean eliminarCliente(String id) {
        Cliente cliente = buscarClientePorId(id);
        if (cliente != null) {
            listaClientes.remove(cliente);
            return true;
        }
        return false;
    }

    public CuentaVirtual buscarCuenta(Cliente cliente, String numeroCuenta) {
        return cliente.getListaCuentas().stream()
                .filter(c -> c.getNumeroCuenta().equals(numeroCuenta))
                .findFirst()
                .orElse(null);
    }

    public boolean eliminarCuenta(Cliente cliente, String numeroCuenta) {
        CuentaVirtual cuenta = buscarCuenta(cliente, numeroCuenta);
        if (cuenta != null) {
            cliente.getListaCuentas().remove(cuenta);
            return true;
        }
        return false;
    }

    /**
     *  public boolean actualizarCliente(String id, String nuevoNombre) {
     *      Cliente cliente = buscarClientePorId(id);
     *      if (cliente != null) {
     *          Cliente actualizado = new Cliente(nuevoNombre, cliente.getId());
     *          actualizado.setPuntos(cliente.getPuntos());
     *          actualizado.actualizarRango();
     *          clientes.remove(cliente);
     *          clientes.add(actualizado);
     *          return true;
     *       }
     *      return false;
     *  }
     *
     */

    // Operaciones básicas
    public void realizarDeposito(Cliente cliente, CuentaVirtual cuenta, double monto) {
        Transaccion deposito = new Deposito(cuenta, monto);
        gestor.ejecutarTransaccion(deposito, cliente);
    }

    public void realizarRetiro(Cliente cliente, CuentaVirtual cuenta, double monto) {
        Transaccion retiro = new Retiro(cuenta, monto);
        gestor.ejecutarTransaccion(retiro, cliente);
    }

    public void realizarTransferencia(Cliente cliente, CuentaVirtual origen, CuentaVirtual destino, double monto) {
        Transaccion transferencia = new Transferencia(origen, destino, monto);
        gestor.ejecutarTransaccion(transferencia, cliente);
    }

    // Programar transacciones
    public void programarDeposito(Cliente cliente, CuentaVirtual destino, double monto, int dias) {
        TransaccionProgramada tp = new TransaccionProgramada(
                null, destino, monto,
                LocalDate.now().plusDays(dias),
                false, 0, TipoTransaccion.DEPOSITO
        );
        planificador.agregar(tp);
    }

    public void ejecutarTransaccionesProgramadas(Cliente cliente) {
        planificador.ejecutarPendientes(cliente);
    }

    // Reportes
    public void generarReporteGasto(Cliente cliente, LocalDate inicio, LocalDate fin) {
        ReporteGasto reporte = new ReporteGasto(cliente, inicio, fin);
        reporte.imprimirReporte();
    }

    public boolean canjearBeneficio(Cliente cliente, String nombreBeneficio) {
        return listaBeneficios.stream()
                .filter(b -> b.getNombre().equalsIgnoreCase(nombreBeneficio))
                .findFirst()
                .map(b -> b.canjear(cliente))
                .orElse(false);
    }

    @Override
    public String toString() {
        return "Banco{" +
                "nombre='" + nombre + '\'' +
                ", contacto='" + contacto + '\'' +
                ", email='" + email + '\'' +
                ", nit='" + nit + '\'' +
                ", ubicacionSedeFisica='" + ubicacionSedeFisica + '\'' +
                ", listaClientes=" + listaClientes +
                ", listaCuentas=" + listaCuentas +
                ", gestor=" + gestor +
                ", planificador=" + planificador +
                '}';
    }
}
