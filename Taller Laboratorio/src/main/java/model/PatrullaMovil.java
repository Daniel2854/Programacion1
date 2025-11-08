package model;

public class PatrullaMovil extends ServicioSeguridad{

    private double kilometros;
    private int rutas;

    public PatrullaMovil(String codigoContrato, String cliente, double tarifa, Estado estado, Empresa empresa, double kilometros, int rutas) {
        super(codigoContrato, cliente, tarifa, estado, empresa);
        if(kilometros <= 0 || rutas <= 0) {
            throw new IllegalArgumentException("Datos invalidos, los datos no pueden ser menor o igual cero");
        }
        this.kilometros = kilometros;
        this.rutas = rutas;
    }

    public double getKilometros() {
        return kilometros;
    }
    public void setKilometros(double kilometros) {
        this.kilometros = kilometros;
    }
    public int getRutas() {
        return rutas;
    }
    public void setRutas(int rutas) {
        this.rutas = rutas;
    }

    @Override
    public double calcularCostoMensual(double valorEmpleadoAsignado) {
        return tarifa + (rutas*15000) + (kilometros*1000) + (listaEmpleados.size()*valorEmpleadoAsignado);
    }

    @Override
    public String toString() {
        return "PatrullaMovil{" +
                "kilometros=" + kilometros +
                ", rutas=" + rutas +
                '}';
    }
}
