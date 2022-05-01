import java.awt.*;

public class Orange extends Jewel {
	static Image orangeImage;// shared by all Emeralds

	// I found the locations below by a little bit of guess and
	// check to find a rectangle that bounded the image of the
	// Emerald.
	static final int O_X=0, // x coord of left side of a bounding rectangle
	                 O_Y=52*11, // y coord of the top of a bounding rect
					 O_W = 52, // width of bounding rectangle
					 O_H=52;// height of bounding rectangle
	//how to change color? is there a list with everything? or do we have to manually change the tuple
	public Orange() {
		super(Color.ORANGE, getImage());
	}

	private static  Image getImage() {
		if(orangeImage == null)// haven't opened the emerald image yet
			orangeImage= openImageFromSpriteSheet(O_X, O_Y, O_W, O_H);
		return orangeImage;
	}

}
