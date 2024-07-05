package trianglegame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author nikoleta
 */
class TriangleGame implements ActionListener {

    JFrame frame = new JFrame("TRIANGLE GAME");
    JPanel start_screen = new JPanel();
    JButton start = new JButton("Start");
    JButton over = new JButton("Exit");
    JPanel menu2 = new JPanel();

    TriangleGame() {
        frame.setSize(500, 300);                                   //First frame
        frame.setLocation(400, 200);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        start_screen.setLayout(new BorderLayout());                //First Panel
        menu2.setLayout(new FlowLayout(FlowLayout.CENTER));
        start_screen.add(menu2, BorderLayout.CENTER);

        menu2.setBackground(Color.gray);

        start.addActionListener(this);
        start.setEnabled(true);
        menu2.add(start);
        over.addActionListener(this);
        over.setEnabled(true);
        menu2.add(over);
        frame.add(start_screen, BorderLayout.CENTER);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent click) {
        Object source = click.getSource();
        if (source == start) {
            frame.dispose();
            GameFrame x = new GameFrame();
            x.setVisible(true);

        }
        if (source == over) {
            System.exit(0);
        }

    }
}
