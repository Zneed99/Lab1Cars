import java.util.ArrayList;
import java.util.Random;

public class CarHolder {
    ArrayList<AbstractCar> cars = new ArrayList<>();


    public CarHolder() {}

    public static AbstractCar createVolvo240() {
        return new Volvo240();
    }

    public static AbstractCar createSaab95() {
        return new Saab95();
    }

    public static AbstractCar createScania() {
        return new ScaniaTruck(0);
    }

    public static AbstractCar createRandomVehicle() {
        switch (new Random().nextInt(3)) {
            case 0:
                return new Volvo240();
            case 1:
                return new Saab95();
            case 2:
                return new ScaniaTruck(0);
        }
        throw new Error();
    }

}