import java.awt.*;
public class Ghost extends Moveable {

    private boolean blue;
    private static int counter = 0;

    //constructor for the normal ghost
    public Ghost(int spawnX, int spawnY) {
        super(spawnX, spawnY);
        blue = false;
        super.setDirection(2);
	}

    //returns the vulnerability status of the ghost
    public boolean isBlue() {
        return blue;
    }

    //allows for a change in vulnerability status of the ghost
    public void setIsBlue(boolean p) {
        blue=p;
    }

    /*public void draw(Graphics g) {
        if (canBeEaten == false) {
            if (this.getDirection() == 3){
                if (counter == 0) {
                    g.draw(imgs[0], (int)this.getX(), (int)this.getY(), null);
                    counter++;
                }
                else if (counter == 1) {
                    g.draw(imgs[1], (int)this.getX(), (int)this.getY(), null);
                    counter--;
                }
            }
            if (this.getDirection() == 4) {
                if (counter == 0) {
                    g.draw(imgs[2], (int)this.getX(), (int)this.getY(), null);
                    counter++;
                }
                else if (counter == 1) {
                    g.draw(imgs[3], (int)this.getX(), (int)this.getY(), null);
                    counter--;
                }
            }
            if (this.getDirection() == 2||this.getDirection() == 0) {
                if (counter == 0) {
                    g.draw(imgs[4], (int)this.getX(), (int)this.getY(), null);
                    counter++;
                }
                else if (counter == 1) {
                    g.draw(imgs[5], (int)this.getX(), (int)this.getY(), null);
                    counter--;
                }
            }
        }
        if(canBeEaten == true) {
            if (this.getDirection() == 3){
                if (counter == 0) {
                    g.draw(imgs[6], (int)this.getX(), (int)this.getY(), null);
                    counter++;
                }
                else if (counter == 1) {
                    g.draw(imgs[7], (int)this.getX(), (int)this.getY(), null);
                    counter--;
                }
            }
            if (this.getDirection() == 4) {
                if (counter == 0) {
                    g.draw(imgs[8], (int)this.getX(), (int)this.getY(), null);
                    counter++;
                }
                else if (counter == 1) {
                    g.draw(imgs[9], (int)this.getX(), (int)this.getY(), null);
                    counter--;
                }
            }
            if (this.getDirection() == 2||this.getDirection() == 0) {
                if (counter == 0) {
                    g.draw(imgs[10], (int)this.getX(), (int)this.getY(), null);
                    counter++;
                }
                else if (counter == 1) {
                    g.draw(imgs[11], (int)this.getX(), (int)this.getY(), null);
                    counter--;
                }
            }
        }
    }*/

}