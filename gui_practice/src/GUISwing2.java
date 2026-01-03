import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;

public class GUISwing2 {

    public static void main (String[] args){
        /*
        //JFrame = a GUI window to add components to

        JFrame frame = new JFrame(); //instantiate frame
        frame.setTitle("JFrame Title");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exiting the application when pressing X button
        frame.setResizable(false); //cant resize the window (even maximize)
        frame.setSize(420, 420);


        ImageIcon image = new ImageIcon("src/images/kirby20x20.png"); //instantiate image icon
        frame.setIconImage(image.getImage()); //change the icon frame //di nagana amo
        frame.getContentPane().setBackground(new Color(0xEFB6D4)); //change bg color


        frame.setVisible(true);
        */

        //instantiate the myframe class

        MyFrame myFrame = new MyFrame();
    }
}
