/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sfj.scheduling;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 *
 * @author Z51
 */


public class resultProcesses extends JFrame{
    JTextField t1,t2,t3;
    JLabel l1,l2,l3;
    int w=50,processesNum;
    ArrayList<process>arr2;
    public resultProcesses(ArrayList<process>arr,float x,float y,float z)
    {
    this.setTitle("Your calculations");
    this.setSize(2000,1000);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setLayout(null);
    l1=new JLabel("waiting time");
    l1.setBounds(450,w,120,30);
    this.add(l1);
    l2=new JLabel("turn arround time");
    l2.setBounds(600,w,120,30);
    this.add(l2);
    l3=new JLabel("responset time");
    l3.setBounds(750,w,120,30);
    this.add(l3); 
    w+=50;
    for(int i=0;i<arr.size();i++)
    {
    int a=i+1;
    l1=new JLabel("process number "+a);
    l1.setBounds(300,w,120,30);
    this.add(l1);    
    t1=new JTextField();
    String s=String.valueOf(arr.get(i).waitingTime);
    t1.setText(s);
    t1.setBounds(450,w,120,30);
    this.add(t1);
    t2=new JTextField();
    s=String.valueOf(arr.get(i).turnArroundTime);
    t2.setText(s);
    t2.setBounds(600,w,120,30);
    this.add(t2);
    t3=new JTextField();
    s=String.valueOf(arr.get(i).responseTime);
    t3.setText(s);
    t3.setBounds(750,w,120,30);
    this.add(t3);
    w+=50;
    }
    l1=new JLabel("total average");
    l1.setBounds(300,w,120,30);
    this.add(l1);
    t1=new JTextField();
    String s=String.valueOf(x);
    t1.setText(s);
    t1.setBounds(450,w,120,30);
    this.add(t1);
    t2=new JTextField();
    s=String.valueOf(y);
    t2.setText(s);
    t2.setBounds(600,w,120,30);
    this.add(t2);
    t3=new JTextField();
    s=String.valueOf(z);
    t3.setText(s);
    t3.setBounds(750,w,120,30);
    this.add(t3);
    CALCULATIONS CAL=new CALCULATIONS();
    arr2=CAL.order(arr);
    }
    //private class graphic extends JComponent{
    public void paint(Graphics g){
        super.paint(g);
        int b=300;
        //g.setColor(Color.BLACK);
        //g.drawString(""+0,b,w+330);
    for(int i=0;i<arr2.size();i++)
    {
        if(i==0)
        g.setColor(Color.WHITE);
        else{
            if(i%5==0)
                g.setColor(Color.ORANGE);
            else{
                if(i%4==0)
                    g.setColor(Color.MAGENTA);
                else{
                    if(i%3==0)
                        g.setColor(Color.GREEN);
                    else{
                        if(i%2==0)
                            g.setColor(Color.PINK);
                        else{
                            if(i%1==0)
                               g.setColor(Color.YELLOW); 
                        }
                    }
                }
            }
        }
        g.drawRect(b,w+200,arr2.get(i).burstTime*30,100);
        g.fillRect(b,w+200,arr2.get(i).burstTime*30,100);
        g.setColor(Color.BLACK);
        g.drawString("P"+arr2.get(i).id,b+((arr2.get(i).burstTime*30)/2),w+250);
        b+=(arr2.get(i).burstTime*30);
        g.drawString(""+arr2.get(i).burstSum,b,w+330);
    }
    }
}




