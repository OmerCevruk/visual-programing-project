package com.mycompany.mavenproject1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;

public class AttendanceFrame extends javax.swing.JFrame {
    private int parentID;
    private String parentName;
 
    private Connection conn;

    Vector<Vector<Object>> data = new Vector<>();

    public AttendanceFrame(int parentID) {
        this.parentID = parentID;
        this.parentID = ParentAuth.parentId;
        this.parentName = ParentAuth.userName;
        initComponents();
        initializeDatabaseConnection();
        loadDataFromDatabase();
        populateTable();
        
    }

    private void initializeDatabaseConnection() {
        try {
            conn = new JDBCPostgreSQLConnection().connect();
        } catch (Exception e) {
            Logger.getLogger(AttendanceFrame.class.getName()).log(Level.SEVERE, "Database connection failed", e);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        attendanceTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Attendance");

        attendanceTable.setModel(new DefaultTableModel(
            new Object [][] {},
            new String [] {"Date", "Status"}
        ));
        jScrollPane1.setViewportView(attendanceTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


private void loadDataFromDatabase() {
        data = new Vector<>();
        try (PreparedStatement pstmt = conn.prepareStatement(
            "SELECT a.\"Date\", a.\"Status\" " +
            "FROM attendance a " +
            "JOIN parent_child pc ON a.\"ChildID\" = pc.\"ChildID\" " +
            "WHERE pc.\"ParentID\" = ?")) {
            System.out.println(parentID);
            System.out.println(parentName);
            pstmt.setInt(1, parentID);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Vector<Object> row = new Vector<>();
                row.add(rs.getString("Date"));
                row.add(rs.getString("Status"));
                System.out.println(row+"aaaaaaaa"+parentID+parentName);
                data.add(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceFrame.class.getName()).log(Level.SEVERE, "Failed to load data", ex);
        }
    }

    private void populateTable() {
        if (data.isEmpty()) {
            Logger.getLogger(AttendanceFrame.class.getName()).log(Level.WARNING, "No data to display");
            return;
        }

        Object[][] tableData = convertDataToTableFormat();
        DefaultTableModel tableModel = createTableModel(tableData);

        attendanceTable.setModel(tableModel);
        tableModel.fireTableDataChanged();
    }

    private Object[][] convertDataToTableFormat() {
        int rowCount = data.size();
        int colCount = data.get(0).size();
        Object[][] tableData = new Object[rowCount][colCount];

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                tableData[i][j] = data.get(i).get(j);
            }
        }

        return tableData;
    }

    private DefaultTableModel createTableModel(Object[][] tableData) {
        return new DefaultTableModel(tableData, new Object[]{"Date", "Status"}) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // All cells are non-editable
            }
        };
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new AttendanceFrame(5).setVisible(true); // Example parentID
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable attendanceTable;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
