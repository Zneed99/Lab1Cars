import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class StorageTest extends TestCase {

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
        public void testTestCompileError () {
            //storage.getLoadedCars().add(saab);
        }

        @Test
        public void testMoveCarTransporter () {
            carTransport.load(volvo);
            carTransport.gas(1);
            carTransport.move();
            assertEquals(carTransport.getY(), volvo.getY());


        }
        @Test
        public void testLoadCartransportY () {
            storage.getLoadedCars().add(volvo);
            carTransport.gas(1);
            carTransport.move();
            assertEquals(volvo.getY(), 0.0);


        }

}
