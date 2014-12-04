/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.Timer;
/**
 *
 * @author nvf5039
 */
public class Game extends JPanel {
    
    private final int WIDTH = 288;
    private final int HEIGHT = 512;
    private JLayeredPane layeredPane;
    private final String BGPATH = "res/daybg.png";
    private final String BIRDPATH = "res/bird.gif";
    
    Timer Tim;

    
    public Game(){
        JLabel bg, bird;    
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
                
        //Create and set up the layered pane.
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(WIDTH, HEIGHT));
 
        //This is where the bird is
        Point origin = new Point(WIDTH/4 - 17, HEIGHT/2 - 12);
        
        bg = new JLabel(new ImageIcon(BGPATH));
        bird = new JLabel (new ImageIcon(BIRDPATH));
        
        bg.setBounds(0,0,bg.getIcon().getIconWidth(), bg.getIcon().getIconHeight());
        bird.setBounds(origin.x,origin.y,bird.getIcon().getIconWidth(), bird.getIcon().getIconHeight());
        
        layeredPane.add(bg, new Integer (-1));
        
        layeredPane.add(bird, new Integer (0));
 
        //Add control pane and layered pane to this JPanel.
        //add(Box.createRigidArea(new Dimension(0, 10)));
        add(layeredPane);

    }
    
    /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
        if (path != null) {
            return new ImageIcon(path);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
    
    /*
    public OuterFrame(){
        
        layeredPane = new JLayeredPane();
        getContentPane().add(layeredPane);
        //GamePanel Shell = new GamePanel();
        
        
        bg = new BackgroundScroller();
        ((Component)bg).setFocusable(true);
        //getContentPane().add(bg);
        layeredPane.add(bg, new Integer (-1));
        
        JButton j = new JButton("Text");
       
        // Shell.add(j);
        JButton k = new JButton("Second");
        
        layeredPane.add(j, new Integer (0));
        layeredPane.add(k, new Integer (1));
        
        layeredPane.setLayer(j,2);
        
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
    */
}
