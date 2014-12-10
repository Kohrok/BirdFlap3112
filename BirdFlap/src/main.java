import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 * @author nvf5039
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame frame = new JFrame("Flapping");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JComponent newContentPane = new Game();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.setSize(288, 512);
        //frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }
    
}

