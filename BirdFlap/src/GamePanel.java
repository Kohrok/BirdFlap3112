
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
public class GamePanel {
    
    ArrayList<Obstacles> Obstacles;
    Timer Tim;
    ImageIcon Background;
    BoardObj mainCharacter;
    
    public GamePanel(){
        Obstacles = new ArrayList();
        Tim = new Timer();
        Background = new ImageIcon();
        mainCharacter = new BoardObj();
    }
    
    public void actionPerformed(ActionEvent e){
        
    }
    
    public void scrollBackground(ImageIcon bg, ArrayList<Obstacles> Obstacles){
        
    }
    
    public ArrayList getObstacles(){
        return Obstacles;
    }
    
    public void addObstacles(){
        Obstacles.add();
    }
}
