public class Application {
    public static void main(String[] args) {
        CarHolder carHolder = new CarHolder();
        carHolder.cars.add(CarHolder.createVolvo240());
        carHolder.cars.add(CarHolder.createSaab95());
        carHolder.cars.add(CarHolder.createScania());
        DrawPanel drawPanel = new DrawPanel(800, 560, carHolder.cars);
        InfoView infoPanel = new InfoView(200, 200, carHolder.cars );
        CarView frame = new CarView("CarSim 1.0",infoPanel,drawPanel);
        CarController cc = new CarController(carHolder,frame);
        // Start a new view and send a reference of self
        cc.actions();
        // Start the timer
        cc.timer.start();
    }
}
