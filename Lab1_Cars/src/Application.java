public class Application {
    public static void main(String[] args) {
        CarHolder carHolder = new CarHolder();
        CarView frame = new CarView("CarSim 1.0");
       // InfoView info = new InfoView();
        CarController cc = new CarController(carHolder,frame);
        // Start a new view and send a reference of self
        frame.drawPanel.carList = carHolder.cars;
        frame.infoPanel.cars = carHolder.cars;
        frame.infoPanel.printLabels();
        cc.actions();
        // Start the timer
        cc.timer.start();
    }
}
