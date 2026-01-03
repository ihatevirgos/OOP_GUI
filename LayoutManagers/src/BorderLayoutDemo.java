import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BorderLayoutDemo extends JFrame implements ActionListener {
    private JButton buttons[];
    private final String names[] = {"Hide North", "Hide South", "Hide East", "Hide West", "Hide Center"};
    private BorderLayout layout;

    public BorderLayoutDemo() {
        super ("Border Layout Demo");

        layout = new BorderLayout(5,5); // 5 px gap

        //content pane
        Container container = getContentPane();
        container.setLayout(layout);

        buttons = new JButton[names.length];

        for (int count = 0; count < names.length; count ++) {
            buttons[count] = new JButton(names[count]);
            buttons[count].addActionListener(this);
        }

        //placebuttons
        container.add(buttons[0], BorderLayout.NORTH);
        container.add(buttons[1], BorderLayout.SOUTH);
        container.add(buttons[2], BorderLayout.EAST);
        container.add(buttons[3], BorderLayout.WEST);
        container.add(buttons[4], BorderLayout.CENTER);

        setSize(300, 200);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent event) {
        for (int count = 0; count < buttons.length; count ++) {
            if (event.getSource() == buttons[count])
                buttons[count].setVisible(false); //deletes if button is pressed
            else
                buttons[count].setVisible(true);

            //relayout after pressing the button
            layout.layoutContainer(getContentPane());
        }


    }


    public static void main(String [] args) {
        BorderLayoutDemo application = new BorderLayoutDemo();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
