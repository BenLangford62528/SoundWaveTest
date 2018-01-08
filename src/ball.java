import javafx.scene.image.Image;

class ball {
    private double a;
    private double currentHeight;
    private Image image;
    private double u;
    private double s;
    private boolean atBottom;
    private boolean beep;
    private int x;

    double getCurrentHeight() {
        return currentHeight;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    ball(Image image, int x, double grav) {
        this.image = image;
        this.atBottom = false;
        this.u = 0;
        this.x = x;
        this.a = 9.81 * grav;
        this.currentHeight = 0;
        this.beep = false;
    }

    Image getImage() {
        return image;
    }

    double getU() {
        return u;
    }

    void setGrav(double gravity) {
        this.a = gravity;
    }

    void setBeep() {this.beep = false;}

    boolean getBeep() {return beep;}

    double getS() {
        return s;
    }

    void update(int max, double t) {
        if (!atBottom) {
            if (currentHeight > max - (180)){
                if(beep == true) {
                    currentHeight = 0;//= max- image.getHeight() * 1.4;
                } else {
                    currentHeight = max - 180;
                    u = -u+7;
                }
                //u = -u+7;
            }
            u = u + a * t;
            s = u * t + ((a * (t * t)) / 2);
            currentHeight += s;

        }
    }
}