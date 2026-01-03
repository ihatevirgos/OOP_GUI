import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextAreaDemo extends JFrame {

    private JTextArea textArea1, textArea2;
    private JButton copyButton;


    public TextAreaDemo() {
        super ("TextArea Demo ya");

        Box box = Box.createHorizontalBox();

        String string = "This is a demo string to\n" +
        "Illustrate copying text \n from one text area to \n another text area using an \n external event";

        //setup textArea1
        textArea1 = new JTextArea (string, 10, 15);
        box.add(new JScrollPane(textArea1));

        //setup copybutton
        copyButton = new JButton("Copy >>>");
        box.add(copyButton);
        copyButton.addActionListener(
          new ActionListener() {
              public void actionPerformed(ActionEvent event) {
                  textArea2.setText(textArea1.getSelectedText()); //need to highloight the text before pressing the copy
                  // textArea2.setText(textArea1.getText()); doesnt neet to highlight
              }
          }
        );

        //setup text area 2
        textArea2 = new JTextArea(10,15);
        textArea2.setEditable(false);
        box.add(new JScrollPane(textArea2));

        //add to content pane
        Container container = getContentPane();
        container.add(box);

        setSize(425, 200);
        setVisible(true);
    }


    public static void main(String[] args) {

        TextAreaDemo application = new TextAreaDemo();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
