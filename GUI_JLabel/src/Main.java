import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;


public class Main {

    public static void main (String[] args) {
        //JLabel = display area

        // Load original image
        ImageIcon originalIcon = new ImageIcon("images/guy_shutup.png");
        Image originalImage = originalIcon.getImage();

        // Resize the image
        Image resizedImage = originalImage.getScaledInstance(300, 200,Image.SCALE_SMOOTH);

        //instantiate
        ImageIcon image = new ImageIcon(resizedImage);
        JLabel label = new JLabel();
        ImageIcon logo = new ImageIcon("src/images/kirby20x20.png");
        Border border = BorderFactory.createLineBorder(Color.magenta, 3);



        //set label and icon
        label.setText("SYBAU </3"); // set text (pwede rin sa loob ng parenthesis sa taas)
        label.setIcon(image);

        //set the label position
        label.setHorizontalTextPosition(JLabel.CENTER); //moves the label bc it places at the right of the image as default
        label.setVerticalTextPosition(JLabel.TOP);
        label.setIconTextGap(25); // gap from text to img
        label.setBorder(border);

        //set label alignment
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);

        //label coordinates
        //label.setBounds(100, 100, 250, 250);

        //change label font and color
        label.setForeground(new Color(0x000080));
        label.setFont(new Font("Papyrus", Font.PLAIN, 20));

        //frame setup
        JFrame frame = new JFrame();
        frame.setTitle("SYBAU bru");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setSize(500, 500);
        //frame.setResizable(false);

        //frame.setLayout(null);

        frame.pack(); //resize to accomodate all of the components


        //window logo
        frame.setIconImage(logo.getImage());
        frame.getContentPane().setBackground(new Color (0xE791BF));

        frame.add(label);
        frame.pack(); //resize to accomodate all of the components

        frame.setVisible(true); // this should be at the last
    }

}