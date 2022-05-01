import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.lang.Math;

public class BejeweledGrid {
	/**
	 * The 2D array of jewels
	 */
	private Jewel[][] jewels;

	/** Offsets for drawing the grid of Jewels.  The entire grid will
	 * be shifted to the right OFFSET_X and down OFFSET_Y
	*/
	public static final int OFFSET_X = 40, OFFSET_Y = 20;

	// This can play sounds!  I have loaded up the sounds below
	private SoundPlayer sp = new SoundPlayer();

	private static final int NUM_TYPES = 1;
	private int numdraws=0;
	private int numClicks=0;
	private int rr=-1;
	private int cc=-1;




	public BejeweledGrid() {
		jewels = new Jewel[10][10];// just for testing, you will change dimensions
		this.refill();// refill method fills empty spaces
		ArrayList<String>fileList = new ArrayList<String>();
		String root = "sounds/";
		fileList.add(root+"badmove.wav");//0
		fileList.add(root+"bomb explode.wav");//1
		fileList.add(root+"carddeal.wav");//2
		fileList.add(root+"cold wind.wav");//3
		fileList.add(root+"earthquake.wav");//4
		fileList.add(root+"gem hit.wav");//5
		fileList.add(root+"ice warning.wav");//6
		fileList.add(root+"rewind.wav");//7
		sp.loadFiles(fileList);
		for(int i = 0; i<fileList.size(); i++) {// play them all to see if working... cacophony!
			sp.play(i);
		}
	}

	/** directs each Jewel to draw itself.  The Jewel knows its row
	 * and column and can ask the grid for the offset info
	 * @param g Graphics context onto which the Jewels will draw themselves
	 */
	public void draw(Graphics g) {
		numdraws++;
		g.setColor(Color.red);
		//g.drawString("TESTING! Remove this! Num of draws "+numdraws,30,200 );
		for(int r = 0; r < this.jewels.length; r++) {
			for(int c = 0; c < jewels[r].length;c++) {
				Jewel j = jewels[r][c];
				if(j != null)
					j.draw(g,r,c);
			}
		}

	}

	//get array size for  2d array
//	public int[] getArraySize() {
//		int[] size = new int[2];
//		int[0]=this.jewels.length;
//
//
//	}

	//getters
	public int getArrayRows() {
		return jewels.length;
	}
	public int getArrayCols() {
		return jewels[0].length;
	}
	/** swaps the Jewels at the specified locations.  Also must
	 * tell the Jewels to set their rows and cols appropriately.
	 * @param r1 row of Jewel 1
	 * @param c1 col of Jewel 1
	 * @param r2 row of Jewel 2
	 * @param c2 col of Jewel 2
	 */

	public void swap(int r1, int c1, int r2, int c2) {
		//assuming that user didnt pick correct jewels?
		if ((Math.abs(r1-r2)==1 && c1==c2) || (Math.abs(c1-c2)==1 && r1==r2)) {
			Jewel tempOne = jewels[c1][r1];
			Jewel tempTwo = jewels[c2][r2];
			jewels[c1][r1] = null;
			jewels[c2][r2] = null;
			jewels[c1][r1] = tempTwo;
			jewels[c2][r2] = tempOne;
		}
		// more of course tell the Jewels they are changing locations
	}

	/**
	 * Creates an ArrayList<Jewel> of all Jewels Locations that are part of a
	 * three-in-a-row.  The same Jewel Location may appear in the List more than
	 * once.
	 * @return
	 */
	public ArrayList<Location> _3InARows() {
		ArrayList<Location> list = _3InARowHor();
		list.addAll(_3InARowVert());
		return list;
	}

	/**
	 *
	 * @return returns an ArrayList of Jewels that make up three or more in
	 *         a row vertically or an empty list if fewer than 3 in a row exist
	 */
	private ArrayList<Location> _3InARowVert() {
		ArrayList<Location> list = new ArrayList<> ();
		for (int r=0; r< jewels.length-2; r++) {
			for (int c=0; c<jewels[0].length; c++) {
				if (jewels[r][c]==jewels[r+1][c] && jewels[r][c]==jewels[r+2][c]) {
					list.add(new Location(r,c));
				}
			}
		}
		return list;
	}
	/**
	 * @return returns an ArrayList of Jewels that make up three or more in
	 *         a row horizontally or an empty list if fewer than 3 in a row exist
	 */
	private ArrayList<Location> _3InARowHor() {
		ArrayList<Location> list = new ArrayList<> ();
		for (int r=0; r< jewels.length; r++) {
			for (int c=0; c<jewels[0].length-2; c++) {
				if (jewels[r][c]==jewels[r][c+1] && jewels[r][c]==jewels[r][c+2]) {
					list.add(new Location(r,c));
				}
			}
		}
		return list;
	}
	/**
	 * @return returns an ArrayList of Jewels that make up three or more in
	 *         a row horizontally or an empty list if fewer than 3 in a row exist
	 */
//	private ArrayList<Location> _3InARowHor() {
//		ArrayList<Location> list = new ArrayList<> ();
//
//
//		return list;
//	}
	/**
	 * This method drops all Jewels that should drop...
	 * Basically, any Jewel that has no Jewel below it needs to
	 * be in a higher row.  Lots of ways to approach this.
	 * One possible algorithm:
	 * 	1. Start at bottom row.  If nothing there (null) then copy the jewel above it
	 * 	   into this location and delete the jewel above it (set to null).
	 *  2. Do this for every location in this row.
	 *  3. After this row is done, move to a higher (smaller indexed) row
	 * 	4. If any jewels moved down (a non-null moved to a null location), then there
	 *     may be more jewels that need to be dropped (think about a 3-in-a-row vertical).
	 *     So a good strategy might be count the number that moved, if that number is greater
	 * 	   than 0, then drop again (recursive).  This is costly, but some might find it easier than a
	 * 	   nested loop that is 3 layers deep.
	 */
	public void drop() {

	}

	/**
	 * Fill in any empty positions in the grid with randomly selected Jewel
	 */
	//iterate thru 2d array of each space in the grid and fill
	public void refill() {
		for (int row = 0; row < jewels.length; row++) {
			for (int col = 0; col < jewels[0].length; col++) {
				if (jewels[row][col] == null) {
					jewels[row][col] = randomJewel();
				}
			}
		}
	}

	/**
	 * Generates a random Jewel that will have its starting location
	 * at the specified row and col.
	 * @param r row where the Jewel will be placed
	 * @param c col where the Jewel will be placed
	 * @return random type of Jewel constructed at r,c
	 */


	private Jewel randomJewel() {

		int t = (int) (Math.random() * this.NUM_TYPES);
		if (t == 0) {
			int randColor = (int) (Math.random() * 7);
			if (randColor == 1) {
				return new Blue();
			}
			if (randColor == 2) {
				return new Emerald();
			}
			if (randColor == 3) {
				return new Orange();
			}
			if (randColor == 4) {
				return new Purple();
			}
			if (randColor == 5) {
				return new Ruby();
			}
			if (randColor == 6) {
				return new White();
			}
			else {
				return new Yellow();
			}
		}
		return null;// this should never happen
	}

	/**
	 * This method is called by the game when a click has been made
	 * on the panel.  Must determine if the click makes sense (is it
	 * a valid location, is there a Jewel at the location, can that
	 * Jewel be clicked).  If it is the first click, then note it and
	 * the next click will attempt a move (maybe).
	 * @param me
	 */
	public void justClicked(MouseEvent me) {
		int row=(me.getX()-OFFSET_X)/Jewel.SQUARE_SIZE;
		int col=(me.getY()-OFFSET_Y)/Jewel.SQUARE_SIZE;
		if (rr!=-1 && cc!=-1) {
			swap(rr,cc,row,col);
			rr=-1;
			cc=-1;
			row=-1;
			col=-1;
			for (int i=0; i< jewels.length; i++) {

			}
			_3InARowHor();
			_3InARowVert();
			refill();
		}
		else {
			rr=row;
			cc=col;
			_3InARowHor();
			_3InARowVert();
			refill();
		}

		sp.play(5);
	}
}
