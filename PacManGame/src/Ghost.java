import java.awt.*;
public class Ghost extends Moveable {
    private Location l;
    //constructor for the normal ghost
    public Ghost(int x, int y){
        l = new Location(x, y);
	}

    public Location getLocation(){
        return l;
    }
}