/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Edward Omorusi C00258296
 */
public class Product extends javax.swing.JFrame {

    /**
     * Creates new form Product
     */
    //  public  constructor
    public Product() {
        initComponents();
        ConnectDB();
        tableUpdate();
    }
    // variables used to  connect to the database
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
     // connecting the product table to the database
    /**
     * ConnectDB - connect the GUI to the database
     */
      public void ConnectDB()
    {
         try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database","root","");
            System.out.println(con);
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
      }
    
    // updating the table of the product table on the database
      /**
       * tableUpdate - updates the product table in the database
       */
    private void tableUpdate()
    {
         int k;
        try {
           
            pst = con.prepareStatement("SELECT * FROM product");
             rs = pst.executeQuery();
             
             ResultSetMetaData rss = rs.getMetaData();
             k = rss.getColumnCount();
             
             DefaultTableModel df = (DefaultTableModel)productTable.getModel();
             df.setRowCount(0);
             while(rs.next())
             {
                 Vector v2 = new Vector();
                 for(int a = 1; a<=k; a++)
                 {
                     v2.add(rs.getString("product_ID"));
                     v2.add(rs.getString("productName"));
                     v2.add(rs.getString("quantity"));
                     v2.add(rs.getString("price"));
                     v2.add(rs.getString("supplierID"));
                     
                 }
                 df.addRow(v2);
             }
        } catch (Exception e) {
           
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        backButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        productTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        productnameLabel = new javax.swing.JLabel();
        quantityLabel = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        supplierLabel = new javax.swing.JLabel();
        productnameText = new javax.swing.JTextField();
        quantityText = new javax.swing.JTextField();
        priceText = new javax.swing.JTextField();
        supplieridText = new javax.swing.JTextField();
        deleteButton2 = new javax.swing.JButton();
        addButton2 = new javax.swing.JButton();
        updateButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        backButton2.setBackground(new java.awt.Color(204, 255, 204));
        backButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        backButton2.setText("Back");
        backButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton2ActionPerformed(evt);
            }
        });

        productTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Product ID", "Product Name", "Quantity", "Price", "Supplier ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        productTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(productTable);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Product table");

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Product Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 3, 12))); // NOI18N

        productnameLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        productnameLabel.setText("Product Name");

        quantityLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        quantityLabel.setText("Quantity");

        priceLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        priceLabel.setText("Price");

        supplierLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        supplierLabel.setText("Supplier ID");

        supplieridText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplieridTextActionPerformed(evt);
            }
        });

        deleteButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        deleteButton2.setText("Delete");
        deleteButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButton2ActionPerformed(evt);
            }
        });

        addButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addButton2.setText("Add");
        addButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButton2ActionPerformed(evt);
            }
        });

        updateButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        updateButton2.setText("Update");
        updateButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(deleteButton2)
                        .addGap(31, 31, 31)
                        .addComponent(addButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(updateButton2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(quantityLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(priceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(29, 29, 29))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(supplierLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(90, 90, 90))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(productnameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(productnameText, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(supplieridText, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                .addComponent(priceText)
                                .addComponent(quantityText)))))
                .addGap(35, 35, 35))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(productnameLabel)
                    .addComponent(productnameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quantityLabel)
                    .addComponent(quantityText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(priceText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(supplierLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(supplieridText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(424, 424, 424)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(backButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(52, 52, 52)
                .addComponent(backButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel5)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**
 * 
 * @param BackButton - will go back to the menu table
 */
    private void backButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton2ActionPerformed
        // Will brings us to the Menu Screen
        
        Menu menu = new Menu();
        menu.show();
       
        dispose();
    }//GEN-LAST:event_backButton2ActionPerformed
// the add button will add a new product to the database
    /**
     *
     * @param AddButton - will add a new record to the product table
     */
    private void addButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButton2ActionPerformed
      
        try {
            //will ask the user if he really want to add a new product to the database
             int addRecord = JOptionPane.showConfirmDialog(null, "Are you sure that you what to add a new record?","Waring",JOptionPane.YES_NO_OPTION);
           // if the user say yes will add the new product to the database
           if(addRecord == JOptionPane.YES_OPTION)
           {
               // getting the product detaisl from the textboxes
         String productName = productnameText.getText();
         String quantity  = quantityText.getText();
         String price = priceText.getText();
         String supplierID = supplieridText.getText();

         // if the buser forget to fill any record will display a warning message to the screen
         if(productName.equals(""))
         {
             JOptionPane.showConfirmDialog(null, "Enter the product name","Waring!!",JOptionPane.CLOSED_OPTION);
         }
        else  if(quantity.equals(""))
         {
             JOptionPane.showConfirmDialog(null, "Enter quantity of the product","Waring!!",JOptionPane.CLOSED_OPTION);
         }
        else   if(price.equals(""))
         {
             JOptionPane.showConfirmDialog(null, "Enter the price of the product ","Waring!!",JOptionPane.CLOSED_OPTION);
         }
        else    if(supplierID.equals(""))
         {
             JOptionPane.showConfirmDialog(null, "Enter the supplier ID","Waring!!",JOptionPane.CLOSED_OPTION);
         }
            
              else
              {
                  // inserting  the new product into the product table 
            pst = con.prepareStatement("INSERT INTO product(productName,quantity,price,supplierID) VALUES(?,?,?,?)");
            
       
        pst.setString(1,productName);
        pst.setString(2,quantity);
        pst.setString(3,price);
        pst.setString(4,supplierID);
        
        pst.executeUpdate();
        // displaying a message saying that the product is added
          JOptionPane.showMessageDialog(this, "Product Added!");
        tableUpdate();// updating product table
       // setting the textboxes to empty
         productnameText.setText("");
         quantityText.setText("");
         priceText.setText("");
         supplieridText.setText("");
         productnameText.requestFocus();
         
              }
        
           }
        
       // error message
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_addButton2ActionPerformed
// the upadte button will edit a record that is have already added to the database
    /**
     * 
     * @param updateButton - will update any record that is in the product table
     */
    private void updateButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButton2ActionPerformed
  try {  
      // asking the user if he really want to update a record from the product table
            int deleteRecord = JOptionPane.showConfirmDialog(null, "Are you sure that you what to update this record?","Waring",JOptionPane.YES_NO_OPTION);
            // if yes will delete a record from the product table
            if(deleteRecord == JOptionPane.YES_OPTION)
            {
                // getting the rows from the product table
                DefaultTableModel Df = (DefaultTableModel)productTable.getModel();
                int selectedindex = productTable.getSelectedRow();
                int id = Integer.parseInt(Df.getValueAt(selectedindex, 0).toString());    
                // storing the product detaisl into the product table
                String productName = productnameText.getText();
                 String quantity  = quantityText.getText();
                 String price = priceText.getText();
                 String supplierID = supplieridText.getText();

         // if the user forget to  fill a record a warning message will dislay
         if(productName.equals(""))
         {
             JOptionPane.showConfirmDialog(null, "Enter the product name","Waring!!",JOptionPane.CLOSED_OPTION);
         }
       else   if(quantity.equals(""))
         {
             JOptionPane.showConfirmDialog(null, "Enter quantity of the product","Waring!!",JOptionPane.CLOSED_OPTION);
         }
        else   if(price.equals(""))
         {
             JOptionPane.showConfirmDialog(null, "Enter the price of the product ","Waring!!",JOptionPane.CLOSED_OPTION);
         }
        else    if(supplierID.equals(""))
         {
             JOptionPane.showConfirmDialog(null, "Enter the supplier ID","Waring!!",JOptionPane.CLOSED_OPTION);
         }
            
              else
              {
                  // updating a record form the product table
            pst = con.prepareStatement("UPDATE  product SET productName=?,quantity=? ,price= ?,supplierID=? WHERE product_ID=?");
           
       
        pst.setString(1,productName);
        pst.setString(2,quantity);
        pst.setString(3,price);
        pst.setString(4,supplierID);
        pst.setInt(5, id);
        pst.executeUpdate();
        // dispaying a message saying that the product have been updated form the database
          JOptionPane.showMessageDialog(this, "Updated product");
        tableUpdate();// updating product table
       // setting the textboxes  to empty for the user
         productnameText.setText("");
         quantityText.setText("");
         priceText.setText("");
         supplieridText.setText("");
         
              }
        
           }
        
       // errro message
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_updateButton2ActionPerformed
// the user will be able to click and display the product details into the textboxes in the product table
    /**
     * 
     * @param MouseClicked - will allow the user to select any record in the product table and display the information
     */
    private void productTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productTableMouseClicked
       DefaultTableModel Df = (DefaultTableModel)productTable.getModel();
        int selectedindex = productTable.getSelectedRow();
         // displaying the details into the textboxes of the product table
         productnameText.setText(Df.getValueAt(selectedindex,1 ).toString());
         quantityText.setText(Df.getValueAt(selectedindex,2).toString()); 
         priceText.setText(Df.getValueAt(selectedindex,3 ).toString());
         supplieridText.setText(Df.getValueAt(selectedindex,4 ).toString());
        
        
        
    }//GEN-LAST:event_productTableMouseClicked
// the delete button will delete a record from the database
    /**
     * 
     * @param DeleteButton - will  delete any record in the product table
     */
    private void deleteButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButton2ActionPerformed
         try {
            
              DefaultTableModel Df = (DefaultTableModel)productTable.getModel();
               int selectedindex = productTable.getSelectedRow();
            
               int id = Integer.parseInt(Df.getValueAt(selectedindex, 0).toString());
            // asking the user if he really wnat to delete this record from the database
                 int deleteRecord = JOptionPane.showConfirmDialog(null, "Are you sure that you what to delete this record?","Waring!!",JOptionPane.YES_NO_CANCEL_OPTION);
          // if yes it will delete the record
                  if(deleteRecord == JOptionPane.YES_OPTION)
                  {
                      // deleting the product form the database
                   pst = con.prepareStatement("DELETE FROM product WHERE product_ID=?");
            
            
                  pst.setInt(1, id);
            
            
             pst.executeUpdate();
        
              // display a message saying that the product is deleted
          JOptionPane.showMessageDialog(this, "Record Deleted");
          tableUpdate(); // updating product table
       // setting the textboxes  to empty for the user
         productnameText.setText("");
         quantityText.setText("");
         priceText.setText("");
         supplieridText.setText("");
         
              }
        
           }
         // error message
         catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_deleteButton2ActionPerformed

    private void supplieridTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplieridTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_supplieridTextActionPerformed

   /**
    * 
    * @param args 
    */
    public static void main(String args[]) {
      
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Product().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton2;
    private javax.swing.JButton backButton2;
    private javax.swing.JButton deleteButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JTextField priceText;
    private javax.swing.JTable productTable;
    private javax.swing.JLabel productnameLabel;
    private javax.swing.JTextField productnameText;
    private javax.swing.JLabel quantityLabel;
    private javax.swing.JTextField quantityText;
    private javax.swing.JLabel supplierLabel;
    private javax.swing.JTextField supplieridText;
    private javax.swing.JButton updateButton2;
    // End of variables declaration//GEN-END:variables
}
