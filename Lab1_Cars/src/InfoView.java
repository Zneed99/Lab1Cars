import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class InfoView extends JPanel {


    JLabel infoLabel = new JLabel("Speed of cars:");
    ArrayList<JLabel> modelAndSpeed = new ArrayList<>();

    JPanel infoPanel = new JPanel();
    ArrayList<AbstractCar> cars;

    public InfoView(int x, int y){
        this.setPreferredSize(new Dimension(x,y));
        this.setBackground(Color.GREEN);
        this.setLayout(new GridLayout(4,4));
        infoPanel.add(infoLabel,0);
        initComponents();
    }

    void printLabels() {
        int position = 1;
        for(int i = 0; i < cars.size(); i++){

            modelAndSpeed.add(new JLabel(cars.get(i).getModelName() + " " + cars.get(i).getCurrentSpeed()));
        }
        for(int i = 0; i < modelAndSpeed.size(); i++){
            infoPanel.add(modelAndSpeed.get(i));
            position++;

        }

        /*for(int i = 0; i < cars.size(); i++){
            String modelSpeed = cars.get(i).getModelName() + " : " + cars.get(i).getCurrentSpeed();
            modelAndSpeed.get(i).setText(modelSpeed);
        }

         */

    }
    private void initComponents() {

       // this.setPreferredSize(new Dimension(X,Y));
        //this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));


        infoPanel.setLayout(new BorderLayout());
        infoPanel.add(infoLabel, BorderLayout.PAGE_START);
        infoPanel.add(infoLabel, BorderLayout.PAGE_END);
        this.add(infoLabel);

    }

}
