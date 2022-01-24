/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cargo.project;
import java.awt.Color;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author HP
 */
public class Customer_Reg extends javax.swing.JInternalFrame {
  String g;


    public Customer_Reg() {
        initComponents();
        table_update() ;
         table_update();
        
        
    }
  
    @SuppressWarnings("unchecked")
     Connection con1;
      PreparedStatement insert;
      
      
       private void table_update() {
        int CC;
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost/cargo","root","");
              
            insert = con1.prepareStatement("SELECT * FROM CUSTOMERS");
            ResultSet Rs = insert.executeQuery();
            
            ResultSetMetaData RSMD = Rs.getMetaData();
            CC = RSMD.getColumnCount();
            DefaultTableModel DFT = (DefaultTableModel) jTable2.getModel();
            DFT.setRowCount(0);

            while (Rs.next()) {
                Vector v2 = new Vector();
           
                for (int ii = 1; ii <= CC; ii++) {
      
                    v2.add(Rs.getString("CUST_ID"));
                    v2.add(Rs.getString("CUST_NAME"));
                    v2.add(Rs.getString("CUST_TELL"));
                    v2.add(Rs.getString("CUST_ADDRESS"));
                    v2.add(Rs.getString("GENDER"));
                }
                DFT.addRow(v2);
            }
        } catch (Exception e) {
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtcust_id = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtcust_name = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtcust_phone = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtcust_address = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        combo = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        btn_save = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        close_cc = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setBackground(new java.awt.Color(0, 255, 255));
        setClosable(true);
        setTitle("Customer Registration");

        jPanel1.setBackground(new java.awt.Color(0, 255, 255));

        jLabel1.setText("Customer ID:");

        txtcust_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcust_idKeyReleased(evt);
            }
        });

        jLabel2.setText("Customer Name:");

        jLabel3.setText("Customer_Phone");

        txtcust_phone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcust_phoneKeyReleased(evt);
            }
        });

        jLabel4.setText("Customer_address");

        jLabel5.setText("Customer_Gender:");

        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select One", "Male", "Female" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcust_id, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcust_address, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcust_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcust_name, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(combo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtcust_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtcust_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtcust_phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtcust_address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 51, 204));

        btn_save.setBackground(new java.awt.Color(255, 0, 0));
        btn_save.setText("Save");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        btn_update.setBackground(new java.awt.Color(255, 0, 0));
        btn_update.setText("Update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_delete.setBackground(new java.awt.Color(255, 0, 0));
        btn_delete.setText("Delete");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        close_cc.setBackground(new java.awt.Color(255, 0, 0));
        close_cc.setText("Close");
        close_cc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                close_ccActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_save, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_update, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(close_cc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_save)
                    .addComponent(btn_update))
                .addGap(38, 38, 38)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_delete)
                    .addComponent(close_cc))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jScrollPane1.setBackground(new java.awt.Color(0, 0, 204));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Phone", "Title 4", "Gender"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        // TODO add your handling code here:
        validation();
          if(txtcust_id.getText().equals("") &&  txtcust_name.getText().equals("")  &&  txtcust_phone.getText().equals("") && txtcust_address.getText().equals("")){
             JOptionPane.showMessageDialog(this, "Please fill all fields");
        }
          else 
          {
       String id= txtcust_id.getText();
       String name= txtcust_name.getText();
        String phone= txtcust_phone.getText();
        String address= txtcust_address.getText();
         String gender=combo.getSelectedItem().toString();     
        try {

              Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost/cargo","root","");
              
          
            insert = con1.prepareStatement("insert into customers values(?,?,?,?,?)");
            insert.setString(1,id);
            insert.setString(2,name);
            insert.setString(3,phone);
             insert.setString(4,address);
              
             insert.setString(5,gender);
             
            insert.executeUpdate();
            JOptionPane.showMessageDialog(this, "Record Saved");  
            
            txtcust_id.setText("");
            txtcust_name.setText("");
            txtcust_phone.setText("");
            txtcust_address.setText("");
             table_update();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Customer_Reg.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
 
    }//GEN-LAST:event_btn_saveActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // TODO add your handling code here:
         validation();
        if(txtcust_id.getText().equals("") &&  txtcust_name.getText().equals("")  &&  txtcust_phone.getText().equals("") && txtcust_address.getText().equals("")){
        
             JOptionPane.showMessageDialog(this, "Please fill all fields");
        }
        else 
        {
             DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            int selectedIndex = jTable2.getSelectedRow();
            try {   
                
            int ids = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());
        String id= txtcust_id.getText();
       String name=  txtcust_name.getText();
        String phone=  txtcust_phone.getText();
        String address= txtcust_address.getText();
           String gender=combo.getSelectedItem().toString();
               Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost/cargo","root","");
            insert = con1.prepareStatement("update CUSTOMERS set  CUST_NAME= ?, CUST_TELL= ?,CUST_ADDRESS= ? ,GENDER=?  where CUST_ID= ?");
            
            
            insert.setString(1,name);
            insert.setString(2,phone);
             insert.setString(3,address);
            insert.setString(4,gender);
            insert.setInt(5,ids);
            insert.executeUpdate();
            JOptionPane.showMessageDialog(this, "Record Updated");
        table_update();
          txtcust_id.setText("");
            txtcust_name.setText("");
            txtcust_phone.setText("");
            txtcust_address.setText("");          
                table_update();

        } catch (ClassNotFoundException ex) {
           
        } catch (SQLException ex) {

        }
        }
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here:
          if(txtcust_id.getText().equals("") &&  txtcust_name.getText().equals("")  &&  txtcust_phone.getText().equals("") && txtcust_address.getText().equals("")){
        
             JOptionPane.showMessageDialog(this, "Please fill ID field");
        }
          else
          {
                  DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
          int selectedIndex = jTable2.getSelectedRow();
            try {   
                
            int id = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());
            int dialogResult = JOptionPane.showConfirmDialog (null, "Do you want to Delete the record","Warning",JOptionPane.YES_NO_OPTION);
            if(dialogResult == JOptionPane.YES_OPTION){

             Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost/cargo","root","");   
            insert = con1.prepareStatement("delete from CUSTOMERS where CUST_ID = ?");
            insert.setInt(1,id);
            insert.executeUpdate();
            JOptionPane.showMessageDialog(this, "Record Delete");
            txtcust_id.setText("");
            txtcust_name.setText("");
            txtcust_phone.setText("");
            txtcust_address.setText("");
           

            table_update();
           
           }

        } catch (ClassNotFoundException ex) {
        
        } catch (SQLException ex) {
            
        }
          }
    
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void close_ccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_close_ccActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_close_ccActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        int selectedIndex = jTable2.getSelectedRow();

        txtcust_id.setText(model.getValueAt(selectedIndex, 0).toString());
        txtcust_name.setText(model.getValueAt(selectedIndex, 1).toString());
        txtcust_phone.setText(model.getValueAt(selectedIndex, 2).toString());
        txtcust_address.setText(model.getValueAt(selectedIndex, 3).toString());
        txtcust_address.setText(model.getValueAt(selectedIndex, 3).toString()); 
        String g=model.getValueAt(selectedIndex, 4).toString();
        combo.setSelectedItem(g);

    }//GEN-LAST:event_jTable2MouseClicked

       public  void validation(){
    
        
        
      String id =txtcust_id.getText();
 
     String Tell=txtcust_phone.getText();
     
       if(Tell.matches("^[0-9]*$"))
        {
            txtcust_phone.setBackground(Color.green);   
        } 
        
        else
        {
           
       txtcust_phone.setBackground(Color.red);
             JOptionPane.showMessageDialog(this, "Phone: only numbers are allowed");
        }
    
        if(id.matches("^[0-9]*$"))
        {
            txtcust_id.setBackground(Color.green);
           
        } 
        
        else
        {
           
       txtcust_id.setBackground(Color.red);
             JOptionPane.showMessageDialog(this, "ID: only numbers are allowed");
        }
      
    }
    private void txtcust_idKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcust_idKeyReleased
        // TODO add your handling code here:
        String id = txtcust_id.getText();
           if(id.matches("^[0-9]*$"))
        {
            txtcust_id.setBackground(Color.green);
           
        } 
        
        else
        {
           
       txtcust_id.setBackground(Color.red);
             JOptionPane.showMessageDialog(this, "ID: only numbers are allowed");
        }
    }//GEN-LAST:event_txtcust_idKeyReleased

    private void txtcust_phoneKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcust_phoneKeyReleased
        // TODO add your handling code here:
          String Tell=txtcust_phone.getText();
     
       if(Tell.matches("^[0-9]*$"))
        {
            txtcust_phone.setBackground(Color.green);   
        } 
        
        else
        {
           
       txtcust_phone.setBackground(Color.red);
             JOptionPane.showMessageDialog(this, "Phone: only numbers are allowed");
        }
        
        
    }//GEN-LAST:event_txtcust_phoneKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_save;
    private javax.swing.JButton btn_update;
    private javax.swing.JButton close_cc;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField txtcust_address;
    private javax.swing.JTextField txtcust_id;
    private javax.swing.JTextField txtcust_name;
    private javax.swing.JTextField txtcust_phone;
    // End of variables declaration//GEN-END:variables
}
