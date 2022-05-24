
import java.awt.*;

public class Player extends Moveable {

    /*player in and of itself is just a moveable object. The unique parameters like score and number of lives are
    already present in the main.*/


    //constructor for the player
    private int counter = 0;
    /* consider making the constructor empty (without parameters). Pay attention to Aarya's work to see 
    if that might work*/
    public Player(String na, Image[] imgs, int dx, int dy, int spawnX, int spawnY) {
        super(na, imgs, dx, dy, spawnX, spawnY);
	}

    /*public Player() {
        new Moveable? with predetermined names and image arrays
    }*/

    //draws images based on the direction of the player
    public void draw(Graphics g) {
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
}