import java.awt.*;

/**
 * Class for the CarTransporter.
 */
public class CarTransport<T extends AbstractCar> extends AbstractCar {
    Storage<T> storage;
    Ramp ramp;

    /**
     * @param ramp initializes the ramp.
     */
    public CarTransport(Ramp ramp) {
        super(4, 200, Color.BLACK, "MODELU113", 0, 0, Direction.DOWN, 17);
        this.ramp = ramp;
        ramp.setUp(false);
        this.storage = new Storage<>(16, 0);

    }

    /**
     * Same move as before but also moves the storage inside.
     */
    @Override
    public void move() {
        super.move();
        storage.moveStorage(this.getY(), this.getX());
    }

    /**
     * @param car Loads a specific car
     */

    void load(T car) {
        if  (!ramp.isUp()) {
            storage.load(car, this.getX(), this.getY());
        }
    }

    /**
     * Unloads like a stack. First in last out principle.
     */
 /*
    public void unload() {
        if (storage.getLoadedCars().size() != 0 && storage.getLoadedCars().get(storage.getLoadedCars().size() - 1).isLoaded()) {
            storage.carLastIndex().setLoaded(false);
            storage.carLastIndex().setY(getY() - 10);
            storage.removeFromList(storage.carLastIndex());
        }
    }
*/

    /**
     * Cartransport unload.
     */
        public void unload (){
            T car = storage.carLastIndex();
            storage.unload(car, getY());

        }




    /**
     * Boolean used in load.
     */
    /**
     * @param car            checks the cars coordinate
     * @param carTransporter checks the cartransporters coordinate
     * @return boolean if the car is close enough
     */


    /**
     * Can gas if the ramp isn't up
     *
     * @param amount A value between [0,1]. If set higher or lower it will be changed to a valid number
     */
    @Override
    public void gas(double amount) {
        if (!(ramp.isUp())) {
            super.gas(1);
        }
    }

    /**
     * SpeedFactor for the carTransport
     *
     * @return
     */
    @Override
    public double speedFactor() {
        return 1;

    }


}
