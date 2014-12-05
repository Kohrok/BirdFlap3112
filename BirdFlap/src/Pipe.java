
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
   
    int x,y;    
      
    public Pipe(String imgPath, String position){
        super(imgPath);
        openHeight = (int)(Math.random() * 10) + 1;
        if (position == "top")
        {
            this.setBounds(288, 0, this.icon.getIconWidth(), this.icon.getIconHeight());
            this.setLocation(288,0);
        }
        if (position == "bottom")
        {
            this.setBounds(288, 512, this.icon.getIconWidth(), this.icon.getIconHeight());
            this.setLocation(288,0);
        }
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
