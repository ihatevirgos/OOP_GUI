import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TestButton extends JFrame{
    //declare
    private JButton plainButton, kirbyButton;

    public TestButton() {
        super ("Button Testing");
        
        //get content pane
        Container container = getContentPane();
        container.setLayout(new FlowLayout());
        
        //additional step - adding photo in the button
        ImageIcon closedMouth = new ImageIcon("src/images/kirby closed mouth.jpg");
        ImageIcon openMouth = new ImageIcon("src/images/kirbyOpenMouth.jpg");

        Image closedImg = closedMouth.getImage();
        Image openImg = openMouth.getImage();

        Image resizedKirbyClosed = closedImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        Image resizedKirbyOpen = openImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);

        Icon kirby1 = new ImageIcon(resizedKirbyClosed);
        Icon kirby2 = new ImageIcon(resizedKirbyOpen);

        //button declaration
        JButton plainButton = new JButton("plain button");
        JButton kirbyButton = new JButton("kirby button ^_^", kirby1);

        kirbyButton.setRolloverIcon(kirby2); //when cursor is at the kirby button

        //add buttons to the container
        container.add(plainButton);
        container.add(kirbyButton);

        //action listener
        ButtonHandler handler = new ButtonHandler();
        plainButton.addActionListener(handler);
        kirbyButton.addActionListener(handler);


        //setup frame
        setSize(275, 170);
        ImageIcon image = new ImageIcon("src/images/kirby20x20.png");
        setIconImage(image.getImage());
        getContentPane().setBackground(new Color(0xEFB6D4));
        setVisible(true);
        setResizable(false);



    }

    //handler
    private class ButtonHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
           JOptionPane.showMessageDialog(TestButton.this, "u pressed " + event.getActionCommand());
        }

    }
    

    public static void main(String[] args){
        TestButton kirbinatorWindow = new TestButton();
        kirbinatorWindow.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
