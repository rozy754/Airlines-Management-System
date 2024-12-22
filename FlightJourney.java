package AMSP;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class FlightJourney extends JFrame implements ActionListener{
    JFrame f;
    JLabel l1, l2, l3;
    JButton b, b2;
    Choice ch1, ch2;
    
       
    
    FlightJourney(){
        f= new JFrame("Select Source & Destination");
        f.setBackground(Color.green);
        f.setLayout(null);
        
       l1 = new JLabel();
       l1.setBounds(0,0,500,270);
       l1.setLayout(null);
       
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("AMSP/icon/img1.jpg"));
        Image il = img.getImage().getScaledInstance(700,370, Image.SCALE_SMOOTH);
        ImageIcon ic1 = new ImageIcon(il);
        l1.setIcon(ic1); 
  
        l2 = new JLabel("Source");
        l2.setVisible(true);
        l2.setBounds(40,60,150,30);
        l2.setForeground(Color.white);
        Font F1 = new Font("Airal", Font.BOLD, 21);
        
        l2.setFont(F1);
        l1.add(l2);
        f.add(l1);
        
         l3 = new JLabel("Destination");
        l3.setVisible(true);
        l3.setBounds(40,120,150,30);
        l3.setForeground(Color.white);
        l3.setFont(F1);
        l1.add(l3);
        
        ch1 = new Choice();
        ch1.setBounds(240,60,190,25);
      
        try{
            ConnectionClass obj = new ConnectionClass();
            String q = "Select distinct source from bookedflight";
            ResultSet rest = obj.stm.executeQuery(q);
            while(rest.next()){
                ch1.add(rest.getString("Source"));
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        
        
        
        ch2 = new Choice();
        ch2.setBounds(240,120,190,25);
        try{
            ConnectionClass obj = new ConnectionClass();
            String q = "Select distinct destination from bookedflight";
            ResultSet rest = obj.stm.executeQuery(q);
            while(rest.next()){
                ch2.add(rest.getString("destination"));
            }
            rest.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        
        l1.add(ch1);
        l1.add(ch2);
        ch1.setFont(F1);
        ch2.setFont(F1);
        
        b= new JButton("Search");
        b.setBounds(140,185,100,30);
        b.addActionListener(this);
        l1.add(b);
        
        b2 = new JButton("Close");
        b2.setBounds(260,185,100,30);
        b2.addActionListener(this);
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.red);
        l1.add(b2);
        
        f.setSize(500,270);
        f.setLocation(450,250);
        f.setVisible(true);
        
        
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b2){
            f.setVisible(false);
        }
        if(ae.getSource()==b){
            f.setVisible(false);
            new FlightJourneyDetails(ch1.getSelectedItem(),ch2.getSelectedItem()).setVisible(true);
            
        }
    }
    
    public static void main(String[] args){
        new FlightJourney().setVisible(true);
    }
}
        

