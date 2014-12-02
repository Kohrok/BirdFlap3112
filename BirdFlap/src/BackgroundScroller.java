/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
 
/**
 *
 * @author nvf5039
 * Derived from base code from http://www.nutt.net/2013/11/25/create-scrolling-background-java/
 */
public class BackgroundScroller extends Canvas {
    // Two copies of the background image to scroll
    private Background backOne, backTwo;
    private BufferedImage back;

    private final String BGONE = "daybg";
    private final String BGTWO = "daybg";
    
    public BackgroundScroller() {
        backOne = new Background(BGONE);
        backTwo = new Background(backOne.getImageWidth(), 0, BGTWO);
 
        setVisible(true);
    }

 
    @Override
    public void update(Graphics window) {
        paint(window);
    }
 
    public void paint(Graphics window) {
        Graphics2D twoD = (Graphics2D)window;
 
        if (back == null)
            back = (BufferedImage)(createImage(getWidth(), getHeight()));
 
        // Create a buffer to draw to
        Graphics buffer = back.createGraphics();
 
        // Put the two copies of the background image onto the buffer
        backOne.draw(buffer);
        backTwo.draw(buffer);
 
        // Draw the image onto the window
        twoD.drawImage(back, null, 0, 0);
    }
 
}