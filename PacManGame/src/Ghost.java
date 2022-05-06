public class Ghost extends Moveable {
    private BufferedImage img; //0-3, each corresponding to a different color ghost?

    //constructor for the normal ghost
    public Ghost(int dx, int dy, int locX, int locY, int ghostColor) {
        super(dx, dy, locX, locY);
        this.img = ImageIO.read(new File("Ghost" + ghostColor + ".png"));
    }

    //constructor for fancy ghosts
    public Ghost(int dx, int dy, int locX, int locY, String name) {
        super(dx, dy, locX, locY) {
        this.img = ImageIO.read(new File(name + ".png"));
        }
    }

    public int getImg() { //color can be defaulted to zero if there is only one image sprite for ghost
        return img;
    }

    //if ghost.getColor()==certain number, draw corresponding ghost over the rectangle/moveable object?

}