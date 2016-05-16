import java.io.*;
import java.util.*;

public class CalcBrain
{
    public double max;
    public ArrayList<Double> zeros = new ArrayList<Double>();

    public void findMax()
    {
        for(int i=0; i<750; i++){
            double deriv = -0.01 * (i-375);
            if(deriv==0) max = i;
        }
        System.out.println("Max Height Attained - time = "+max+" is "+calcY(max)+" meters");
    }
    
    public void findZeros()
    {
        double y=0;
        System.out.println("Zeros of function: ");
        zeros.add(0.834);
        zeros.add(749.165);
        for(int x = 0; x<zeros.size(); x++){
            System.out.println("     t = "+zeros.get(x));
        }
    }
    
    public void findROC()
    {
        double ROC = max/(calcY(max));
        System.out.println("Average Rate of Change on [0, maximum height] is: "+ROC);
    }
    
    public void findIRC(double x)
    {
        double deriv = -0.01 * (x-375);
        System.out.println("Instantaneous Rate of Change of f(t) at "+(Math.floor(x * 10) / 10)+" = "+(Math.floor(deriv * 100) / 100)+ " ft/sec");
    }
    
    public void findSpeed(double x)
    {
        double deriv = -0.01 * (x-375);
        if(deriv<0){
            System.out.println("The Rocket's speed is increasing when t = "+(Math.floor(x * 1) / 1)+" s");
        } else {
            System.out.println("The Rocket's speed is decreasing when t = "+(Math.floor(x * 1) / 1)+" s");
        }
    }
    
    public void speed(double x){
        double deriv = -0.01 * (x-375);
        System.out.println("Rocket's speed at t = "+Math.floor(x)+" s"+" is "+Math.abs((Math.floor(deriv * 100) / 100))+ " ft/sec");
    }
    
    public void findDP(double x)
    {
        double y = Math.floor(-0.005*(Math.pow((x-375),2)) + 700);
        System.out.println("Displacement: "+y+" ft");
    }
    
    public void findTD(double x)
    {
        double y = Math.floor(-0.005*(Math.pow((x-375),2)) + 700);
        double dis = Math.abs(700-y);
        if(x<375) System.out.println("Total Distance: "+y+" ft");
        if(x>=375) System.out.println("Total Distance: "+(dis+700)+" ft");
    }
    
    public double calcY(double x) {
        double y = -0.005*(Math.pow((x-375),2)) + 700;
        return y;
    }
}
