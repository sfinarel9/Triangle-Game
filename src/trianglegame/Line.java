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
 * @author nikoleta
 */
public class Line extends Shape implements ShapeInterface, ActionListener {
    JPanel panel = new JPanel();
    JButton win = new JButton("Play Again");
    JFrame winframe = new JFrame();
    JFrame mainframe; 
    public Line(JFrame frame) {            //constructor used only when I want to use the End Game Frame
        mainframe = frame;
        action();
    }

    public Line(int x) {
        super("finalLine");
        super.setX(x);
        super.x = this.x;
    }
     @Override
    public void action() {                                              //Make the Win Frame
        
        JLabel label = new JLabel(" Congratulation! You Won!");

        label.setForeground(Color.darkGray);
        panel.setBackground(Color.lightGray);

        win.addActionListener(this);
        win.setEnabled(true);
        panel.setLayout(new GridLayout(2, 1));

        panel.add(label);
        panel.add(win);
        winframe.add(panel);
        winframe.setTitle("You Win");
        winframe.setBounds(450, 250, 300, 150);
        winframe.setVisible(true);
        winframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    @Override
    public void printShape() {
      System.out.println("Type: " + super.getType());  
    }

   
    @Override
    public void actionPerformed(ActionEvent click) {
        Object source = click.getSource();
        if (source == win) {
            winframe.dispose();
            mainframe.dispose();
            new TriangleGame();
        }
    }
    
}
