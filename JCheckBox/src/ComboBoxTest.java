import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class ComboBoxTest extends JFrame {
    private JComboBox imagesComboBox;
    private JLabel label;

   private String names[] = {"src/images/shark20x20.png", "src/images/tighnari20x20.png", "src/images/kirby20x20.png"};
   private Icon icons[] = {new ImageIcon(names[0]), new ImageIcon(names[1]), new ImageIcon(names[2])};

   //setting up gui
    public ComboBoxTest(){
        super ("Testing JComboBox");

        //content pane
        Container container = getContentPane();
        container.setLayout(new FlowLayout());

        //jcombobox
        imagesComboBox = new JComboBox(names);
        imagesComboBox.setMaximumRowCount(3);
        imagesComboBox.addItemListener(
                new ItemListener(){
                    public void itemStateChanged(ItemEvent event){
                        //if checkbox is selecteed
                        if(event.getStateChange() == ItemEvent.SELECTED)
                            label.setIcon(icons[imagesComboBox.getSelectedIndex()]);
                    }
                }
        );

        container.add(imagesComboBox);

        label = new JLabel(icons[0]);
        container.add(label);

        setSize(950,500);
        setVisible(true);
        setResizable(false);

    }

    public static void main (String [] args){
        ComboBoxTest application = new ComboBoxTest();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
