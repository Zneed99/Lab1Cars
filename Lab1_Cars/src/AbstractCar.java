import java.awt.*;


public abstract class AbstractCar implements Moveable {

    private int nrDoors;
    private double enginePower;
    private double currentSpeed;
    private Color color;
    private String modelName;
    private double x;
    private double y;
    private Direction direction;
    private int size;
    private boolean isLoaded;

    /**
     * @param nrDoors     Number of doors on the car
     * @param enginePower Engine power of the car
     * @param color       Color of the car
     * @param modelName   The car model name
     * @param x           Position in x
     * @param y           Position in y
     * @param direction   Direction of the car
     */

    AbstractCar(int nrDoors, double enginePower, Color color, String modelName, double x, double y, Direction direction, int size) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.size = size;
        this.isLoaded = false;
        stopEngine();
    }

    /**
     * Moves the car
     */
    //Need to fix! Can't move if loaded to a truck
    @Override
    public void move() {
        if (!isLoaded) {
            switch (direction) {
                case UP:
                    this.y -= currentSpeed;
                    break;
                case LEFT:
                    this.x -= currentSpeed;
                    break;
                case DOWN:
                    this.y += currentSpeed;
                    break;
                case RIGHT:
                    this.x += currentSpeed;
                    break;
            }
        }
    }

    /**
     * Turns left
     */
    @Override
    public void turnLeft() {
        switch (direction) {
            case LEFT:
                direction = Direction.DOWN;
                break;
            case DOWN:
                direction = Direction.RIGHT;
                break;
            case UP:
                direction = Direction.LEFT;
                break;
            case RIGHT:
                direction = Direction.UP;
                break;
        }
    }

    /**
     * Turns right
     */
    @Override
    public void turnRight() {
        switch (direction) {
            case LEFT:
                direction = Direction.UP;
                break;
            case DOWN:
                direction = Direction.LEFT;
                break;
            case UP:
                direction = Direction.RIGHT;
                break;
            case RIGHT:
                direction = Direction.DOWN;
                break;
        }
    }

    /**
     * All classes override this function to fit the class
     *
     * @return
     */
    public abstract double speedFactor();

    /**
     * Increments the speed
     *
     * @param amount A value between [0,1]. If set higher or lower it will be changed to a valid number
     */
    private void incrementSpeed(double amount) {
        setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));
    }

    /**
     * Decrements the speed
     *
     * @param amount A value between [0,1]. If set higher or lower it will be changed to a valid number
     */
    private void decrementSpeed(double amount) {
        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount, 0));
    }

    /**
     * Increases the cars speed
     *
     * @param amount A value between [0,1]. If set higher or lower it will be changed to a valid number
     */
    public void gas(double amount) {
        if ( !(getCurrentSpeed() == 0)){
            if (0 <= amount && amount <= 1) {
                incrementSpeed(amount);
            } else if (amount > 1) {
                amount = 1;
                incrementSpeed(amount);
            } else if (amount < 0) {
                amount = 0;
                incrementSpeed(amount);
            }
        }
    }

    /**
     * Decreases the cars speed
     *
     * @param amount A value between [0,1]. If set higher or lower it will be changed to a valid number
     */
    public void brake(double amount) {
        if (0 <= amount && amount <= 1) {
            decrementSpeed(amount);
        } else if (amount > 1) {
            amount = 1;
            decrementSpeed(amount);
        } else if (amount < 0) {
            amount = 0;
            decrementSpeed(amount);
        }
    }

    public double getEnginePower() {
        return enginePower;
    }

   public double getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Direction getDirection() {
        return direction;
    }

    /**
     * Sets a speed value on the car
     */
    void startEngine() {
        currentSpeed = 0.1;
    }

    /**
     * Sets the speed value on the car to 0
     */
     void stopEngine() {
        currentSpeed = 0;
    }

    /**
     * Used to determine the cars direction
     */
    protected enum Direction {
        UP, DOWN, LEFT, RIGHT;

    }


    public boolean isLoaded() {
        return isLoaded;
    }

    public void setLoaded(boolean loaded) {
        isLoaded = loaded;
    }
}
