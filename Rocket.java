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
    public static double dx, dy, d2x, d2y; //oldX, oldY;
    public static double x,y;
    ImageIcon rocket;
    ImageIcon temp = new ImageIcon();
    ImageIcon blow;
    int count;
    //ArrayList<Line2D.Double> lines = new ArrayList<Line2D.Double>();
    public Rocket(double x, double y, double dx, double dy, double d2x, double d2y ) throws IOException
    {
        
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        this.d2x = d2x;
        this.d2y = d2y;
        //oldX = x;
        //oldY = y;
        rocket = new ImageIcon(this.getClass()
            .getResource("rocket.gif"));
        blow = new ImageIcon(this.getClass()
            .getResource("blow.gif"));
        temp = rocket;
        count = 0;
    }

    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        g2.translate(0,700);
        int realx = (int) x;
        int realy = (int) y;
// //         Line2D.Double line = new Line2D.Double(oldX,oldY,x,y);
// //         Line2D.Double test = new Line2D.Double(x,y,x+100,y);
// //         g2.draw(test);
// //         lines.add(line);
//         for(Line2D.Double l : lines) {
//             g2.draw(line);
//             g2.fill(line);
//         }
        temp.paintIcon(this, g2, realx, realy);
    }

    public void actionPerformed(ActionEvent e)
    {
       try{
          if(x<750) {
              move();
              calc();
              repaint();
            }
          else {
              stop();
            }
       } catch(IOException bb){
           bb.printStackTrace();
       }
    }
    
    public void move() throws IOException{
        //oldX = x;
        //oldY = y;
        x+=0.2;
        y = -(calcY(x));        
    }
    
    public void calc(){
        System.out.print('\u000C');
        CalcBrain g = new CalcBrain();
        System.out.println("f(t) = -0.005(t-375)^2 + 700");
        System.out.println("v(t) = -0.01(t-375)");
        System.out.println("a(t) = -0.01");
        System.out.println();
        g.findMax();
        g.findZeros();
        System.out.println();
        g.findROC();
        System.out.println();
        g.findIRC(x);
        g.speed(x);
        g.findSpeed(x);
        System.out.println();
        g.findDP(x);
        g.findTD(x);
    }

    public double calcY(double x) {
        y = -0.005*(Math.pow((x-375),2)) + 700;
        return y;
    }
    
    public void stop(){
        y=20;
        x=751;
        temp = blow;
    }
    
}