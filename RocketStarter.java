import javax.swing.JFrame;
import javax.swing.*;
/**
 * Write a description of class RocketStarter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RocketStarter
{
    public RocketStarter() {
    }
    public void start() {
        JFrame j = new JFrame("Calculus AB - Rocket");
        j.setSize(300,800);
        Rocket r = new Rocket(0,0,0,0,0,0);
        Timer t = new Timer(1000,r);
        j.add(r);
        t.start();
        j.setVisible(true);
    }
}
