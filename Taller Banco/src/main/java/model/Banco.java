package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Banco {
    private String nombre;
    private ArrayList<Cuenta> listaCuentas;

    public Banco(String nombre) {
        this.nombre = nombre;
        this.listaCuentas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public ArrayList<Cuenta> getListaCuentas() {
        return listaCuentas;
    }
    public void setListaCuentas(ArrayList<Cuenta> listaCuentas) {
        this.listaCuentas = listaCuentas;
    }

    public void agregarCuenta(Cuenta cuenta) {
        listaCuentas.add(cuenta);
    }

    public void mostrarCuentas() {
        for (Cuenta aux : listaCuentas) {
            System.out.println(aux);
        }
    }

    public ArrayList<Cuenta> buscarCuentasMayor100Mil() {
        ArrayList<Cuenta> cuentasEncontradas = new ArrayList<>();

        for (Cuenta aux: listaCuentas) {
            if (aux.getSaldo() > 100000.0) {
                cuentasEncontradas.add(aux);
            }
        }
        return cuentasEncontradas;
    }

    public List<Cuenta> obtenerCuentas() {
        return listaCuentas.stream().filter(c-> c.getSaldo() > 100000.0).
                collect(Collectors.toUnmodifiableList());
    }
}
