import junit.framework.TestCase;

public class CarTransportTest extends TestCase {
    Ramp ramp = new Ramp();
    CarTransport<AbstractCar> carTransport = new CarTransport<>(ramp);
    Volvo240 volvo = new Volvo240();

    public void testLoadCars() {
        carTransport.load(volvo);
        carTransport.unload();
        assertEquals(volvo.getY(), -10.0);


    }

}