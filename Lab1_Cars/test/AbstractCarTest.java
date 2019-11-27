import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class AbstractCarTest extends TestCase {

    private Volvo240 volvo;
    private Saab95 saab;
    Ramp ramp;
    Storage<Volvo240> storage;
    Storage<AbstractCar> aStorage;
    CarTransport carTransport;


    @Before
    public void setUp() {
        volvo = new Volvo240();
        saab = new Saab95();
        storage = new Storage(100, 0);
        ramp = new Ramp();
        aStorage = new Storage<>(4, 0);
        carTransport = new CarTransport(ramp);

    }

    @Test
    public void testMove() {

        if (ramp.isUp()) {
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
        saab.gas(1);
        saab.brake(1);
        assertEquals(0.0, saab.getCurrentSpeed());
    }

    @Test
    public void testVolvoBrake() {
        volvo.gas(1);
        volvo.brake(1);
        assertEquals(0.0, volvo.getCurrentSpeed());
    }

    @Test
    public void testBrakeHighValue() {
        volvo.gas(1);
        volvo.brake(4);
        assertEquals(0.0, volvo.getCurrentSpeed());
    }

    @Test
    public void testBrakeLowValue() {
        volvo.gas(1);
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


