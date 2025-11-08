package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmpleadoTest {
    @Test
    public void testSalarioVigilanteSinHorasExtra() {
        Vigilante v = new Vigilante("Daniel", "123", Turno.NOCHE, 1200000, null, 101, Arma.LETAL );
        double salario = v.calcularSalarioTotal(0, 5400);
        assertEquals(1200000, salario);
    }

    @Test
    public void testSalarioSupervisorConHorasExtra() {
        Supervisor s = new Supervisor("Laura", "456", Turno.DIA, 1500000, null, 70000);
        double salario = s.calcularSalarioTotal(5, 5400);
        assertEquals(1500000 + (5 * 5400) + 70000, salario);
    }

    @Test
    public void testAsignarYCalcularDotacion() {
        OperadorMonitoreo o = new OperadorMonitoreo("Felipe", "789", Turno.DIA, 1300000, null, 4, 12600);
        o.asignarEquipo(new Equipo("EQ001", "headset", Estado.ACTIVO, 250000, null));
        o.asignarEquipo(new Equipo("EQ002", "computador", Estado.ACTIVO, 1500000, null));
        assertEquals(1750000, o.calcularValorDotacion());
    }

    @Test
    public void testRetirarEquipo() {
        Vigilante v = new Vigilante("Carlos", "123", Turno.NOCHE, 1200000, null, 203, Arma.LETAL);
        Equipo radio = new Equipo("EQ001", "radio", Estado.ACTIVO, 300000, null);
        v.asignarEquipo(radio);
        v.retirarEquipo("EQ001");
        assertEquals(0, v.calcularValorDotacion());
    }

    @Test
    public void testSalarioBaseMenorCero() {
        assertThrows(Throwable.class, ()-> {new Vigilante("Maria", "942", Turno.DIA, -145000, null, 504, Arma.NO_LETAL);});
    }

    @Test
    public void testSalarioBaseIgualCero() {
        assertThrows(Throwable.class, ()-> {new Supervisor("Juan", "765", Turno.NOCHE, 0, null, 0);});
    }

}