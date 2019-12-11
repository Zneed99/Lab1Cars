public class Application {
    public static void main(String[] args) {
        CarHolder carHolder = new CarHolder();
        CarView frame = new CarView("CarSim 1.0");
        CarController cc = new CarController(carHolder,frame);
        // Start a new view and send a reference of self
        //cc.frame = new CarView("CarSim 1.0");
        frame.drawPanel.carList = carHolder.cars;
        frame.infoView.cars = carHolder.cars;
        cc.actions();
        // Start the timer
        cc.timer.start();
    }
}
