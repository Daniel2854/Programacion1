package model;

public class OperadorMonitoreo extends Empleado {

    private int zonasMonitoreadas;
    private double bonoZona;

    public OperadorMonitoreo(String nombre, String documento, Turno turno, double salarioBase, Empresa empresa, int zonasMonitoreadas, double bonoZona) {
        super(nombre, documento, turno, salarioBase, empresa);
        if(zonasMonitoreadas<=0 || bonoZona<0) {
            throw new IllegalArgumentException("Datos invalidos, los daos no pueden ser menor o igual cero");
        }
        this.zonasMonitoreadas = zonasMonitoreadas;
        this.bonoZona = bonoZona;
    }

    @Override
    public double calcularSalarioTotal(int horasExtra, double valorHora) {
        return salarioBase + (horasExtra*valorHora) + (zonasMonitoreadas*bonoZona);
    }
}
