import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {


    //constructor
    MyFrame(){
        JFrame frame = new JFrame(); //instantiate frame
        this.setTitle("JFrame Title");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exiting the application when pressing X button
        this.setResizable(false); //cant resize the window (even maximize)
        this.setSize(420, 420);


        ImageIcon image = new ImageIcon("src/images/kirby20x20.png"); //instantiate image icon
        this.setIconImage(image.getImage()); //change the icon frame //di nagana amo
        this.getContentPane().setBackground(new Color(0xEFB6D4)); //change bg color


        this.setVisible(true);
    }
}
