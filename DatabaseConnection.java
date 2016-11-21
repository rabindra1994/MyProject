

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DatabaseConnection {
    //variable declarations started
    /*
    FOR DERBY DATABASE USE FOLLOWING
    private final String classlocation="org.apache.derby.jdbc.ClientDriver";
    private final String URL="jdbc:derby://localhost:1527/lib_mgmt_system",
                         username="root",
                         password="root";

    
    */
        private final String classlocation="com.mysql.jdbc.Driver";
        private final String URL="jdbc:mysql://localhost:3306/studentmanagementsystem",
                username="root",
                password="";
        private Connection DatabaseConnection;
    //variable declarations ended    
public Connection connect() 
    {
            try 
            {
                Class.forName(classlocation);
                
            } 
               catch (ClassNotFoundException ex) 
               {
                JOptionPane.showMessageDialog(null, "Driver not found for mysql", "Error message", JOptionPane.ERROR_MESSAGE);
               }
            try 
            {
                DatabaseConnection=DriverManager.getConnection(URL,username,password);
               
            
            } 
                catch (SQLException ex) 
                {
                JOptionPane.showMessageDialog(null, "Database not connected \n Please connect the database...", "Error message", JOptionPane.ERROR_MESSAGE);
               
                }
            
            return DatabaseConnection;
    }

}
