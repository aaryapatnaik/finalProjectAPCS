
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

    public void draw(Graphics g) {
        if (counter == 0) {
            g.draw(imgs[0], (int)this.getX(), (int)this.getY(), null);
            counter++;
        }
        else if (counter == 0) {
            g.draw(imgs[1], (int)this.getX(), (int)this.getY(), null);
            counter--;
        }
    }

}