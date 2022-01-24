/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx.cargo;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


/**
 * FXML Controller class
 *
 * @author HP
 */
public class CustomerController implements Initializable {

      public ObservableList<customerclass> list1;
    
    @FXML
    private TextField txtcustid;
    @FXML
    private TextField txtcustname;
    @FXML
    private TextField txtcustphone;
    @FXML
    private TextField txtcustaddress;
    @FXML
    private TextField txtcustgender;
    @FXML
    private Button btnsave;
    @FXML
    private TableColumn<customerclass, String> cID;
    @FXML
    private TableColumn<customerclass, String> CName;
    @FXML
    private TableColumn<customerclass, String> CTell;
    @FXML
    private TableColumn<customerclass, String> CAddress;
    @FXML
    private TableColumn<customerclass, String> CGender;
    
  Connection con1;
      PreparedStatement insert;
    @FXML
    private Button btnupdate;
    @FXML
    private Button btndelete;
    @FXML
    private Button btnclose;
    @FXML
    private TableView<customerclass> table;
      
   String ID , Name ,Phone , Address, Gender;
    
    public void id(){
      String id= txtcustid.getText();
        if(id.matches("^[0-9]*$"))
        {
           
        } 
        
        else
        {
            
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText("ID");
                alert.setContentText("ID : Only Numbers are Allowed");
                alert.showAndWait();
        }
    }   
     public void phone(){
      String id= txtcustphone.getText();
        if(id.matches("^[0-9]*$"))
        {
           
        } 
        
        else
        {
            
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText("Phone Number");
                alert.setContentText("Phone : Only Numbers are Allowed");
                alert.showAndWait();
        }
    }   
    public void clear(){
       txtcustid.setText("");
            txtcustname.setText("");
            txtcustphone.setText("");
            txtcustaddress.setText("");
            txtcustgender.setText("");
    }
      @FXML
      public void insert () {                                         
        // TODO add your handling code here:
    
        id();
        phone();
      if (txtcustid.getText() .equals("") && txtcustname.getText() .equals("")&& txtcustphone.getText() .equals("")&&txtcustaddress.getText() .equals("") &&txtcustgender.getText() .equals("") ) 
       {
           
            //alert information
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setContentText("You must fill All Fields.");
            alert.setHeaderText(null);
            alert.showAndWait();
           }
        else {
     
        try {
           
         int id= Integer.parseInt( txtcustid.getText());
       String name= txtcustname.getText();
        int  phone= Integer.parseInt(txtcustphone.getText());
        String address= txtcustaddress.getText();
         String gender= txtcustgender.getText();
            Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost/cargo","root","");
            insert = con1.prepareStatement("insert into customers (cust_id ,cust_name,cust_tell,cust_address,Gender )values(?,?,?,?,?)");
            insert.setInt(1,id);
            insert.setString(2,name);
            insert.setInt(3,phone);
             insert.setString(4,address);
            insert.setString(5,gender);
            insert.executeUpdate();
           
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Success...");
    alert.setHeaderText("Record Saved ");
       alert.showAndWait();
      display();
            txtcustid.setText("");
            txtcustname.setText("");
            txtcustphone.setText("");
            txtcustaddress.setText("");
            txtcustgender.setText("");
           
           
            } catch (ClassNotFoundException | SQLException ex) {
             Logger.getLogger(CargoController.class.getName()).log(Level.SEVERE, null, ex);
            
            
        }
        }
         
         
       
    }      
      
      @FXML
       public void mouseDataFilling(){
    
    table.setOnMouseClicked( e-> {
        customerclass obj = table.getItems().get(table.getSelectionModel().getSelectedIndex());  
          
            txtcustid.setText(obj.getID());
            txtcustname.setText(obj.getName());
            txtcustphone.setText(obj.getPhone()); 
            txtcustaddress.setText(obj.getAddress()); 
            txtcustgender.setText(obj.getGender()); 
            
     });
    
   
            } 
       
       
    @FXML
         public void delete(){
              id();
        phone();

        
            
        String name= txtcustname.getText();
        int  phone= Integer.parseInt(txtcustphone.getText());
        String address= txtcustaddress.getText();
         String gender= txtcustgender.getText();
        if (txtcustid.getText() .equals("") ) {

            //alert information
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setContentText("You must fill All ID textBox to Delete.");
            alert.setHeaderText(null);
            alert.showAndWait();
        }
        else {

            int id = Integer.parseInt(txtcustid.getText());
            id = Integer.parseInt(txtcustid.getText());


            try {
              Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost/cargo","root","");
                String sql = "DELETE FROM customers WHERE cust_id ='" + id + "' ";

                PreparedStatement pst;

                pst = con1.prepareStatement(sql);
                pst.execute();
                list1.clear();



                //alert information
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setContentText("The Row was Deleted");
                alert.setHeaderText(null);
                alert.showAndWait();

                   txtcustid.setText("");
            txtcustname.setText("");
            txtcustphone.setText("");
            txtcustaddress.setText("");
            txtcustgender.setText("");
                display();

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        }


  
     }
      
       public void display() throws ClassNotFoundException{
        try {
             Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost/cargo","root","");
               
            String sql = "select * from customers";
            PreparedStatement pst = con1.prepareStatement(sql);

            ResultSet rs =pst.executeQuery(sql);
            list1.clear();

            
            while (rs.next()) {
                ID =rs.getString(1);
                Name =rs.getString(2);
                Phone= rs.getString(3);
                Address= rs.getString(4);  
                 Gender= rs.getString(5); 
                 
               list1.add(new customerclass( ID , Name ,Phone , Address, Gender));
              
            }
            table.setItems(list1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
      
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         
         try {
            // TODO
            
            list1 = FXCollections.observableArrayList();
            cID.setCellValueFactory(new PropertyValueFactory<>("ID"));
            CName.setCellValueFactory(new PropertyValueFactory<>("Name"));
            CTell.setCellValueFactory(new PropertyValueFactory<>("Phone"));
            CAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
              CGender.setCellValueFactory(new PropertyValueFactory<>("Gender"));
              
            
            display();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CargoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void update(ActionEvent event) {
    
        id();
        phone();
   
         if (txtcustid.getText() .equals("") && txtcustname.getText() .equals("")&& txtcustphone.getText() .equals("")&&txtcustaddress.getText() .equals("") &&txtcustgender.getText() .equals("") ) 
       {
           
           
           
            //alert information
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setContentText("You must fill All Fields");
            alert.setHeaderText(null);
            alert.showAndWait();
        }
        else {

            


            try {
                 int ids= Integer.parseInt( txtcustid.getText());
                String name= txtcustname.getText();
              int  phone= Integer.parseInt(txtcustphone.getText());
             String address= txtcustaddress.getText();
             String gender= txtcustgender.getText();
         
              Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost/cargo","root","");
              insert = con1.prepareStatement("update customers set  cust_name= ?, cust_tell= ?,cust_address= ? ,Gender=?  where cust_id= ?");
      
            insert.setString(1,name);
            insert.setInt(2,phone);
             insert.setString(3,address);
            insert.setString(4,gender);
            insert.setInt(5,ids);
            insert.executeUpdate();



                //alert information
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setContentText("The Record Updated");
                alert.setHeaderText(null);
                alert.showAndWait();
  txtcustid.setText("");
            txtcustname.setText("");
            txtcustphone.setText("");
            txtcustaddress.setText("");
            txtcustgender.setText("");
                display();

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        }


    
    }    
    
}
