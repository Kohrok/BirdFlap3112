/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Color;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
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

    private final String BGPATH = "res/daybg.png";
    private final String BIRDPATH = "res/bird.gif";
    private final String TPIPEPATH = "res/toppipe.png";
    private final String BPIPEPATH = "res/bottompipe.png";

    Action spaceBar;
    Bird doge;
    Font myFont;
    int score;
    JLabel bg, bird, scoreLabel;    
    JLayeredPane layeredPane;
    Object obj;
    Pipe top, bottom;
    Point origin;
    Timer Tim;
    
    public Game() {
        
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
                
        //Create and set up the layered pane.
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(WIDTH, HEIGHT));
 
        //This is where the bird is
        origin = new Point(WIDTH/4 - 17, HEIGHT/2 - 12);
        
        bg = new JLabel(new ImageIcon(BGPATH));
        bg.setBounds(0,0,bg.getIcon().getIconWidth(),bg.getIcon().getIconHeight());
        
        doge = new Bird(BIRDPATH);
        doge.setBounds(25,origin.y,doge.getIcon().getIconWidth(),doge.getIcon().getIconHeight());
        
        top = new Pipe(TPIPEPATH, "top");
        bottom = new Pipe(BPIPEPATH, "bottom");
        
        score = 0;
        
        myFont = new Font("SansSerif", Font.BOLD, 24);
        
        scoreLabel = new JLabel(""+score);
        scoreLabel.setBounds(130,25,50,25);
        scoreLabel.setFont(myFont);
        scoreLabel.setForeground(Color.WHITE);
        
        layeredPane.add(bg, new Integer (-1));      // BG is the lowest layer
        layeredPane.add(top, new Integer (0));      // Pipes and bird are the highest layer
        layeredPane.add(bottom, new Integer(0));
        layeredPane.add(doge, new Integer (0));     // Bird is the highest layer
        layeredPane.add(scoreLabel, new Integer (1));
        
        Tim = new Timer(25,this);
        Tim.addActionListener(this);

        System.out.println("Timer started");
        
        spaceBar = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                if(!Tim.isRunning()){
                    Tim.start();
                }
                doge.flap();
                //System.out.println("Space pressed");
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
    public void resetGame(){
        origin = new Point(WIDTH/4 - 17, HEIGHT/2 - 12);
        doge.setBounds(25,origin.y,doge.getIcon().getIconWidth(),doge.getIcon().getIconHeight());
        top.restart();
        bottom.restart();
        score = 0;
        scoreLabel.setText(""+score);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        obj = e;
        if (obj == Tim)
        {
            System.out.println("Tim count");
        }
        doge.fall();
        top.move();
        bottom.move();
        
        if(doge.checkCollision(top, bottom))
        {
            Tim.stop();
            JOptionPane.showMessageDialog(new JFrame(), "Crash! \n SCORE: "+score);
            resetGame();
            //This is where we close the game
        }
        if(!doge.isAlive()){
            Tim.stop();
            JOptionPane.showMessageDialog(new JFrame(), "You fell down! \n SCORE: "+score);
            resetGame();
        }
        
        if (top.checkOffScreen())   // Top and bottom are in parallel
        {
           top.reset();
           bottom.reset();
           score++;
           scoreLabel.setText(""+score);
        }
        bg.repaint();
    }

}
