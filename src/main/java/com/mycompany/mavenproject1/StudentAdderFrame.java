package com.mycompany.mavenproject1;
import com.mycompany.mavenproject1.JDBCPostgreSQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import java.sql.ResultSet;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class StudentAdderFrame extends javax.swing.JFrame {

    
    private final JDBCPostgreSQLConnection connect;

    public StudentAdderFrame() {
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
        headerLabel = new javax.swing.JLabel();
        studentDataPanel = new javax.swing.JPanel();
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
        studentid = new javax.swing.JTextField();
        parentlabel = new javax.swing.JLabel();
        ParentBox = new javax.swing.JComboBox<>();
        CitynameLabel = new javax.swing.JLabel();
        cityName = new javax.swing.JTextField();
        addStudentButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Student Adder");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        rootPanel.setLayout(new java.awt.BorderLayout());

        headerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerLabel.setText("Add a student");
        rootPanel.add(headerLabel, java.awt.BorderLayout.PAGE_START);

        studentDataPanel.setLayout(new java.awt.GridLayout(9, 2, 0, 5));

        nameLabel.setText("Student Name");
        studentDataPanel.add(nameLabel);

        Fullname.setText("enter Full Name");
        Fullname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FullnameActionPerformed(evt);
            }
        });
        studentDataPanel.add(Fullname);

        passwordLabel.setText("Password");
        studentDataPanel.add(passwordLabel);

        jTextField2.setText("enter password");
        studentDataPanel.add(jTextField2);

        EmailLabel.setText("Email");
        studentDataPanel.add(EmailLabel);

        email.setText("enter e-mail");
        studentDataPanel.add(email);

        ClassLabel.setText("Class");
        studentDataPanel.add(ClassLabel);

        studentClass.setText("enter student class");
        studentClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentClassActionPerformed(evt);
            }
        });
        studentDataPanel.add(studentClass);

        DOBLabel.setText("Date of birth");
        studentDataPanel.add(DOBLabel);

        DOBField.setText("enter date of birth");
        DOBField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DOBFieldActionPerformed(evt);
            }
        });
        studentDataPanel.add(DOBField);

        AdressLabel.setText("Adress");
        studentDataPanel.add(AdressLabel);

        Adress.setText("enter adress");
        Adress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdressActionPerformed(evt);
            }
        });
        studentDataPanel.add(Adress);

        StudentIDLabel.setText("Student ID");
        studentDataPanel.add(StudentIDLabel);

        studentid.setText("enter student ID");
        studentid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentidActionPerformed(evt);
            }
        });
        studentDataPanel.add(studentid);

        parentlabel.setText("Parent");
        studentDataPanel.add(parentlabel);

        ParentBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ParentBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ParentBoxActionPerformed(evt);
            }
        });
        studentDataPanel.add(ParentBox);

        CitynameLabel.setText("City Name");
        studentDataPanel.add(CitynameLabel);

        cityName.setText("enter city name (start with capital)");
        studentDataPanel.add(cityName);

        rootPanel.add(studentDataPanel, java.awt.BorderLayout.CENTER);

        addStudentButton.setText("Add Student");
        addStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStudentButtonActionPerformed(evt);
            }
        });
        rootPanel.add(addStudentButton, java.awt.BorderLayout.PAGE_END);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rootPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rootPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setBounds(0, 0, 634, 346);
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

    private void addStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStudentButtonActionPerformed
    String fullNameValue = Fullname.getText();
    String passwordValue = jTextField2.getText();
    String emailValue = email.getText();
    String schoolClassValue = studentClass.getText();
    String dobValue = DOBField.getText();
    String addressValue = Adress.getText();
    int childIDValue = Integer.parseInt(studentid.getText()); 
    String parentNameValue = (String) ParentBox.getSelectedItem();
    String cityNameValue = cityName.getText(); 
    
    // Date conversion
    java.sql.Date sqlDate = null;
    try {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date parsedDate = format.parse(dobValue);
        sqlDate = new java.sql.Date(parsedDate.getTime());
    } catch (ParseException e) {
        JOptionPane.showMessageDialog(this, "Error parsing date: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    // Fetch CityID using CityName
    int cityIDValue = 0;
    try (Connection conn = connect.connect()) {
        String fetchCityIDSql = "SELECT \"CityID\" FROM public.turkish_cities WHERE \"CityName\" = ?";
        PreparedStatement fetchCityIDStmt = conn.prepareStatement(fetchCityIDSql);
        fetchCityIDStmt.setString(1, cityNameValue);
        ResultSet rs = fetchCityIDStmt.executeQuery();
        
        if (rs.next()) {
            cityIDValue = rs.getInt("CityID");
        } else {
            JOptionPane.showMessageDialog(this, "City not found: " + cityNameValue, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error fetching city ID: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Fetch ParentID using ParentName
    int parentIDValue = 0;
    try (Connection conn = connect.connect()) {
        String fetchParentIDSql = "SELECT \"ParentID\" FROM public.parent WHERE \"FullName\" = ?";
        PreparedStatement fetchParentIDStmt = conn.prepareStatement(fetchParentIDSql);
        fetchParentIDStmt.setString(1, parentNameValue);
        ResultSet rs = fetchParentIDStmt.executeQuery();
        
        if (rs.next()) {
            parentIDValue = rs.getInt("ParentID");
        } else {
            JOptionPane.showMessageDialog(this, "Parent not found: " + parentNameValue, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error fetching parent ID: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    // Insert student data into child table
    try (Connection conn = connect.connect()) {
        String sql = "INSERT INTO public.child(\"FullName\", \"Password\", \"Email\", \"SchoolClass\", \"DOB\", \"Address\", \"ChildID\", \"parent\", \"CityID\") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, fullNameValue);
        pstmt.setString(2, passwordValue);
        pstmt.setString(3, emailValue);
        pstmt.setString(4, schoolClassValue);
        pstmt.setDate(5, sqlDate);
        pstmt.setString(6, addressValue);
        pstmt.setInt(7, childIDValue); 
        pstmt.setString(8, parentNameValue);
        pstmt.setInt(9, cityIDValue);
        pstmt.executeUpdate();

        JOptionPane.showMessageDialog(this, "Student added to system successfully");

        // Insert parent-child relationship into parent_child table
        String insertParentChildSql = "INSERT INTO public.parent_child(\"ParentID\", \"ChildID\") VALUES (?, ?)";
        PreparedStatement insertParentChildStmt = conn.prepareStatement(insertParentChildSql);
        insertParentChildStmt.setInt(1, parentIDValue);
        insertParentChildStmt.setInt(2, childIDValue);
        insertParentChildStmt.executeUpdate();
        
        
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_addStudentButtonActionPerformed

    private void ParentBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ParentBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ParentBoxActionPerformed

    private void FullnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FullnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FullnameActionPerformed

    private void studentidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentidActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    
    public static void main(String args[]) {
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentAdderFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Adress;
    private javax.swing.JLabel AdressLabel;
    private javax.swing.JLabel CitynameLabel;
    private javax.swing.JLabel ClassLabel;
    private javax.swing.JTextField DOBField;
    private javax.swing.JLabel DOBLabel;
    private javax.swing.JLabel EmailLabel;
    private javax.swing.JTextField Fullname;
    private javax.swing.JComboBox<String> ParentBox;
    private javax.swing.JLabel StudentIDLabel;
    private javax.swing.JButton addStudentButton;
    private javax.swing.JTextField cityName;
    private javax.swing.JTextField email;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel parentlabel;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JPanel rootPanel;
    private javax.swing.JTextField studentClass;
    private javax.swing.JPanel studentDataPanel;
    private javax.swing.JTextField studentid;
    // End of variables declaration//GEN-END:variables
}
