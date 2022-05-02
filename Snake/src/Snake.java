import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.Rectangle;

public class Snake{

    private int row;
    private int col;
    private int dir; //0 = east, 1 = north, west = 2, south = 3
    private Color color;
    public static final int sq = 10;//size of a body part

    private ArrayList<Segment>  body = new ArrayList<>();

    public Snake() {
        body.add(new Segment(0,0,0,0,null));
    }

    public Snake(int x, int y, Color color, int dir) {
        body.add(new Head(x, y, sq, sq, color));
    }

    public void move() {
        Rectangle front = body.get(0).getRect();
        Segment last  = body.remove(body.size()-1);
        if (dir == 0) {
            body.add(0, new Segment(front.x+sq, front.y, sq, sq, last.getColor()));
        }
        else if (dir == 1) {

        }
        else if (dir == 2) {

        }
        else if (dir == 3) {

        }
    }

    public void draw(Graphics g) {
        for (Segment s:body) {
            s.draw(g);
        }
    }
    
}
