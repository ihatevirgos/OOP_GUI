import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CustomPanelTest extends JFrame{
    private JPanel buttonPanel;
    private CustomPanel myPanel;
    private JButton circleButton, squareButton;

    //setup GUI
    public CustomPanelTest() {
        super("Custom Panel Test");

        //create custom  drawing area
        myPanel = new CustomPanel();
        myPanel.setBackground(new Color (0xEFB6D4 ));

        //setup squareButton
        squareButton = new JButton("Square");
        squareButton.addActionListener(
                new ActionListener() {
                    //draw square
                    public void actionPerformed(ActionEvent event) {
                        myPanel.draw(CustomPanel.SQUARE);
                    }
                }
        );

        circleButton = new JButton("Circle");
        circleButton.addActionListener(
          new ActionListener() {
              public void actionPerformed(ActionEvent event) {
                  myPanel.draw(CustomPanel.CIRCLE);
              }
          }
        );

        //setup panel containing buttons
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1,2));
        buttonPanel.add(circleButton);
        buttonPanel.add(squareButton);

        //attach button panel and ciustom drwaing area to content pane
        Container container = getContentPane();
        container.add(myPanel, BorderLayout.CENTER);
        container.add(buttonPanel, BorderLayout.SOUTH);

        setSize(300, 150);
        setVisible(true);

    }



    public static void main(String[] args) {
        CustomPanelTest application = new CustomPanelTest();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
