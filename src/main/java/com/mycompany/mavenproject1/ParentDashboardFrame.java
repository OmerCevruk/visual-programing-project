package com.mycompany.mavenproject1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * @author Arda
 */
public class ParentDashboardFrame extends javax.swing.JFrame {

    private JButton viewAttendanceButton;
    private JDBCPostgreSQLConnection dbConnection;
    private Connection conn;
    private int childID;
    
    public ParentDashboardFrame(int parentID) {
        dbConnection = new JDBCPostgreSQLConnection();
        conn = dbConnection.connect();
        initComponents();
        loadChildData(parentID);
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerPanel = new javax.swing.JPanel();
        userNameFiller = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(10, 0));
        userNameLabel = new javax.swing.JLabel();
        dashboardPanel = new javax.swing.JPanel();
        dashboardPanel1 = new javax.swing.JPanel();
        ViewAttendancesButton = new javax.swing.JToggleButton();
        LogoutButton = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        headerPanel.setLayout(new javax.swing.BoxLayout(headerPanel, javax.swing.BoxLayout.LINE_AXIS));
        headerPanel.add(userNameFiller);

        userNameLabel.setText("John Doe");
        headerPanel.add(userNameLabel);

        ViewAttendancesButton.setText("View Attendances");
        ViewAttendancesButton.setToolTipText("Directs to Parent add page");
        ViewAttendancesButton.setAutoscrolls(true);
        ViewAttendancesButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ViewAttendancesButton.setMaximumSize(new java.awt.Dimension(110, 110));
        ViewAttendancesButton.setMinimumSize(new java.awt.Dimension(110, 25));
        ViewAttendancesButton.setPreferredSize(new java.awt.Dimension(170, 25));
        ViewAttendancesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewAttendancesButtonActionPerformed(evt);
            }
        });
        dashboardPanel1.add(ViewAttendancesButton);

        LogoutButton.setText("Logout");
        LogoutButton.setToolTipText("Directs to teacher add page");
        LogoutButton.setAutoscrolls(true);
        LogoutButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LogoutButton.setMaximumSize(new java.awt.Dimension(110, 110));
        LogoutButton.setMinimumSize(new java.awt.Dimension(110, 25));
        LogoutButton.setPreferredSize(new java.awt.Dimension(170, 25));
        LogoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutButtonActionPerformed(evt);
            }
        });
        dashboardPanel1.add(LogoutButton);

        dashboardPanel.add(dashboardPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 870, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 870, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dashboardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 870, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 443, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 105, Short.MAX_VALUE)
                    .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(dashboardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 106, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ViewAttendancesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewAttendancesButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ViewAttendancesButtonActionPerformed

    private void LogoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LogoutButtonActionPerformed
    
     private void loadChildData(int parentID) {
        try {
            String sql = "SELECT \"ChildID\" FROM parent_child WHERE \"ParentID\" = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, parentID);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                childID = rs.getInt("ChildID");
            } else {
                JOptionPane.showMessageDialog(this, "No child found for this parent.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading child data.");
        }
    }
  
    public static void main(String[] args) {
        int parentID = 5; // Replace with actual parent ID from login
        new ParentDashboardFrame(parentID).setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton LogoutButton;
    private javax.swing.JToggleButton ViewAttendancesButton;
    private javax.swing.JPanel dashboardPanel;
    private javax.swing.JPanel dashboardPanel1;
    private javax.swing.JPanel headerPanel;
    private javax.swing.Box.Filler userNameFiller;
    private javax.swing.JLabel userNameLabel;
    // End of variables declaration//GEN-END:variables
}
