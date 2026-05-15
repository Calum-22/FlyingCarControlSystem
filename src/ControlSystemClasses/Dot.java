package ControlSystemClasses;

public class Dot {
    private int x;
    private int y;
    private char dir;
    private int vel;

    public Dot(int x, int y, char direction, int velocity){
        this.x = x;
        this.y = y;
        this.dir = direction;
        this.vel = velocity;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public char getDir(){
        return this.dir;
    }

    public int getVel(){
        return this.vel;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setDir(char dir) {
        this.dir = dir;
    }

    public void setVel(int vel) {
        this.vel = vel;
    }
}
