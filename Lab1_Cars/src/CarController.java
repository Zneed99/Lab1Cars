import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
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
    public Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    private CarView frame;
    private CarHolder carHolder;
    // A list of cars, modify if needed

    public CarController(CarHolder carHolder, CarView frame) {
        this.carHolder = carHolder;
        this.frame = frame;
    }

    private int gasAmount = 0;
    private final int brakeAmount = 1;


    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (AbstractCar car : carHolder.cars) {
                car.move();
                int x = (int) Math.round(car.getX());
                int y = (int) Math.round(car.getY());
                //frame.drawPanel.moveIt(x, y, car.getClass());

                if (x > 700 || x < 0 || y > 700 || y < 0){
                    car.setCurrentSpeed(car.getCurrentSpeed());
                    car.uTurn();
                }
                frame.infoView.printLabels();
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }


    public void actions(){
        frame.gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });

        // This actionListener is for the gas button only
        // TODO: Create more for each component as necessary
        frame.gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gas(gasAmount);
            }
        });
        frame.brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                brake(brakeAmount);
                System.out.println("Bromsa dårååååå");
            }
        });

        frame.turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                turboOn();
            }
        });

        frame.turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                turboOff();
            }
        });

        frame.liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                raiseBed();
            }
        });

        frame.lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lowerBed();
            }
        });

        frame.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startCars();
            }
        });

        frame.stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopCars();
            }
        });

    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (AbstractCar car : carHolder.cars) {
            car.gas(gas);
        }
    }

    void brake(int amount){
        for (AbstractCar car : carHolder.cars){
            car.brake(amount);
        }
    }

    void turboOn(){
        for (AbstractCar car : carHolder.cars){
            if (car instanceof Saab95){
                ((Saab95) car).setTurboOn();
            }
        }
    }

    void turboOff(){
        for (AbstractCar car : carHolder.cars){
            if (car instanceof Saab95){
                ((Saab95) car).setTurboOff();
            }
        }
    }

    void raiseBed(){
        for (AbstractCar car : carHolder.cars){
            if (car instanceof ScaniaTruck){
                ((ScaniaTruck) car).setRol(ScaniaTruck.raiseOrLower.RAISE);
                ((ScaniaTruck) car).raiseOrLower();
                System.out.println(((ScaniaTruck) car).getDegree());
            }
        }
    }

    void lowerBed(){
        for (AbstractCar car : carHolder.cars){
            if (car instanceof ScaniaTruck){
                ((ScaniaTruck) car).setRol(ScaniaTruck.raiseOrLower.LOWER);
                ((ScaniaTruck) car).raiseOrLower();
                System.out.println(((ScaniaTruck) car).getDegree());
            }
        }
    }

    void startCars(){
        for (AbstractCar car : carHolder.cars){
            car.startEngine();
        }
    }

    void stopCars(){
        for(AbstractCar car : carHolder.cars){
            car.stopEngine();
        }
    }
}
