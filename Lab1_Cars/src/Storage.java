import java.util.ArrayList;
import java.util.List;

/**
 *The actual storage of cars.
 */
public class Storage<T extends AbstractCar> {
    private List<T> loadedCars = new ArrayList<>();
    private int maxStorageSize;
    private int currentSize;


    public Storage(int maxStorageSize, int currentSize) {
        this.maxStorageSize = maxStorageSize;
        this.currentSize = currentSize;
    }

    /**
     * Loads cars, updated the state of the car, changed x,y to the transporters coordinates.
     * If statement makes sure that the car is close, the truck isn't full and the ramp isn't up.
     * @param car           the type of car.
     * @param carTransport  the transporter
     */


    /**
     *
     * @param maxStorageSize
     * @param currentSize
     * @return
     */


    /**
     * Unloads the car like a stack from the transporter, sets coordinates like Load.
     */

    public void TestCompileError() {
        Storage<Volvo240> storage = new Storage<>(2, 0);
        Saab95 saab95 = new Saab95();
        Volvo240 volvo = new Volvo240();
        storage.getLoadedCars().add(volvo);
        //storage.getLoadedCars().add(saab95);

    }




    /**
     *
     * @param car Type of car that gets unloaded from the workshop.
     */


    /**
     * Moves the storage if the storage is moving.
     *
     */

    public void moveStorage(double y, double x) {
        for (int i = 0; i < getLoadedCars().size(); i++) {
            getLoadedCars().get(i).setX(x);
            getLoadedCars().get(i).setY(y);
        }
    }

    /**
     * checks if the storage is full
     *
     * @param car sizeclass of the car, checks if the maxStorageSize isn't exceeded
     * @return
     */
    boolean isFull(T car) {
        if (car.getSize() + currentSize <= maxStorageSize) {
            currentSize += car.getSize();
            return false;
        }
        return true;
    }

    void removeFromList(T car) {
        this.getLoadedCars().remove(car);
    }

    /**
     *
     * @param car  specific car that gets loaded
     * @param x    x coordinate of loader
     * @param y    y coordinate of loader
     *  Loads the car into the storage.
     */
    void load(T car, double x, double y) {
        if (isCarClose(car, x, y) && !this.isFull(car) && !car.isLoaded()){
        car.setX(x);
        car.setY(y);
        getLoadedCars().add(car);
        car.setLoaded(true);
        }
    }

    /**
     *
     * @param car   specific car that unloaded
     * @param y     y coordinate of the loader
     */
      void unload(T car, double y){
        if(car.isLoaded() && (this.getLoadedCars().size() != 0))
            car.setY(y - 10);
            car.setLoaded(false);
            this.removeFromList(car);
        }

    /**
     *
     * @param car  the car that will get loaded
     * @param x    coordinate of the loader
     * @param y    coordinate of the loader
     * @return     boolean if it's too far away
     */
     private boolean isCarClose(T car,double x, double y) {
        return car.getY() - y < 10 && car.getX() - x < 10;
    }

    /**
     *
     * @return gets the last index in list.
     */
    T carLastIndex(){ T a= this.getLoadedCars().get(getLoadedCars().size()-1);
        return  a; }
    List<T> getLoadedCars() {
        return loadedCars;
    }
}
