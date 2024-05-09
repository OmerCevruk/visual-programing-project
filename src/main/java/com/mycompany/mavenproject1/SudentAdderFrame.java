package com.mycompany.mavenproject1;
import com.mycompany.mavenproject1.JDBCPostgreSQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import java.sql.ResultSet;


public class SudentAdderFrame extends javax.swing.JFrame {

    
    private final JDBCPostgreSQLConnection connect;

    public SudentAdderFrame() {
        initComponents();
        connect = new JDBCPostgreSQLConnection();
        populateParentBox(); 
    }

   
private void populateParentBox() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        try (Connection conn = connect.connect()) {
            String sql = "SELECT \"FullName\" FROM public.parent";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String parentName = rs.getString("FullName");
                model.addElement(parentName);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        ParentBox.setModel(model);
    }
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rootPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        Fullname = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        EmailLabel = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        ClassLabel = new javax.swing.JLabel();
        studentClass = new javax.swing.JTextField();
        DOBLabel = new javax.swing.JLabel();
        DOBField = new javax.swing.JTextField();
        AdressLabel = new javax.swing.JLabel();
        Adress = new javax.swing.JTextField();
        StudentIDLabel = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        ParentBox = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        rootPanel.setLayout(new java.awt.BorderLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Add a student");
        rootPanel.add(jLabel1, java.awt.BorderLayout.PAGE_START);

        jPanel1.setLayout(new java.awt.GridLayout(8, 2));

        nameLabel.setText("Student Name");
        jPanel1.add(nameLabel);

        Fullname.setText("enter FullName");
        jPanel1.add(Fullname);

        passwordLabel.setText("password");
        jPanel1.add(passwordLabel);

        jTextField2.setText("Enter PasWord");
        jPanel1.add(jTextField2);

        EmailLabel.setText("Email");
        jPanel1.add(EmailLabel);

        email.setText("Enter e-mail");
        jPanel1.add(email);

        ClassLabel.setText("class");
        jPanel1.add(ClassLabel);

        studentClass.setText("enter student class");
        studentClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentClassActionPerformed(evt);
            }
        });
        jPanel1.add(studentClass);

        DOBLabel.setText("Date of birth");
        jPanel1.add(DOBLabel);

        DOBField.setText("Enter Date of birth");
        DOBField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DOBFieldActionPerformed(evt);
            }
        });
        jPanel1.add(DOBField);

        AdressLabel.setText("Adress");
        jPanel1.add(AdressLabel);

        Adress.setText("Enter adress");
        Adress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdressActionPerformed(evt);
            }
        });
        jPanel1.add(Adress);

        StudentIDLabel.setText("Sudent ID");
        jPanel1.add(StudentIDLabel);

        jTextField1.setText("Student ID");
        jPanel1.add(jTextField1);

        jLabel2.setText("Parent");
        jPanel1.add(jLabel2);

        ParentBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ParentBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ParentBoxActionPerformed(evt);
            }
        });
        jPanel1.add(ParentBox);

        rootPanel.add(jPanel1, java.awt.BorderLayout.CENTER);

        jButton1.setText("Add Student");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        rootPanel.add(jButton1, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(rootPanel);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void studentClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentClassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentClassActionPerformed

    private void DOBFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DOBFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DOBFieldActionPerformed

    private void AdressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AdressActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         String fullNameValue = Fullname.getText();
        String passwordValue = jTextField2.getText();
        String emailValue = email.getText();
        String schoolClassValue = studentClass.getText();
        String dobValue = DOBField.getText();
        String addressValue = Adress.getText();
        String ChildIDValue = jTextField1.getText();
        String parentValue = (String) ParentBox.getSelectedItem();

        
        try (Connection conn = connect.connect()) {
            String sql = "INSERT INTO public.child(\"FullName\", \"Password\", \"Email\", \"SchoolClass\", \"DOB\", \"Address\", \"ChildID\", \"parent\") VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, fullNameValue);
            pstmt.setString(2, passwordValue);
            pstmt.setString(3, emailValue);
            pstmt.setString(4, schoolClassValue);
            pstmt.setString(5, dobValue);
            pstmt.setString(6, addressValue);
            pstmt.setString(7, ChildIDValue);
            pstmt.setString(8, parentValue);
            pstmt.executeUpdate();

            JOptionPane.showMessageDialog(this, "Student added successfully");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ParentBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ParentBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ParentBoxActionPerformed

    
    public static void main(String args[]) {
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SudentAdderFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Adress;
    private javax.swing.JLabel AdressLabel;
    private javax.swing.JLabel ClassLabel;
    private javax.swing.JTextField DOBField;
    private javax.swing.JLabel DOBLabel;
    private javax.swing.JLabel EmailLabel;
    private javax.swing.JTextField Fullname;
    private javax.swing.JComboBox<String> ParentBox;
    private javax.swing.JLabel StudentIDLabel;
    private javax.swing.JTextField email;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JPanel rootPanel;
    private javax.swing.JTextField studentClass;
    // End of variables declaration//GEN-END:variables
}
