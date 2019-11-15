import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class AbstractCarTest extends TestCase {

    private Volvo240 volvo;
    private Saab95 saab;

    @Before
    public void setUp() {
        volvo = new Volvo240();
        saab = new Saab95();
    }

    @Test
    public void testMove() {
        volvo.startEngine();
        volvo.move();
        volvo.turnLeft();
        volvo.move();
        volvo.turnLeft();
        volvo.move();
        volvo.turnLeft();
        volvo.move();
        volvo.turnLeft();
        volvo.move();
        assertEquals(-0.1, volvo.getY());
    }

    @Test
    public void testTurnRight() {
        volvo.turnRight();
        volvo.turnRight();
        volvo.turnRight();
        volvo.turnRight();
        volvo.turnRight();
        assertEquals(AbstractCar.Direction.LEFT, volvo.getDirection());
    }

    @Test
    public void testVolvoGas() {
        volvo.gas(1);
        assertEquals(1.25, volvo.getCurrentSpeed());
    }

    @Test
    public void testSaabGas() {
        saab.gas(1);
        assertEquals(1.25, saab.getCurrentSpeed());
    }

    @Test
    public void testSaabBrake() {
        //saab.setCurrentSpeed(1.25);
        saab.brake(1);
        assertEquals(0.0, saab.getCurrentSpeed());
    }

    @Test
    public void testVolvoBrake() {
        //volvo.setCurrentSpeed(1.25);
        volvo.brake(1);
        assertEquals(0.0, volvo.getCurrentSpeed());
    }

    @Test
    public void testBrakeHighValue() {
        //volvo.setCurrentSpeed(1.25);
        volvo.brake(4);
        assertEquals(0.0, volvo.getCurrentSpeed());
    }

    @Test
    public void testBrakeLowValue() {
        //volvo.setCurrentSpeed(1.25);
        volvo.brake(-4);
        assertEquals(1.25, volvo.getCurrentSpeed());
    }

    @Test
    public void testGasHighValue() {
        saab.gas(4);
        assertEquals(1.25, saab.getCurrentSpeed());
    }

    @Test
    public void testGasLowValue() {
        saab.gas(-4);
        assertEquals(0.0, saab.getCurrentSpeed());
    }
}