import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class ListTest extends JFrame{
    private JList colorList;
    private Container container;

    private final String colorNames[] = {"Black", "Blue", "Red", "Yellow", "White"};
    private final Color colors[] = {Color.BLACK, Color.BLUE, Color.RED, Color.YELLOW, Color.WHITE};

    //setup GUI
    public ListTest(){
        super("List Test");

        //get content pane
        container = getContentPane();
        container.setLayout(new FlowLayout());

        //create list with color names array
        colorList = new JList(colorNames);
        colorList.setVisibleRowCount(5);

        colorList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //not allowing multiple selections

        //add scrollpane
        container.add(new JScrollPane(colorList));
        colorList.addListSelectionListener(new ListSelectionListener() {
                                               //handler
                                               public void valueChanged(ListSelectionEvent event) {
                                                   container.setBackground(colors[colorList.getSelectedIndex()]);
                                               }
                                           });


        setSize(350, 150);
        setVisible(true);


    }


    public static void main (String[] args){
        ListTest application = new ListTest();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
