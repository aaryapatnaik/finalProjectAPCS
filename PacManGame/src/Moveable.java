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

	//private String name; will be used in main for distinction between ghosts
	
	//private Image[] images; for animating a character. The player should have 16 images, the ghost should have 32 images.
	//images 0-7 should be moving images for the player. 8-16 should be idle images, 2 in each direction. The ghost will
	//have a set of 8 images for moving normally, idle normal, and moving blue and idle blue. 

	private int direction = 2; //needed for turning methods in both ghost and player. 

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

	public Moveable(int spawnX, int spawnY) {
		rect = new Rectangle(spawnX, spawnY, 25, 25);
		this.direction = 2;
	}

	//getters in case it is needed for a comparison method of sorts
	//returns the integer x coordinate of the moveable
	public int getX() {
		return (int)(this.rect.x);
	}

	//returns the integer y coordinate of the moveable
	public int getY() {
		return (int)(this.rect.y);
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

	/*public Image[] getImageArray() {
        return this.images;
    }*/
  
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
	0 is right, 1 is left , 2 is up, and 3 is down*/
	// this method should probably be in the main pac man class. 
	public ArrayList<Integer> checkSurroundings(Moveable m, Cell[][] b) {
		int x = (int)(m.getX()); //divide by cell width
		int y = (int)(m.getY()); //divide by cell width

		ArrayList<Integer> dir = new ArrayList<Integer>();

		//check for null, then check if the cell is a solid wall
		//gameboard is a temporary name, it should be whatever the board name in main is
		if (b[y+1][x] != null && b[y+1][x].getWall() == true) {
			dir.add(2);
		}
		if (b[y-1][x] != null && b[y-1][x].getWall() == true) {
			dir.add(3);
		}
		if (b[y][x+1] != null && b[y][x+1].getWall() == true) {
			dir.add(0);
		}
		if (b[y][x-1] != null && b[y][x-1].getWall() == true) {
			dir.add(1);
		}
		return dir;
	}

	public int getDirection() {
		return direction;
	}

	//Set of direction changers. 
	public String turnRight() {
        this.direction = 0;
		return "Turned right!";
    }
    public String turnLeft() {
		this.direction = 1;
		return "Turned left!";
    }
    public String turnDown() {
		this.direction = 3;
		return "Turned down!";
    }
    public String turnUp() {
		this.direction = 2;
		return "Turned up!";
    }

	public void setDirection(int i) {
		this.direction = i;
	}

}