import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Painter extends JFrame{
    private int pointCount = 0;

    //array of 1k java.awt.point references
    private Point points[] = new Point[1000];

    //setup gui
    public Painter() {
        super ("Paint program");

        //create label
        getContentPane().add(new JLabel("Drag the mouse to draw"), BorderLayout.SOUTH);

        addMouseMotionListener(
                new MouseMotionAdapter() {
                    public void mouseDragged(MouseEvent event) {
                        if (pointCount < points.length) {
                            points[pointCount] = new Point(event.getX(), event.getY());
                            ++pointCount;
                            repaint();
                        }
                    }
                }
        );

        setSize(300, 150);
        setVisible(true);
    }

    public void paint(Graphics g) {
        super.paint(g); //clears drawing area

        for(int index = 0; index < points.length; index++){
            if (points[index] != null){
                g.fillOval(points[index].x, points[index].y, 4, 4);
            }
        }

    }

    public static void main (String [] args) {
        Painter application = new Painter();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
