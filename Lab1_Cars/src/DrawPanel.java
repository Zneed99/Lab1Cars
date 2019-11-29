
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

public class DrawPanel<T extends AbstractCar> extends JPanel {

    // Just a single image, TODO: Generalize
   // private List<BufferedImage> images = new ArrayList<>();
    // To keep track of a singel cars position
    private BufferedImage volvoImage;
    private BufferedImage saabImage;
    private BufferedImage scaniaImage;


    private Point volvoPoint = new Point();
    private Point saabPoint = new Point();
    private Point scaniaPoint = new Point();

    //HashMap<T, BufferedImage> carPositions;

    // TODO: Make this genereal for all cars
    void moveIt(int x, int y, Class car) {
        if(car.equals(Volvo240.class)){
            volvoPoint.setLocation(x,y);
        }
        if(car.equals(Saab95.class)){
            saabPoint.setLocation(x, y);
        }
        if(car.equals(ScaniaTruck.class)){
            scaniaPoint.setLocation(x, y);
        }
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.cyan);

        // Print an error message in case file is not found with a try/catch block
        try {
            //carPositions.put(car, ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg")));
            //carPositions.put(car, ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg")));
            //carPositions.put(car, ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg")));

            volvoImage = (ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg")));
            saabImage =(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg")));
            scaniaImage =(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg")));

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
        g.drawImage(volvoImage, volvoPoint.x, volvoPoint.y, null); // see javadoc for more info on the parameters
        g.drawImage(saabImage, saabPoint.x, saabPoint.y + 100, null); // see javadoc for more info on the parameters
        g.drawImage(scaniaImage, scaniaPoint.x, scaniaPoint.y + 200, null); // see javadoc for more info on the parameters
        /*
        for( int i = 0; i < images.size(); i++){
            g.drawImage(images.get(i), carPoint.x, carPoint.y, null); // see javadoc for more info on the parameters
            carPoint.y += 100;
        }
         */
    }
}

