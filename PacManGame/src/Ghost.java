public class Ghost extends Moveable {
    int color; //0-3, each corresponding to a different color ghost?
    //constructor for the ghost
    public Ghost(int dx, int dy, int locX, int locY, int ghostColor) {
        super(dx, dy, locx, locy);
        this.color = ghostColor;
    }

    public int getColor() { //color can be defaulted to zero if there is only one image sprite for ghost
        return color;
    }

    //if ghost.getColor()==certain number, draw corresponding ghost over the rectangle/moveable object?

}