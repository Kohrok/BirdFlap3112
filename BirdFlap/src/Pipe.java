
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
    
    static int holeSize;
    int openHeight;    // The size of the gap between pipes
    final int MINPIPE = 242;     // Minimum Pipe Height
    int pipeStartX, x,y;    
      
    public Pipe(String imgPath, String position){
        super(imgPath);
        holeSize = (int)(Math.random() * ((10))) * 10 + 50;     // Integer Min and the hole
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
        holeSize = (int)(Math.random() * ((10))) * 10 + 50;     // Integer Min and the hole
        x = 288;
        if (y <= 0){                                        // This is a top pipe
            y = 0 - holeSize;
        }
        else{                                               // This is a bottom pipe
            y = 512 - holeSize;
        }
        this.setBounds(this.x, this.y, this.icon.getIconWidth(), this.icon.getIconHeight());
    }
    
    public void restart(){
         holeSize = (int)(Math.random() * ((10))) * 10 + 50;     // Integer Min and the hole
        x = 236;
        if (y <= 0){                                        // This is a top pipe
            y = 0 - holeSize;
        }
        else{                                               // This is a bottom pipe
            y = 512 - holeSize;
        }
        this.setBounds(this.x, this.y, this.icon.getIconWidth(), this.icon.getIconHeight());
    }
    
    public boolean checkOffScreen(){
        return (this.x < -52);    // Returns true if offScreen
    }
}
