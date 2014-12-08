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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;
/**
 *
 * @author nvf5039
 */
public class Game extends JPanel implements ActionListener {
    
    private final int WIDTH = 288;
    private final int HEIGHT = 512;
    private JLayeredPane layeredPane;
    private final String BGPATH = "res/daybg.png";
    private final String BIRDPATH = "res/bird.gif";
    private final String TPIPEPATH = "res/toppipe.png";
    private final String BPIPEPATH = "res/bottompipe.png";
    
    Timer Tim;
    JLabel bg, bird;    
    Bird doge;
    
    Obstacle pipes;
    Pipe top, bottom;
    public Game() {
        
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
                
        //Create and set up the layered pane.
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(WIDTH, HEIGHT));
 
        //This is where the bird is
        Point origin = new Point(WIDTH/4 - 17, HEIGHT/2 - 12);
        
        bg = new JLabel(new ImageIcon(BGPATH));
        bg.setBounds(0,0,bg.getIcon().getIconWidth(),bg.getIcon().getIconHeight());
        
        doge = new Bird(BIRDPATH);
        doge.setBounds(25,origin.y,doge.getIcon().getIconWidth(),doge.getIcon().getIconHeight());
        
        top = new Pipe(TPIPEPATH, "top");
        bottom = new Pipe(BPIPEPATH, "bottom");
        //pipes = new Obstacle(HEIGHT/2); // Default height is halfway point of the screen

        layeredPane.add(bg, new Integer (-1));      // BG is the lowest layer
        layeredPane.add(top, new Integer (0));
        layeredPane.add(bottom, new Integer(0));
        layeredPane.add(doge, new Integer (0));     // Bird is the highest layer
        
        Tim = new Timer(25,this);
        Tim.addActionListener(this);
        Tim.start();

        System.out.println("Timer started");
        
        Action spaceBar = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                doge.flap();
                System.out.println("Space pressed");
            }
        };
        this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0),"check");
        this.getActionMap().put("check", spaceBar);
       
        add(layeredPane);

    }
    
    public Bird getBird (){
        return doge;
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
        
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e;
        if (obj == Tim)
        {
            System.out.println("Tim count");
        }
        doge.fall();
        top.move();
        bottom.move();
        if (top.checkOffScreen())   // Top and bottom are in parallel
        {
           top.reset();
           bottom.reset();
        }
        bg.repaint();

    }

}
