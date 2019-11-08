
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rohan
 */
public class student_list extends javax.swing.JFrame {

    /**
     * Creates new form student_list
     */
    public student_list() {
        initComponents();
        this.getContentPane().setBackground(new Color(52,73,94));
        get_students();
        hidden_status.setVisible(false);
        hidden_fees.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        hidden_status = new javax.swing.JLabel();
        hidden_fees = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(44, 62, 80));
        jPanel1.setForeground(new java.awt.Color(44, 62, 80));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Students registered with evolution");

        hidden_status.setText("jLabel2");

        hidden_fees.setText("jLabel3");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(98, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(74, 74, 74))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(hidden_fees, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addComponent(hidden_status, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(113, 113, 113))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addComponent(hidden_fees, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hidden_status, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed

        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
try
{
    
    DefaultTableModel d=(DefaultTableModel)jTable1.getModel();
    String sn=Integer.toString((int) d.getValueAt(jTable1.getSelectedRow(),0));
    Class.forName("java.sql.DriverManager");
          
        Connection c1=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/eli","root","12345");
        Statement s1=(Statement)c1.createStatement();
        String q1="select fees_status,fees_received from fees where student_no='"+sn+"';";
        ResultSet rs=s1.executeQuery(q1);
        if(rs.next())
        {
            String status=rs.getString("fees_status");
            String fr=rs.getString("fees_received");
            hidden_status.setText(""+status);
            hidden_fees.setText(""+fr);
            
        }

    Class.forName("java.sql.DriverManager");
    Connection c=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/eli","root","12345");
    Statement s=(Statement)c.createStatement();
    String q="select * from record where student_no='"+sn+"';";
    ResultSet rss=s.executeQuery(q);
    
    if(rss.next())
    {
        String n=(String)d.getValueAt(jTable1.getSelectedRow(),1);
        String co=(String)d.getValueAt(jTable1.getSelectedRow(),2);
        String reg=(String)d.getValueAt(jTable1.getSelectedRow(),3);
        String con=(String)d.getValueAt(jTable1.getSelectedRow(),4);

        String bday=rss.getString("dob");
        String place=rss.getString("pob");
        String add=rss.getString("address");
        String p=rss.getString("pay");
        
        student_profile sprofile=new student_profile();
        
        sprofile.jLabel25.setText(""+bday);
        sprofile.jLabel9.setText(""+place);
        sprofile.jTextArea1.setText(""+add);
        sprofile.jLabel18.setText(""+p);
        sprofile.jLabel3.setText(""+sn);
        sprofile.jLabel1.setText(""+n);
        sprofile.jLabel5.setText(""+reg);
        sprofile.jLabel11.setText(""+con);
        sprofile.jLabel24.setText(""+co);
       
        
        int paying=Integer.parseInt(p);
        int frec=Integer.parseInt(hidden_fees.getText());
        int total=paying-frec;
        sprofile.jLabel21.setText(""+total);
        sprofile.jLabel16.setText(""+this.hidden_fees.getText());
        
        sprofile.setTitle(""+n+" ~ evolution language institute" );
        sprofile.setVisible(true);
        
        //select student_no,name,course,reg_date,contact from record order by student_no desc";
        
    }
      
    
}
catch(Exception e)
{
    JOptionPane.showMessageDialog(this,e.getMessage());
}// TODO add your handling code here:
        }
    }//GEN-LAST:event_jTable1KeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(student_list.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(student_list.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(student_list.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(student_list.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new student_list().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel hidden_fees;
    private javax.swing.JLabel hidden_status;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables


public void get_students()
{
     String host="jdbc:mysql://localhost:3306/eli";
    String username="root";
    String password="12345";
    
    Statement stmt=null;
    Connection con=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
    
    try
    {
        con=DriverManager.getConnection(host,username,password);
  String q="select student_no,name,course,reg_date,contact from record order by student_no desc";
  
  pst=con.prepareStatement(q);
  rs=pst.executeQuery();
  jTable1.setModel(DbUtils.resultSetToTableModel(rs));
    }
   catch(Exception e)
   {JOptionPane.showMessageDialog(this,e.getMessage());}
}
}