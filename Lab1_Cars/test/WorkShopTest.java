import junit.framework.TestCase;

public class WorkShopTest extends TestCase {

    private WorkShop<AbstractCar> workShop = new WorkShop<>(new Storage(16, 0), 0,0);
    private Volvo240 volvo = new Volvo240();




    public void testUnload() {

        workShop.load(volvo);
        workShop.unload(volvo);
        assertEquals(volvo.getY(), -10.0);

    }


}