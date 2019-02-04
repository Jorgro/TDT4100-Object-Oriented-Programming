

package Application.noticeboard;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class NoticeBoard implements Runnable {

    private JTextArea origin;
    private JTextArea destination;
    private JFrame frame;
    private GridLayout layout;
    private JButton button;

    public NoticeBoard() {
        this.origin = new JTextArea();
        this.destination = new JTextArea(); 
        this.layout = new GridLayout(3, 1);
        this.button = new JButton("Copy!");
    }




    @Override
    public void run() {
        frame = new JFrame("Notice board");
        frame.setPreferredSize(new Dimension(400, 200));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    public void createComponents(Container container) {
        container.setLayout(layout);

        ActionEventListener copier = new ActionEventListener(this.origin, this.destination);
        this.button.addActionListener(copier);

        container.add(this.origin);
        container.add(this.button);
        container.add(this.destination);
    }

    public static void main(String[] args) {
        NoticeBoard b = new NoticeBoard();
        SwingUtilities.invokeLater(b);
    }

}