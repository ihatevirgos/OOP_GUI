import java.awt.*;
import javax.swing.*;

public class OvalPanel extends JPanel{
    private int diameter = 10;

    // draw an oval in a specific diametere
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.fillOval(10, 10, diameter, diameter);
    }


    //validate and set diameter then repaint
    public void setDiameter(int newDiameter) {
        diameter = (newDiameter >= 0? newDiameter : 10);
        repaint();
    }

    public Dimension getPreferredSize(){
        return new Dimension(200, 200);
    }

    public Dimension getMinimumSize() {
        return getPreferredSize();
    }
}
