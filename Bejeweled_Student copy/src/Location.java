
/**
 * This class encapsulates the row and column of a location
 * in a 2D array.  Write the entire class using appropriate 
 * class design concepts.
 */
import java.awt.event.MouseEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Location {
    private int row;
    private int col;

    public Location(int row, int col) {
        this.row=row;
        this.col=col;
    }

    public int getRow() {
        return row;
    }
    public int getCol() {
        return col;
    }

    public int[] getLoc() {
        int[] loc = new int[2];
        loc[0]=row;
        loc[1]=col;
        return loc;
    }


    //is adjacent method
//    public int getMouseX(MouseEvent e) {
//        return e.getX();
//    }
//    public int getMouseY(MouseEvent e) {
//        return e.getY();
//    }
}
