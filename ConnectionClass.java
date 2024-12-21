package AMSP;

import java.sql.*;

public class ConnectionClass {
     Connection con;
     Statement stm;

     ConnectionClass() {
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish connection
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ams", "root", "Priya03@");
            stm = con.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    
    public static void main(String[] args){
       new ConnectionClass();
    }
}
