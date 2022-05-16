import java.awt.*;
public class Ghost extends Moveable {

    private static boolean canBeEaten;

    //constructor for the normal ghost
    public Ghost(String na, Image[] imgsIdle, Image[] imgsActive, int dx, int dy, int spawnX, int spawnY) {
        super(na, imgsIdle, imgsActive, dx, dy, spawnX, spawnY);
        canBeEaten = false;
	}

<<<<<<< HEAD
    public Location getLocation(){
        return l;
    } 

    
=======
    //returns the vulnerability status of the ghost
    public boolean getBeEaten() {
        return canBeEaten;
    }

    //allows for a change in vulnerability status of the ghost
    public void setBeEaten(boolean t) {
        canBeEaten = t;
    }
>>>>>>> b049d8c362eb7384f48e651c5fad34f9d6752b42
}