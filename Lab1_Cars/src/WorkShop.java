import java.util.ArrayList;
import java.util.List;
/**
 *Workshop has a storage of "cars"
 */
public class    WorkShop<T extends AbstractCar> {
    private Storage<T> storage;
    private int x;
    private int y;

    /**
     * @param storage storage for the workshop
     * @param x       coordinate of the workshop
     * @param y       coordinate of the workshop
     */
    public WorkShop(Storage storage, int x, int y) {
        this.storage = storage;
        this.x = x;
        this.y = y;
    }

    /**
     * @param car Specific car that the customer wants
     *            Checks the list if the car is inside the list.
     */
    public void unload(T car) {
        for (int i = 0; i < storage.getLoadedCars().size(); i++) {
            if (storage.getLoadedCars().get(i) == car) {
                storage.unload(car,getY());
            }
        }
    }


    public void load(T car) {
        if (isCarClose(car, this) && (!storage.isFull(car)) && !car.isLoaded()) {
            storage.load(car,getX(), getY());

        }
    }


    private boolean isCarClose(AbstractCar car, WorkShop workShop) {
        return car.getY() - workShop.getY() < 10 && car.getX() - workShop.getX() < 10;
    }

    public double getX() {
        return x;
    }


    public double getY() {
        return y;
    }
}

