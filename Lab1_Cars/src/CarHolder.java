import java.util.ArrayList;

public class CarHolder {
    ArrayList<AbstractCar> cars = new ArrayList<>();


    public CarHolder() {
        this.cars.add(new Volvo240());
        this.cars.add(new ScaniaTruck(0));
        this.cars.add(new Saab95());
    }
}
