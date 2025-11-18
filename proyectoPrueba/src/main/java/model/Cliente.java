package model;

import java.util.ArrayList;
import java.util.List;

public class Cliente implements Sujeto {
    private final String nombre;
    private final String id;
    private int puntos;
    private RangoCliente rango = RangoCliente.BRONCE;
    private final SistemaPuntos sistemaPuntos = new SistemaPuntos();
    private final List<Notificacion> listaNotificaciones = new ArrayList<>();
    private final List<Cuenta> listaCuentas = new ArrayList<>();
    private final HistorialTransacciones historialT = new HistorialTransacciones();
    private final List<Observador> observadores = new ArrayList<>();

    public Cliente(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
    }

    public String getNombre() { return nombre; }
    public String getId() { return id; }
    public int getPuntos() { return puntos; }
    public void setPuntos(int puntos) { this.puntos = Math.max(0, puntos); }
    public RangoCliente getRango() { return rango; }
    public SistemaPuntos getSistemaPuntos() { return sistemaPuntos; }
    public HistorialTransacciones getHistorialT() { return historialT; }

    public void addCuenta(Cuenta c) {
        c.setCliente(this);
        listaCuentas.add(c);
    }
    public List<Cuenta> getListaCuentas() { return listaCuentas; }

    public double consultarSaldo() {
        return listaCuentas.stream().mapToDouble(Cuenta::getSaldo).sum();
    }

    public int consultarPuntos() { return puntos; }

    public List<Transaccion> consultarHistorial() { return historialT.getTransacciones(); }

    public void actualizarRango() {
        if (puntos >= 2000) rango = RangoCliente.ORO;
        else if (puntos >= 1000) rango = RangoCliente.PLATA;
        else rango = RangoCliente.BRONCE;
    }

    @Override
    public void suscribir(Observador obs) { observadores.add(obs); }

    @Override
    public void desuscribir(Observador obs) { observadores.remove(obs); }

    @Override
    public void notificar(String mensaje) { observadores.forEach(o -> o.actualizar(mensaje)); }

    @Override
    public List<Observador> getObservadores() { return observadores; }

    public void agregarNotificacion(Notificacion n) {
        listaNotificaciones.add(n);
        suscribir(n);
    }
    public List<Notificacion> getListaNotificaciones() { return listaNotificaciones; }
}