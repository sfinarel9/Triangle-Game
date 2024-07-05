package trianglegame;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author sfinarel
 */
public class Square extends Shape implements ShapeInterface, ActionListener {

    JPanel panel = new JPanel();
    JButton again = new JButton("Play Again");
    JFrame endframe = new JFrame();
    JFrame mainframe;

    public Square(JFrame frame) {            //constructor used only when I want to use the End Game Frame
        mainframe = frame;
        action();
    }

    public Square(int x) {
        super("square");
        super.setX(x);
        super.x = this.x;
    }

    @Override
    public void printShape() {
        System.out.println("Type: " + super.getType());
    }

    @Override
    public void action() {                                              //Make the End Frame
        
        JLabel label = new JLabel(" Nice Try ! The game is over!");

        label.setForeground(Color.darkGray);
        panel.setBackground(Color.lightGray);

        again.addActionListener(this);
        again.setEnabled(true);
        panel.setLayout(new GridLayout(2, 1));

        panel.add(label);
        panel.add(again);
        endframe.add(panel);
        endframe.setTitle("END GAME");
        endframe.setBounds(450, 250, 300, 150);
        endframe.setVisible(true);
        endframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent click) {
        Object source = click.getSource();
        if (source == again) {
            endframe.dispose();
            mainframe.dispose();
            new TriangleGame();
        }
    }
}
