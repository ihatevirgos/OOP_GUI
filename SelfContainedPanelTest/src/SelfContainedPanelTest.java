import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

import com.SelfContainedPanelTestPackage.SelfContainedPanel;

public class SelfContainedPanelTest extends JFrame{
    private SelfContainedPanel myPanel;

    public SelfContainedPanelTest() {

        //setup
        myPanel = new SelfContainedPanel();
        myPanel.setBackground(new Color(0xEFB6D4));


        // Set explicit size
        myPanel.setPreferredSize(new Dimension(400, 200));
        // Optional: also set minimum size
        myPanel.setMinimumSize(new Dimension(300, 150));

        Container container = getContentPane();
        container.setLayout(new FlowLayout());
        container.add(myPanel);

        addMouseMotionListener(
                new MouseMotionListener() {
                    //handle
                    public void mouseDragged(MouseEvent event) {
                        setTitle("Dragging x = " + event.getX() + " ; y = " + event.getY());
                    }

                    public void mouseMoved(MouseEvent event) {
                        setTitle("Moving x = " + event.getX() + " ; y = " + event.getY());
                    }
                }
        );


        setSize(500, 300);
        setVisible(true);
    }


    public static void main(String[] args) {
        SelfContainedPanelTest application = new SelfContainedPanelTest();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
