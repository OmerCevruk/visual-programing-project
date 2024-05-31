/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author funghu
 */
public class CanteenGoodsManagementFrame extends javax.swing.JFrame {
    Connection conn;
    private javax.swing.JTable table;
    
    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
    /**
     * Creates new form CanteenGoodsManagementFrame
     */
    public CanteenGoodsManagementFrame() {
        initComponents();
        this.table = new javax.swing.JTable();
        initializeDatabaseConnection();
        loadDataFromDatabase();
        populateTable();
        TableScrollPane.setViewportView(table); 
        updateAVGPrice();
        
    }
    
    private void initializeDatabaseConnection() {
        try {
            conn = new JDBCPostgreSQLConnection().connect();
        } catch (Exception e) {
            Logger.getLogger(CanteenPurchaseFrame.class.getName()).log(Level.SEVERE, "Database connection failed", e);
        }
    }

    private void loadDataFromDatabase() {
        data = new Vector<>();
        try (Statement stmt = conn.createStatement();
           ResultSet rs = stmt.executeQuery("SELECT * FROM public.canteen_product")) {
            while (rs.next()) {
                Vector<Object> row = new Vector<>();
                row.add(rs.getString("ProductName"));
                row.add(rs.getDouble("Price")); // Directly add the price as Double
                row.add(false); // fills the remove collum
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
                    updateAVGPrice();
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
    
    private DefaultTableModel createTableModel(Object[][] tableData) {
        // Exclude the checkbox column
       return new DefaultTableModel(tableData, new Object[]{"Product Name", "Price", "Remove"}) {
           @Override
           public Class<?> getColumnClass(int columnIndex) {
               return switch (columnIndex) {
                   case 1 -> Double.class;
                   case 2 -> Boolean.class;
                   default -> String.class;
               }; 
           }

           @Override
           public boolean isCellEditable(int row, int column) {
               return column == 2; // Make Remove column editable
           }
           
           
       };
    }
    
    private void updateAVGPrice() {
        double totalPrice = 0;
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        
        for (int row = 0; row < tableModel.getRowCount(); row++) {
            double price = (double) tableModel.getValueAt(row, 1);       
            totalPrice += price;
        }
        
        totalPrice = totalPrice/tableModel.getRowCount();
        AverageLabel.setText("Total: " + totalPrice + " tl");
    }
    
    private void removeSelectedRows() {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();

        for (int row = tableModel.getRowCount() - 1; row >= 0; row--) {
            Boolean isSelected = (Boolean) tableModel.getValueAt(row, 2);
            if (isSelected != null && isSelected) {
                String productName = (String) tableModel.getValueAt(row, 0);
                removeProductFromDatabase(productName);
                tableModel.removeRow(row);
            }
        }

        updateAVGPrice();
    }
    
    private void removeProductFromDatabase(String productName) {
        String deleteSQL = "DELETE FROM public.canteen_product WHERE \"ProductName\" = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(deleteSQL)) {
            pstmt.setString(1, productName);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CanteenPurchaseFrame.class.getName()).log(Level.SEVERE, "Failed to delete product", ex);
        }
    }
    
    private void addRowToTable() {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();

        // Get product name and price from text fields
        String productName = ProductName.getText().trim();
        double price;
        try {
            price = Double.parseDouble(Price.getText().trim());
        } catch (NumberFormatException e) {
            return;
        }
        // Check if product name or price is empty string
        if (productName.isEmpty()) {
            return;
        } else {
        }

        // Add data to the table model
        Object[] rowData = {productName, price, false};
        tableModel.addRow(rowData);

        addProductToDatabase(productName, price);
        ProductName.setText("");
        Price.setText("");
    }
    
    private void addProductToDatabase(String productName, double price) {
        String insertSQL = "INSERT INTO public.canteen_product(\"ProductName\", \"Price\") VALUES (?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
            pstmt.setString(1, productName);
            pstmt.setDouble(2, price);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CanteenPurchaseFrame.class.getName()).log(Level.SEVERE, "Failed to add product", ex);
        }
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
        AverageLabel = new javax.swing.JLabel();
        CenterPanel = new javax.swing.JPanel();
        LeftPadding = new javax.swing.JPanel();
        TableScrollPane = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        RightPadding = new javax.swing.JPanel();
        BottomPanel = new javax.swing.JPanel();
        ProductName = new javax.swing.JTextField();
        Price = new javax.swing.JTextField();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(30, 0), new java.awt.Dimension(32767, 0));
        SubmitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Goods Management");
        setMinimumSize(new java.awt.Dimension(500, 90));

        AverageLabel.setText("Average Price 0 tl");
        TopPanel.add(AverageLabel);

        getContentPane().add(TopPanel, java.awt.BorderLayout.PAGE_START);

        CenterPanel.setLayout(new javax.swing.BoxLayout(CenterPanel, javax.swing.BoxLayout.LINE_AXIS));
        CenterPanel.add(LeftPadding);

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
        TableScrollPane.setViewportView(jTable1);

        CenterPanel.add(TableScrollPane);
        CenterPanel.add(RightPadding);

        getContentPane().add(CenterPanel, java.awt.BorderLayout.CENTER);

        BottomPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 10));

        ProductName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ProductName.setText("Product Name");
        ProductName.setToolTipText("Name of the product you want to add");
        ProductName.setPreferredSize(new java.awt.Dimension(120, 25));
        BottomPanel.add(ProductName);

        Price.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Price.setText("Price");
        Price.setToolTipText("Price of the product that you want to add");
        Price.setPreferredSize(new java.awt.Dimension(120, 25));
        BottomPanel.add(Price);
        BottomPanel.add(filler1);

        SubmitButton.setText("Submit");
        SubmitButton.setToolTipText("Submit all the changes");
        SubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitButtonActionPerformed(evt);
            }
        });
        BottomPanel.add(SubmitButton);

        getContentPane().add(BottomPanel, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitButtonActionPerformed
 
        int confirmDialogResult = JOptionPane.showConfirmDialog(null, "Do you want to submit this data?", "Submit Data", JOptionPane.YES_NO_OPTION);
        if (confirmDialogResult == JOptionPane.YES_OPTION) {
            removeSelectedRows();
            addRowToTable();   
        }
    }//GEN-LAST:event_SubmitButtonActionPerformed

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
            java.util.logging.Logger.getLogger(CanteenGoodsManagementFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CanteenGoodsManagementFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CanteenGoodsManagementFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CanteenGoodsManagementFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CanteenGoodsManagementFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AverageLabel;
    private javax.swing.JPanel BottomPanel;
    private javax.swing.JPanel CenterPanel;
    private javax.swing.JPanel LeftPadding;
    private javax.swing.JTextField Price;
    private javax.swing.JTextField ProductName;
    private javax.swing.JPanel RightPadding;
    private javax.swing.JButton SubmitButton;
    private javax.swing.JScrollPane TableScrollPane;
    private javax.swing.JPanel TopPanel;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
