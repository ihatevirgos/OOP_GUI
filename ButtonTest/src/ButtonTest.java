import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonTest extends JFrame{
    private JButton plainButton, fancyButton;

    //set up GUI
    public ButtonTest(){
        super ("Testing Buttons");

        //get content pane
        Container container = getContentPane();
        container.setLayout(new FlowLayout());

        //create button
        plainButton = new JButton("Plain Button");
        container.add(plainButton);

        //load original image for resize
        ImageIcon kirbyClosed = new ImageIcon("src/images/kirby closed mouth.jpg");
        ImageIcon kirbyOpen = new ImageIcon("src/images/kirbyOpenMouth.jpg");

        Image kirby1Orig = kirbyClosed.getImage();
        Image kirby2Orig = kirbyOpen.getImage();


        //resize
        Image resizedKirby1 = kirby1Orig.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        Image resizedKirby2 = kirby2Orig.getScaledInstance(50, 50, Image.SCALE_SMOOTH);

        Icon kirby1 = new ImageIcon(resizedKirby1);
        Icon kirby2 = new ImageIcon(resizedKirby2);

        fancyButton = new JButton ("kirby button ^_^", kirby1);
        fancyButton.setRolloverIcon(kirby2);
        container.add(fancyButton);

        //create instance of button handler
        ButtonHandler handler = new ButtonHandler();
        fancyButton.addActionListener(handler);
        plainButton.addActionListener(handler);

        //setup frame (FRIST THING TO DO)
        setSize(275, 150);
        ImageIcon image = new ImageIcon("src/images/kirby20x20.png");
        setIconImage(image.getImage());
        getContentPane().setBackground(new Color(0xEFB6D4));

        setVisible(true);
        setResizable(false);

    }

    private class ButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            JOptionPane.showMessageDialog(ButtonTest.this, "You pressed: " + event.getActionCommand());
        }
    }

    public static void main (String args[]){
        ButtonTest application = new ButtonTest();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}


