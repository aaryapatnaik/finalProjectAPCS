
import java.awt.*;

public class Player extends Moveable {

    private int score;
    //constructor for the player

    public Player(String na, Image[] imgsIdle, Image[] imgsActive, int dx, int dy, int spawnX, int spawnY) {
        super(na, imgsIdle, imgsActive, dx, dy, spawnX, spawnY);
        score = 0;
	}

    public int getScore() {
        return score;
    }

    /* adds a score. this can be implemented after every refresh. If a player stands over a cell with pellet, add points to
    score. If a player collides with a ghost that is vulnerable, add points. the actual killing of the ghost can be dont somewhere else.*/

    public void addScore(int sc) {
        score+=sc;
    }

}