
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nvf5039
 */
public class Bird extends BoardObj implements ActionListener{
    
    final int ySpeed = 1;
    final int jumpHeight = -1;
    final int xPos = 25;
    final int BOOST = 40;
    long time, stop;
    
    public Bird(String imgPath){
        super(imgPath);
    }
    
    public void fall(){
        this.setLocation(this.getX(), this.getY() + ySpeed);
    }
    
    public int getYPos(){
        return this.getY();
    }
    public boolean isAlive(){
        boolean hit = false;
        return true;
    }

    public void flap(){
 
        this.setLocation(this.getX(), this.getY() - BOOST);
        // Timing still isn't working
        /*
        time = System.currentTimeMillis();
        stop = time + 250;
        
        
        Timer flyTime = new Timer(25, this);
        flyTime.addActionListener(this);
        flyTime.start();
        while (System.currentTimeMillis() < stop)
        {
            if (System.currentTimeMillis() > stop)
            {
                flyTime.stop();
            }
        }
        */
        
//        flyTime.stop();
        /*
        Timer startFly = new Timer(500, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Timer flyTime = new Timer(50, new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        setLocation(xPos, getYPos() + jumpHeight);
                        System.out.println("Jumping 5");

                    }
                });
                
                flyTime.start();
            }
        });
        
        startFly.setRepeats(false);
        startFly.start();
        */
    }
    
    public void actionPerformed(ActionEvent e) {
        this.setLocation(xPos, getYPos() + jumpHeight);
        System.out.println("Jumping 5");
    }
}
