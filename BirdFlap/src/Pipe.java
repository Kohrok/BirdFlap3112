
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
public class Pipe extends BoardObj{
    
    static int HOLESIZE;
    int pipeStartX;
    int openHeight;    // The size of the gap between pipes
    final int MINPIPE = 242;     // Minimum Pipe Height
    int x,y;    
      
    public Pipe(String imgPath, String position){
        super(imgPath);
        HOLESIZE = (int)(Math.random() * ((512/3)));
        openHeight = 40;     // Integer Min and the hole
        
        pipeStartX = 288 - this.icon.getIconWidth();    // The right edge of the screen
        x = pipeStartX;
        
        if (position == "top")
        {
            y = 0-openHeight;
            this.setBounds(pipeStartX, y, this.icon.getIconWidth(), this.icon.getIconHeight());
        }
        if (position == "bottom")
        {
            y = 512-openHeight;
            this.setBounds(pipeStartX, y, this.icon.getIconWidth(), this.icon.getIconHeight());
        }
    }
    public void move(){
        x-=3;
        this.setBounds(this.x, this.y, this.icon.getIconWidth(), this.icon.getIconHeight());
    }
    
    public void reset(){
        HOLESIZE = (int)(Math.random() * ((512/3)));     // Integer Min and the hole
        x = 288;
        this.setBounds(this.x, this.y, this.icon.getIconWidth(), this.icon.getIconHeight());
    }
    
    public void restart(){
        openHeight = (int)(Math.random() * ((512/3) - HOLESIZE)) + MINPIPE;     // Integer Min and the hole
        x = 236;
        this.setBounds(this.x, this.y, this.icon.getIconWidth(), this.icon.getIconHeight());
    }
    
    public boolean checkOffScreen(){
        return (this.x < -52);    // Returns true if offScreen
    }
    /*
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
    }*/
}
