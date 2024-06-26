/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author funghu
 */
public class TakeAttandanceFrame extends javax.swing.JFrame {
    private Connection conn;
    /**
     * Creates new form TakeAttandanceFrame
     */
    public TakeAttandanceFrame() {
        initComponents();
        conn = new JDBCPostgreSQLConnection().connect();
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
        headerLabel = new javax.swing.JLabel();
        BottomPanel = new javax.swing.JPanel();
        CenterPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        studentNumberField = new javax.swing.JTextField();
        AbsentButton = new javax.swing.JButton();
        PresentButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Take attendance");

        headerLabel.setText("Take attendance");
        TopPanel.add(headerLabel);

        getContentPane().add(TopPanel, java.awt.BorderLayout.PAGE_START);
        getContentPane().add(BottomPanel, java.awt.BorderLayout.PAGE_END);

        jLabel1.setText("Student Number");

        studentNumberField.setText("1");

        AbsentButton.setText("Absent");
        AbsentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbsentButtonActionPerformed(evt);
            }
        });

        PresentButton.setText("Present");
        PresentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PresentButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(91, 91, 91))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(studentNumberField)
                            .addComponent(AbsentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PresentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(109, 109, 109))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(studentNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(AbsentButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PresentButton)
                .addContainerGap(103, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout CenterPanelLayout = new javax.swing.GroupLayout(CenterPanel);
        CenterPanel.setLayout(CenterPanelLayout);
        CenterPanelLayout.setHorizontalGroup(
            CenterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CenterPanelLayout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(84, 84, 84))
        );
        CenterPanelLayout.setVerticalGroup(
            CenterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(CenterPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void markAttendance(int studentId, String status) {
    LocalDate currentDate = LocalDate.now();
    Date sqlDate = Date.valueOf(currentDate);

    try {
        // Check if the attendance record exists for the given student and current date
        String checkSql = "SELECT \"AttendanceID\" FROM attendance WHERE \"ChildID\" = ? AND \"Date\" = ?";
        PreparedStatement checkStmt = conn.prepareStatement(checkSql);
        checkStmt.setInt(1, studentId);
        checkStmt.setDate(2, sqlDate);
        ResultSet rs = checkStmt.executeQuery();

        if (rs.next()) {
            // If record exists, update it
            int attendanceId = rs.getInt("AttendanceID");
            String updateSql = "UPDATE attendance SET \"Status\" = ? WHERE \"AttendanceID\" = ?";
            PreparedStatement updateStmt = conn.prepareStatement(updateSql);
            updateStmt.setString(1, status);
            updateStmt.setInt(2, attendanceId);
            int affectedRows = updateStmt.executeUpdate();

            if (affectedRows > 0) {
                JOptionPane.showMessageDialog(this, "Attendance updated successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to update attendance.");
            }
        } else {
            // If record does not exist, insert a new one
            String insertSql = "INSERT INTO attendance (\"ChildID\", \"Date\", \"Status\") VALUES (?, ?, ?)";
            PreparedStatement insertStmt = conn.prepareStatement(insertSql);
            insertStmt.setInt(1, studentId);
            insertStmt.setDate(2, sqlDate);
            insertStmt.setString(3, status);
            int affectedRows = insertStmt.executeUpdate();

            if (affectedRows > 0) {
                JOptionPane.showMessageDialog(this, "Attendance marked successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to mark attendance.");
            }
        }

    } catch (SQLException ex) {
        Logger.getLogger("take attendance").log(Level.SEVERE, "Failed to mark attendance", ex);
        JOptionPane.showMessageDialog(this, "Error occurred while marking attendance.");
    }
}

    private void AbsentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbsentButtonActionPerformed
        // TODO add your handling code here:
        int studentId = Integer.valueOf(studentNumberField.getText());
     markAttendance(studentId, "Absent");
    }//GEN-LAST:event_AbsentButtonActionPerformed

    private void PresentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PresentButtonActionPerformed
        int studentId = Integer.valueOf(studentNumberField.getText());
        markAttendance(studentId, "Present");    
    }//GEN-LAST:event_PresentButtonActionPerformed

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
            java.util.logging.Logger.getLogger(TakeAttandanceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TakeAttandanceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TakeAttandanceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TakeAttandanceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TakeAttandanceFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AbsentButton;
    private javax.swing.JPanel BottomPanel;
    private javax.swing.JPanel CenterPanel;
    private javax.swing.JButton PresentButton;
    private javax.swing.JPanel TopPanel;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField studentNumberField;
    // End of variables declaration//GEN-END:variables
}
