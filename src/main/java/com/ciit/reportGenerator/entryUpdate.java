/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.ciit.reportGenerator;

import com.raven.datechooser.DateChooser;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Mikel
 */
public class entryUpdate extends javax.swing.JFrame {

    private DateChooser entryDate = new DateChooser();
    
    public entryUpdate() {
        
        initComponents();
        
        entryDate.setTextField(dateTxt);
        entryDate.setLabelCurrentDayVisible(false);
        entryDate.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        Connect();
        LoadID();
    }
    
    
    Connection con;
    PreparedStatement pstUpdate;
    PreparedStatement pstLoadData;
    ResultSet rs;
    public void Connect(){

        try { 
          con = DriverManager.getConnection("jdbc:mysql://localhost/inex","root","");
        } catch (SQLException ex) {
            Logger.getLogger(entryAdd.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void LoadID(){
        
        try {
            pstLoadData = con.prepareStatement("SELECT ID FROM accounts");
            rs = pstLoadData.executeQuery();
            idCbox.removeAllItems();
            while(rs.next()){
                idCbox.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(entryUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        descTxt = new javax.swing.JFormattedTextField();
        entryUpdateBtn = new javax.swing.JButton();
        clearTxtBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        accountTypeCbox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        dateTxt = new javax.swing.JTextField();
        amtTxt = new javax.swing.JTextField();
        idCbox = new javax.swing.JComboBox<>();
        entrySearchBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        entryUpdateBtn.setText("Update Entry");
        entryUpdateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entryUpdateBtnActionPerformed(evt);
            }
        });

        clearTxtBtn.setText("Clear");
        clearTxtBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearTxtBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("ID");

        accountTypeCbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Income", "Expense" }));

        jLabel2.setText("Amount");

        jLabel3.setText("Account Type");

        jLabel4.setText("Description");

        jLabel5.setText("Date");

        idCbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idCboxActionPerformed(evt);
            }
        });

        entrySearchBtn.setText("Search Entry");
        entrySearchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrySearchBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(entrySearchBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(entryUpdateBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clearTxtBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateTxt))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(descTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(accountTypeCbox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(amtTxt))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(idCbox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(idCbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(dateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(amtTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(accountTypeCbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(descTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(entryUpdateBtn)
                    .addComponent(clearTxtBtn)
                    .addComponent(entrySearchBtn))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void entryUpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entryUpdateBtnActionPerformed
        
        int response = JOptionPane.showConfirmDialog(this, "Do you want to Update this record?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if (response == JOptionPane.YES_OPTION){ 
            
            try {

                String date = dateTxt.getText();
                String amount = amtTxt.getText();
                String account = accountTypeCbox.getSelectedItem().toString();
                String desc = descTxt.getText();
                String id = idCbox.getSelectedItem().toString();

                pstUpdate = con.prepareStatement("UPDATE accounts SET date=?, amount=?, account_Type=?, description=? WHERE ID=?");
                pstUpdate.setString(1, date);
                pstUpdate.setString(2, amount);
                pstUpdate.setString(3, account);
                pstUpdate.setString(4, desc);
                pstUpdate.setString(5, id);

                int x = pstUpdate.executeUpdate();

                    if (x==1){
                
                        JOptionPane.showMessageDialog(this, "Record Updated Successfully!");
                        dateTxt.setText("");
                        amtTxt.setText("");
                        descTxt.setText("");
                        LoadID();
                
                    }else{
                        JOptionPane.showMessageDialog(this, "Record was not Updated!");           
                    }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex);
            }
        
        }else if(response == JOptionPane.NO_OPTION){
                
        } 
    }//GEN-LAST:event_entryUpdateBtnActionPerformed

    private void clearTxtBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearTxtBtnActionPerformed

        dateTxt.setText("");
        amtTxt.setText("");
        descTxt.setText("");
        
    }//GEN-LAST:event_clearTxtBtnActionPerformed

    private void entrySearchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrySearchBtnActionPerformed
        
        try {
            String id = idCbox.getSelectedItem().toString();
            
            pstLoadData = con.prepareStatement("SELECT * FROM accounts WHERE ID=?");
            pstLoadData.setString(1,id);
            rs = pstLoadData.executeQuery();
            
            if (rs.next()==true){
                dateTxt.setText(rs.getString(2));
                amtTxt.setText(rs.getString(3));
                accountTypeCbox.getEditor().setItem((rs.getString(4)));
                descTxt.setText(rs.getString(5));
            } else {
                JOptionPane.showMessageDialog(this, "No Record Found!");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(entryUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }//GEN-LAST:event_entrySearchBtnActionPerformed

    private void idCboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idCboxActionPerformed
        
        //Load ID on ComboBox value change
        
//        try {
//            
//            String id = idCbox.getSelectedItem().toString();
//            
//            pstLoadData = con.prepareStatement("SELECT * FROM accounts WHERE ID=?");
//            pstLoadData.setString(1,id);
//            rs = pstLoadData.executeQuery();
//            
//            while (rs.next() == true){
//                dateTxt.setText(rs.getString(2));
//                amtTxt.setText(rs.getString(3));
//                accountTypeCbox.getEditor().setItem((rs.getString(4)));
//                descTxt.setText(rs.getString(5));
//                //LoadID(); 
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(entryUpdate.class.getName()).log(Level.SEVERE, null, ex);
//        }
               
    }//GEN-LAST:event_idCboxActionPerformed

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
            java.util.logging.Logger.getLogger(entryUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(entryUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(entryUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(entryUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new entryUpdate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> accountTypeCbox;
    private javax.swing.JTextField amtTxt;
    private javax.swing.JButton clearTxtBtn;
    private javax.swing.JTextField dateTxt;
    private javax.swing.JFormattedTextField descTxt;
    private javax.swing.JButton entrySearchBtn;
    private javax.swing.JButton entryUpdateBtn;
    private javax.swing.JComboBox<String> idCbox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
