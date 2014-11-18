/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Component;
import javax.swing.JFrame;
/**
 *
 * @author njh5156
 */
public class OuterFrame extends JFrame{
    
    public OuterFrame(){
        GamePanel Shell = new GamePanel();
        
        BackgroundScroller bg = new BackgroundScroller();
        ((Component)bg).setFocusable(true);
        getContentPane().add(bg);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
