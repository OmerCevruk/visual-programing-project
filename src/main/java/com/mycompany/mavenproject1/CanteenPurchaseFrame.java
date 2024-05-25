package com.mycompany.mavenproject1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class CanteenPurchaseFrame extends javax.swing.JFrame {
    Connection conn = new JDBCPostgreSQLConnection().connect();
    
    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
    
    public CanteenPurchaseFrame() {
        initComponents();
        
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM public.canteen_product");
            while (rs.next()) {
                Vector<Object> row = new Vector<Object>();
                row.add(rs.getString("ProductName"));
                row.add(rs.getDouble("Price"));
                row.add(false);
                row.add(0);
                data.add(row);
            }
            
            Vector<String> columnNames = new Vector<String>();
            columnNames.add("Product Name");
            columnNames.add("Price");
            columnNames.add("Select");
            columnNames.add("Count");

            DefaultTableModel tableModel = new DefaultTableModel(data, columnNames) {
                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    switch (columnIndex) {
                        case 2: return Boolean.class;
                        case 3: return Integer.class;
                        default: return String.class;
                    }
                }

                @Override
                public boolean isCellEditable(int row, int column) {
                    return column == 2 || column == 3;
                }
            };

            this.ItemTable.setModel(tableModel);

        } catch (SQLException ex) {
            Logger.getLogger(CanteenPurchaseFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TopPanel = new javax.swing.JPanel();
        StudentNameLabel = new javax.swing.JLabel();
        BoxPanel = new javax.swing.JPanel();
        CenterPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ItemTable = new javax.swing.JTable();
        BottomPanel = new javax.swing.JPanel();
        ConfirmButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        StudentNameLabel.setText("Student Name");
        TopPanel.add(StudentNameLabel);

        BoxPanel.setLayout(new javax.swing.BoxLayout(BoxPanel, javax.swing.BoxLayout.LINE_AXIS));
        TopPanel.add(BoxPanel);

        getContentPane().add(TopPanel, java.awt.BorderLayout.PAGE_START);

        CenterPanel.setLayout(new javax.swing.BoxLayout(CenterPanel, javax.swing.BoxLayout.LINE_AXIS));

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
        jScrollPane1.setViewportView(ItemTable);

        CenterPanel.add(jScrollPane1);

        getContentPane().add(CenterPanel, java.awt.BorderLayout.CENTER);

        ConfirmButton.setText("ConfirmButton");
        BottomPanel.add(ConfirmButton);

        getContentPane().add(BottomPanel, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ItemTablePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_ItemTablePropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_ItemTablePropertyChange

    
    public static void main(String args[]) {
        
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
    private javax.swing.JLabel StudentNameLabel;
    private javax.swing.JPanel TopPanel;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
