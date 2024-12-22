package AMSP;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class FlightJourneyDetails extends JFrame{
    JTable t;
    String x[]= {"Ticket ID", "Source", "Destination", "Class","Price", "Flight Code", "Flight Name", "Journey Date", "Journey Time","Username", "Name"};
    String y[][] = new String [20][11];
    int i=0, j=0;
    Font f;
 
    
    FlightJourneyDetails(String src, String dst){
        super("Flight Journey Details");
        setSize(1300,400);
        setLocation(0,10);
        f= new Font("MS UI Gothic",Font.BOLD, 17);
        
        try{
            ConnectionClass obj = new ConnectionClass();
            String q = "select * from bookedflight where source='"+src+"'and destination='"+dst+"'";
            ResultSet rest = obj.stm.executeQuery(q);
            
            while(rest.next()){
                y[i][j++] = rest.getString("tid");
                y[i][j++] = rest.getString("source");
                y[i][j++] = rest.getString("destination");
                y[i][j++] = rest.getString("class_name");
                y[i][j++] = rest.getString("price");
                y[i][j++] = rest.getString("f_code");
                y[i][j++] = rest.getString("f_name");
                y[i][j++] = rest.getString("journey_date");
                y[i][j++] = rest.getString("journey_time");
                y[i][j++] = rest.getString("username");
                y[i][j++] = rest.getString("name");
                 i++;
                 j=0;
                 
            }
            
            t = new JTable(y,x);
                
        }
        catch(Exception ex){
            ex.printStackTrace();
            
        }
        
        t.setFont(f);
        t.setBackground(Color.BLACK);
        t.setForeground(Color.WHITE);
      
        JScrollPane js = new JScrollPane(t);
        add(t);
        
    }
}
