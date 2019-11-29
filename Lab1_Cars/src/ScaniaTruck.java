import java.awt.*;

/**
 * a type of truck
 */
public class ScaniaTruck extends AbstractCar {

    private int degree;
    private raiseOrLower rol;
    private Direction direction;

    /**
     * The degree on the truck's bed
     * @param degree
     */
    public ScaniaTruck(double degree) {
        super(2,200,Color.red,"Scania 2000",0,0,Direction.RIGHT, 17);
        this.degree = 0;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    /**
     * Enum used to raise or lower the truck's bed
     */
    protected enum raiseOrLower {RAISE, LOWER}

    /**
     * Raises or lowers the truck's bed
     */
    public void raiseOrLower() {
        switch (rol) {
            case RAISE:
                if (getDegree() + 2 > 70) {
                    break;
                }
                setDegree(getDegree() + 2);
                break;
            case LOWER:
                if (getDegree() - 2 < 0) {
                    break;
                }
                setDegree(getDegree() - 2);
                break;
        }
    }

    /**
     * Checks if you can load. Can only load if the degree isn't zero
     * @return
     */
    private boolean isLoading() {
        return getDegree() != 0;
    }

    /**
     * The speedFactor of the truck
     * @return
     */
    @Override
    public double speedFactor() {
        return 1;
    }

    /**
     * Able to gas if the truck isn't loading
     * @param amount A value between [0,1]. If set higher or lower it will be changed to a valid number
     */
    @Override
    public void gas(double amount) {
        if (!(isLoading())) {
            super.gas(amount);
        }
    }

    public void setRol(raiseOrLower rol) {
        this.rol = rol;
    }



}







