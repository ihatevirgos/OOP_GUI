import javax.swing.*;
import java.awt.*;

public class CustomPanel extends JPanel {
    public final static int CIRCLE = 1, SQUARE = 2;
    private int shape;

    //draw an oval or rec
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if(shape == CIRCLE)
            g.fillOval(50,10, 60, 60);
        else  if(shape == SQUARE)
            g.fillRect(50, 10, 60, 60);
    }

    //set shape value and repaint
    public void draw(int shapeToDraw) {
        shape = shapeToDraw;
        repaint();
    }
    
}
