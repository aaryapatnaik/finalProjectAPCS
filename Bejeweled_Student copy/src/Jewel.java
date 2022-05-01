import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public abstract class Jewel {
	/**
	 * This spritesheet has all the images in the game.  Each subclass
	 * of Jewel, will use the spritesheet to open a subimage to be shared
	 * by all instances of that subclass.  See Emerald for example.
	 */
	private static Image spriteSheet;
	
	/** standardize the size of every Jewel */
	public static final int SQUARE_SIZE = 52;
	/** Color of this Jewel.  If another Jewel has the same Color
	 * then they are of the same type */
	private Color color;
	private Image[] images;
	private  boolean selected;
	
	public Jewel(Color c, Image i) {
		// this is an example of one constructor calling another.
		// Best practices would have you write any code once.  NEVER copy code.  
		// If you are copying code, you are copying bugs!
		this(c,new Image[]{i});
	}
	/**
	 * This constructor inputs an array of Images so that you 
	 * can animate your Jewel.  You will have to think about 
	 * how you plan on animating.
	 * @param c
	 * @param imgs
	 */
	public Jewel(Color c, Image[] imgs) {
		this.images = imgs; this.color = c;
		selected = false;
	}
	/** Retrieves the subimage from the spritesheet based on the 
	 * specified x,y,w, and h of bounding rectangle of the subimage
	 * Each Jewel has its own bounding rectangle
	 * @param x x-coord of upper-lefthand corner of bounding rectangle
	 * @param y y-coord of upper-lefthand corner of bounding rectangle
	 * @param w width of bounding rectangle
	 * @param h height of bounding rectangle
	 * @return Image that represents this Jewel
	 */
	protected static Image openImageFromSpriteSheet(int x, int y, int w, int h) {
		openSpriteSheet();
		return ((BufferedImage)spriteSheet).getSubimage(x,y,w,h).getScaledInstance(SQUARE_SIZE, SQUARE_SIZE, BufferedImage.SCALE_SMOOTH);
	}
	/**
	 * Opens the spritesheet if it hasn't already been opened.  This spritesheet
	 * will be shared by all Jewels
	 */
	private static void openSpriteSheet() {
		if(spriteSheet==null) {
			try {
				File f = new File("images/gemsheet.png");
				spriteSheet = ImageIO.read(f);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void draw(Graphics g, int row, int col) {
		g.drawImage(images[0], col*this.SQUARE_SIZE +BejeweledGrid.OFFSET_X,
				    row*this.SQUARE_SIZE +BejeweledGrid.OFFSET_Y,null);
		
	}
	
	@Override
	/**
	 * @return true if this Jewel has the same Color as the 
	 * specified Object (assuming non-null Jewel). 
	 * @param You must verify that the specified Object is not 
	 * null and that it is a Jewel.  Look up how to do this. 
	 */
	public boolean equals(Object obj) {
		if (obj==null) {
			return false;
		}
		try {
			Jewel o = (Jewel) obj;
			return this.color.equals(o.color);
		}
		catch (Exception e){

		}
		return false;
	}

}
