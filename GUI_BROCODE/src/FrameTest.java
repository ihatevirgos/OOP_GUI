import javax.swing.*;
import java.awt.*;

public class FrameTest extends JFrame{
    JLabel label1;

    public FrameTest() {

        Container container = getContentPane();
        container.setLayout(new FlowLayout());

        ImageIcon sybau = new ImageIcon("src/images/guy_shutup.png");

        //label
        label1 = new JLabel("SYBAU </3");
        label1.setIcon(sybau);
        label1.setHorizontalTextPosition(JLabel.CENTER);
        label1.setVerticalTextPosition(JLabel.TOP);
        label1.setFont(new Font("Papyrus", Font.PLAIN, 25));

        container.add(label1);

        //this.setSize(420, 420);
        this.setTitle("Test Frame");


        ImageIcon kirbyImage = new ImageIcon("src/images/kirby20x20.png");
        this.setIconImage(kirbyImage.getImage());
        this.getContentPane().setBackground(new Color(0xEFB6D4));

        this.setResizable(false);
        this.setVisible(true);

    }

    public static void main(String[] args){

        FrameTest application = new FrameTest();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.pack();



    }
}
