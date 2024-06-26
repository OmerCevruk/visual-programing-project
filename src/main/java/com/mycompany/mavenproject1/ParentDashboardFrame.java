package com.mycompany.mavenproject1;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * @author Arda
 */
public class ParentDashboardFrame extends javax.swing.JFrame {

    private final JDBCPostgreSQLConnection dbConnection;
    private final Connection conn;

    private int parentID;
    
    public ParentDashboardFrame() {
        dbConnection = new JDBCPostgreSQLConnection();
        conn = dbConnection.connect();
        this.parentID = ParentAuth.parentId;
        initComponents();
        this.userNameLabel.setText(ParentAuth.userName);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerPanel = new javax.swing.JPanel();
        userNameFiller = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(10, 0));
        userNameLabel = new javax.swing.JLabel();
        dashboardPanel = new javax.swing.JPanel();
        viewAttendanceButton = new javax.swing.JToggleButton();
        logoutButton = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Dashboard");

        headerPanel.setLayout(new javax.swing.BoxLayout(headerPanel, javax.swing.BoxLayout.LINE_AXIS));
        headerPanel.add(userNameFiller);

        userNameLabel.setText("John Doe");
        headerPanel.add(userNameLabel);

        dashboardPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 5));

        viewAttendanceButton.setText("View Attendances");
        viewAttendanceButton.setToolTipText("Directs to Parent add page");
        viewAttendanceButton.setAutoscrolls(true);
        viewAttendanceButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        viewAttendanceButton.setMaximumSize(new java.awt.Dimension(110, 110));
        viewAttendanceButton.setMinimumSize(new java.awt.Dimension(110, 25));
        viewAttendanceButton.setPreferredSize(new java.awt.Dimension(170, 25));
        viewAttendanceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAttendanceButtonActionPerformed(evt);
            }
        });
        dashboardPanel.add(viewAttendanceButton);

        logoutButton.setText("Logout");
        logoutButton.setToolTipText("Directs to teacher add page");
        logoutButton.setAutoscrolls(true);
        logoutButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logoutButton.setMaximumSize(new java.awt.Dimension(110, 110));
        logoutButton.setMinimumSize(new java.awt.Dimension(110, 25));
        logoutButton.setPreferredSize(new java.awt.Dimension(170, 25));
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });
        dashboardPanel.add(logoutButton);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                        .addComponent(dashboardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE))
                    .addGap(0, 0, 0)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 405, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(dashboardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void viewAttendanceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAttendanceButtonActionPerformed
        // Open the attendance frame
        new AttendanceFrame(parentID).setVisible(true);
    }//GEN-LAST:event_viewAttendanceButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
       // Reset ParentAuth state
        ParentAuth parentAuth = new ParentAuth();
        parentAuth.logout();
    
        // Close the parent dashboard
        dispose();

        // Show the login screen
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ParentLoginFrame().setVisible(true);
            }
        });
    }//GEN-LAST:event_logoutButtonActionPerformed
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new ParentDashboardFrame().setVisible(true); // Example parentID
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel dashboardPanel;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JToggleButton logoutButton;
    private javax.swing.Box.Filler userNameFiller;
    private javax.swing.JLabel userNameLabel;
    private javax.swing.JToggleButton viewAttendanceButton;
    // End of variables declaration//GEN-END:variables
}
