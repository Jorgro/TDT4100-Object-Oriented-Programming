package Application;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class Survey implements Runnable {
    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Survey");
        frame.setPreferredSize(new Dimension(200, 300));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);


    }

    private void createComponents(Container container)
 {
    BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
    container.setLayout(layout);

    JCheckBox general = new JCheckBox("Hello there");
    JRadioButton kenobi = new JRadioButton("General Kenobi");
    kenobi.addActionListener(new MessageListener());
    JRadioButton sucker = new JRadioButton("i dont know");
    JLabel text = new JLabel("What is the right answer? ");
    ButtonGroup buttons = new ButtonGroup();
    buttons.add(kenobi);
    buttons.add(sucker);

    container.add(general);
    container.add(text);
    container.add(kenobi);
    container.add(sucker);


 }
    public static void main(String[] args) {
        Survey surv = new Survey();
        SwingUtilities.invokeLater(surv);
    }


}