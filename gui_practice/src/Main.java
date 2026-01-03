import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args){
        String name = JOptionPane.showInputDialog("Enter name ya");
        JOptionPane.showMessageDialog(null, "Hello " + name);

        int age = Integer.parseInt(JOptionPane.showInputDialog("Enter age")); //because joptionpane stores input as string
        JOptionPane.showMessageDialog(null, "You are " + age + " years old");

        JOptionPane.showMessageDialog(null, "Damn, you old af....");

        double height = Double.parseDouble(JOptionPane.showInputDialog("Enter height in cm")); //because joptionpane stores input as string
        JOptionPane.showMessageDialog(null, "You are " + height);
        JOptionPane.showMessageDialog(null, "bru u short af...");
    }
}
