import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import com.github.sarxos.webcam.Webcam;
import java.awt.geom.*;
import javax.swing.Timer;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Engine
{
    public static void main(String[] args) throws IOException{
        
        JFrame j = new JFrame("Calculus AB - Rocket");
        j.setSize(800,800);
        Rocket r = new Rocket(0,1,0,0,0,0);
        Timer t = new Timer(10,r);
        
        j.add(r);
        t.start();
        j.setVisible(true);
    }
}
