
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel {

    // Just a single image, TODO: Generalize
   // private List<BufferedImage> images = new ArrayList<>();
    // To keep track of a singel cars position

    HashMap<String, BufferedImage> carPositions = new HashMap<>();
    ArrayList<AbstractCar> cars;





    // TODO: Make this general for all cars
    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, ArrayList<AbstractCar> cars) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.cyan);
        this.cars = cars;

        // Print an error message in case file is not found with a try/catch block
        try {
            carPositions.put("Volvo240", ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg")));
            carPositions.put("Saab95", ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg")));
            carPositions.put("Scania 2000", ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg")));


        }catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }



        // This method is called each time the panel updates/refreshes/repaints itself

// TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int distance = 0;
        for (AbstractCar cars : cars){
            g.drawImage(carPositions.get(cars.getModelName()) ,(int) cars.getX(), (int) cars.getY() + distance, null); // see javadoc for more info on the parameters
            distance += 100;
        }
    }
}