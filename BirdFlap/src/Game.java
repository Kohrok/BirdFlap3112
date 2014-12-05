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
public class Game extends JPanel implements ActionListener, KeyListener{
    
    private final int WIDTH = 288;
    private final int HEIGHT = 512;
    private JLayeredPane layeredPane;
    private final String BGPATH = "res/daybg.png";
    private final String BIRDPATH = "res/bird.gif";
    
    Timer Tim;
    JLabel bg, bird;    
    Bird doge;
        
    public Game() {
        
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
        
        doge = new Bird(BIRDPATH);
        doge.setBounds(0,0,doge.getIcon().getIconWidth(),doge.getIcon().getIconHeight());
        
        
        layeredPane.add(bg, new Integer (-1));    
        layeredPane.add(bird, new Integer (0));
        layeredPane.add(doge, new Integer (1));
        
        Tim = new Timer(200,this);
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

        doge.fall();
        System.out.println("repainting");
        bg.repaint();

    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if(keyCode==KeyEvent.VK_SPACE){
            doge.flap();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
