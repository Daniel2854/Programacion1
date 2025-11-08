package app;

import model.*;

import java.time.LocalDateTime;

public class Aplicacion {
    public static void main(String[] args) {
        Empresa empresa = new Empresa("SEGURCOL S.A.", "3105940266", "segurocol@gmail.com");

        // Crear empleados
        Vigilante v1 = new Vigilante("Carlos", "123", Turno.NOCHE, 1200000, empresa, 1, Arma.LETAL);
        Supervisor s1 = new Supervisor("Laura", "456", Turno.DIA, 1500000, empresa, 50000);
        OperadorMonitoreo o1 = new OperadorMonitoreo("Andrés", "789", Turno.DIA, 1300000, empresa, 5, 15000);

        empresa.registrarEmpleado(v1);
        empresa.registrarEmpleado(s1);
        empresa.registrarEmpleado(o1);

        // Crear equipos
        Equipo radio = new Equipo("EQ001", "radio", Estado.ACTIVO, 300000, empresa);
        Equipo uniforme = new Equipo("EQ002", "uniforme", Estado.ACTIVO, 150000, empresa);
        Equipo arma = new Equipo("EQ003", "arma", Estado.ACTIVO, 500000, empresa);

        // Asignar equipos
        v1.asignarEquipo(radio);
        v1.asignarEquipo(arma);
        s1.asignarEquipo(uniforme);

        // Crear servicio
        CustodiaFija custodia = new CustodiaFija("CT001", "Edificio Laureles epik", 2500000, Estado.ACTIVO, empresa);
        custodia.agregarPuesto(101);
        custodia.agregarPuesto(102);
        custodia.asignarEmpleado(v1);
        custodia.asignarEmpleado(s1);

        empresa.getListaServicios().add(custodia);

        // Registrar novedad
        Novedad novedad = new Novedad("Vigilante Carlos sufrió una caida", "leve", LocalDateTime.now(), empresa);
        empresa.registrarNovedad(novedad);

        // Calcular costos
        double costoServicios = empresa.calcularCostoTotalServicios(77000);
        double gastoEmpresa = empresa.gastoTotalEmpresa();

        // Mostrar resultados
        System.out.println("Costo total de servicios: $" + costoServicios);
        System.out.println("Gasto total de la empresa: $" + gastoEmpresa);

        // Informe de dotación
        System.out.println("\nInforme de dotación:");
        empresa.informeDotacion().forEach((empleado, valor) -> {
            System.out.println(empleado.getClass().getSimpleName() + " " + empleado.getNombre() + ": $" + valor);
        });

        // Novedades recientes
        System.out.println("\nNovedades registradas:");
        empresa.obtenerNovedades(LocalDateTime.now().minusDays(1), LocalDateTime.now())
                .forEach(n -> System.out.println(n.fecha() + " - " + n.tipo() + ": " + n.descripcion()));

    }
}
