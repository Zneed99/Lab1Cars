import java.awt.*;

public class Saab95 extends AbstractCar {

    private boolean turboOn;

    public Saab95() {
        super(2, 125, Color.red, "Saab95", 0, 0, Direction.DOWN,2);
        turboOn = false;
    }

    /**
     * Sets the speed for the saab
     *
     * @return
     */
    @Override
    public double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

    public void setTurboOn() {
        turboOn = true;
    }

    public void setTurboOff() {
        turboOn = false;
    }

    public boolean isTurboOn() {
        return turboOn;
    }
}
