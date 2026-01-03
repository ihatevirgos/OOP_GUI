import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class LabelTest extends JFrame{
    private JLabel label1, label2, label3;  //declaring three JLabels

    //setting up GUI
    public LabelTest(){
        super("Testing JLabel");

        //get content pane and set layout
        Container container = getContentPane();
        container.setLayout(new FlowLayout());

        //JLabel constructor w a string argument
        label1 = new JLabel("Label with text");
        label1.setToolTipText("This is label1"); //text that appears when user moves cursor over JLabel
        container.add(label1);

        //JLabel constructor with string, icon, and alignment arguments
        ImageIcon originalIcon = new ImageIcon("images/shark.jpg");
        Image originalImage = originalIcon.getImage();
        Image resizedShark = originalImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH);

        Icon bug = new ImageIcon(resizedShark);
        label2 = new JLabel("Label with text and icon", bug, SwingConstants.LEFT);
        label2.setToolTipText("This is label2");
        container.add(label2);

        //JLabel constructor no arguments
        label3 = new JLabel();
        label3.setText("Label with icon and text at bottom");
        label3.setIcon(bug);
        label3.setHorizontalTextPosition(SwingConstants.CENTER);
        label3.setVerticalTextPosition(SwingConstants.BOTTOM);
        label3.setToolTipText("This is label3");
        container.add(label3);

        setSize(275, 200);
        setVisible(true);

    }

    public static void main(String args[]){
        LabelTest application = new LabelTest();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
