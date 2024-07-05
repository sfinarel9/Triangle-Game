package trianglegame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javafx.scene.canvas.Canvas;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;

public class MyCanvas extends JComponent implements KeyListener {

    boolean start_moving = false;
    int moving = 0;
    ReadFile rt = new ReadFile();
    private Canvas canvas;
    int num, count = 0, ythesis = 160, npoints;
    int ypoints[] = {ythesis + 10, ythesis - 20, ythesis + 10, ythesis + 40, ythesis + 10}; //Points for Rhombus
    Timer timer1;
    JFrame myframe;

    public MyCanvas(JFrame frame) {
        myframe = frame;
        setBackground(Color.red);

        timer1 = new Timer(3, new ActionListener() {   // timer for canvas movement
            public void actionPerformed(ActionEvent arg0) {
                move();
            }
        });
        timer1.start();
    }

    Polygon triangle;
    int myXpoints[] = {30, 70, 110};   //x points for triangle
    int y1 = 200, y2 = 140, y3 = 200;  //y points for triangle
    boolean color = true;

    public void paint(Graphics g) {
        g.setColor(Color.white);                           //BACKGROUND COLOR
        g.fillRect(0, 0, getWidth(), getHeight());

        if (color) {                                      //when you hit a rhombus it changes background colors between lightgray and pink
            g.setColor(Color.lightGray);
            g.fillRect(0, 0, getWidth(), getHeight());
        } else {
            g.setColor(Color.pink);
            g.fillRect(0, 0, getWidth(), getHeight());
        }

        count = 0;
        npoints = 3;
        g.setColor(Color.black);
        triangle = new Polygon(myXpoints, new int[]{y1, y2, y3}, npoints);
        g.fillPolygon(triangle);                                 //draw my triangle
        npoints = 5;                                             //set the points for Rhombus

        for (Shape s : rt.shapes) {
            switch (s.getType()) {
                case "rhombus":
                    int xpoints[] = {rt.xthesis.get(count), rt.xthesis.get(count) + 30, rt.xthesis.get(count) + 60, rt.xthesis.get(count) + 30, rt.xthesis.get(count)};
                    g.setColor(Color.red);
                    g.fillPolygon(xpoints, ypoints, npoints);  //draw my rhombus
                    count++;
                    break;
                case "square":
                    g.setColor(Color.blue);
                    g.fillRect(rt.xthesis.get(count), ythesis, 40, 40);  //draw my rect
                    count++;
                    break;
                case "circle":
                    g.setColor(Color.black);
                    g.fillOval(rt.xthesis.get(count), ythesis, 40, 40); //draw my circle
                    count++;
                    break;
                case "finalLine":
                    g.setColor(Color.black);
                    g.drawLine(rt.xthesis.get(count), 800, rt.xthesis.get(count), 0); //draw the final line
                    count++;
                    break;
            }
        }
    }

//CANVAS MOVING
    public void move() {
        for (int s = 0; s < rt.xthesis.size(); s++) {
            rt.xthesis.set(s, rt.xthesis.get(s) - moving);               //they come to the left
            repaint();
            if ((rt.xthesis.get(s) < 108) && (rt.xthesis.get(s) >= 30)) {        //if 2 shapes collide
                if (y1 > 140) {
                    switch (rt.shape.get(s)) {                                   //act according the type of each shape 
                        case "rhombus":
                            color = (!color);
                            repaint();
                            break;
                        case "square":
                            new Square(myframe);
                            timer1.stop();
                            break;
                        case "circle":
                            moving += 0.8;
                            break;
                        case "finalLine":
                            timer1.stop();
                            new Line(myframe);
                            break;
                    }
                }
            }
        }
    }

//TRIANGLE MOVING
    public void moveUp() {
        y1 = y1 - 150;
        y2 = y2 - 150;
        y3 = y3 - 150;
        repaint();

    }

    javax.swing.Timer movementtimer;

    public void moveDown() throws InterruptedException {

        movementtimer = new javax.swing.Timer(2, new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (y3 != 200) {
                    y1 = y1 + 1;
                    y2 = y2 + 1;
                    y3 = y3 + 1;
                    repaint();
                } else {
                    movementtimer.stop();
                }
            }
        });
        movementtimer.start();

    }

    //MANAGING MY GAME
    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("keyPressed");
        if ((e.getKeyCode() == KeyEvent.VK_SPACE) || (e.getKeyCode()==KeyEvent.VK_UP)) {
            if (!start_moving) {
                moving = 2;
                start_moving = true;
            }
            moveUp();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        try {
            moveDown();
        } catch (InterruptedException ex) {
            System.out.println("Problem");
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("keyTyped");
    }
}
