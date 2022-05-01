import java.awt.*;

public class White extends Jewel {
	static Image whiteImage;// shared by all Emeralds

	// I found the locations below by a little bit of guess and
	// check to find a rectangle that bounded the image of the
	// Emerald.
	static final int W_X=0, // x coord of left side of a bounding rectangle
	                 W_Y=52*3, // y coord of the top of a bounding rect
					 W_W = 52, // width of bounding rectangle
					 W_H=52;// height of bounding rectangle
	//how to change color? is there a list with everything? or do we have to manually change the tuple
	public White() {
		super(Color.WHITE, getImage());
	}

	private static  Image getImage() {
		if(whiteImage == null)// haven't opened the emerald image yet
			whiteImage= openImageFromSpriteSheet(W_X, W_Y, W_W, W_H);
		return whiteImage;
	}

}
