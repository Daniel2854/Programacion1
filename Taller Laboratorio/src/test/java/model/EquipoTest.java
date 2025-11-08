package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EquipoTest {
    @Test
    public void testCrearEquipo() {
        Equipo e = new Equipo("EQ001", "radio", Estado.ACTIVO, 300000, null);
        assertEquals("EQ001", e.getCodigo());
        assertEquals("radio", e.getTipo());
        assertEquals(Estado.ACTIVO, e.getEstado());
        assertEquals(300000, e.getValorReposicion());
    }

    @Test
    public void testModificarEstado() {
        Equipo e = new Equipo("EQ002", "uniforme", Estado.ACTIVO, 150000, null);
        e.setEstado(Estado.SUSPENDIDO);
        assertEquals(Estado.SUSPENDIDO, e.getEstado());
    }

    @Test
    public void valorReposicionMenorCero() {
        assertThrows(Throwable.class, ()-> {new Equipo("EQ003", "binoculares", Estado.ACTIVO, -97000, null);});
    }


}