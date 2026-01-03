import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class CheckBoxTest extends JFrame{
    private JTextField field;
    private JCheckBox bold, italic;

    //set up GUI
    public CheckBoxTest(){
      super("JCheckBox Test");

      //get content pane
        Container container = getContentPane();
        container.setLayout(new FlowLayout());

        //setup JTextField and font
        field = new JTextField("Watch the font style change", 20);
        field.setFont(new Font("Serif", Font.PLAIN, 14));
        container.add(field);

        //create checkbox objects
        bold = new JCheckBox("Bold");
        container.add(bold);

        italic = new JCheckBox("Italic");
        container.add(italic);

        //register listeners (create method first)
        CheckBoxHandler handler = new CheckBoxHandler();
        bold.addItemListener(handler);
        italic.addItemListener(handler);

        //set up frame
        setSize(275, 100);
        setVisible(true);
    }


    private class CheckBoxHandler implements ItemListener{
        private int valBold = Font.PLAIN;
        private int valItalic = Font.PLAIN;

        //respond to event
        public void itemStateChanged(ItemEvent event){
            //for bold
            if (event.getSource() == bold)
                valBold = bold.isSelected() ? Font.BOLD : Font.PLAIN;

            //for italic
            if (event.getSource() == italic)
                valItalic = italic.isSelected() ? Font.ITALIC : Font.PLAIN;

            //set text field font
            field.setFont(new Font ("Serif", valBold + valItalic, 14));
        }
    }

    public static void main (String args[]){
        CheckBoxTest application = new CheckBoxTest();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
