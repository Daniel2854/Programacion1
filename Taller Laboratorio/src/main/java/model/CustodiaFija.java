package model;

import java.util.ArrayList;

public class CustodiaFija extends ServicioSeguridad{
    private ArrayList<Integer> puestos = new ArrayList<>();

    public CustodiaFija(String codigoContrato, String cliente, double tarifa, Estado estado, Empresa empresa){
        super(codigoContrato, cliente, tarifa, estado, empresa);
    }

    public ArrayList<Integer> getPuesto() {
        return puestos;
    }
    public void setPuesto(ArrayList<Integer> puesto) {
        this.puestos = puesto;
    }

    public void agregarPuesto(int numeroPuesto) {
        puestos.add(numeroPuesto);
    }


    @Override
    public double calcularCostoMensual(double valorEmpleadoAsignado) {
        return tarifa + (puestos.size()*42000) +(listaEmpleados.size()*valorEmpleadoAsignado);
    }

    @Override
    public String toString() {
        return "CustodiaFija{" +
                "puesto=" + puestos +
                '}';
    }
}
