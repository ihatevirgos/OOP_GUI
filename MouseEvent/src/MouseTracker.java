import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MouseTracker extends JFrame implements MouseListener, MouseMotionListener{

    private JLabel statusBar;

    //setup gui
    public MouseTracker() {
        super ("Demonstrating Mouse Events");

        statusBar = new JLabel("yahoo");
        getContentPane().add(statusBar, BorderLayout.SOUTH);

       addMouseListener(this);
       addMouseMotionListener(this);

        setSize(575, 300);
        setVisible(true);
    }

    public void mouseClicked(MouseEvent event) {
        statusBar.setText("Clicked at [" + event.getX() + ", " + event.getY() + "]");
    }

    public void mousePressed(MouseEvent event) {
        statusBar.setText("Pressed at [" + event.getX() + ", " + event.getY() + "]");
    }

    public void mouseReleased(MouseEvent event) {
        statusBar.setText("Released at [" + event.getX() + ", " + event.getY() + "]");
    }

    public void mouseEntered(MouseEvent event) {
        statusBar.setText("Entered at [" + event.getX() + ", " + event.getY() + "]");
        getContentPane().setBackground(new Color (0XEFB6D4));
    }

    public void mouseExited(MouseEvent event) {
        statusBar.setText("Mouse outside the window");
        getContentPane().setBackground(Color.WHITE);
    }

    public void mouseMoved(MouseEvent event) {
        statusBar.setText("Moved at [" + event.getX() + ", " + event.getY() + "]");
    }

    public void mouseDragged(MouseEvent event) {
        statusBar.setText("Dragged at [" + event.getX() + ", " + event.getY() + "]");
    }




    public static void main(String args[]) {
        MouseTracker application = new MouseTracker();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
