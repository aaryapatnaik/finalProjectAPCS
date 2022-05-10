import java.awt.*;


public class Ghost extends Moveable {

    private static boolean isVulnerable;

    //constructor for the normal ghost
    public Ghost(String na, Image[] imgsIdle, Image[] imgsActive, int dx, int dy, int spawnX, int spawnY) {
        super(na, imgsIdle, imgsActive, dx, dy, spawnX, spawnY);
        isVulnerable = false;
	}

    public boolean getVulnerable() {
        return isVulnerable;
    }

    public void setVulnerable(boolean ent) {
        isVulnerable = ent;
    }

}