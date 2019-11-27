import junit.framework.TestCase;
import org.junit.Test;

public class ScaniaTruckTest extends TestCase {
    ScaniaTruck scaniaTruck = new ScaniaTruck(0);

@Test
    public void testRaiseOrLower() {
        scaniaTruck.setRol(ScaniaTruck.raiseOrLower.RAISE);
        scaniaTruck.raiseOrLower();
        assertEquals(scaniaTruck.getDegree(), 2);



    }
}