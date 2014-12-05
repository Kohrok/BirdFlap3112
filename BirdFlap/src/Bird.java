/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nvf5039
 */
public class Bird extends BoardObj{
    
    final int ySpeed = 8;
    final int jumpHeight = -25;
    
    public Bird(String imgPath){
        super(imgPath);
    }
    
    public boolean checkCollision(){
        return false;
    }
    
    public void fall(){
        this.setLocation(this.getX(), this.getY() + ySpeed);
    }
    
    public void flap(){
        this.setLocation(this.getX(), this.getY() + jumpHeight);
    }
}
