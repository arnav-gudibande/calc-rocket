import javax.swing.JFrame;
import java.io.IOException;
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
import java.util.Random;//imports all neccessary components
import javax.swing.ImageIcon;

public class Rocket extends JComponent implements ActionListener
{
    public double dx, dy, d2x, d2y;
    public double x,y;
    ImageIcon rocket;

    public Rocket(double x, double y, double dx, double dy, double d2x, double d2y ) throws IOException
    {
        
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        this.d2x = d2x;
        this.d2y = d2y;
        rocket = new ImageIcon(this.getClass()
            .getResource("rocket.gif"));
    }

    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        g2.translate(0,700);
        int realx = (int) x;
        int realy = (int) y;
        rocket.paintIcon(this, g2, realx, realy);
    }

    public void actionPerformed(ActionEvent e)
    {
       try{
           move();
       } catch(IOException bb){
           bb.printStackTrace();
       }
    }
    
    public void move() throws IOException{
        x+=0.2;
        y = -(calcY(x));
        System.out.println(x + "       " + y);
        repaint();
    }

    public double calcY(double x) {

        y = Math.pow((x-300),2);
        y = (-(y/10))+800;
        return y;
    }
    
}