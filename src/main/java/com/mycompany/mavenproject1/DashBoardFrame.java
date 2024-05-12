/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author funghu
 */
public class DashBoardFrame extends javax.swing.JFrame {

    /**
     * Creates new form DashBoardFrame
     */
    public DashBoardFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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
        dashboardPanel.add(addParentButton);

        addStudentButton.setText("Add Student");
        addStudentButton.setToolTipText("Directs to student add page");
        addStudentButton.setAutoscrolls(true);
        addStudentButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addStudentButton.setMaximumSize(new java.awt.Dimension(110, 110));
        addStudentButton.setMinimumSize(new java.awt.Dimension(110, 25));
        addStudentButton.setPreferredSize(new java.awt.Dimension(170, 25));
        dashboardPanel.add(addStudentButton);

        addTeacherButton.setText("Add Teacher");
        addTeacherButton.setToolTipText("Directs to teacher add page");
        addTeacherButton.setAutoscrolls(true);
        addTeacherButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addTeacherButton.setMaximumSize(new java.awt.Dimension(110, 110));
        addTeacherButton.setMinimumSize(new java.awt.Dimension(110, 25));
        addTeacherButton.setPreferredSize(new java.awt.Dimension(170, 25));
        dashboardPanel.add(addTeacherButton);

        parentPanel.add(dashboardPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(parentPanel);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DashBoardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashBoardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashBoardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashBoardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashBoardFrame().setVisible(true);
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
