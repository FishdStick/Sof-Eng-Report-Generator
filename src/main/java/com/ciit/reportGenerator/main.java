/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.ciit.reportGenerator;

import com.raven.datechooser.DateChooser;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.Iterator;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.xml.crypto.Data;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 *
 * @author Mikel
 */
public class main extends javax.swing.JFrame {

    private DateChooser chDate = new DateChooser();
    
    public main() {
        initComponents();
        chDate.setTextField(dateText);
        chDate.setDateSelectionMode(DateChooser.DateSelectionMode.BETWEEN_DATE_SELECTED);
        chDate.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        
        Connect();
        FetchData();
    }
 
        Connection con;
        PreparedStatement pst;
        ResultSet rs;
        
    public void Connect(){

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inex","root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    }
    
    private void FetchData(){
        
        try {
            int q;
            pst = con.prepareStatement("SELECT * FROM accounts");
            rs = pst.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            q = rss.getColumnCount();
            
            DefaultTableModel df = (DefaultTableModel)accounts.getModel();
            df.setRowCount(0);
            
            while(rs.next()){
                
                Vector v2 = new Vector();
                
                for(int a=1; a<=q;a++){
                    
                    v2.add(rs.getString("ID"));
                    v2.add(rs.getString("date"));
                    v2.add(rs.getString("amount"));
                    v2.add(rs.getString("account_Type"));
                    v2.add(rs.getString("description"));
                    
                }
                df.addRow(v2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void Export(JTable table, File file){
        
        TableModel m = accounts.getModel();
        
        try {
            
            FileWriter fw = new FileWriter(file);
            for (int i = 0; i<m.getColumnCount(); i++){
                
                fw.write(m.getColumnName(i)+"\t");
                
            }
            fw.write("\n");
            
            for (int i = 0; i<m.getRowCount(); i++){
                for (int j = 0; j<m.getColumnCount(); j++){
                    fw.write(m.getValueAt(i,j).toString()+"\t");
                }
                fw.write("\n");
            }
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        accounts = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        addEntry = new javax.swing.JButton();
        updateEntry = new javax.swing.JButton();
        deleteEntry = new javax.swing.JButton();
        exportToExcel = new javax.swing.JButton();
        refreshTable = new javax.swing.JButton();
        viewAuditTrail = new javax.swing.JButton();
        dateText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        highlightCells = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        accounts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Date", "Amount", "Account Type", "Description"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(accounts);

        jLabel1.setText("INEX Generator");

        addEntry.setText("New Entry");
        addEntry.setToolTipText("");
        addEntry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEntryActionPerformed(evt);
            }
        });

        updateEntry.setText("Update Entry");
        updateEntry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateEntryActionPerformed(evt);
            }
        });

        deleteEntry.setText("Delete Entry");
        deleteEntry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteEntryActionPerformed(evt);
            }
        });

        exportToExcel.setText("Export");
        exportToExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportToExcelActionPerformed(evt);
            }
        });

        refreshTable.setText("Refresh");
        refreshTable.setToolTipText("");
        refreshTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshTableActionPerformed(evt);
            }
        });

        viewAuditTrail.setText("Audit Log");
        viewAuditTrail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAuditTrailActionPerformed(evt);
            }
        });

        jLabel2.setText("Date Range");

        highlightCells.setText("Higlight");
        highlightCells.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                highlightCellsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addEntry)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(updateEntry)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deleteEntry)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(refreshTable)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(exportToExcel)
                        .addGap(12, 12, 12)
                        .addComponent(highlightCells)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(viewAuditTrail))
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dateText, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 966, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addEntry)
                    .addComponent(updateEntry)
                    .addComponent(deleteEntry)
                    .addComponent(refreshTable)
                    .addComponent(exportToExcel)
                    .addComponent(viewAuditTrail)
                    .addComponent(highlightCells))
                .addContainerGap(123, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateEntryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateEntryActionPerformed
        new entryUpdate().setVisible(true);
    }//GEN-LAST:event_updateEntryActionPerformed

    private void addEntryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEntryActionPerformed
        new entryAdd().setVisible(true);
    }//GEN-LAST:event_addEntryActionPerformed

    private void viewAuditTrailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAuditTrailActionPerformed
        new auditLog().setVisible(true);
    }//GEN-LAST:event_viewAuditTrailActionPerformed

    private void deleteEntryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteEntryActionPerformed
        new entryDelete().setVisible(true);
    }//GEN-LAST:event_deleteEntryActionPerformed

    private void refreshTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshTableActionPerformed
        FetchData();    
    }//GEN-LAST:event_refreshTableActionPerformed

    private void exportToExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportToExcelActionPerformed
        
        JFileChooser jChoose = new JFileChooser();
        int option = jChoose.showSaveDialog(main.this);
        
            if(option == JFileChooser.APPROVE_OPTION){
                
                String name = jChoose.getSelectedFile().getName();
                String path = jChoose.getSelectedFile().getParentFile().getPath();
                String file = path + "\\" + name + ".xls";

                Export(accounts, new File(file));
 
            }
    }//GEN-LAST:event_exportToExcelActionPerformed

    private void highlightCellsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_highlightCellsActionPerformed
         
        JFileChooser jChoose = new JFileChooser();
        int option = jChoose.showOpenDialog(main.this);
        
            if(option == JFileChooser.APPROVE_OPTION){
                
                File file = jChoose.getSelectedFile();
                
                try{
                    
                    FileInputStream fileIn = new FileInputStream(file);
                    
                    XSSFWorkbook wb = new XSSFWorkbook(fileIn);
                    XSSFSheet sheet = wb.getSheetAt(0);
                    //Note: If you want to use different cellstyles, declare different cellstyles
                    XSSFCellStyle income = wb.createCellStyle();
                    XSSFCellStyle expense = wb.createCellStyle();   
                    Iterator <Row> rowIterator = sheet.iterator();
                   
                    while (rowIterator.hasNext()){
                        
                        Row row = rowIterator.next();
                        Cell cell = row.getCell(3);
                        
                            if(cell.toString().equals("Income")){
                                income.setFillForegroundColor(IndexedColors.BRIGHT_GREEN.getIndex());
                                income.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                                cell.setCellStyle(income);
                                
                            }else if(cell.toString().equals("Expense")){
                                expense.setFillForegroundColor(IndexedColors.RED.getIndex());
                                expense.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                                cell.setCellStyle(expense);
                                
                            }

                    }
     
                        FileOutputStream fileOut = new FileOutputStream(file);
                        wb.write(fileOut);
                        wb.close();
                        fileOut.close();
                        
                } catch (Exception e){
                    System.out.println(e.getMessage());
                }
        }
   
    }//GEN-LAST:event_highlightCellsActionPerformed

    /**
     *
     * @param args
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
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable accounts;
    private javax.swing.JButton addEntry;
    private javax.swing.JTextField dateText;
    private javax.swing.JButton deleteEntry;
    private javax.swing.JButton exportToExcel;
    private javax.swing.JButton highlightCells;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton refreshTable;
    private javax.swing.JButton updateEntry;
    private javax.swing.JButton viewAuditTrail;
    // End of variables declaration//GEN-END:variables
}
