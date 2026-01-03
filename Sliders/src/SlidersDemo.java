import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class SlidersDemo extends JFrame{

    private JSlider diameterSlider;
    private OvalPanel myPanel;

    //setup
    public SlidersDemo() {
        super("Slider demo");

        myPanel = new OvalPanel();
        myPanel.setBackground(new Color(0xEFB6D4));


        //setup jslider
        diameterSlider = new JSlider(SwingConstants.HORIZONTAL, 0, 200, 10) ;
        diameterSlider.setMajorTickSpacing(10);
        diameterSlider.setPaintTicks(true);

        //register jslider
        diameterSlider.addChangeListener(
                new ChangeListener() {
                    public void stateChanged(ChangeEvent e) {
                        myPanel.setDiameter(diameterSlider.getValue());
                    }
                }
        );

        Container container = getContentPane();
        container.add(diameterSlider, BorderLayout.SOUTH);
        container.add(myPanel, BorderLayout.CENTER);

        setSize(200,270);
        setVisible(true);


    }




    public static void main(String[] args) {
        SlidersDemo application = new SlidersDemo();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
