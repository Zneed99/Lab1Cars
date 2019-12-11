import java.util.ArrayList;

public class CarHolder {
    ArrayList<AbstractCar> cars = new ArrayList<>();


    public CarHolder() {
        cars.add(new Volvo240());
        cars.add(new ScaniaTruck(0));
        cars.add(new Saab95());
    }
}
