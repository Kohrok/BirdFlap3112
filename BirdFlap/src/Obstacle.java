
import java.awt.Rectangle;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author njh5156
 */
public class Obstacle extends BoardObj{
    
    static JLabel top;
    static int openHeight;
    static JLabel bottom;
   
    int x,y;
    
    public JLabel getTop(){
        return top;
    }
    
    public JLabel getBottom(){
        return bottom;
    }
    
    public Obstacle(int height){
        top = new JLabel(new ImageIcon("res/toppipe.png"));
        bottom = new JLabel(new ImageIcon("res/bottompipe.png"));
        openHeight = height;
        setUp();
    }
    
    public Obstacle(){
        top = new JLabel(new ImageIcon("res/toppipe.png"));
        bottom = new JLabel(new ImageIcon("res/bottompipe.png"));
        openHeight = (int)(Math.random() * 10) + 1;
        setUp();
    }
    
    public void setUp(){
        switch(openHeight){
            case 1:x = 10;y = 10;break;
            case 2:x = 20;y = 10;break;
            case 3:x = 30;y = 10;break;
            case 4:x = 40;y = 10;break;
            case 5:x = 50;y = 10;break;
            case 6:x = 60;y = 10;break;
            case 7:x = 70;y = 10;break;
            case 8:x = 80;y = 10;break;
            case 9:x = 90;y = 10;break;
            case 10:x = 100;y = 10;break;
        }
        top.setBounds(288,0,52,x);
        bottom.setBounds(288,512,52,y);
    }
    
    public static void moveObstacle(Obstacle current, int speed){
        int topY = current.top.getY();
        int bottomY = current.bottom.getY();
        int topW = current.top.getWidth();
        int bottomW = current.bottom.getWidth();
        int topH = current.top.getHeight();
        int bottomH = current.bottom.getHeight();
        
        int nextXtop = current.top.getX() - speed;
        int nextXbottom = current.bottom.getX() - speed;
        
        current.top.setBounds(topY,nextXtop,topW,topH);
        current.bottom.setBounds(bottomY,nextXbottom,bottomW,bottomH);
    }
}
