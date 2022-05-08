
import java.awt.*;

public class Player extends Moveable {


    //constructor for the player

    public Player(String na, Image[] imgsIdle, Image[] imgsActive, int dx, int dy, int spawnX, int spawnY) {
        super(na, imgsIdle, imgsActive, dx, dy, spawnX, spawnY);
	}

    /*might be easier for the player to be controlled by w a s d and use a scanner(i think that's what its called)
    to detect inputs instead of using the arrow keys?*/
}