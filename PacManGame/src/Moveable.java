import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.awt.*;
import java.awt.Color;
import java.awt.Graphics2D;

//https://docs.oracle.com/javase/7/docs/api/java/awt/Rectangle.html

public class Moveable {
	
	/** rect has info about location and dimension of this game object*/
	private Rectangle rect;

	private String name; // will be used in main for distinction between ghosts
	private Image[] images;// for animating a character idle

	private int direction; //needed for turning methods in both ghost and player. 

	//for testing
	private Color color = new Color(255, 255, 0);

	/** dx is how far this object moves this Rectangle each time I move
	 *  dy is how far this object moves the Rectangle each time I move
	 *  If dy or dx change between moves, it will look like this object is 
	 *  accelerating or decelerating in that direction.
	 */
	private double dx, dy;
	
	/*creates a new moveable with a name, image arrays, the horizontal distance change, the vertical distance change,
	and the intial location of the rectangle object.*/

	public Moveable(String na, Image[] imgs, int dx, int dy, int spawnX, int spawnY) {
		name = na;
		rect = new Rectangle(spawnX, spawnY, 25, 25);
		images = imgs;
		this.dx = dx;
		this.dy = dy;
		this.direction = 1; //the objects will start facing east
	}

	//getters in case it is needed for a comparison method of sorts
	//returns the integer x coordinate of the moveable
	public double getX() {
		return this.rect.x;
	}

	//returns the integer y coordinate of the moveable
	public double getY() {
		return this.rect.y;
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

	//sets location 
	public void setLocation(int x, int y) {
		this.rect.setLocation(x,y);
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
        return this.images;
    }
  
	//for testing
	public void testDraw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(color);
		g2.fill(rect);
	}
	
	/** Pretty basic right now, but can make this way better!*/
	/*rather nonfunctional as of right now. Intention was the display the images in the array when the player moves.
	did not consider different image arrays for different directions.*/
	public void drawIdle(Graphics g) {
		for (int i = 0; i < 2; i++) {
			Image img = images[i];
			g.drawImage(img, (int)rect.getX(), (int)rect.getY(), null);
		}
	}

	public void drawActive(Graphics g) {
		for (int i = 2; i < 4; i++) {
			Image img = images[i];
			g.drawImage(img, (int)rect.getX(), (int)rect.getY(), null);
		}
	}
	
	//should return true or false when the player collides with a ghost
	public boolean collidedWithMoveable(Moveable go) {
		return this.rect.intersects(go.rect);
	}

	/*return true or false when the player collides with a wall(probs don't need this).
	Probably is not working right now*/ 
	public boolean collidedWithWall(Cell wall) {
		return wall.getWall();
	}

	/*checks if there is a cell wall either above, below, to the left, to the right. Returns an arraylist with numbers
	that represent possible directions for both the player and the ghost. This can be used to randomly sort through direction
	choices for ghost and present possible directions for player when it hits a wall.
	0 is north, 1 is east, 2 is south, and 3 is west*/
	// this method should probably be in the main pac man class. 
	public ArrayList<Integer> checkSurroundings(Moveable m, Cell[][] b) {
		int x = (int)(m.getX()); //divide by cell width
		int y = (int)(m.getY()); //divide by cell width

		ArrayList<Integer> dir = new ArrayList();

		//check for null, then check if the cell is a solid wall
		//gameboard is a temporary name, it should be whatever the board name in main is
		if (b[y+1][x] != null && b[y+1][x].getWall() == true) {
			dir.add(0);
		}
		if (b[y-1][x] != null && b[y-1][x].getWall() == true) {
			dir.add(1);
		}
		if (b[y][x+1] != null && b[y][x+1].getWall() == true) {
			dir.add(2);
		}
		if (b[y][x-1] != null && b[y][x-1].getWall() == true) {
			dir.add(3);
		}

		return dir;
	}

	//Set of direction changers. 
	public String turnRight() {
        this.direction = 1;
		return "Turned right!";
    }
    public String turnLeft() {
		this.direction = 3;
		return "Turned left!";
    }
    public String turnDown() {
		this.direction = 2;
		return "Turned down!";
    }
    public String turnUp() {
		this.direction = 0;
		return "Turned up!";
    }

	public String setDirection(int i) {
		if (i < 0 && i > 4 ) {
			return "Invalid parameter";
		}
		this.direction = i;
		return "Changed direction to" + i;
	}

}
