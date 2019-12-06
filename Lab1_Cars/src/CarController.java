import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    public ArrayList<AbstractCar> cars = new ArrayList<>();


    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();


        cc.cars.add(new Volvo240());
        cc.cars.add(new Saab95());
        cc.cars.add(new ScaniaTruck(0));

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);
        cc.frame.drawPanel.carList = cc.cars;

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (AbstractCar car : cars) {
                car.move();
                int x = (int) Math.round(car.getX());
                int y = (int) Math.round(car.getY());
                //frame.drawPanel.moveIt(x, y, car.getClass());

                if (x > 700 || x < 0 || y > 700 || y < 0){
                    car.setCurrentSpeed(car.getCurrentSpeed());
                    car.uTurn();
                }

                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }



    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (AbstractCar car : cars) {
            car.gas(gas);
        }
    }

    void brake(int amount){
        for (AbstractCar car : cars){
            car.brake(amount);
        }
    }

    void turboOn(){
        for (AbstractCar car : cars){
            if (car instanceof Saab95){
                ((Saab95) car).setTurboOn();
            }
        }
    }

    void turboOff(){
        for (AbstractCar car : cars){
            if (car instanceof Saab95){
                ((Saab95) car).setTurboOff();
            }
        }
    }

    void raiseBed(){
        for (AbstractCar car : cars){
            if (car instanceof ScaniaTruck){
                ((ScaniaTruck) car).setRol(ScaniaTruck.raiseOrLower.RAISE);
                ((ScaniaTruck) car).raiseOrLower();
                System.out.println(((ScaniaTruck) car).getDegree());
            }
        }
    }

    void lowerBed(){
        for (AbstractCar car : cars){
            if (car instanceof ScaniaTruck){
                ((ScaniaTruck) car).setRol(ScaniaTruck.raiseOrLower.LOWER);
                ((ScaniaTruck) car).raiseOrLower();
                System.out.println(((ScaniaTruck) car).getDegree());
            }
        }
    }

    void startCars(){
        for (AbstractCar car : cars){
            car.startEngine();
        }
    }

    void stopCars(){
        for(AbstractCar car : cars){
            car.stopEngine();
        }
    }

    ArrayList<AbstractCar> getList(){
        return cars;
    }
}
