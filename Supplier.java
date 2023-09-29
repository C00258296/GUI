
package gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Edward
 */
public class Supplier extends javax.swing.JFrame {

    /**
     * Creates new form Supplier
     */
    //  public constructor
    public Supplier() {
        initComponents();
        tableUpdate();
        ConnectDB();
       
    }
    
    //variables used to connect the gui to the database
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
     
    // connecting the  supplier table to the database
    /**
     * Connecting to the Database
     */
      public void ConnectDB()
    {
         try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database","root","");
            System.out.println(con);
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
      }
    
      // updating the table of the supplier table on the database
      /**
       * updating table in database
       */
        private void tableUpdate()
    {
         int k;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database","root","");
            pst = con.prepareStatement("SELECT * FROM supplier");
             rs = pst.executeQuery();
             
             ResultSetMetaData rss = rs.getMetaData();
             k = rss.getColumnCount();
             
             DefaultTableModel df = (DefaultTableModel)supplierTable.getModel();
             df.setRowCount(0);
             while(rs.next())
             {
                 Vector v2 = new Vector();
                 for(int a = 1; a<=k; a++)
                 {
                     v2.add(rs.getString("supplierID"));
                     v2.add(rs.getString("supplierName"));
                      v2.add(rs.getString("supplierSurname"));
                      v2.add(rs.getString("phoneNumber"));
                      v2.add(rs.getString("productName")); 
                 }
                 df.addRow(v2);
             }
        } catch (Exception e) {
           
        }
    }
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        supplierTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        suppliernameLabel1 = new javax.swing.JLabel();
        suppliernameText = new java.awt.TextField();
        suppliersurnameLabel = new javax.swing.JLabel();
        surnameText = new java.awt.TextField();
        phonenumberText = new java.awt.TextField();
        productnameText = new java.awt.TextField();
        phonenumberLabel = new javax.swing.JLabel();
        productLabel = new javax.swing.JLabel();
        addbutton2 = new javax.swing.JButton();
        updateButton3 = new javax.swing.JButton();
        deleteButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));

        backButton2.setBackground(new java.awt.Color(204, 255, 204));
        backButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        backButton2.setText("Back");
        backButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Supplier ");

        supplierTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Supplier ID", "Supplier Name", "Supplier Surname", "Phone Number", "Product Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        supplierTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                supplierTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(supplierTable);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, null, null, null, new java.awt.Font("Segoe UI", 2, 18))); // NOI18N

        suppliernameLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        suppliernameLabel1.setText("Supplier Name");

        suppliersurnameLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        suppliersurnameLabel.setText("Supplier Surname");

        phonenumberLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        phonenumberLabel.setText("Phone Number");

        productLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        productLabel.setText("Product Name");

        addbutton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addbutton2.setText("Add");
        addbutton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbutton2ActionPerformed(evt);
            }
        });

        updateButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        updateButton3.setText("Update");
        updateButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButton3ActionPerformed(evt);
            }
        });

        deleteButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        deleteButton2.setText("Delete");
        deleteButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(deleteButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(addbutton2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                        .addComponent(updateButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(phonenumberLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(productLabel)
                                .addGap(135, 135, 135)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(productnameText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(phonenumberText, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(suppliersurnameLabel)
                            .addComponent(suppliernameLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(suppliernameText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(surnameText, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))))
                .addGap(10, 10, 10))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(suppliernameLabel1)
                    .addComponent(suppliernameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(suppliersurnameLabel)
                    .addComponent(surnameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phonenumberLabel)
                    .addComponent(phonenumberText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(productLabel)
                    .addComponent(productnameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addbutton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(479, 479, 479)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(169, 169, 169)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(529, 529, 529)
                        .addComponent(backButton2)))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(backButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**
 * 
 * @param menu - display the menu table to the screen
 */
    private void backButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton2ActionPerformed
       // will bring the user back to the Menu table
        
        Menu menu = new Menu();
        menu.show();
        
       dispose();
       
       
    }//GEN-LAST:event_backButton2ActionPerformed
//  this button will update the details of a record that is already stored in the database
    /**
     * 
     * @param  updating button - updating the details to the supplier table
     */
    private void updateButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButton3ActionPerformed
try {
            
             int updatedRecord = JOptionPane.showConfirmDialog(null, "Are you sure that you what to updated a new record?","Waring",JOptionPane.YES_NO_OPTION);
          
           if(updatedRecord == JOptionPane.YES_OPTION)
           {
                DefaultTableModel Df = (DefaultTableModel)supplierTable.getModel();
                int selectedindex = supplierTable.getSelectedRow();

                int id = Integer.parseInt(Df.getValueAt(selectedindex, 0).toString());  
               String supplierName= suppliernameText.getText();
                String  supplierSurname=  surnameText.getText();
                String phoneNumber =   phonenumberText.getText();
               String  productName = productnameText.getText();
        
         // error message if the user dont fill each textboxes 
         if(supplierName.equals(""))
         {
             JOptionPane.showConfirmDialog(null, "Enter customer first name","Waring!!",JOptionPane.CLOSED_OPTION);
         }
      else  if(supplierSurname.equals(""))
         {
             JOptionPane.showConfirmDialog(null, "Enter customer last name","Waring!!",JOptionPane.CLOSED_OPTION);
         }
       else  if(productName.equals(""))
         {
             JOptionPane.showConfirmDialog(null, "Enter customer product name","Waring!!",JOptionPane.CLOSED_OPTION);
         }
       else   if(phoneNumber.equals(""))
         {
             JOptionPane.showConfirmDialog(null, "Enter customer phone number","Waring!!",JOptionPane.CLOSED_OPTION);
         }
         
              else
              {
                  // updating the details of the supplier
            pst = con.prepareStatement("UPDATE supplier SET supplierName=? ,supplierSurname=? , phonenumber=? , productName=? WHERE supplierID=?");
            
       
        pst.setString(1,supplierName);
        pst.setString(2,supplierSurname);
        pst.setString(3,phoneNumber);
        pst.setString(4,productName);
        pst.setInt(5, id);
          
        pst.executeUpdate();
        // will display a message saying that the supplier have been updated
          JOptionPane.showMessageDialog(this, " Supplier Updated");
        tableUpdate(); // updating product supplier table
       
        // setting the textboxes empty for the user
         suppliernameText.setText("");
         surnameText.setText("");
         phonenumberText.setText("");
         productnameText.setText("");
         
         suppliernameText.requestFocus();
         
              }
        
           }
        
       // error handling message 
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }   
          
        
    }//GEN-LAST:event_updateButton3ActionPerformed
//  the add button will add a new suppier to the database 
    /**
     * 
     * @param add - adding the supplier details to the supplier table
     */
    private void addbutton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbutton2ActionPerformed
      
       // will ask the user if he relly want to add a new supplier to the database
        try {
            
             int deleteRecord = JOptionPane.showConfirmDialog(null, "Are you sure that you what to add a new record?","Waring",JOptionPane.YES_NO_OPTION);
          // if the user click on yes the new supplier will be added to the database
           if(deleteRecord == JOptionPane.YES_OPTION)
           {
     String supplierName= suppliernameText.getText();
     String  supplierSurname=  surnameText.getText();
     String phoneNumber =   phonenumberText.getText();
      String  productName = productnameText.getText();
        
        //warning  message  if the user dont fill the details
         if(supplierName.equals(""))
         {
             JOptionPane.showConfirmDialog(null, "Enter customer first name","Waring!!",JOptionPane.CLOSED_OPTION);
         }
         else if(supplierSurname.equals(""))
         {
             JOptionPane.showConfirmDialog(null, "Enter customer last name","Waring!!",JOptionPane.CLOSED_OPTION);
         }
         else  if(productName.equals(""))
         {
             JOptionPane.showConfirmDialog(null, "Enter customer product name","Waring!!",JOptionPane.CLOSED_OPTION);
         }
        else    if(phoneNumber.equals(""))
         {
             JOptionPane.showConfirmDialog(null, "Enter customer phone number","Waring!!",JOptionPane.CLOSED_OPTION);
         }
         
              else
              {
                  // will insert a new record into the supplier table in the database
            pst = con.prepareStatement("INSERT INTO supplier(supplierName,supplierSurname,phoneNumber,productName) VALUES(?,?,?,?)");
            
       
        pst.setString(1,supplierName);
        pst.setString(2,supplierSurname);
        pst.setString(3,phoneNumber);
        pst.setString(4,productName);
      
          
        pst.executeUpdate();
        //  will display a message to the user saying that the supplier have been added 
          JOptionPane.showMessageDialog(this, "Supplier Added!");
        tableUpdate(); // updating product supplier table
      // setting the textboxes empty for the user
         suppliernameText.setText("");
         surnameText.setText("");
         phonenumberText.setText("");
         productnameText.setText("");
         
         suppliernameText.requestFocus();
         
              }
        
           }
        
       // error handling
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
       
    }                                          

    private void phoneTextActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void emailTextActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void deleteButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                              
      
            
            
        
                            
    }//GEN-LAST:event_addbutton2ActionPerformed
// when the user click on table will be have ro select any record in the supplier table
    /**
     *
     * @param supplier - allowing the user to click on the table and  display the details 
     */
    private void supplierTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supplierTableMouseClicked
       // taking the supplier table rows
        DefaultTableModel Df = (DefaultTableModel)supplierTable.getModel();
        int selectedindex = supplierTable.getSelectedRow();
        // displaying the details into the textboxes of the supplier table
        
         suppliernameText.setText(Df.getValueAt(selectedindex,1 ).toString());
         surnameText.setText(Df.getValueAt(selectedindex,2).toString()); 
         phonenumberText.setText(Df.getValueAt(selectedindex,3 ).toString());
         productnameText.setText(Df.getValueAt(selectedindex,4 ).toString());
                
      
        
    }//GEN-LAST:event_supplierTableMouseClicked
// the delete button will delete any record stored in the supplier table in the database
    /**
     * 
     * @param delete - deleting supplier record from the supplier table
     */
    private void deleteButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButton2ActionPerformed
      
     try {
             // taking the supplier table rows
              DefaultTableModel Df = (DefaultTableModel)supplierTable.getModel();
               int selectedindex = supplierTable.getSelectedRow();
            
               int id = Integer.parseInt(Df.getValueAt(selectedindex, 0).toString());
            // asking the user if he want to delete the record
                 int deleteRecord = JOptionPane.showConfirmDialog(null, "Are you sure that you what to delete this record?","Waring!!",JOptionPane.YES_NO_CANCEL_OPTION);
          // if the user click on yes the record will be deleted from the database
                  if(deleteRecord == JOptionPane.YES_OPTION)
                  {
                      // deleting the suppplier of the database
                   pst = con.prepareStatement("DELETE FROM supplier WHERE supplierID=?");
            
            
                  pst.setInt(1, id);
            
            
             pst.executeUpdate();
        
              
          JOptionPane.showMessageDialog(this, "Record Deleted!");
          tableUpdate();// updating product supplier table
        // setting the table empty for the user
         suppliernameText.setText("");
         surnameText.setText("");
         phonenumberText.setText("");
         productnameText.setText("");
         
              }
        
           }
     //error handling
         catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
                                       
    }//GEN-LAST:event_deleteButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
     public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(() -> {
            new Supplier().setVisible(true);
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addbutton2;
    private javax.swing.JButton backButton2;
    private javax.swing.JButton deleteButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel phonenumberLabel;
    private java.awt.TextField phonenumberText;
    private javax.swing.JLabel productLabel;
    private java.awt.TextField productnameText;
    private javax.swing.JTable supplierTable;
    private javax.swing.JLabel suppliernameLabel1;
    private java.awt.TextField suppliernameText;
    private javax.swing.JLabel suppliersurnameLabel;
    private java.awt.TextField surnameText;
    private javax.swing.JButton updateButton3;
    // End of variables declaration//GEN-END:variables
}
