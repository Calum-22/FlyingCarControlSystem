package Graphics;

import ControlSystemClasses.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/*for now the test panel will do all the display logic, but for the actual visualisation
system, the control loop will be instatiated and have methods that control everything
*/
public class TestPanel extends JPanel implements ActionListener {
    static final int SCREEN_WIDTH = 1000;
    static final int SCREEN_HEIGHT = 600;
    static final int TICK_SPEED = 40;//find good value for this
    private Random rand = new Random();
    Timer timer;
    private boolean running;
    private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
    private ArrayList<Dot> dots = new ArrayList<Dot>();
    private final char[] DIRECTION = {'U','D','L','R'};

    TestPanel(){
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setBackground(Color.gray);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        start();
    }

    public void start(){
        timer = new Timer(TICK_SPEED,this);
        timer.start();
        running = true;
        makeDots();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g){
        //this is where stuff is added to the screen, this is just to test moving objects
        g.setColor(Color.red);
        for(int i=0;i<dots.size();i++){
            g.fillOval(dots.get(i).getX(),dots.get(i).getY(),10,10);
        }
    }

    public void makeDots(){
        int numDots = rand.nextInt(10,20);
        for(int i=0;i<numDots;i++){
            dots.add(new Dot(rand.nextInt(0,SCREEN_WIDTH),rand.nextInt(0,SCREEN_HEIGHT),DIRECTION[rand.nextInt(0,3)],rand.nextInt(1,20)));//x,y,direction(char u,d,r,l),velocity
        }
    }

    public void moveDots(){
        for(Dot dot: dots){
            switch(dot.getDir()){
                case 'U':
                    dot.setY(dot.getY()-dot.getVel());
                    break;
                case 'D':
                    dot.setY(dot.getY()+dot.getVel());
                    break;
                case 'L':
                    dot.setX(dot.getX()-dot.getVel());
                    break;
                case 'R':
                    dot.setX(dot.getX()+dot.getVel());
                    break;
            }
        }
        ArrayList<Dot> temp = new ArrayList<Dot>();
        for(Dot dot:dots){
            if(!(dot.getX() > SCREEN_WIDTH||dot.getX() < 0)&&!(dot.getY()>SCREEN_HEIGHT||dot.getY()<0)){
                temp.add(dot);
            }
        }
        dots = temp;
    }

    public void speedUp(){
        for(Dot dot:dots){
            dot.setVel((int)(dot.getVel()*2));
        }
    }

    public void slowDown(){
        for(Dot dot:dots){
            dot.setVel((int)(dot.getVel()/2));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e){
        //game loop
        if(running){
            moveDots();
        }
        repaint();
    }

    public class MyKeyAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e){
            switch(e.getKeyCode()){
                case KeyEvent.VK_T:
                    running = true;
                    break;
                case KeyEvent.VK_F:
                    running = false;
                    break;
                case KeyEvent.VK_M:
                    makeDots();
                    break;
                case KeyEvent.VK_S:
                    speedUp();
                    break;
                case KeyEvent.VK_D:
                    slowDown();
                    break;
            }
        }
    }

}
