public class Cell {
    private boolean wall;
    private boolean containsFood;
    private boolean containsBigFood;
    //private static double x, y;
    

    public Cell (boolean w, boolean cf){
        wall = w;
        containsFood = cf;
    }

    public void setFood (boolean cf) {
        containsFood = cf;
    }

    public void setBigFood (boolean cf) {
        containsBigFood = cf;
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