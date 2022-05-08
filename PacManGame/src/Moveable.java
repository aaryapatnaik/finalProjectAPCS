import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.*;

/**
 * Generic GameObject.  This has all the BASIC attributes and behaviors that 
 * ALL game objects should have.  Many of these can be overridden in subclasses.
 * Those behaviors and attributes include:
 * 
 * Location and size (using a Rectangle for that)
 * Color (used for testing but not used in the final version)
 * speed in the x and speed in the y direction
 * The GameObject has the ability to move, detect collisions with 
 * another GameObject and the ability to draw itself on a Graphics
 * 
 * @author RHanson
 *
 */
public class Moveable {
	
	/** rect has info about location and dimension of this game object*/
	private Rectangle rect;


	private String name; // will be used in main for distinction between ghosts
	private Image[] imagesIdle;// for animating a character idle
	private Image[] imagesActive; //for animating an active character

	/** dx is how far this object moves this Rectangle each time I move
	 *  dy is how far this object moves the Rectangle each time I move
	 *  If dy or dx change between moves, it will look like this object is 
	 *  accelerating or decelerating in that direction.
	 */
	private double dx, dy;
	
	
	public Moveable(String na, Image[] imgsIdle, Image[] imgsActive, int dx, int dy, int spawnX, int spawnY) {
		name = na;
		rect = new Rectangle(spawnX, spawnY, 25, 25);
		imagesIdle = imgsIdle;
		imagesActive = imgsActive;
		this.dx = dx;
		this.dy = dy;
	}

	public double getDx() {
		return dx;
	}
	public void setDx(double dx) {
		this.dx = dx;
	}
	
	public double getDy() {
		return dy;
	}
	public void setDy(double dy) {
		this.dy = dy;
	}

	public void move() {
		moveX();
		moveY();
	}

	public void moveY() {
		rect.setLocation(rect.x+0, (int) (rect.y+dy));
	}
	
	public void moveX() {
		rect.setLocation((int) (rect.x+dx), rect.y+0);
	}

	public Rectangle getRect() {
		return rect;
	}

	public Image[] getIdleImageArray() {
        return this.imagesIdle;
    }

	public Image[] getActiveImagesArray() {
		return this.imagesActive;
	}
  
	
	/** Pretty basic right now, but can make this way better!*/
	public void drawIdle(Graphics g) {
		for (int i = 0; i < imagesIdle.length; i++) {
			Image img = imagesIdle[i];
			g.drawImage(img, (int)rect.getX(), (int)rect.getY(), null);
		}
	}
	
	public boolean collidedWith(Moveable go) {
		return this.rect.intersects(go.rect);
	}
}
