package com.mycompany.mavenproject1;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentDashboardFrame extends javax.swing.JFrame {

    public StudentDashboardFrame(int childID, String fullName) {
        initComponents();
        welcomeLabel.setText("Welcome, " + fullName);

        
        

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
       
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerPanel = new javax.swing.JPanel();
        userNameFiller = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(10, 0));
        welcomeLabel = new javax.swing.JLabel();
        dashboardPanel = new javax.swing.JPanel();
        canteenButton = new javax.swing.JToggleButton();
        viewClassesButton = new javax.swing.JToggleButton();
        logoutButton = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        headerPanel.setLayout(new javax.swing.BoxLayout(headerPanel, javax.swing.BoxLayout.LINE_AXIS));
        headerPanel.add(userNameFiller);
        headerPanel.add(welcomeLabel);

        canteenButton.setText("Make Purchase ");
        canteenButton.setToolTipText("Directs to Parent add page");
        canteenButton.setAutoscrolls(true);
        canteenButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        canteenButton.setMaximumSize(new java.awt.Dimension(110, 110));
        canteenButton.setMinimumSize(new java.awt.Dimension(110, 25));
        canteenButton.setPreferredSize(new java.awt.Dimension(170, 25));
        canteenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                canteenButtonActionPerformed(evt);
            }
        });
        dashboardPanel.add(canteenButton);

        viewClassesButton.setText("View Classes");
        viewClassesButton.setToolTipText("Directs to student add page");
        viewClassesButton.setAutoscrolls(true);
        viewClassesButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        viewClassesButton.setMaximumSize(new java.awt.Dimension(110, 110));
        viewClassesButton.setMinimumSize(new java.awt.Dimension(110, 25));
        viewClassesButton.setPreferredSize(new java.awt.Dimension(170, 25));
        viewClassesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewClassesButtonActionPerformed(evt);
            }
        });
        dashboardPanel.add(viewClassesButton);

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
            .addGap(0, 336, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(dashboardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void canteenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_canteenButtonActionPerformed
        CanteenPurchaseFrame canteenFrame = new CanteenPurchaseFrame();
        canteenFrame.setVisible(true);
    }//GEN-LAST:event_canteenButtonActionPerformed

    private void viewClassesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewClassesButtonActionPerformed
        
    }//GEN-LAST:event_viewClassesButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
         // Close the student dashboard
        dispose();
    }//GEN-LAST:event_logoutButtonActionPerformed

     public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentDashboardFrame(1, "John Doe").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton canteenButton;
    private javax.swing.JPanel dashboardPanel;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JToggleButton logoutButton;
    private javax.swing.Box.Filler userNameFiller;
    private javax.swing.JToggleButton viewClassesButton;
    private javax.swing.JLabel welcomeLabel;
    // End of variables declaration//GEN-END:variables
}
