import java.awt.*;
public class Ghost extends Moveable {

    private static boolean canBeEaten;

    //constructor for the normal ghost
    public Ghost(String na, Image[] imgsIdle, Image[] imgsActive, int dx, int dy, int spawnX, int spawnY) {
        super(na, imgsIdle, imgsActive, dx, dy, spawnX, spawnY);
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
<<<<<<< HEAD
=======

    //draw method for vulnerable ghost
>>>>>>> 75bf6a1ea3e11495537f70df330ce4ea57a4cdd6
}