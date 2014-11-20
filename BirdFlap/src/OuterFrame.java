/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;
/**
 *
 * @author njh5156
 */
public class OuterFrame extends JFrame implements ActionListener{
    
    private final int WIDTH = 288;
    private final int HEIGHT = 512;
    
    public BackgroundScroller bg;
    Timer Tim;
    
    public OuterFrame(){
        GamePanel Shell = new GamePanel();
        
        bg = new BackgroundScroller();
        ((Component)bg).setFocusable(true);
        getContentPane().add(bg);
        
        // Start timer test
        
        Tim = new Timer(16,this);
        Tim.addActionListener(this);
        Tim.start();
        System.out.println("Timer started");
        
        
        // End timer test
        
        // Adding this line makes the background not appear...
//        this.add(Shell);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(WIDTH, HEIGHT);
    }
    
    public void actionPerformed(ActionEvent evt) {
        Object obj = evt;
            bg.repaint();
        
    }
}
