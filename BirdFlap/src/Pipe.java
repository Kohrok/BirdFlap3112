
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
    
    static int openHeight;
    int pipeStartX;
    final int HOLESIZE = 175;    // The size of the gap between pipes
    final int MINPIPE = 200;     // Minimum Pipe Height
    int x,y;    
      
    public Pipe(String imgPath, String position){
        super(imgPath);
        openHeight = (int)(Math.random() * ((512/3) - HOLESIZE)) + MINPIPE;     // Integer Min and the hole
        
        pipeStartX = 288 - this.icon.getIconWidth();    // The right edge of the screen
        x = pipeStartX;
        
        if (position == "top")
        {
            y = 0;
            this.setBounds(pipeStartX, y, this.icon.getIconWidth(), openHeight);
        }
        if (position == "bottom")
        {
            y = 512-openHeight;
            this.setBounds(pipeStartX, y, this.icon.getIconWidth(), openHeight);
        }
    }
    public void move(){
        x--;
        this.setBounds(this.x, this.y, this.icon.getIconWidth(), openHeight);
    }
    
    public void reset(){
        openHeight = (int)(Math.random() * ((512/3) - HOLESIZE)) + MINPIPE;     // Integer Min and the hole
        x = 288;
        this.setBounds(this.x, this.y, this.icon.getIconWidth(), openHeight);
    }
    
    public void restart(){
        openHeight = (int)(Math.random() * ((512/3) - HOLESIZE)) + MINPIPE;     // Integer Min and the hole
        x = 236;
        this.setBounds(this.x, this.y, this.icon.getIconWidth(), openHeight);
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
