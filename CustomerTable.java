package gui;
// import used for the GUI
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



public class CustomerTable extends javax.swing.JFrame {

   /**
    *  customer table constructor
    */
    // public constructor
    public CustomerTable() {
        initComponents();
        ConnectDB();
        tableUpdate();
       
       
    }
    // variables used for connecction to the database
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    // connecting to the database
    /**
     * Connecting to the database using url of the database
     */
    public void ConnectDB()
    {    // trying to connect to the database
         try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database","root","");
            System.out.println(con);
            // error handling
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CustomerTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(CustomerTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
      }
    // updating the table of the customer table on the database
    /**
     * updates the customer table in the database
     */
    private void tableUpdate()
    {
         int k;
        try {
           // selecting the customer id from the customer table in the database
            pst = con.prepareStatement(" SELECT * FROM customer");
             rs = pst.executeQuery();
             
             ResultSetMetaData rss = rs.getMetaData();
             k = rss.getColumnCount();
             
             DefaultTableModel df = (DefaultTableModel)customerProduct.getModel();
             df.setRowCount(0);
             while(rs.next())
             {
                 // storing the rows for the table 
                 Vector v2 = new Vector();
                 for(int a = 1; a<=k; a++)
                 {
                     v2.add(rs.getString("CustomerID"));
                     v2.add(rs.getString("firstName"));
                      v2.add(rs.getString("lastName"));
                      v2.add(rs.getString("address"));
                      v2.add(rs.getString("phoneNumber"));
                      v2.add(rs.getString("email"));
                      v2.add(rs.getString("product_ID"));
                 }
                 df.addRow(v2);
             }
        } catch (Exception e) {
           
        }
    }
    
    
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        backButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        customerProduct = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        firstNameLabel = new javax.swing.JLabel();
        surnameLabel = new javax.swing.JLabel();
        addressLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        phonenumberLabel = new javax.swing.JLabel();
        nameText = new javax.swing.JTextField();
        lastnameText = new javax.swing.JTextField();
        addressText = new javax.swing.JTextField();
        emailText = new javax.swing.JTextField();
        phoneText = new javax.swing.JTextField();
        addButton1 = new javax.swing.JButton();
        updateButton1 = new javax.swing.JButton();
        deleteButton1 = new javax.swing.JButton();
        productIdText = new javax.swing.JTextField();
        productLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Customer Table");

        backButton1.setBackground(new java.awt.Color(204, 255, 204));
        backButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        backButton1.setText("Back");
        backButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton1ActionPerformed(evt);
            }
        });

        customerProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Custumer ID", "First Name", "Surname", "Address", "Phone Number", "email", "Product ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        customerProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customerProductMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(customerProduct);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Customer Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jPanel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        firstNameLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        firstNameLabel.setText("First Name");

        surnameLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        surnameLabel.setText("Last Name");

        addressLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addressLabel.setText("Address");

        emailLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        emailLabel.setText("Email");

        phonenumberLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        phonenumberLabel.setText("Phone Number");

        emailText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTextActionPerformed(evt);
            }
        });

        phoneText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneTextActionPerformed(evt);
            }
        });

        addButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addButton1.setText("Add");
        addButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButton1ActionPerformed(evt);
            }
        });

        updateButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        updateButton1.setText("Update");
        updateButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButton1ActionPerformed(evt);
            }
        });

        deleteButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        deleteButton1.setText("Delete");
        deleteButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButton1ActionPerformed(evt);
            }
        });

        productLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        productLabel.setText("ProductID");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(addButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(updateButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(deleteButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(productLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(productIdText, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(phonenumberLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(phoneText, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(addressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(surnameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(firstNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nameText)
                                    .addComponent(lastnameText)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(emailText, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 6, Short.MAX_VALUE))
                                    .addComponent(addressText))))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameLabel)
                    .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(surnameLabel)
                    .addComponent(lastnameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addressLabel)
                    .addComponent(addressText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailLabel)
                    .addComponent(emailText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phonenumberLabel))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productIdText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(productLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(438, 438, 438)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(473, 473, 473)
                        .addComponent(backButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(216, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(backButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
// when the user press the back button he will bring him to the menu table
    /**
     * 
     * @param Back - will bring the user back to the menu table
     */
    private void backButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton1ActionPerformed
        // will bring us back to the Menu screen
        
        Menu menu = new Menu();
        menu.show();
       
        dispose();
    }//GEN-LAST:event_backButton1ActionPerformed
// when the user press the add button will add a new record to the Customer table in the database
    /**
     * 
     * @param Add - will add a new record to the customer table
     */
    private void addButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButton1ActionPerformed
        
       
        try {
            // it will display a message saying to the user if he really want to add a new customer to the database
             int addRecord = JOptionPane.showConfirmDialog(null, "Are you sure that you what to add a new record?","Waring",JOptionPane.YES_NO_OPTION);
          
           if(addRecord == JOptionPane.YES_OPTION)
           {
               // getting the inputs from the user
         String firstName = nameText.getText();
         String lastName  = lastnameText.getText();
         String address = addressText.getText();
         String email = emailText.getText();
         String phoneNumber = phoneText.getText();
         String product_ID = productIdText.getText();
         
         //  if the user forget to fill a recod a message will display to the screen
         if(firstName.equals(""))
         {
             JOptionPane.showConfirmDialog(null, "Enter customer first name" ,"Waring!!",JOptionPane.CLOSED_OPTION);
         }
        else  if(lastName.equals(""))
         {
             JOptionPane.showConfirmDialog(null, "Enter customer last name","Waring!!",JOptionPane.CLOSED_OPTION);
         }
        else   if(address.equals(""))
         {
             JOptionPane.showConfirmDialog(null, "Enter customer address name","Waring!!",JOptionPane.CLOSED_OPTION);
         }
        else    if(email.equals(""))
         {
             JOptionPane.showConfirmDialog(null, "Enter customer email","Waring!!",JOptionPane.CLOSED_OPTION);
         }
       else      if(phoneNumber.equals(""))
         {
             JOptionPane.showConfirmDialog(null, "Enter customer phone number","Waring!!",JOptionPane.CLOSED_OPTION);
         }
        else      if(product_ID.equals(""))
         {
             JOptionPane.showConfirmDialog(null, "Enter customer product id","Waring!!",JOptionPane.CLOSED_OPTION);
         }
        else 
              {
                  // inserting the customer details to the customer table in the database
            pst = con.prepareStatement("INSERT INTO customer(firstName,lastName,address,phoneNumber,email,product_ID) VALUES(?,?,?,?,?,?)");
            
       
        pst.setString(1,firstName);
        pst.setString(2,lastName);
        pst.setString(3,address);
        pst.setString(4,phoneNumber);
        pst.setString(5,email);
        pst.setString(6,product_ID);
          
        pst.executeUpdate();
         // telling the user that the new customer is added to the database
          JOptionPane.showMessageDialog(this, "Customer Added");
        tableUpdate();// updating product customer table
       // setting the textboxes empty
         nameText.setText("");
         lastnameText.setText("");
         addressText.setText("");
         emailText.setText("");
         phoneText.setText("");
         productIdText.setText("");
         nameText.requestFocus();
         
              }
        
           }
        
       // error message
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(CustomerTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
       
    }//GEN-LAST:event_addButton1ActionPerformed

    private void phoneTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneTextActionPerformed

    private void emailTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailTextActionPerformed
// the delete button will delete a record that the user what to delete from the customer table from  the database
    /**
     * 
     * @param DeleteButton - will delete a record from the customer table
     */
    private void deleteButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButton1ActionPerformed
       try {
            // gettting rows from the customer product table
              DefaultTableModel Df = (DefaultTableModel)customerProduct.getModel();
               int selectedindex = customerProduct.getSelectedRow();
            
            int id = Integer.parseInt(Df.getValueAt(selectedindex, 0).toString());
            // asking the user if he really want to delete the record
           int deleteRecord = JOptionPane.showConfirmDialog(null, "Are you sure that you what to delete this record?","Waring",JOptionPane.YES_NO_CANCEL_OPTION);
          // if the user click the yes button the record will be deleted from the database
           if(deleteRecord == JOptionPane.YES_OPTION)
           {   /// deleting the record from the customer table
                 pst = con.prepareStatement("DELETE FROM customer WHERE customerID=?");
            
            
           pst.setInt(1, id);
            
            
             pst.executeUpdate();
        
            // displaying a message to the screen saying that the record is deleted  
          JOptionPane.showMessageDialog(this, "Record Deleted");
        tableUpdate();// updating product customer table
        // setting the textboxes empty for the user
         nameText.setText("");
         lastnameText.setText("");
         addressText.setText("");
         emailText.setText("");
         phoneText.setText("");
         productIdText.setText("");
        
           }
        // error message
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(CustomerTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deleteButton1ActionPerformed
// the user will be able to click on the table and the the details will display in the textboxes in the customer table
    /**
     * 
     * @param MouseClicked -will allow the user to click in the customer table and display the details
     */
    private void customerProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerProductMouseClicked
       
        DefaultTableModel Df = (DefaultTableModel)customerProduct.getModel();
        int selectedindex = customerProduct.getSelectedRow();
        // getting the detaisl of the rows and displaying it in the textboxes 
         nameText.setText(Df.getValueAt(selectedindex,1 ).toString());
         lastnameText.setText(Df.getValueAt(selectedindex,2).toString()); 
         addressText.setText(Df.getValueAt(selectedindex,3 ).toString());
         phoneText.setText(Df.getValueAt(selectedindex,4 ).toString());
         emailText.setText(Df.getValueAt(selectedindex,5).toString());
         productIdText.setText(Df.getValueAt(selectedindex,6 ).toString());

        
        
    }//GEN-LAST:event_customerProductMouseClicked
 // the update button will change details that are in the customer table in the database
    /**
     * 
     * @param UpdateBUtton - will update any record from the customer table
     */
    private void updateButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButton1ActionPerformed

        try {
            // asking the user if he really want to update this record 
            int deleteRecord = JOptionPane.showConfirmDialog(null, "Are you sure that you what to update this record?","Waring",JOptionPane.YES_NO_OPTION);
            // asking the user if he what to update the record 
            if(deleteRecord == JOptionPane.YES_OPTION)
            {

                DefaultTableModel Df = (DefaultTableModel)customerProduct.getModel();
                int selectedindex = customerProduct.getSelectedRow();

                int id = Integer.parseInt(Df.getValueAt(selectedindex, 0).toString());
            // getting the details of a record from the customer table  and storing it into thetextboxes
                String firstName = nameText.getText();
                String lastName  = lastnameText.getText();
                String address = addressText.getText();
                String email = emailText.getText();
                String phoneNumber = phoneText.getText();
                String product_ID = productIdText.getText();
           // Warning the user to fill the textboxes if he don't fill them   
            if(firstName.equals(""))
         {
             JOptionPane.showConfirmDialog(null, "Enter customer first name","Waring!!",JOptionPane.CLOSED_OPTION);
         }
        else  if(lastName.equals(""))
         {
             JOptionPane.showConfirmDialog(null, "Enter customer last name","Waring!!",JOptionPane.CLOSED_OPTION);
         }
         else  if(address.equals(""))
         {
             JOptionPane.showConfirmDialog(null, "Enter customer address name","Waring!!",JOptionPane.CLOSED_OPTION);
         }
         else   if(email.equals(""))
         {
             JOptionPane.showConfirmDialog(null, "Enter customer email","Waring!!",JOptionPane.CLOSED_OPTION);
         }
         else    if(phoneNumber.equals(""))
         {
             JOptionPane.showConfirmDialog(null, "Enter customer phone number","Waring!!",JOptionPane.CLOSED_OPTION);
         }
        else      if(product_ID.equals(""))
         {
             JOptionPane.showConfirmDialog(null, "Enter customer product id","Waring!!",JOptionPane.CLOSED_OPTION);
         }
              else
              {
                  // updating the customer details to the customer table 
                pst = con.prepareStatement("UPDATE customer SET firstName=? , lastName=? ,address=?,email=?,phoneNumber=?,product_ID =?  WHERE customerID = ?");

                pst.setString(1,firstName);
                pst.setString(2,lastName);
                pst.setString(3,address);
                pst.setString(4,email);
                pst.setString(5,phoneNumber);
                pst.setString(6,product_ID);
                pst.setInt(7, id);

                pst.executeUpdate();
               // displaying a message to the customer saying that the record have been update
                JOptionPane.showMessageDialog(this, "Record updated");
                tableUpdate();// updating product customer table
             // setting the textboxes from the customer table empty
                nameText.setText("");
                lastnameText.setText("");
                addressText.setText("");
                emailText.setText("");
                phoneText.setText("");
                productIdText.setText("");
              }

            }
        // erro message
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(CustomerTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_updateButton1ActionPerformed

   /**
    * 
    * @param args 
    */
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerTable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton1;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JTextField addressText;
    private javax.swing.JButton backButton1;
    private javax.swing.JTable customerProduct;
    private javax.swing.JButton deleteButton1;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField emailText;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lastnameText;
    private javax.swing.JTextField nameText;
    private javax.swing.JTextField phoneText;
    private javax.swing.JLabel phonenumberLabel;
    private javax.swing.JTextField productIdText;
    private javax.swing.JLabel productLabel;
    private javax.swing.JLabel surnameLabel;
    private javax.swing.JButton updateButton1;
    // End of variables declaration//GEN-END:variables
}
