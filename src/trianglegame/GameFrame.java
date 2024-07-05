package trianglegame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author nikoleta
 */
public class GameFrame extends JFrame {

    JMenuBar menuBar = new JMenuBar();
    JMenu gameMenu = new JMenu("Game");
    JMenu optionsMenu = new JMenu("Options");
    JMenu aboutMenu = new JMenu("Help");
    MyCanvas x = new MyCanvas(this);
    int number;

    public GameFrame() {
        this.setTitle("Triangle Game");                        //Frame including My canvas , the main frame of the game
        this.setBounds(150, 50, 800, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        this.setContentPane(x);
        this.addKeyListener(x);
        this.setJMenuBar(menuBar);

        menuBar.add(gameMenu);
        newMenuItem("Restart", gameMenu);
        newMenuItem("Exit", gameMenu);

        menuBar.add(aboutMenu);
        newMenuItem("About", aboutMenu);

    }

    public void newMenuItem(String string, JMenu menu) {            //Add items in menu bar and "give" them actions
        JMenuItem newItem = new JMenuItem(string);
        newItem.setActionCommand(string);

        if (string == "Restart") {
            newItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    dispose();
                    new TriangleGame();
                }
            });
        }

        if (string == "About") {
            newItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    JOptionPane.showMessageDialog(null, "Πατησε space ή up για να ξεκινησεις το παιχνιδι και ξανα space ή up για να αποφυγεις τα εμποδια!");

                }
            });
        }
        if (string == "Exit") {
            newItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    System.exit(0);
                }
            });
        }
        menu.add(newItem);
    }
}
