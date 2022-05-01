import java.awt.*;

public class Yellow extends Jewel {
	static Image yellowImage;// shared by all Emeralds

	// I found the locations below by a little bit of guess and
	// check to find a rectangle that bounded the image of the
	// Emerald.
	static final int Y_X=0, // x coord of left side of a bounding rectangle
	                 Y_Y=52*1, // y coord of the top of a bounding rect
					 Y_W = 52, // width of bounding rectangle
					 Y_H=52;// height of bounding rectangle
	//how to change color? is there a list with everything? or do we have to manually change the tuple
	public Yellow() {
		super(Color.YELLOW, getImage());
	}

	private static  Image getImage() {
		if(yellowImage == null)// haven't opened the emerald image yet
			yellowImage= openImageFromSpriteSheet(Y_X, Y_Y, Y_W, Y_H);
		return yellowImage;
	}

}
