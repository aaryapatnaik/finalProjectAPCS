
import java.awt.*;

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

    public int getLives() {
        return livesLeft;
    }
    public void liftLost() {
        livesLeft -= 1;
    }
}