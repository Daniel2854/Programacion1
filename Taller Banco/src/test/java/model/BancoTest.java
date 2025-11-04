package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BancoTest {
    Banco b1 = null;

    @BeforeEach
    public void setUpClass() {
        b1 = new Banco("Banco UQ");
    }

    @Test
    public void agregarCuentaTest(){
        Cuenta c1 = new Cuenta("Daniel", "1234", 1000.0);
        b1.agregarCuenta(c1);

        assertTrue(b1.getListaCuentas().size() == 1);
    }

    @Test
    public void obtenerCuentasTest(){
        Cuenta c1 = new Cuenta("Daniel", "1234", 1000.0);
        Cuenta c2 = new Cuenta("Laura", "5678", 1000.0);
        Cuenta c3 = new Cuenta("Sofia", "91011", 180000.0);
        Cuenta c4 = new Cuenta("Luisa", "121314", 1700000.0);
        Cuenta c5 = new Cuenta("Manuel", "151617", 125000.0);

        b1.agregarCuenta(c1);
        b1.agregarCuenta(c2);
        b1.agregarCuenta(c3);
        b1.agregarCuenta(c4);
        b1.agregarCuenta(c5);
        List<Cuenta> cuentas = List.of(c3,c4,c5);

        assertIterableEquals(cuentas,b1.buscarCuentasMayor100Mil());
    }
}