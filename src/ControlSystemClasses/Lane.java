package ControlSystemClasses;

public class Lane {
    private double maxVel;
    private double minVel;
    private double maxWidth;
    private double maxHeight;
    private int priority;
    private Point start; //may not need coordinates depending on how route ends up being implemented
    private Point end;

    public Lane(double maximumVelocity, double maximumWidth, double maximumHeight, int priority, Point start, Point end){
        this.maxVel = maximumVelocity;
        this.minVel = maximumVelocity*0.6; //or appropriate percentage
        this.maxWidth = maximumWidth;
        this.maxHeight = maximumHeight;
        this.priority = priority;
        this.start = start;
        this.end = end;
    }



    //getters
    public double getMaxVel() {
        return maxVel;
    }

    public double getMinVel() {
        return minVel;
    }

    public double getMaxWidth() {
        return maxWidth;
    }

    public int getPriority() {
        return priority;
    }

    public double getMaxHeight() {
        return maxHeight;
    }

    //setters
    public void setMaxHeight(double maxHeight) {
        this.maxHeight = maxHeight;
    }

    public void setMaxVel(double maxVel) {
        this.maxVel = maxVel;
    }

    public void setMaxWidth(double maxWidth) {
        this.maxWidth = maxWidth;
    }

    public void setMinVel(double minVel) {
        this.minVel = minVel;
    }
}
