package com.mycompany.mavenproject1;


public class ManagmentDashboardFrame extends javax.swing.JFrame {

  
    public ManagmentDashboardFrame() {
        initComponents();
        this.userNameLabel.setText(ManagerAuth.UserName);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        parentPanel = new javax.swing.JPanel();
        headerPanel = new javax.swing.JPanel();
        userNameFiller = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(10, 0));
        userNameLabel = new javax.swing.JLabel();
        dashboardPanel = new javax.swing.JPanel();
        addParentButton = new javax.swing.JToggleButton();
        addStudentButton = new javax.swing.JToggleButton();
        addTeacherButton = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dashboard");
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        parentPanel.setLayout(new java.awt.BorderLayout());

        headerPanel.setLayout(new javax.swing.BoxLayout(headerPanel, javax.swing.BoxLayout.LINE_AXIS));
        headerPanel.add(userNameFiller);

        userNameLabel.setText("John Doe");
        headerPanel.add(userNameLabel);

        parentPanel.add(headerPanel, java.awt.BorderLayout.PAGE_START);

        addParentButton.setText("Add Parent");
        addParentButton.setToolTipText("Directs to Parent add page");
        addParentButton.setAutoscrolls(true);
        addParentButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addParentButton.setMaximumSize(new java.awt.Dimension(110, 110));
        addParentButton.setMinimumSize(new java.awt.Dimension(110, 25));
        addParentButton.setPreferredSize(new java.awt.Dimension(170, 25));
        addParentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addParentButtonActionPerformed(evt);
            }
        });
        dashboardPanel.add(addParentButton);

        addStudentButton.setText("Add Student");
        addStudentButton.setToolTipText("Directs to student add page");
        addStudentButton.setAutoscrolls(true);
        addStudentButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addStudentButton.setMaximumSize(new java.awt.Dimension(110, 110));
        addStudentButton.setMinimumSize(new java.awt.Dimension(110, 25));
        addStudentButton.setPreferredSize(new java.awt.Dimension(170, 25));
        addStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStudentButtonActionPerformed(evt);
            }
        });
        dashboardPanel.add(addStudentButton);

        addTeacherButton.setText("Add Teacher");
        addTeacherButton.setToolTipText("Directs to teacher add page");
        addTeacherButton.setAutoscrolls(true);
        addTeacherButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addTeacherButton.setMaximumSize(new java.awt.Dimension(110, 110));
        addTeacherButton.setMinimumSize(new java.awt.Dimension(110, 25));
        addTeacherButton.setPreferredSize(new java.awt.Dimension(170, 25));
        addTeacherButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTeacherButtonActionPerformed(evt);
            }
        });
        dashboardPanel.add(addTeacherButton);

        parentPanel.add(dashboardPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(parentPanel);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addParentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addParentButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addParentButtonActionPerformed

    private void addStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStudentButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addStudentButtonActionPerformed

    private void addTeacherButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTeacherButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addTeacherButtonActionPerformed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManagmentDashboardFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton addParentButton;
    private javax.swing.JToggleButton addStudentButton;
    private javax.swing.JToggleButton addTeacherButton;
    private javax.swing.JPanel dashboardPanel;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JPanel parentPanel;
    private javax.swing.Box.Filler userNameFiller;
    private javax.swing.JLabel userNameLabel;
    // End of variables declaration//GEN-END:variables
}
