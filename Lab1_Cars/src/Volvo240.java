import java.awt.*;

/**
 * Type of car
 */
public class Volvo240 extends AbstractCar {

    private final static double trimFactor = 1.25;

    public Volvo240() {
        super(4, 100, Color.black, "Volvo240", 0, 0, Direction.RIGHT,2);
    }

    /**
     * Sets the speed for the volvo
     *
     * @return
     */
    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }

    private double getTrimFactor() {
        return trimFactor;
    }


}
