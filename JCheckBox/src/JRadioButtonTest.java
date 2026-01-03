import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JRadioButtonTest extends JFrame{

    private JTextField field;
    private Font plainFont, boldFont, italicFont, boldItalicFont;
    private JRadioButton plainButton, boldButton, italicButton, boldItalicButton;
    private ButtonGroup radioGroup;

    //create GUI and font
    public JRadioButtonTest(){
        super("RadioButton Test");

        //container
        Container container = getContentPane();
        container.setLayout(new FlowLayout());

        //setup jtextfield
        field = new JTextField("Watch the font style change", 25);
        container.add(field);

        //create radio button
        plainButton = new JRadioButton("Plain", true);
        container.add(plainButton);

        boldButton = new JRadioButton("Bold", false);
        container.add(boldButton);

        italicButton = new JRadioButton("Italic", false);
        container.add(italicButton);

        boldItalicButton = new JRadioButton("Bold&Italic", false);
        container.add(boldItalicButton);

        //create logical  relationship  betwee jradoibuttons (to force to select  only one option)
        radioGroup = new ButtonGroup();
        radioGroup.add(plainButton);
        radioGroup.add(boldButton);
        radioGroup.add(italicButton);
        radioGroup.add(boldItalicButton);



        plainFont = new Font("Serif", Font.PLAIN, 14);
        boldFont = new Font("Serif", Font.BOLD, 14);
        italicFont = new Font("Serif", Font.ITALIC, 14);
        boldItalicFont = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
        field.setFont(plainFont); //set initial font

        //register
        plainButton.addItemListener(new RadioButtonHandler(plainFont));
        boldButton.addItemListener(new RadioButtonHandler(boldFont));
        italicButton.addItemListener(new RadioButtonHandler(italicFont));
        boldItalicButton.addItemListener(new RadioButtonHandler(boldItalicFont));

        setSize(300, 100);
        setVisible(true);
    }

    private class RadioButtonHandler implements ItemListener {
        private Font font;

        public RadioButtonHandler(Font f){
            font = f;
        }
        public void itemStateChanged(ItemEvent event){
            field.setFont(font);
        }
    }

    public static void main(String[] args){
        JRadioButtonTest applicaiton = new JRadioButtonTest();
        applicaiton.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}
