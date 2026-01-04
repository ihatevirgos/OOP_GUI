import java.awt.event.*;
import javax.swing.*;
import java.awt.*;


public class Calculator extends JFrame implements ActionListener{

    //private JFrame calculatorFrame;
    private JTextField textField;
    private JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9,
                    bAdd, bSubtract, bMultiply, bDivide, bEqual, bClear, bDecimal;

    String input1, operator, input2; //store operator and operands


    public Calculator() {

        input1 = operator = input2 = "";

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception e) {
            System.err.println(e.getMessage());
        }

        textField = new JTextField(20);
        textField.setEditable(false);
        textField.setHorizontalAlignment(JTextField.RIGHT);

        // initialize buttons
        b0 = new JButton("0");
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");

        //initialize operator buttons
        bAdd = new JButton("+");
        bSubtract = new JButton("-");
        bMultiply = new JButton("*");
        bDivide = new JButton("/");

        bEqual = new JButton("=");
        bClear = new JButton("C");
        bDecimal = new JButton(".");



        //add action listener
        b0.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);

        bAdd.addActionListener(this);
        bSubtract.addActionListener(this);
        bMultiply.addActionListener(this);
        bDivide.addActionListener(this);

        bClear.addActionListener(this);
        bEqual.addActionListener(this);
        bDecimal.addActionListener(this);

        JPanel panel = new JPanel(new GridLayout(5,4,5,5));
        panel.setBackground(new Color(0xEFB6D4));

        //add elements to panel
        //row1
        panel.add(b7);
        panel.add(b8);
        panel.add(b9);
        panel.add(bDivide);

        //row2
        panel.add(b4);
        panel.add(b5);
        panel.add(b6);
        panel.add(bMultiply);

        //row3
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(bSubtract);

        //row4
        panel.add(b0);
        panel.add(bDecimal);
        panel.add(bEqual);
        panel.add(bAdd);

        //row5
        panel.add(bClear);// You might need to adjust positioning
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));


        // Add text field at the top
        setLayout(new BorderLayout());
        add(textField, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);


        setTitle("Calculator so cool hell yeah ! ! >3<");
        pack();   // Use pack() instead of setSize()
        setLocationRelativeTo(null); //center the window
        setBackground(new Color(0xEFB6D4));
        setVisible(true);
    }

    private void checkSpecialResult(double result) {
        if (result ==  67) {
            try {
                JOptionPane.showMessageDialog(this, "Six Seven",
                        "sixseven", JOptionPane.INFORMATION_MESSAGE,
                        new ImageIcon("src/images/sixseven.jpg"));
            } catch (Exception e) {
                // Text-only fallback
                JOptionPane.showMessageDialog(
                        this,
                        "✨ 42: The Answer to Everything! ✨",
                        "Special Result!",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        }
    }



    public void actionPerformed(ActionEvent e) {
        String value = e.getActionCommand();

        if((value.charAt(0) >= '0' && value.charAt(0) <= '9')  || value.charAt(0) == '.') {
            // Handle decimal point validation
            if (value.equals(".")) {
                if (!operator.equals("")) {
                    // We're in the second number
                    if (input2.contains(".")) {
                        return; // Already has a decimal point, ignore
                    }
                } else {
                    // We're in the first number
                    if (input1.contains(".")) {
                        return; // Already has a decimal point, ignore
                    }
                }
            }

            // If an operator is present, add to the second number
            if (!operator.equals(""))
                input2 = input2 + value;
            else
                input1 = input1 + value;

            textField.setText(input1 + operator + input2);
        }

        else if (value.charAt(0) == 'C') {
            //clear everything
            input1 = operator = input2 = "";

            //set value of the text
            textField.setText(input1 + operator + input2);
        }

        else if(value.charAt(0) == '=') {
            //calculate result
            if(!input1.equals("") && !operator.equals("") && !input2.equals("")) {
                double result = 0;
                double num1 = Double.parseDouble(input1);
                double num2 = Double.parseDouble(input2);


                if (operator.equals("+"))
                    result = num1 + num2;
                else if (operator.equals("-"))
                    result = num1 - num2;
                else if (operator.equals("*"))
                    result = num1 * num2;
                else if (operator.equals("/")){
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        textField.setText("Error: Division by zero");
                        input1 = operator = input2 = "";
                        return;
                    }
                }

                textField.setText(input1 + operator + input2 + " = " + result);

                checkSpecialResult(result);

                input1 = Double.toString(result);
                operator = input2 = "";
            }
        }

        else {
            //handle operators
            if(!input1.equals("")) {
                //if we alr have full calculation. calculate first
                if(!operator.equals("") && !input2.equals("")) {
                    double result = 0;
                    double num1 = Double.parseDouble(input1);
                    double num2 = Double.parseDouble(input2);


                    if (operator.equals("+"))
                        result = num1 + num2;
                    else if (operator.equals("-"))
                        result = num1 - num2;
                    else if (operator.equals("*"))
                        result = num1 * num2;
                    else if (operator.equals("/")) {
                        if (num2 != 0) {
                            result = num1 / num2;
                        } else {
                            textField.setText("Error: Division by zero");
                            input1 = operator = input2 = "";
                            return;
                        }
                    }

                    input1 = Double.toString(result);
                    input2 = "";
                }
                operator = value;
                textField.setText(input1 + operator + input2);
            }

        }



    }
}

