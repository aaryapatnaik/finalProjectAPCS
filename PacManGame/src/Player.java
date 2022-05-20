
import java.awt.*;

public class Player extends Moveable {

    /*player in and of itself is just a moveable object. The unique parameters like score and number of lives are
    already present in the main.*/


    //constructor for the player

    /* consider making the constructor empty (without parameters). Pay attention to Aarya's work to see 
    if that might work*/
    public Player(String na, Image[] imgs, int dx, int dy, int spawnX, int spawnY) {
        super(na, imgs, dx, dy, spawnX, spawnY);
	}

    /*public Player() {
        new Moveable? with predetermined names and image arrays
    }*/


}