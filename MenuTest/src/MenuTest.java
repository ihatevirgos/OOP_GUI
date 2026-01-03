import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuTest extends JFrame{

    private final Color colorValues[] = {Color.BLACK, Color.BLUE, Color.RED, Color.GREEN};
    private JRadioButtonMenuItem colorItems[], fonts[];
    private JCheckBoxMenuItem styleItems[];
    private JLabel displayLabel;
    private ButtonGroup fontGroup, colorGroup;
    private int style;


    public MenuTest() {
        super("Using JMenu");

        //setup file menu
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic('F'); //single quote dapat

        //setup about menu
        JMenuItem aboutItem = new JMenuItem("About");
        aboutItem.setMnemonic('A');
        fileMenu.add(aboutItem);
        aboutItem.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        JOptionPane.showMessageDialog(MenuTest.this, "This is an example\n of using menus",
                                "About", JOptionPane.PLAIN_MESSAGE);
                    }
                }
        );

        //setup exit menu item
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.setMnemonic('X');
        fileMenu.add(exitItem);
        exitItem.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        System.exit(0);
                    }
                }
        );

        // create menu bar and attach to menutest window
        JMenuBar bar = new JMenuBar();
        setJMenuBar(bar);
        bar.add(fileMenu);

        //create format menu
        JMenu formatMenu = new JMenu("Format");
        formatMenu.setMnemonic('r');

        //create color submenu
        String colors[] = {"Black", "Blue", "Red", "Green"};
        JMenu colorMenu = new JMenu("Color");
        colorMenu.setMnemonic('C');

        colorItems = new JRadioButtonMenuItem[colors.length];
        colorGroup = new ButtonGroup();
        ItemHandler itemHandler = new ItemHandler();

        //create color radio button mnu items
        for(int count = 0; count < colors.length; count ++) {
            colorItems[count] = new JRadioButtonMenuItem(colors[count]);
            colorMenu.add(colorItems[count]);
            colorGroup.add(colorItems[count]);
            colorItems[count].addActionListener(itemHandler);
        }

        //select first color menu item
        colorItems[0].setSelected(true);

        //addformat menu to menubar
        formatMenu.add(colorMenu);
        formatMenu.addSeparator();

        //create format submenu
        String fontNames[] = {"Serif", "Monospaced", "SanSerif"};

        JMenu fontMenu = new JMenu("Font");
        fontMenu.setMnemonic('n');

        fonts = new JRadioButtonMenuItem[fontNames.length];
        fontGroup = new ButtonGroup();

        //create Font radio button menu items
        for(int count = 0; count < fonts.length; count ++) {
            fonts[count] = new JRadioButtonMenuItem(fontNames[count]);
            fontMenu.add(fonts[count]);
            fontGroup.add(fonts[count]);
            fonts[count].addActionListener(itemHandler);
        }

        //select first as default
        fonts[0].setSelected(true);
        fontMenu.addSeparator();


        //setup style menu
        String styleNames[] = {"Bold", "Italic"};

        styleItems = new JCheckBoxMenuItem[styleNames.length];
        StyleHandler styleHandler = new StyleHandler();

        //create style checkbox
        for(int count = 0; count < styleNames.length; count ++){
            styleItems[count] = new JCheckBoxMenuItem(styleNames[count]);
            fontMenu.add(styleItems[count]);
            styleItems[count].addItemListener(styleHandler);
        }

        //put font menu in format menu
        formatMenu.add(fontMenu);

        //add format menu to menu bar
        bar.add(formatMenu);

        //setup label to display text
        displayLabel = new JLabel("Six seven", SwingConstants.CENTER);
        displayLabel.setForeground(colorValues[0]);
        displayLabel.setFont(new Font("Serif", Font.PLAIN, 67));

        getContentPane().setBackground(new Color(0xEFB6D4));
        getContentPane().add(displayLabel, BorderLayout.CENTER);


        setSize(600, 200);
        setVisible(true);
    }

    public static void main(String[] args) {

        MenuTest application = new MenuTest();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private class ItemHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            for (int count = 0; count < colorItems.length; count ++) {
                if (colorItems[count].isSelected()) {
                    displayLabel.setForeground(colorValues[count]);
                    break;
                }

            }
            //for font selection
            for (int count = 0; count < fonts.length; count ++) {
                if (event.getSource() == fonts) {
                    displayLabel.setFont(new Font(fonts[count].getText(), style, 67));
                    break;
                }
                repaint();
            }
        }


    }
    private class StyleHandler implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            style = 0;

            //check for bold selection
            if(styleItems[0].isSelected())
                style += Font.BOLD;

            //for italic
            if(styleItems[1].isSelected())
                style += Font.ITALIC;

            displayLabel.setFont(new Font(displayLabel.getFont().getName(), style, 67));
            repaint();
        }
    }
}
