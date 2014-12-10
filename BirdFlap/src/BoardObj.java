
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author njh5156
 */
public class BoardObj extends JLabel{
    
    boolean crash;
    ImageIcon icon;
    Rectangle r0, r1, r2;
    
    public BoardObj(){
        icon = new ImageIcon();
    }
    
    public BoardObj(String imgPath){
        icon = new ImageIcon(imgPath);
        this.setIcon(icon);
    }
    
    public boolean checkCollision(BoardObj b1, BoardObj b2){
        
        crash = false;
        
        r0 = new Rectangle(this.getBounds());
        r1 = new Rectangle(b1.getBounds());
        r2 = new Rectangle(b2.getBounds());
        
        if (r0.intersects(r1)){
            crash = true;
        }
        if(r0.intersects(r2)){
            crash = true;
        }
        return crash;
    }
}
