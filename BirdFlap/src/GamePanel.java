
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
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
public class GamePanel extends JPanel{
    
    ArrayList<Obstacle> Obstacles;
    Timer Tim;
    BoardObj mainCharacter;
    
    
    public GamePanel(){
        setLayout(null);
        Obstacles = new ArrayList();

        mainCharacter = new BoardObj();

        ActionListener timeTracker = new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                int random = (int)Math.floor(Math.random() * 10) + 1;
                addObstacles(random);
                Obstacle.moveObstacle(Obstacles.get(0), 5);
            }
        };
        Tim = new Timer(1000, timeTracker);
        Tim.start();
    }
    
    public void actionPerformed(ActionEvent e){
        
    }
    
    public ArrayList getObstacles(){
        return Obstacles;
    }
    
    public void addObstacles(int number){
        Obstacle another = new Obstacle(number);
        Obstacles.add(another);
    }
}
