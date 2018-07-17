
package sfj.scheduling;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class dataProcesses extends JFrame{
    JTextField t1,t2;
    JButton b;
    JLabel l,l1,l2,l3;
    ArrayList<JTextField> burstArr=new ArrayList();
    ArrayList<JTextField> arrivalArr=new ArrayList();
    ArrayList<process> processesArr=new ArrayList();
    public dataProcesses(int processesNum)
    {
    this.setTitle("Your calculations");
    this.setSize(2000,1000);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setLayout(null);
    int y=100,x;
    for(int i=0;i<processesNum;i++)
    {
    x=i+1;
    l=new JLabel("process number "+x);
    l.setBounds(450,y,120,30);
    this.add(l);
    l1=new JLabel("Arival Time");
    l1.setBounds(600,y,120,30);
    this.add(l1);
    t2=new JTextField(10);
    arrivalArr.add(t2);
    t2.setBounds(750,y,150,30);
    this.add(t2);
    l2=new JLabel("Burst Time");
    this.add(l2);
    l2.setBounds(970,y,100,30);
    t1=new JTextField(10);
    burstArr.add(t1);
    t1.setBounds(1050,y,100,30);
    this.add(t1);
    y+=100;
    }
    b=new JButton("submit");
    b.setBounds(900,y+100,100,30);
    this.add(b);
    b.addActionListener(new myHandler());
    }
    private class myHandler implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            validation v=new validation();
            boolean flag=false;
            for(int i=0;i<burstArr.size();i++)
            {
                String s=burstArr.get(i).getText();
                String c=arrivalArr.get(i).getText();
                if(v.isCharacter(s)||v.isCharacter(c))
                {
                    JOptionPane.showMessageDialog(null, "you must enter only positive value for all inputs");
                    flag=true;
                    break;
                }
                int x=Integer.parseInt(s);
                int y=Integer.parseInt(c);
                if(v.negativeNum(x)||v.negativeNum(y))
                {
                    JOptionPane.showMessageDialog(null, "you must enter only positive value for all inputs");
                    flag=true;
                    break;
                }     
                
            }
                if(flag==false)
                {
                    for(int i=0;i<burstArr.size();i++)
                    {
                        process p=new process(i+1);
                        p.burstTime=Integer.parseInt(burstArr.get(i).getText());
                        p.arrivalTime=Integer.parseInt(arrivalArr.get(i).getText());
                        processesArr.add(p);
                        CALCULATIONS CAL =new CALCULATIONS();
                        processesArr=CAL.order(processesArr);
                        processesArr=CAL.sumsAssigns(processesArr);
                        processesArr=CAL.processCalculation(processesArr);
                        float AVG_waitingTime=CAL.AVG_waitngTime(processesArr);
                        float AVG_turnArrouneTime=CAL.AVG_turnArroundTime(processesArr);
                        float AVG_responseTime=CAL.AVG_responseTime(processesArr);
                        processesArr=CAL.reconfigure(processesArr);
                        dataProcesses d=new dataProcesses(5);
                        resultProcesses r=new resultProcesses(processesArr,AVG_waitingTime,AVG_turnArrouneTime,AVG_responseTime);
                        d.setVisible(false);
                        r.setVisible(true);
                    }
                }
}
}
}

