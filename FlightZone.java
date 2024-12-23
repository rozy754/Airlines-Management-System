
package AMSP;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;


public class FlightZone extends JFrame {
    
    private JTable table;
    private JTextField t;
    Choice ch1;
    
    public static void main(String[] args){
        new FlightZone().setVisible(true);
        
    }
    FlightZone(){
        getContentPane().setBackground(new java.awt.Color(77,157,227));
        getContentPane().setFont(new Font("Arial",Font.BOLD,18));
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(860,700);
        setLayout(null);
        setVisible(true);
        
        JLabel flightCode = new JLabel("Flight Code");
        flightCode.setFont(new Font("Arial",Font.BOLD,18));
        flightCode.setBounds(100,100,150,30);
        flightCode.setForeground(new Color(15,11,1));
        add(flightCode);
        
        JLabel flightDetails = new JLabel("Air India Flight Information");
        flightDetails.setFont(new Font("Arial",Font.BOLD,33));
        flightDetails.setBounds(250,20,570,35);
        flightDetails.setForeground(new Color(15,11,1));
       add(flightDetails);
        
        JButton bt= new JButton("Show Details");
        bt.setFont(new Font("Arial",Font.BOLD,20));
        bt.addActionListener(new ActionListener(){
        
            public void actionPerformed(ActionEvent ae){
                try{
                    
                    String code = ch1.getSelectedItem();
                    ConnectionClass c = new ConnectionClass();
                    String str = "select * from flight where f_code = '"+code+"'";
                    ResultSet rs = c.stm.executeQuery(str);
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                    
                }
                catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        
        });
        
        bt.setBounds(560,100,220,30);
        add(bt);
        
        
        table = new JTable();
        table.setBackground(Color.WHITE);
        table.setBounds(23,250,800,300);
        table.setFont(new Font("Arial",Font.BOLD, 14));
        add(table);
        
        ch1 = new Choice();
        ch1.setBounds(290,103,200,35);
        ch1.setFont(new Font("Arial",Font.BOLD, 18));
        try{
            ConnectionClass con = new ConnectionClass();
            String str = "select distinct f_code from flight";
            ResultSet rs = con.stm.executeQuery(str);
            while(rs.next()){
                ch1.add(rs.getString("f_code"));
                
            }
        }
        catch(Exception exx){
            exx.printStackTrace();
        }
        add(ch1);
        
        
        JLabel flightC = new JLabel("flight Code");
        flightC.setFont(new Font("Arial",Font.BOLD,14));
        flightC.setBounds(33,220,126,16);
        flightC.setForeground(new Color(15,11,1));
       add(flightC);
       
        JLabel flightName = new JLabel("flight Name");
        flightName.setFont(new Font("Arial",Font.BOLD,14));
        flightName.setBounds(155,220,120,16);
        flightName.setForeground(new Color(15,11,1));
       add(flightName);
       
       JLabel source = new JLabel("Source");
        source.setFont(new Font("Arial",Font.BOLD,14));
        source.setBounds(275,220,104,16);
        source.setForeground(new Color(15,11,1));
       add(source);
        
        JLabel destination = new JLabel("Destination");
        destination.setFont(new Font("Arial",Font.BOLD,14));
        destination.setBounds(380,220,120,16);
        destination.setForeground(new Color(15,11,1));
       add(destination);
       
       JLabel capacity = new JLabel("Capacity");
        capacity.setFont(new Font("Arial",Font.BOLD,14));
        capacity.setBounds(497,220,111,16);
        capacity.setForeground(new Color(15,11,1));
       add(capacity);
       
        
       JLabel classname = new JLabel("Class Name");
        classname.setFont(new Font("Arial",Font.BOLD,14));
        classname.setBounds(610,220,120,16);
        classname.setForeground(new Color(15,11,1));
       add(classname);
       
       JLabel price = new JLabel("Price");
        price.setFont(new Font("Arial",Font.BOLD,14));
        price.setBounds(740,220,111,16);
        price.setForeground(new Color(15,11,1));
       add(price);

       
       setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
       setSize(900,650);
       setVisible(true);
       setLocation(100,50);
    }
}
