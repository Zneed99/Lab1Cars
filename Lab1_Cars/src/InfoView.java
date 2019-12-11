import javax.swing.*;
import java.util.ArrayList;


public class InfoView {
    JLabel infoLabel = new JLabel("Speed of cars:");
    ArrayList<AbstractCar> cars;
    void printLabels() {

        for(int i = 0; i < cars.size(); i++){
            JLabel speedLabel = new JLabel("" + cars.get(i).getCurrentSpeed());
            JLabel modelLabel = new JLabel(cars.get(i).getModelName());
        }
    }


}
