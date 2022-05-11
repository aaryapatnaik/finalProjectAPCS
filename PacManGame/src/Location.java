public class Location {
    private int x;
    private int y;
    public Location(int xx, int yy){
        x = xx;
        y = yy;
    }
    public int getRow(){
        return x;
    }
    public int getCol(){
        return y;
    }
    public void setRow(int newx){
        x = newx;
    }
    public void setCol(int newy){
        y = newy;
    }
    public boolean equals(Location l){
        return (x==l.getRow())&&(y==l.getCol());
    }
}
