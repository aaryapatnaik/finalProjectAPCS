
public class Cell {
    private boolean wall;
    private boolean containsFood;
    private boolean containsBigFood;
    /* private static int height = 30;
    private static int width = 30; */
    

    public Cell (boolean w, boolean cf){
        wall = w;
        containsFood = cf;

    }
    
    public Cell (boolean w, boolean cf, boolean bg){
        wall = w;
        containsFood = cf;
        containsBigFood = bg;
    }

    public void setFood (boolean cf) {
        containsFood = cf;
    }

    public void setBigFood (boolean cf) {
        containsBigFood = cf;
    }

    public void setWall (boolean w) {
        wall = w;
    }

    public boolean getWall() {
        return wall; //jutin was here
    }

    public boolean getContainsFood() {
        return containsFood;
    }

    public boolean getContainsBigFood() {
        return containsBigFood;
    }

}