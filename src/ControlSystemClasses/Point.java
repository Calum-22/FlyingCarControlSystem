package ControlSystemClasses;

//java awt package has a point class already, either make a new version or investigate if the awt version is the same
public class Point {
    private int x;
    private int y;
    //don't think z is needed as lane has height

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
