
package AMSP;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class CheckPaymentDetails extends JFrame {
    
    JTextField textField;
    JTable table;
    JLabel Sector,TicketId, Capacity, Classcode, Classname, label;
    
    public static void main(String[] args){
        new CheckPaymentDetails();
    }
    
    CheckPaymentDetails(){
    
        initialize();
        
    }
    private void initialize(){
        setTitle("Payment Details");
        getContentPane().setBackground(Color.WHITE);
        setSize(945,590);
        setLayout(null);
        
        
        JLabel Fcode = new JLabel("Username");
         Fcode.setFont(new Font("Arial", Font.BOLD, 16));
         Fcode.setBounds(190,160,150,26);
         add(Fcode);
         
         textField = new JTextField();
         textField.setBounds(300,160,150,26);
         textField.setFont(new Font("Arial",Font.BOLD,14));
         add(textField);
         
         table = new JTable();
         table.setBounds(93,297,766,87);
         add(table);
         
         JButton show = new JButton("show");
         show.setFont(new Font("Arial",Font.BOLD,14));
         show.setBackground(Color.BLACK);
         show.setForeground(Color.WHITE);
         show.setBounds(500,160,150,26);
         add(show);
         
         Sector = new JLabel("Check Payment Details");
         Sector.setForeground(Color.BLUE);
         Sector.setFont(new Font("Arial",Font.BOLD,33));
         Sector.setBounds(291,17,800,39);
         add(Sector);
         
         
        TicketId = new JLabel("Ticket Id");
        TicketId.setFont(new Font("Arial",Font.BOLD,14));
        TicketId.setBounds(117,262,108,26);
     //   flightCode.setForeground(new Color(15,11,1));
        add(TicketId);
        
        Capacity = new JLabel("Price");
        Capacity.setFont(new Font("Arial",Font.BOLD,14));
        Capacity.setBounds(237,268,38,14);
     //   flightCode.setForeground(new Color(15,11,1));
        add(Capacity);
        
        Classcode = new JLabel("Journey Date");
        Classcode.setFont(new Font("Arial",Font.BOLD,14));
        Classcode.setBounds(362,264,101,24);
     //   flightCode.setForeground(new Color(15,11,1));
        add(Classcode);
        
        Classname = new JLabel("Journey Time");
        Classname.setFont(new Font("Arial",Font.BOLD,14));
        Classname.setBounds(485,268,114,14);
     //   flightCode.setForeground(new Color(15,11,1));
        add(Classname);
        
        
        JLabel Cardno= new JLabel("Username");
        Cardno.setFont(new Font("Arial",Font.BOLD,14));
        Cardno.setBounds(620,269,101,19);
     //   flightCode.setForeground(new Color(15,11,1));
        add(Cardno);
        
     
        JLabel Phoneno= new JLabel("Status");
         Phoneno.setFont(new Font("Arial",Font.BOLD,14));
         Phoneno.setBounds(752,264,86,24);
     //   flightCode.setForeground(new Color(15,11,1));
        add(Phoneno);
     
           label = new JLabel("");
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("AMSP/icon/img5.1.jpg"));
        Image img = ic.getImage().getScaledInstance(1550,800,Image.SCALE_SMOOTH);
        ImageIcon ic1 = new ImageIcon(img);
        label.setIcon(ic1);
        label.setBounds(0,0,960,590);
        add(label);
       setVisible(true);
       
       show.addActionListener(new ActionListener()
       {
         public void actionPerformed(ActionEvent ae){
          try{
              String usn = textField.getText();
              ConnectionClass obj = new ConnectionClass();
              String str = "select tid,price,journey_date, journey_time,username,status from bookedFlight where username = '"+usn+"' and status = 'success'";
              ResultSet rs = obj.stm.executeQuery(str);
              table.setModel(DbUtils.resultSetToTableModel(rs));
              table.setFont(new Font("Arial",Font.BOLD, 14));
          }
          catch(SQLException e){
              e.printStackTrace();
          }
         }
         
       });
// yh us lie hai ki kha pure screen mai tumhara frame open hoga
       setSize(960,590);
       setLocation(40,20);
       setVisible(true);
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
    }
}
