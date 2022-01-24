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
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
public class ShipController implements Initializable {

    @FXML
    private TextField txtid;
    @FXML
    private TextField txtname;
    @FXML
    private TextField contact;
    @FXML
    private Button btnupdate;
    @FXML
    private Button btndelete;
    @FXML
    private Button btnsave;
    @FXML
    private TableColumn<shipclass, String> CID;
    @FXML
    private TableColumn<shipclass, String> CName;
    @FXML
    private TableColumn<shipclass, String> CContact;
    @FXML
    private TableView<shipclass> table;
    
     Connection con1;
      PreparedStatement insert;
       String ID , Name,Contact;
       
        public ObservableList<shipclass> list;
       
       
    
          public void insert(){                                         
        // TODO add your handling code here:
        
       String id= txtid.getText();
        String name= txtname.getText();
        String con= contact.getText();
        
        

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost/cargo","root","");
            insert = con1.prepareStatement("insert into ship (ship_id ,ship_name,contact)values(?,?,?)");
            insert.setString(1,id);
            insert.setString(2,name);
            insert.setString(3,con);
           
            insert.executeUpdate();
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Success...");
    alert.setHeaderText("Record Saved ");

    alert.showAndWait();
   
               txtid.setText("");
            txtname.setText("");
            contact.setText("");
            txtid.requestFocus();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ShipController.class.getName()).log(Level.SEVERE, null, ex);

        }

    }  
          public void clear(){
              txtid.setText("");
            txtname.setText("");
            contact.setText("");
            txtid.requestFocus();
          }
          
           public void display() throws ClassNotFoundException{
        try {
             Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost/cargo","root","");
               
            String sql = "select * from ship";
            PreparedStatement pst = con1.prepareStatement(sql);

            ResultSet rs =pst.executeQuery(sql);
            list.clear();

            while (rs.next()) {
                ID =rs.getString(1);
                Name =rs.getString(2);
                Contact= rs.getString(3);
               
               list.add(new shipclass(ID, Name,Contact));
               
               //String ;
              
            }
            table.setItems(list);
            rs.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
                  
  public void mouseDataFilling(){
    
    table.setOnMouseClicked( e-> {
        shipclass obj = table.getItems().get(table.getSelectionModel().getSelectedIndex());        
            txtid.setText(obj.getID());
            txtname.setText(obj.getName());
            contact.setText(obj.getContact()); 
            
          
            
     });
    
   
            } 
     public void update(){

        if (txtid.getText().equals("")){

            //alert information
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setContentText("You must fill id  to update.");
            alert.setHeaderText(null);
            alert.showAndWait();
        }
        else {
            try {
                if (txtid.getText().equals("")) {

                    //alert information
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning");
                    alert.setContentText("You must fill all blanks  to update.");
                    alert.setHeaderText(null);
                    alert.showAndWait();

                }

                  else{
                    
                int ids =Integer.parseInt(txtid.getText());
                
            String name = txtname.getText();
            String  con =contact.getText();
            
            
               

               Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost/Cargo","root","");
              
                String sql = "update ship set ship_name= '" + name + "',contact= '" + con +  "' WHERE ship_id ='" + ids + "' ";

          
                PreparedStatement pst;
                pst = con1.prepareStatement(sql);
                pst.execute();
                list.clear();

                display();

                //alert information
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setContentText("The Data has been Updated");
                alert.setHeaderText(null);
                alert.showAndWait();

                txtid.clear();
                txtname.clear();
                contact.clear();
                
                
                

            } }
            catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        }



    }
      
  
   public void delete(){

        
            String Name = txtname.getText();
            
        if (txtid.getText() .equals("") ) {

            //alert information
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setContentText("You must fill All ID textBox to Delete.");
            alert.setHeaderText(null);
            alert.showAndWait();
        }
        else {

            int id = Integer.parseInt(txtid.getText());
            id = Integer.parseInt(txtid.getText());


            try {
              Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost/cargo","root","");
                String sql = "DELETE FROM ship WHERE ship_id ='" + id + "' ";

                PreparedStatement pst;

                pst = con1.prepareStatement(sql);
                pst.execute();
                list.clear();



                //alert information
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setContentText("The Row was Deleted");
                alert.setHeaderText(null);
                alert.showAndWait();

                txtid.setText("");
            txtname.setText("");
            contact.setText("");
           
                display();

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

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
            
            list = FXCollections.observableArrayList();
            CID.setCellValueFactory(new PropertyValueFactory<>("ID"));
            CName.setCellValueFactory(new PropertyValueFactory<>("Name"));
            CContact.setCellValueFactory(new PropertyValueFactory<>("Contact"));
           
            display();
           
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CargoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }      
    
    
}
