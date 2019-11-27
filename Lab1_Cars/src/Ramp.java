public class Ramp {
    private boolean up;

    public boolean isUp() {
        return up;
    }

    public void changeStateOfRamp(){
        if (up){
            up = false;
        } else {
           up = true;
        }
    }

    public void setUp(boolean up) {
        this.up = up;
    }
}
