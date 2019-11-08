/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;

/**
 *
 * @author rohan
 */
public class get_fees {
    

    void fees(int sn) {
      
        try
        {
            Class.forName("java.sql.DriverManager");
            Connection c=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/eli","root","12345");
            Statement s=(Statement)c.createStatement();
            String q="select name,pay,fees_received,five_hundred,two_thousand from record,fees,notes where record.student_no=fees.student_no and notes.student_no='"+sn+"' and fees.student_no='"+sn+"';";
            ResultSet rs=s.executeQuery(q);
            if(rs.next())
            {
                String p=rs.getString("pay");
                String fr=rs.getString("fees_received");
                String fh=rs.getString("five_hundred");
                String tt=rs.getString("two_thousand");
                int remaining=Integer.parseInt(p)-Integer.parseInt(fr);
                String name=rs.getString("name");
                fees_section fs=new fees_section();
                fs.jLabel1.setText(""+name);
                fs.jLabel2.setText(""+sn);
                fs.jLabel4.setText(""+fr);
                fs.jLabel6.setText(""+remaining);
                fs.jTextArea1.setText(""+fh);
                fs.jTextArea2.setText(""+tt);
                fs.setVisible(true);
            }
            
            
        }
        catch(Exception e){JOptionPane.showMessageDialog(null,e.getMessage());}
         //To change body of generated methods, choose Tools | Templates.
    }
    
}
