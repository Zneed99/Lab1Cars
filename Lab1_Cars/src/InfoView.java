import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class InfoView extends JPanel {


    private JLabel infoLabel = new JLabel("Speed of cars:");
    private  ArrayList<JLabel> modelAndSpeed = new ArrayList<>();
    private JPanel infoPanel = new JPanel();
    private ArrayList<AbstractCar> cars;

    public InfoView(int x, int y, ArrayList<AbstractCar> cars){
        this.setPreferredSize(new Dimension(x,y));
        this.setBackground(Color.GREEN);
        infoPanel.add(infoLabel,0);
        this.cars = cars;
        initComponents();
    }

    void clearJlabels(){
        for (Component component : this.getComponents()) {
            this.remove(component);
        }
    }
  void printLabels() {
        modelAndSpeed.clear();
      clearJlabels();
        for(int i = 0; i < cars.size(); i++){
            modelAndSpeed.add(new JLabel(cars.get(i).getModelName() + " " + cars.get(i).getCurrentSpeed() + " Km/h"));

        }
      for(int i = 0; i < modelAndSpeed.size(); i++){

          this.add(modelAndSpeed.get(i));

      }
      System.out.println(modelAndSpeed.size());
    }
    void updateLabels(){
        for(int i = 0; i < modelAndSpeed.size(); i++){

            modelAndSpeed.get(i).setText(cars.get(i).getModelName() + " " + cars.get(i).getCurrentSpeed() + " Km/h");

        }

    }

    private void initComponents() {
        infoPanel.add(infoLabel);
        this.add(infoLabel);
        printLabels();



    }
}
