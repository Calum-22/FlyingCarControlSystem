package ControlSystemClasses;

import java.util.ArrayList;

public class Route {
    private ArrayList<Lane> lanes;
    private char size; //this system will be changed to accomodate more sizes, for now S,M,L
    private int[] start;
    private int[] end;

    public Route(char size, int[] start, int[] end){
        this.size = size;
        this.start = start;
        this.end = end;
        this.lanes = new ArrayList<Lane>();
        switch(this.size){
            case 'S':
                addLanes(1);
                break;
            case 'M':
                addLanes(2);
                break;
            case 'L':
                addLanes(3);
                break;
        }
    }

    private void addLanes(int size){
        if(size == 1){
            lanes.add(new Lane(75,0,0,1,this.start,this.end));
            lanes.add(new Lane(75,0,0,1,this.end,this.start));
        }
    }

    public int[] getStart(){
        return this.start;
    }

    public int[] getEnd(){
        return this.end;
    }
}
