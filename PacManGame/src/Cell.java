public class Cell {
    private boolean wall;
    private boolean containsFood;
    private static double x, y;
    

    public Cell (boolean w, boolean cf){
        wall = w;
        containsFood = cf;
    }

    public void setFood (boolean cf) {
        containsFood = cf;
    }

    public boolean getWall() {
        return wall;
    }

    public boolean getContainsFood() {
        return containsFood;
    }

}