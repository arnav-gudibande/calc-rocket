import javax.swing.JFrame;
import java.awt.geom.*;
import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.JPanel;
import java.awt.Color;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.Timer;
import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.*;
import java.awt.BasicStroke;
import java.util.ArrayList;
import java.util.Random;

public class Rocket extends JComponent implements ActionListener
{
    public double dx, dy, d2x, d2y;
    public double x,y;
    Ellipse2D.Double rocket;

    public Rocket(int x, int y, int dx, int dy, )//the explicit parameters for the BAll constructor
    {
        
    }

    public void paintComponent(Graphics g)//necessary overriden method, the result of extending JFrame
    {
        Graphics2D g2 = (Graphics2D) g;
        ball = new Ellipse2D.Double(x, y, d, d);
        g2.setColor(setBallColor());
        g2.fill(ball);
    }

    public void actionPerformed(ActionEvent e)
    {
        move();//when the timer calls itself, move the ball
    }
    
    public void move(){
        repaint();//repaints the frame and also adds to the speed that the ball is moving in
        x+=dx;//speed is added to the dx
        y+=dy;//speed is added to dy
        if(y<=0) moveDown();//if any of the bounds are breached, then make the ball move accordingly
        if(y>=540)moveUp();
        if(x<=0) moveRight();
        if(x>=760) moveLeft();
    }

    public void moveUp()
    {
        dy += -1;//make the dx go down to move up in the frame
    }
    
}