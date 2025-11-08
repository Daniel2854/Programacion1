package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServicioSeguridadTest {
    @Test
    public void testCostoCustodiaFija() {
        CustodiaFija cf = new CustodiaFija("CT001", "Cliente A", 2000000, Estado.ACTIVO, null);
        cf.agregarPuesto(101);
        cf.agregarPuesto(102);
        assertEquals(2000000 + 2 * 42000, cf.calcularCostoMensual(34000));
    }

    @Test
    public void testCostoPatrullajeMovil() {
        PatrullaMovil pm = new PatrullaMovil("PM001", "Cliente B", 1800000, Estado.ACTIVO, null, 15, 3);
        assertEquals(1800000 + (3 * 15000) + (15*1000), pm.calcularCostoMensual(50000));
    }

    @Test
    public void testCostoMonitoreoRemoto() {
        MonitoreoRemoto mr = new MonitoreoRemoto("MR001", "Cliente C", 1500000, Estado.ACTIVO, null, 5);
        assertEquals(1500000 + 5 * 2000, mr.calcularCostoMensual(34000));
    }

    @Test
    public void testAsignarEmpleado() {
        CustodiaFija cf = new CustodiaFija("CT001", "Cliente A", 2000000, Estado.ACTIVO, null);
        Vigilante v = new Vigilante("Carlos", "123", Turno.NOCHE, 1200000, null, 101, Arma.LETAL);
        cf.asignarEmpleado(v);
        assertTrue(cf.getListaEmpleados().contains(v));
    }


}