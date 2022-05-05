public class Player extends Moveable {

    private BufferedImage img;

    //constructor for the player
    public Player(int dx, int dy, int locX, int locY, String name) {
        super(dx, dy, locx, locy);
        this.img = ImageIO.read(new File(name + ".png"));
    }

    public getImg() {
        return img;
    }
    /*might be easier for the player to be controlled by w a s d and use a scanner(i think that's what its called)
    to detect inputs instead of using the arrow keys?*/
}