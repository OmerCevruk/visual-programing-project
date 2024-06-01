package com.mycompany.mavenproject1;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class AttendanceFrame extends javax.swing.JFrame {
    private JTable attendanceTable;
    private JDBCPostgreSQLConnection dbConnection;
    private Connection conn;
    
    public AttendanceFrame(int ChildID) {
        dbConnection = new JDBCPostgreSQLConnection();
        conn = dbConnection.connect();
        initComponents();
        int childID = 0;
        loadAttendanceData(childID);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void loadAttendanceData(int childID) {
        try {
            String sql = "SELECT \"Date\", \"Status\" FROM attendance WHERE \"ChildID\" = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, childID);
            ResultSet rs = pstmt.executeQuery();

            DefaultTableModel model = new DefaultTableModel(new String[]{"Date", "Status"}, 0);
            while (rs.next()) {
                String date = rs.getString("Date");
                String status = rs.getString("Status");
                model.addRow(new Object[]{date, status});
            }
            attendanceTable.setModel(model);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading attendance data.");
        }
    }

    public static void main(String[] args) {
        int childID = 6; // Replace with actual child ID
        new AttendanceFrame(childID).setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
