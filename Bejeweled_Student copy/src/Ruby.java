import java.awt.*;

public class Ruby extends Jewel {
	static Image rubyImage;// shared by all Emeralds

	// I found the locations below by a little bit of guess and
	// check to find a rectangle that bounded the image of the
	// Emerald.
	static final int R_X=0, // x coord of left side of a bounding rectangle
	                 R_Y=52*7, // y coord of the top of a bounding rect
					 R_W = 52, // width of bounding rectangle
					 R_H=52;// height of bounding rectangle
	//how to change color? is there a list with everything? or do we have to manually change the tuple
	public Ruby() {
		super(Color.RED, getImage());
	}

	private static  Image getImage() {
		if(rubyImage == null)// haven't opened the emerald image yet
			rubyImage= openImageFromSpriteSheet(R_X, R_Y, R_W, R_H);
		return rubyImage;
	}

}
