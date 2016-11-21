

import java.awt.Container;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class StudentShow extends JFrame {

    
     private JTable table;
    //public static int k=0;
    public  String mes="";
    public StudentShow() {
         try {
             setSize(1080,480);
             Container cp=getContentPane();
             
             Connection con=new DatabaseConnection().connect();
             Statement stmt=con.createStatement();
             
             String sql=getSQLString("select * from student");
             ResultSet rs=stmt.executeQuery(sql);
             displayResultSet(rs);
             
             
             setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
             show();
         } catch (SQLException ex) {
             mes+="SQL Exception Caught\n";
             JOptionPane.showMessageDialog(null, mes,"Error message",JOptionPane.ERROR_MESSAGE);
         }
    }
    
public String getSQLString(String sql){
    return sql;
}
    private void displayResultSet(ResultSet rs)  {
         try {
             boolean moreRecords=rs.next();
             if(!moreRecords){
                 JOptionPane.showMessageDialog(null, "No content ");
                 return;
             }
             else{
                 Vector columnHeads=new Vector();
                 Vector data=new  Vector();
                 ResultSetMetaData rsmd=rs.getMetaData();
                 for(int i=1;i<=rsmd.getColumnCount();++i)
                     columnHeads.addElement(rsmd.getColumnName(i));
                 do{
                     data.addElement(getNextRow(rs,rsmd));
                 }while(rs.next());
                 table=new JTable(data, columnHeads);
                 JScrollPane jsp=new JScrollPane(table);
                 getContentPane().add(jsp);
                 validate();
                 
             }} catch (SQLException ex) {
            mes+="SQL Exception Caught\n";
             JOptionPane.showMessageDialog(null, mes,"Error message",JOptionPane.ERROR_MESSAGE);
         }
        
    }

    private Vector getNextRow(ResultSet rs, ResultSetMetaData rsmd)  {
         
             Vector cr=new Vector();
         try {
             for(int i=1;i<=rsmd.getColumnCount();++i)
                 switch(rsmd.getColumnType(i)){
                     case Types.VARCHAR:
                         cr.addElement(rs.getString(i));
                         break;
                     case Types.INTEGER:
                         cr.addElement(new Long(rs.getLong(i)));
                         break;
                     case Types.DATE:
                         cr.addElement((rs.getDate(i)));
                         break;
                     default:
                         JOptionPane.showMessageDialog(this, "Type was : "+rsmd.getColumnTypeName(i));
                 }
         } catch (SQLException ex) {
            mes+="SQL Exception Caught\n";
             JOptionPane.showMessageDialog(null, mes,"Error message",JOptionPane.ERROR_MESSAGE); 
         }
             return cr;
          }
    }
