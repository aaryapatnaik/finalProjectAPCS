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
	
	/*creates a new moveable with a name, image arrays, the horizontal distance change, the vertical distance change,
	and the intial location of the rectangle object*/

	public Moveable(String na, Image[] imgsIdle, Image[] imgsActive, int dx, int dy, int spawnX, int spawnY) {
		name = na;
		rect = new Rectangle(spawnX, spawnY, 25, 25);
		imagesIdle = imgsIdle;
		imagesActive = imgsActive;
		this.dx = dx;
		this.dy = dy;
	}

	//gets horizontal distance change per refresh
	public double getDx() {
		return dx;
	}

	//sets horizontal distance change per refresh
	public void setDx(double dx) {
		this.dx = dx;
	}
	
	//gets vertical distance change per refresh
	public double getDy() {
		return dy;
	}

	//sets vertical distance change per refresh
	public void setDy(double dy) {
		this.dy = dy;
	}

	//moves the rectangle object in both directions
	public void move() {
		moveX();
		moveY();
	}

	//changes the vertical location of the rectangle by dy
	public void moveY() {
		rect.setLocation(rect.x+0, (int) (rect.y+dy));
	}
	
	//changes the horizontal location of the rectangle by dx
	public void moveX() {
		rect.setLocation((int) (rect.x+dx), rect.y+0);
	}

	//returns the rectangle object
	public Rectangle getRect() {
		return rect;
	}

	//returns the array of images for the moveable when it is idle/still
	public Image[] getIdleImageArray() {
        return this.imagesIdle;
    }

	//returns the array of images for the moveable when it is active/moving
	public Image[] getActiveImagesArray() {
		return this.imagesActive;
	}
  
	
	/** Pretty basic right now, but can make this way better!*/
	/*rather nonfunctional as of right now. Intention was the display the images in the array when the player moves.
	did not consider different image arrays for different directions.*/
	public void drawIdle(Graphics g) {
		for (int i = 0; i < imagesIdle.length; i++) {
			Image img = imagesIdle[i];
			g.drawImage(img, (int)rect.getX(), (int)rect.getY(), null);
		}
	}

	public void drawActive(Graphics g) {
		for (int i = 0; i < imagesActive.length; i++) {
			Image img = imagesActive[i];
			g.drawImage(img, (int)rect.getX(), (int)rect.getY(), null);
		}
	}
	
	//should return true or false when the player collides with a ghost
	public boolean collidedWithMoveable(Moveable go) {
		return this.rect.intersects(go.rect);
	}

	//return true or false when the player collides with a wall
	public boolean collidedWithWall(Cell wall) {
		return this.rect.intersects(wall.Cell);
	}
}
