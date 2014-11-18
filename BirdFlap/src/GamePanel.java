
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author njh5156
 */
public class GamePanel{
    
    ArrayList<Obstacle> Obstacles;
    Timer Tim;
    ImageIcon Background;
    BoardObj mainCharacter;
    
    
    public GamePanel(){
        Obstacles = new ArrayList();
        Background = new ImageIcon();
        mainCharacter = new BoardObj();

        ActionListener timeTracker = new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                // Action on timer tick goes here
            }
        };
        Tim = new Timer(1000, timeTracker);
        Tim.start();
    }
    
    public void actionPerformed(ActionEvent e){
        
    }
    
    public void scrollBackground(ImageIcon bg, ArrayList<Obstacle> Obstacles){
        
    }
    
    public ArrayList getObstacles(){
        return Obstacles;
    }
    
    public void addObstacles(){
        Obstacle another = new Obstacle();
        Obstacles.add(another);
    }
}
