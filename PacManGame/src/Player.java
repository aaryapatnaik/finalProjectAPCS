
import java.awt.*;

<<<<<<< HEAD
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

=======
public class Player {
    private int x;
    private int y;
    private int livesLeft;

    //constructor for the player

    public Player() {
        x = 0;
        y = 0;
        livesLeft = 3;
    }

    public void setX(int value) {
        x = value;
    }
    public void setY(int value) {
        y = value;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
>>>>>>> f3c2817cd5d29f6942dd960d3123109e2a026a87

    public int getLives() {
        return livesLeft;
    }
    public void liftLost() {
        livesLeft -= 1;
    }
}