
import java.awt.*;
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
public class BoardObj extends Rectangle{
    
    Point startPos;
    ImageIcon icon;
    
    public BoardObj(){
        startPos = new Point(0,0);
        icon = new ImageIcon();
    }
}
