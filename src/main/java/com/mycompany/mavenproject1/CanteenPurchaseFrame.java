/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.sql.CallableStatement;
import java.util.List;
import javafx.util.Pair;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

/**
 *
 * @author Omer
 */
public class CanteenPurchaseFrame extends javax.swing.JFrame {
    Connection conn;
    private javax.swing.JTable table;
    
    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
    /**
     * Creates new form CanteenPurchaseFrame
     */
    public CanteenPurchaseFrame() {
        initComponents();
        this.table = new javax.swing.JTable();
        initializeDatabaseConnection();
        loadDataFromDatabase();
        populateTable();
        TableScrollPane.setViewportView(table);      
        
    }
    
    private void initializeDatabaseConnection() {
        try {
            conn = new JDBCPostgreSQLConnection().connect();
        } catch (Exception e) {
            Logger.getLogger(CanteenPurchaseFrame.class.getName()).log(Level.SEVERE, "Database connection failed", e);
        }
    }
    
     /**
     * Loads data from the database.
     */
    private void loadDataFromDatabase() {
        data = new Vector<>();
        try (Statement stmt = conn.createStatement();
           ResultSet rs = stmt.executeQuery("SELECT * FROM public.canteen_product")) {
            while (rs.next()) {
                Vector<Object> row = new Vector<>();
                row.add(rs.getString("ProductName"));
                row.add(rs.getDouble("Price")); // Directly add the price as Double
                row.add(0); // Count
                data.add(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CanteenPurchaseFrame.class.getName()).log(Level.SEVERE, "Failed to load data", ex);
        }
    }

    private void populateTable() {
        if (data.isEmpty()) {
            Logger.getLogger(CanteenPurchaseFrame.class.getName()).log(Level.WARNING, "No data to display");
            return;
        }

        Object[][] tableData = convertDataToTableFormat();
        DefaultTableModel tableModel = createTableModel(tableData);

        table.setModel(tableModel);
        tableModel.fireTableDataChanged();
        
        tableModel.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE && e.getColumn() == 2) {
                    updateTotalPrice();
                }
            }
        });
        
    }
    
     /**
     * Converts the Vector data into a 2D Object array for the table model.
     */
    private Object[][] convertDataToTableFormat() {
        int rowCount = data.size();
        int colCount = data.get(0).size();
        Object[][] tableData = new Object[rowCount][colCount];

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                tableData[i][j] = data.get(i).get(j);
//                System.out.println(tableData[i][j]);
            }
        }

        return tableData;
    }
    
     /**
     * Creates a table model with the specified data.
     */
    private DefaultTableModel createTableModel(Object[][] tableData) {
        // Exclude the checkbox column
       return new DefaultTableModel(tableData, new Object[]{"Product Name", "Price", "Count"}) {
           @Override
           public Class<?> getColumnClass(int columnIndex) {
               return switch (columnIndex) {
                   case 1 -> Double.class;
                   case 2 -> Integer.class;
                   default -> String.class;
               }; 
           }

           @Override
           public boolean isCellEditable(int row, int column) {
               return column == 2; // Make count column editable
           }
           
           
       };
    }
    
    private void updateTotalPrice() {
        double totalPrice = 0;
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        for (int row = 0; row < tableModel.getRowCount(); row++) {
            double price = (double) tableModel.getValueAt(row, 1);
            int count = (int) tableModel.getValueAt(row, 2);
            totalPrice += price * count;
        }
        TotalPriceLabel.setText("Total: " + totalPrice + " tl");
    }
    
    private List<Pair<String, Integer>> getNameAndCountForEachRow() {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        List<Pair<String, Integer>> nameAndCountList = new ArrayList<>();

        for (int row = 0; row < tableModel.getRowCount(); row++) {
            String productName = (String) tableModel.getValueAt(row, 0); // Assuming "Product Name" is in the first column
            int count = (int) tableModel.getValueAt(row, 2); // Assuming "Count" is in the third column

            nameAndCountList.add(new Pair<>(productName, count));
        }
        return nameAndCountList;
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TopPanel = new javax.swing.JPanel();
        BoxPanel = new javax.swing.JPanel();
        TotalPriceLabel = new javax.swing.JLabel();
        CenterPanel = new javax.swing.JPanel();
        LeftPadding = new javax.swing.JPanel();
        TableScrollPane = new javax.swing.JScrollPane();
        ItemTable = new javax.swing.JTable();
        RightPadding = new javax.swing.JPanel();
        BottomPanel = new javax.swing.JPanel();
        StudentName = new javax.swing.JTextField();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(40, 0), new java.awt.Dimension(40, 0), new java.awt.Dimension(40, 32767));
        ConfirmButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Canteen Purchase");

        BoxPanel.setLayout(new javax.swing.BoxLayout(BoxPanel, javax.swing.BoxLayout.LINE_AXIS));
        TopPanel.add(BoxPanel);

        TotalPriceLabel.setText("Total:0 tl");
        TopPanel.add(TotalPriceLabel);

        getContentPane().add(TopPanel, java.awt.BorderLayout.PAGE_START);

        CenterPanel.setLayout(new javax.swing.BoxLayout(CenterPanel, javax.swing.BoxLayout.LINE_AXIS));
        CenterPanel.add(LeftPadding);

        ItemTable.setAutoCreateColumnsFromModel(false);
        ItemTable.setAutoCreateRowSorter(true);
        ItemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        ItemTable.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                ItemTablePropertyChange(evt);
            }
        });
        TableScrollPane.setViewportView(ItemTable);

        CenterPanel.add(TableScrollPane);
        CenterPanel.add(RightPadding);

        getContentPane().add(CenterPanel, java.awt.BorderLayout.CENTER);

        StudentName.setText("Enter Student name");
        StudentName.setToolTipText("name of the buyer");
        StudentName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StudentNameActionPerformed(evt);
            }
        });
        BottomPanel.add(StudentName);
        BottomPanel.add(filler1);

        ConfirmButton.setText("ConfirmButton");
        ConfirmButton.setToolTipText("Finish purchase");
        ConfirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmButtonActionPerformed(evt);
            }
        });
        BottomPanel.add(ConfirmButton);

        getContentPane().add(BottomPanel, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ItemTablePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_ItemTablePropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_ItemTablePropertyChange

    private void ConfirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmButtonActionPerformed
        String studentName = StudentName.getText(); // Get the student name from the text field
        List<Pair<String, Integer>> items = getNameAndCountForEachRow(); // Get table data
        // Iterate through table data and call the procedure for each product
        for (Pair<String, Integer> item : items) {
            String productName = item.getKey();
            int count = item.getValue();
            try {
                conn.setAutoCommit(false);
            } catch (SQLException ex) {
                Logger.getLogger(CanteenPurchaseFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if(count == 0){continue;}
            for(int i = 0; i < count; i++){
                try {                          
                // Call the stored procedure with the student name, product name, and current timestamp
                CallableStatement stmt = conn.prepareCall("CALL make_canteen_purchase_by_names(?, ?)");
                stmt.setString(1, studentName);
                stmt.setString(2, productName);
                stmt.execute();
                //TODO show a dialog that tells the user the transaction is complete
                } catch (SQLException ex) {
                    String dialogMsg = "";
                    if (ex.getMessage().contains("restricted")) {
                        dialogMsg = "This item is restricted.";
                    } else if (ex.getMessage().contains("Insufficient balance")) {
                        dialogMsg = "Not enough balance to complete the purchase.";
                    } else if (ex.getMessage().contains(studentName)) {
                        dialogMsg = "No student named " + studentName + " was found.";
                    } else {
                        dialogMsg = ex.getMessage(); // show the actual error message
                    }  
                    JOptionPane.showMessageDialog(null, dialogMsg, "Error", JOptionPane.ERROR_MESSAGE);
                    try {
                        conn.rollback();
                    } catch (SQLException ex1) {
                        Logger.getLogger(CanteenPurchaseFrame.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                    return;
                }
            }
            try {
                conn.commit();
                JOptionPane.showMessageDialog(null, "Transaction Succesfull", "Purchase complete", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException ex) {
                Logger.getLogger(CanteenPurchaseFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_ConfirmButtonActionPerformed

    private void StudentNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StudentNameActionPerformed
        
    }//GEN-LAST:event_StudentNameActionPerformed

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
                if ("GTK+".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CanteenPurchaseFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CanteenPurchaseFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CanteenPurchaseFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CanteenPurchaseFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CanteenPurchaseFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BottomPanel;
    private javax.swing.JPanel BoxPanel;
    private javax.swing.JPanel CenterPanel;
    private javax.swing.JButton ConfirmButton;
    private javax.swing.JTable ItemTable;
    private javax.swing.JPanel LeftPadding;
    private javax.swing.JPanel RightPadding;
    private javax.swing.JTextField StudentName;
    private javax.swing.JScrollPane TableScrollPane;
    private javax.swing.JPanel TopPanel;
    private javax.swing.JLabel TotalPriceLabel;
    private javax.swing.Box.Filler filler1;
    // End of variables declaration//GEN-END:variables
}
