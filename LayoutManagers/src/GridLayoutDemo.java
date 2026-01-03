import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class GridLayoutDemo extends JFrame implements ActionListener{

    private JButton buttons[];
    private final String names[] = {"one", "two", "three", "four", "five", "six"};
    private boolean toggle = true;
    private Container container;
    private GridLayout grid1, grid2;

    public GridLayoutDemo() {
        super("GridLayout Demo ya");

        //setup layouts
        grid1 = new GridLayout(2,3,5,5);
        grid2 = new GridLayout(3,2);

        //get content pane
        container = getContentPane();
        container.setLayout(grid1);

        //create and add buttons
        buttons = new JButton[names.length];

        for (int count = 0; count < names.length; count ++) {
            buttons[count] = new JButton(names[count]);
            buttons[count].addActionListener(this);
            container.add(buttons[count]);
        }

        setSize(300, 150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        if (toggle)
            container.setLayout(grid2);
        else
            container.setLayout(grid1);

        toggle = !toggle; //setting toggle to the opposite value
        container.validate();
    }


    public static void main (String [] args) {
        GridLayoutDemo application = new GridLayoutDemo();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
