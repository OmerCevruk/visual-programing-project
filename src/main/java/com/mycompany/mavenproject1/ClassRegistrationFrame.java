package com.mycompany.mavenproject1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ClassRegistrationFrame extends javax.swing.JFrame {
    private final JDBCPostgreSQLConnection connect;
    
    public ClassRegistrationFrame() {
        initComponents();
        connect = new JDBCPostgreSQLConnection();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        registerClassButton = new javax.swing.JButton();
        headerLabel = new javax.swing.JLabel();
        studentDataPanel = new javax.swing.JPanel();
        classIDLabel = new javax.swing.JLabel();
        classIDTextField = new javax.swing.JTextField();
        classNameLabel = new javax.swing.JLabel();
        classNameTextField = new javax.swing.JTextField();
        studentIDLabel = new javax.swing.JLabel();
        studentIDTextField = new javax.swing.JTextField();
        teacherIDLabel = new javax.swing.JLabel();
        teacherIDTextField = new javax.swing.JTextField();
        clearButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Class registeratiration");

        registerClassButton.setText("Register Class");
        registerClassButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerClassButtonActionPerformed(evt);
            }
        });

        headerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerLabel.setText("Register a class for a teacher and a student");

        studentDataPanel.setLayout(new java.awt.GridLayout(4, 2, 0, 30));

        classIDLabel.setText("Class ID");
        studentDataPanel.add(classIDLabel);

        classIDTextField.setText("enter class id");
        classIDTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classIDTextFieldActionPerformed(evt);
            }
        });
        studentDataPanel.add(classIDTextField);

        classNameLabel.setText("Class Name");
        studentDataPanel.add(classNameLabel);

        classNameTextField.setText("enter class name");
        studentDataPanel.add(classNameTextField);

        studentIDLabel.setText("Student ID");
        studentDataPanel.add(studentIDLabel);

        studentIDTextField.setText("enter student id");
        studentDataPanel.add(studentIDTextField);

        teacherIDLabel.setText("Teacher ID");
        studentDataPanel.add(teacherIDLabel);

        teacherIDTextField.setText("enter teacher id");
        studentDataPanel.add(teacherIDTextField);

        clearButton.setText("Clear Field");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(registerClassButton, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                .addGap(78, 78, 78)
                .addComponent(clearButton, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                .addGap(99, 99, 99))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(53, 53, 53)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(headerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
                        .addComponent(studentDataPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(53, 53, 53)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(303, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registerClassButton)
                    .addComponent(clearButton))
                .addGap(12, 12, 12))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(headerLabel)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(studentDataPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                    .addGap(57, 57, 57)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registerClassButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerClassButtonActionPerformed
  try {
            int classID = Integer.parseInt(classIDTextField.getText());
            String className = classNameTextField.getText();
            String studentIDs = studentIDTextField.getText();
            String teacherIDs = teacherIDTextField.getText();

            if (teacherIDs.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Teacher ID must not be empty", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try (Connection conn = connect.connect()) {
                // Insert class info
                String sqlClass = "INSERT INTO public.class (\"ClassID\", \"ClassName\", \"TeacherID\") VALUES (?, ?, ?)";
                PreparedStatement pstmtClass = conn.prepareStatement(sqlClass);
                pstmtClass.setInt(1, classID);
                pstmtClass.setString(2, className);
                pstmtClass.setInt(3, Integer.parseInt(teacherIDs.trim()));  // Assuming one teacher ID for simplicity
                pstmtClass.executeUpdate();

                // Assign students to class
                for (String studentID : studentIDs.split(",")) {
                    String sqlStudent = "INSERT INTO public.class_student (\"class_id\", \"child_id\") VALUES (?, ?)";
                    PreparedStatement pstmtStudent = conn.prepareStatement(sqlStudent);
                    pstmtStudent.setInt(1, classID);
                    pstmtStudent.setInt(2, Integer.parseInt(studentID.trim()));
                    pstmtStudent.executeUpdate();
                }

                JOptionPane.showMessageDialog(this, "Class successfully registered");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Class ID and Teacher ID must be integers", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_registerClassButtonActionPerformed

    private void classIDTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classIDTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_classIDTextFieldActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        classIDTextField.setText("");
        classNameTextField.setText("");
        studentIDTextField.setText("");
        teacherIDTextField.setText("");
    }//GEN-LAST:event_clearButtonActionPerformed

    
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
            java.util.logging.Logger.getLogger(ClassRegistrationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClassRegistrationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClassRegistrationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClassRegistrationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClassRegistrationFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel classIDLabel;
    private javax.swing.JTextField classIDTextField;
    private javax.swing.JLabel classNameLabel;
    private javax.swing.JTextField classNameTextField;
    private javax.swing.JButton clearButton;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JButton registerClassButton;
    private javax.swing.JPanel studentDataPanel;
    private javax.swing.JLabel studentIDLabel;
    private javax.swing.JTextField studentIDTextField;
    private javax.swing.JLabel teacherIDLabel;
    private javax.swing.JTextField teacherIDTextField;
    // End of variables declaration//GEN-END:variables
}
