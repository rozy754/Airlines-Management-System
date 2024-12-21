package AMSP;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;
import javax.swing.border.*;

public class BookFlight extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, backgroundLabel;
    JButton bt1, bt2;
    JPanel p1, p2;
    JTextField tf1, tf2, tf3, tf4, tf5;
    Font headingFont, subHeadingFont, labelFont, buttonFont;
    Choice ch1, ch2, ch3, ch4, ch5,  ch6;

    BookFlight() {
        super("Book Airlines India Flight");
        setLocation(50, 10);
        setSize(1100, 650);

        // Fonts
        headingFont = new Font("Serif", Font.BOLD, 44); // Main Heading Larger
        subHeadingFont = new Font("Serif", Font.BOLD, 22); // Sub Headings
        labelFont = new Font("Serif", Font.PLAIN, 20);
        buttonFont = new Font("Serif", Font.BOLD, 22);

        // Background Image
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("AMSP/icon/img5.1.jpg"));
        Image scaledImg = img.getImage().getScaledInstance(1100, 650, Image.SCALE_SMOOTH);
        backgroundLabel = new JLabel(new ImageIcon(scaledImg));
        backgroundLabel.setLayout(new BorderLayout());

        // Initialize Components
        initializeComponents();
        setupHeadingPanel();
        setupFormPanel();

        // Add Panels
        backgroundLabel.add(p1, BorderLayout.NORTH);
        backgroundLabel.add(p2, BorderLayout.EAST);
        setContentPane(backgroundLabel);

        setVisible(true);
        
         
        
//    
    ch2.addMouseListener(new MouseAdapter()
    {
        @Override 
        public void mouseClicked(MouseEvent arg0){
        try{
            ConnectionClass obj = new ConnectionClass();
            String username = ch2.getSelectedItem();
            String q1 = "select name from passenger where username='" + username + "'";
            ResultSet  rest1 = obj.stm.executeQuery(q1);
            while(rest1.next()){
                tf5.setText(rest1.getString("name"));
                
            }
            
            rest1.close();
            
        }
        catch(Exception exx){
            exx.printStackTrace();
            }
        
        }
    });
//    
    ch1.addMouseListener(new MouseAdapter()
    {
    @Override
            public void mouseClicked(MouseEvent arg0)
            {
               ch6.removeAll();
               try{
                   ConnectionClass obj = new ConnectionClass();
                   String source = ch1.getSelectedItem();
                   String q1 = "Select distinct destination from flight where source='"+source+"'";
                   ResultSet rest1 = obj.stm.executeQuery(q1);
                   while(rest1.next()){
                       ch6.add(rest1.getString("destination"));
                       
                   }
               }
               catch(Exception exx){
                   exx.printStackTrace();
               }
            }
    });
    
    
     ch6.addMouseListener(new MouseAdapter()
    {
    @Override
            public void mouseClicked(MouseEvent arg0)
            {
               ch3.removeAll();
               try{
                   ConnectionClass obj = new ConnectionClass();
                   String source = ch1.getSelectedItem();
                   String destination = ch6.getSelectedItem();
                   String q1 = "Select distinct class_name from flight where source='"+source+"'and destination='"+destination+"'";
                   ResultSet rest1 = obj.stm.executeQuery(q1);
                   while(rest1.next()){
                       ch3.add(rest1.getString("class_name"));
                       
                   }
               }
               catch(Exception exx){
                   exx.printStackTrace();
               }
            }
    });
     
     
     ch3.addMouseListener(new MouseAdapter()
    {
    @Override
            public void mouseClicked(MouseEvent arg0)
            {
               ch4.removeAll();
               try{
                   ConnectionClass obj = new ConnectionClass();
                   String source = ch1.getSelectedItem();
                   String destination = ch6.getSelectedItem();
                   String classname  = ch3.getSelectedItem();
                   
                   String q1 = "Select distinct price from flight where source='"+source+"'and destination='"+destination+"'and class_name='"+classname+"'";
                   ResultSet rest1 = obj.stm.executeQuery(q1);
                   while(rest1.next()){
                       ch4.add(rest1.getString("price"));
                       
                   }
               }
               catch(Exception exx){
                   exx.printStackTrace();
               }
            }
    });

     
     
     
     
     
     
     ch4.addMouseListener(new MouseAdapter()
    {
    @Override
            public void mouseClicked(MouseEvent arg0)
            {
               ch5.removeAll();
               try{
                   ConnectionClass obj = new ConnectionClass();
                   String source = ch1.getSelectedItem();
                   String destination = ch6.getSelectedItem();
                   String classname  = ch3.getSelectedItem();
                   String price = ch4.getSelectedItem();
                   
                   
                   String q1 = "Select distinct f_code from flight where source='"+source+"'and destination='"+destination+"'and class_name='"+classname+"' and price ='"+price+"'";
                   ResultSet rest1 = obj.stm.executeQuery(q1);
                   while(rest1.next()){
                       ch5.add(rest1.getString("f_code"));
                       
                   }
               }
               catch(Exception exx){
                   exx.printStackTrace();
               }
            }
    });
     
     
     
     
       ch5.addMouseListener(new MouseAdapter()
    {
    @Override
            public void mouseClicked(MouseEvent arg0)
            {
              
               try{
                   ConnectionClass obj = new ConnectionClass();
                   String source = ch1.getSelectedItem();
                   String destination = ch6.getSelectedItem();
                   String classname  = ch3.getSelectedItem();
                   String price = ch4.getSelectedItem();
                   String fcode = ch5.getSelectedItem();
                   
                   String q1 = "Select distinct f_name from flight where source='"+source+"'and destination='"+destination+"'and class_name='"+classname+"' and price ='"+price+"' and f_code ='"+fcode+"'";
                   ResultSet rest1 = obj.stm.executeQuery(q1);
                   while(rest1.next()){
                      tf2.setText(rest1.getString("f_name"));
                       
                   }
               }
               catch(Exception exx){
                   exx.printStackTrace();
               }
            }
    });
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    private void initializeComponents() {
        // Labels
        l1 = new JLabel("Book Airlines India Flight");
        l2 = createLabel("Ticket Id");
        l3 = createLabel("Source");
        l4 = createLabel("Destination");
        l5 = createLabel("Classname");
        l6 = createLabel("Price");
        l7 = createLabel("Flight Code");
        l8 = createLabel("Flight Name");
        l9 = createLabel("Journey Date");
        l10 = createLabel("Journey Time");
        l11 = createLabel("Username");
        l12 = createLabel("Name");

        // Text Fields
        tf1 = createTextField();
        tf2 = createTextField();
        tf3 = createTextField();
        tf4 = createTextField();
        tf5 = createTextField();

        tf1.setEditable(false);
        tf2.setEditable(false);
        tf5.setEditable(false);
        tf1.setText("" + Math.abs(new Random().nextInt() % 100000));
        tf1.setForeground(Color.RED);

        // Buttons with New Colors
        bt1 = createButton("Book Flight", new Color(160, 82, 45)); // 3 shades lighter Brown
        bt2 = createButton("Back", new Color(160, 82, 45)); // 3 shades lighter Brown

        
        // Choices
        ch1 = new Choice();
        ch2 = new Choice();
        ch3 = new Choice();
        ch4 = new Choice();
        ch5 = new Choice();
        ch6 = new Choice();
        
        
        bt1.addActionListener(this);  // Add the Action Listener for Book Flight button
        bt2.addActionListener(this);  // Add the Action Listener for Back button
        
        
         try{
            
             ConnectionClass obj = new ConnectionClass();
             String q = "Select distinct Source from flight";
             ResultSet rest = obj.stm.executeQuery(q);
             while(rest.next()){
                 ch1.add(rest.getString("source"));
                 
             }
             rest.close();
             
        }
         catch(Exception ex){
             
             ex.printStackTrace();
         }
         
       
         try{
             
             ConnectionClass obj = new ConnectionClass();
             String q = "Select username from passenger";
             ResultSet rest = obj.stm.executeQuery(q);
             while(rest.next()){
                 ch2.add(rest.getString("username"));
                 
             }
             rest.close();
             
         }
         catch(Exception ex){
             
             ex.printStackTrace();
         }
//        
//        
//        
//        
        
        
        
        
        
        
    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(subHeadingFont);
        label.setForeground(Color.BLACK); // Dark Brown Bold Text
        return label;
    }

    private JTextField createTextField() {
        JTextField textField = new JTextField();
        textField.setFont(labelFont);
        textField.setPreferredSize(new Dimension(250, 30));
        textField.setBackground(new Color(245, 245, 245)); // Light Grey
        textField.setForeground(Color.DARK_GRAY);
        return textField;
    }

    private JButton createButton(String text, Color bgColor) {
        JButton button = new JButton(text);
        button.setFont(buttonFont);
        button.setBackground(bgColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(new LineBorder(Color.BLACK, 2));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(bgColor.darker());
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(bgColor);
            }
        });
        return button;
    }

    private void setupHeadingPanel() {
        p1 = new JPanel();
        p1.setLayout(new GridLayout(1, 1));
        p1.setOpaque(false);

        l1.setFont(headingFont);
        l1.setForeground(new Color(139, 69, 19)); // Aesthetic Brown Shade for Main Heading
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setBorder(new EmptyBorder(20, 0, 10, 0));
        p1.add(l1);
    }

    private void setupFormPanel() {
        p2 = new JPanel();
        p2.setLayout(new GridLayout(12, 2, 10, 10));
        p2.setOpaque(false);
        p2.setBorder(new EmptyBorder(20, 20, 20, 20));

        // Add Components
        p2.add(l2); p2.add(tf1);
        p2.add(l3); p2.add(ch1);
        p2.add(l4); p2.add(ch6);
        p2.add(l5); p2.add(ch3);
        p2.add(l6); p2.add(ch4);
        p2.add(l7); p2.add(ch5);
        p2.add(l8); p2.add(tf2);
        p2.add(l9); p2.add(tf3);
        p2.add(l10); p2.add(tf4);
        p2.add(l11); p2.add(ch2);
        p2.add(l12); p2.add(tf5);
        p2.add(bt1); p2.add(bt2);
    }

    
    

//    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == bt2) {
//            setVisible(false);
//            // Add navigation logic here
//        } else if (e.getSource() == bt1) {
//            JOptionPane.showMessageDialog(this, "Flight Booked Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
//        }
//    }
//    
//    
//    
    
    

    public void actionPerformed(ActionEvent e){
        if(e.getSource()== bt1){
        String tid = tf1.getText();
        String source = ch1.getSelectedItem();
        String destination= ch6.getSelectedItem();
        String classname = ch3.getSelectedItem();
        String price = ch4.getSelectedItem();
        String fcode = ch5.getSelectedItem();
        String fname = tf2.getText();
        String jdate = tf3.getText();
        String jtime = tf4.getText();
        String username = ch2.getSelectedItem();
        String name = tf5.getText();
        String status = "Success";
        try{
        ConnectionClass obj3 = new ConnectionClass();
        String q1 = "insert into bookedflight values ('" + tid + "', '" + source + "', '" 
            + destination + "', '" + classname + "', '" + price + "', '" 
            + fcode + "', '" + fname + "', '" + jdate + "', '" + jtime + "', '" 
            + username + "', '" + name + "', '" + status + "')";
             int aa = obj3.stm.executeUpdate(q1);
             if(aa==1){
              JOptionPane.showMessageDialog(null,"Your flight successfully booked");
              this.setVisible(false);
             }
             
             else{
                 JOptionPane.showMessageDialog(null,"Please!, Fill all details carefuly");
                 
             }
            }
              catch(Exception ee){
                  ee.printStackTrace();
              }                             
        }
        
        if(e.getSource()==bt2){
            JOptionPane.showMessageDialog(null,"Are you sure!");
            this.setVisible(false);
        }
    }
    
    
    

    public static void main(String[] args) {
        new BookFlight().setVisible(true);
    }
}