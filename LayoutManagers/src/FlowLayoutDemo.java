import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class FlowLayoutDemo extends JFrame{
    private JButton leftButton, centerButton, rightButton;
    private Container container;
    private FlowLayout layout;

    public FlowLayoutDemo() {
        super ("FlowLayout Demo");

        layout = new FlowLayout();

        container = getContentPane();
        container.setLayout(layout);

        //left button setup
        leftButton = new JButton("Left");
        container.add(leftButton);
        leftButton.addActionListener(
          new ActionListener() {
              //process leftButton event
              public void actionPerformed(ActionEvent event){
                  layout.setAlignment(FlowLayout.LEFT);

                  //realign attached components
                  layout.layoutContainer(container);
              }
          }
        );

        //centerbutton setup
        centerButton = new JButton("Center");
        container.add(centerButton);
        centerButton.addActionListener(
                new ActionListener() {
                    //process centerButton event
                    public void actionPerformed(ActionEvent event){
                        layout.setAlignment(FlowLayout.CENTER);

                        //realign attached components
                        layout.layoutContainer(container);
                    }
                }
        );

        //irghtbutton setup
        rightButton = new JButton("Right");
        container.add(rightButton);
        rightButton.addActionListener(
                new ActionListener() {
                    //process rightButton event
                    public void actionPerformed(ActionEvent event){
                        layout.setAlignment(FlowLayout.RIGHT);

                        //realign attached components
                        layout.layoutContainer(container);
                    }
                }
        );

        setSize(300, 75);
        setVisible(true);
    }

    public static void main (String[] args) {

        FlowLayoutDemo application = new FlowLayoutDemo();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
