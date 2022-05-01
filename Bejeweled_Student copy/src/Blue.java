import java.awt.*;

public class Blue extends Jewel {
	static Image blueImage;// shared by all Emeralds

	// I found the locations below by a little bit of guess and
	// check to find a rectangle that bounded the image of the
	// Emerald.
	static final int B_X=0, // x coord of left side of a bounding rectangle
	                 B_Y=52*5, // y coord of the top of a bounding rect
					 B_W = 52, // width of bounding rectangle
					 B_H=52;// height of bounding rectangle
	//how to change color? is there a list with everything? or do we have to manually change the tuple
	public Blue() {
		super(Color.BLUE, getImage());
	}

	private static  Image getImage() {
		if(blueImage == null)// haven't opened the emerald image yet
			blueImage= openImageFromSpriteSheet(B_X, B_Y, B_W, B_H);
		return blueImage;
	}

}
