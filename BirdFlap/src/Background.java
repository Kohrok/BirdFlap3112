/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author nvf5039
 * Derived from base code from http://www.nutt.net/2013/11/25/create-scrolling-background-java/
 */
public class Background {
    BufferedImage image;
    private final String DEFAULTSTRING = "bg.png";
    private int x;
    private int y;
    private final int BGSHIFT = 5;      // The number of pixels shifted per tick
 
    public Background() {
        this(0,0);
    }
 
    public Background(int x, int y ) {
        setX(x);
        setY(y);
        
        image = loadImage("bg.png");
    }
 
    public BufferedImage loadImage(String fileLocation) {
        try{
            return ImageIO.read( new File(fileLocation + ".png") );
        }
        catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    /**
     * Method that draws the image onto the Graphics object passed
     * @param window
     */
    public void draw(Graphics window) {
 
        // Draw the image onto the Graphics reference
        window.drawImage(image, getX(), getY(), image.getWidth(), image.getHeight(), null);
 
        shiftX();           // Shift left
        checkPos();         // Check to see if you've moved too far left
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void shiftX(){
        setX(this.x - BGSHIFT);
    }
    
    public void checkPos(){
        if (getX() <= image.getWidth() * -1)
        {
            setX(getX() + (image.getWidth() * 2));
        }
    }
    
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
    /*
    public int getImageWidth() {
        return image.getWidth();
    }
*/
}
