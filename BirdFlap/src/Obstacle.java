
import java.awt.Rectangle;

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
    
    Rectangle top;
    int openHeight;
    Rectangle bottom;
    
    public void Obstacle(){
        top = new Rectangle();
        openHeight = 0;
        bottom = new Rectangle();
    }
    
    public Obstacle spawn(int height){
        openHeight = height;
        return this;
    }
}
