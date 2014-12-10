
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author nvf5039
 */
public class Bird extends BoardObj{
    
    boolean hit;
    final int BOOST = 60;
    final int JUMPHEIGHT = -1;
    final int XPOS = 25;
    final int YSPEED = 2;
    
    public Bird(String imgPath){
        super(imgPath);
    }
    
    public void fall(){
        this.setLocation(this.getX(), this.getY() + YSPEED);
    }
    public void flap(){
        this.setLocation(this.getX(), this.getY() - BOOST);
    }
    public int getYPos(){
        return this.getY();
    }
    public boolean isAlive(){
        hit = true;
        System.out.println(this.getY() - HEIGHT);
        if (this.getY() > 512)    // Bird is out of bounds
        {
            return false;
        }
        return hit;
    }

    
    /*
    public void actionPerformed(ActionEvent e) {
        this.setLocation(xPos, getYPos() + JUMPHEIGHT);
        System.out.println("Jumping 5");
    }
    */
}
