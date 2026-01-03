import javax.swing.*;
import java.awt.*;

public class PanelPractice extends JFrame{
    private JPanel redPanel, bluePanel, greenPanel;
    private JLabel label;

    public PanelPractice(){

        this.setTitle("Test Panel");


        ImageIcon kirbyImage = new ImageIcon("src/images/kirby20x20.png");
        this.setIconImage(kirbyImage.getImage());
        this.getContentPane().setBackground(new Color(0xEFB6D4));
        this.setLayout(null);
        this.setSize(750, 750);



        //label
        ImageIcon kirbyIcon = new ImageIcon("src/images/kirby closed mouth.jpg");
        label = new JLabel("bello");
        label.setIcon(kirbyIcon);
        label.setVerticalTextPosition(JLabel.BOTTOM);
        label.setHorizontalTextPosition(JLabel.CENTER);


        //red panel
        redPanel = new JPanel();
        redPanel.setBackground(Color.red);
        redPanel.setBounds(0, 0, 250, 250);
        redPanel.setLayout(new FlowLayout());

        //blue panel
        bluePanel = new JPanel();
        bluePanel.setBackground(Color.blue);
        bluePanel.setBounds(250, 0, 250, 250);
        bluePanel.setLayout(new FlowLayout());

        //greenPanel
        greenPanel = new JPanel();
        greenPanel.setBackground(Color.green);
        greenPanel.setBounds(0, 250, 500, 250);
        greenPanel.setLayout(new FlowLayout());


        //add components to panel
        greenPanel.add(label);


        //add component
        this.add(redPanel);
        this.add(bluePanel);
        this.add(greenPanel);


        this.setResizable(false);
        this.setVisible(true);
    }

    public static void main(String[] args){
        PanelPractice appli = new PanelPractice();
        appli.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
