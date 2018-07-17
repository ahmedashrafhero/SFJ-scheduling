package sfj.scheduling;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class numOfProcesses extends JFrame{ 
    JTextField t;
    JButton b;
    JLabel l;
    public numOfProcesses()
    {
    this.setTitle("Welcome :))");
    this.setSize(2000,1000);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setLayout(null);
    l=new JLabel("Processes number");
    l.setBounds(600,200,120,30);
    this.add(l);
    
    t=new JTextField(10);
    t.setBounds(750,200,150,30);
    this.add(t);
    
    b=new JButton("submit");                            
    b.setBounds(970,200,100,30);
    this.add(b);
    b.addActionListener(new myHandler());   
    }
        private class myHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            String x=t.getText();           
            validation v=new validation();
            if(v.isCharacter(x))
            {
                JOptionPane.showMessageDialog(null, "you must enter positive value");
            }
            else {
            int y=Integer.parseInt(x);
            if(v.negativeNum(y))
            {
                JOptionPane.showMessageDialog(null, "you must enter only positive value");
            }
            else 
            {
                dataProcesses p=new dataProcesses(y);
                numOfProcesses N=new numOfProcesses();
                N.setVisible(false);
                p.setVisible(true);
            }
        }
        }
        }
}
        
        
    
    

