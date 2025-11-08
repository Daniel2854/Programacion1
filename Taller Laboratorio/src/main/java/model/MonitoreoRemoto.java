package model;

public class MonitoreoRemoto extends ServicioSeguridad{

    private int dispositivos;

    public MonitoreoRemoto(String codigoContrato, String cliente, double tarifa, Estado estado, Empresa empresa, int dispositivos) {
        super(codigoContrato, cliente, tarifa, estado, empresa);
        if(dispositivos < 0) {
            throw new IllegalArgumentException("la cantidad de dispositivos no puede ser menor a cero");
        }
        this.dispositivos = dispositivos;
    }

    public int getDispositivos() {
        return dispositivos;
    }
    public void setDispositivos(int dispositivos) {
        this.dispositivos = dispositivos;
    }

    @Override
    public double calcularCostoMensual(double valorEmpleadoAsignado) {
        return tarifa + (dispositivos*2000) + (listaEmpleados.size()*valorEmpleadoAsignado);
    }

    @Override
    public String toString() {
        return "MonitoreoRemoto{" +
                "dispositivos=" + dispositivos +
                '}';
    }
}
