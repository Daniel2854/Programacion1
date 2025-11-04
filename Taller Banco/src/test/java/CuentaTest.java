import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.logging.Logger;

import model.Cuenta;
import org.junit.jupiter.api.Test;

public class CuentaTest {
    //private static final Logger LOG = Logger.getLogger(CuentaTest.class.getName());

    @Test
    public void saldoNegativoTest(){
        assertThrows(Throwable.class,()-> new Cuenta("Daniel", "112344598", -1000.0));
    }

    @Test
    public void depositarTest(){
        Cuenta c1 = new Cuenta("Daniel", "112344598", 50000.0);
        c1.depositar(50000.0);

        assertEquals(100000.0, c1.getSaldo());
    }

    @Test
    public void depositarCeroTest(){
        Cuenta c1 = new Cuenta("Daniel", "112344598", 50000.0);
        assertThrows(Throwable.class,()-> c1.depositar(0.0));
    }

    @Test
    public void retirarTest(){
        Cuenta c1 = new Cuenta("Daniel", "112344598", 5000.0);

        assertThrows(Throwable.class,()-> c1.retirar(8000.0));
    }

    @Test
    public void retirarCeroTest(){
        Cuenta c1 = new Cuenta("Daniel", "112344598", 80000.0);
        c1.retirar(80000.0);

        assertTrue(c1.getSaldo() == 0.0);
    }
}
