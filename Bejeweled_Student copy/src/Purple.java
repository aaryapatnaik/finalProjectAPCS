import java.awt.*;

public class Purple extends Jewel {
	static Image purpImage;// shared by all Emeralds

	// I found the locations below by a little bit of guess and
	// check to find a rectangle that bounded the image of the
	// Emerald.
	static final int P_X=0, // x coord of left side of a bounding rectangle
	                 P_Y=52*9, // y coord of the top of a bounding rect
					 P_W = 52, // width of bounding rectangle
					 P_H=52;// height of bounding rectangle
	//how to change color? is there a list with everything? or do we have to manually change the tuple
	public Purple() {
		super(Color.PINK, getImage());
	}

	private static  Image getImage() {
		if(purpImage == null)// haven't opened the emerald image yet
			purpImage= openImageFromSpriteSheet(P_X, P_Y, P_W, P_H);
		return purpImage;
	}

}
