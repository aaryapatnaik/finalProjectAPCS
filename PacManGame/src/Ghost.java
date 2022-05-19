import java.awt.*;
public class Ghost extends Moveable {

    private static boolean canBeEaten;

    //constructor for the normal ghost
    public Ghost(String na, Image[] imgs, int dx, int dy, int spawnX, int spawnY) {
        super(na, imgs, dx, dy, spawnX, spawnY);
        canBeEaten = false;
	}

    //returns the vulnerability status of the ghost
    public boolean getBeEaten() {
        return canBeEaten;
    }

    //allows for a change in vulnerability status of the ghost
    public void setBeEaten(boolean t) {
        canBeEaten = t;
    }
    
}