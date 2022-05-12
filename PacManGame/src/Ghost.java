import java.awt.*;
public class Ghost extends Moveable {

    private static boolean canBeEaten;
    //constructor for the normal ghost
    public Ghost(String na, Image[] imgsIdle, Image[] imgsActive, int dx, int dy, int spawnX, int spawnY) {
        super(na, imgsIdle, imgsActive, dx, dy, spawnX, spawnY);
        canBeEaten = false;
	}

    public boolean getBeEaten(boolean f) {
        return canBeEaten;
    }

    public void setBeEaten(boolean t) {
        canBeEaten = t;
    }

}