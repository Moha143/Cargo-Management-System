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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class ShipmentController implements Initializable {
 public ObservableList<shipmentclass> list;
   
      
        String ID, Source,Destination;
    @FXML
    private TextField txtid;
    @FXML
    private TextField txtsource;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnsave;
    @FXML
    private TableView<shipmentclass> table;
    @FXML
    private TableColumn<shipmentclass, String> CID;
    @FXML
    private TableColumn<shipmentclass, String> CSource;
    @FXML
    private TableColumn<shipmentclass,String > CIDes;
    @FXML
    private TextField txtdest;
Connection con1;
      PreparedStatement insert;
    /**
     * Initializes the controller class.
     */
        public void display() throws ClassNotFoundException     {
        
        try {
             Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost/cargo","root","");
               
            String sql = "select * from shipments";
            PreparedStatement pst = con1.prepareStatement(sql);

            ResultSet rs =pst.executeQuery(sql);
            list.clear();

            while (rs.next()) {
                ID =rs.getString(1);
                Source =rs.getString(2);
                Destination= rs.getString(3);
                 
               list.add(new shipmentclass( ID, Source, Destination));
               
            }
            table.setItems(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         
        try {
            // TODO
            
            list = FXCollections.observableArrayList();
            CID.setCellValueFactory(new PropertyValueFactory<>("ID"));
            CSource.setCellValueFactory(new PropertyValueFactory<>("Source"));
            CIDes.setCellValueFactory(new PropertyValueFactory<>("Destination"));
            
            display();
           
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CargoController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
                
            String source = txtsource.getText();
            String  dest =txtdest.getText();
            
          

               Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost/Cargo","root","");
              
                String sql = "update shipments set source= '" + source + "',destination= '" + dest +  "' WHERE shipment_id ='" + ids + "' ";

          
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
                txtsource.clear();
                txtdest.clear();
              
                
                

            } }
            catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        }



    }
    @FXML
    public void delete(ActionEvent event) {
        
        
    
        if (txtid.getText() .equals("") ) {

            //alert information
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setContentText("You must fill All ID textBox to Delete.");
            alert.setHeaderText(null);
            alert.showAndWait();
        }
        else {

            int id;
            id = Integer.parseInt(txtid.getText());


            try {
              Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost/cargo","root","");
                String sql = "DELETE FROM shipments WHERE shipment_id ='" + id + "' ";

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
            txtsource.setText("");
            txtdest.setText("");
            
                display();

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        }


    }

    @FXML
    public void insert(ActionEvent event) throws SQLException {
        
         
       try {
               
           int id =Integer.parseInt(txtid.getText());
            String source = txtsource.getText();
            String dest = txtdest.getText();
            Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost/cargo","root","");
         
         
               
            insert = con1.prepareStatement("insert into shipments (shipment_id ,source, destination)values(?,?,?)");
            
            insert.setInt(1,id);
            insert.setString(2,source);
            insert.setString(3,dest);
            
        
            insert.executeUpdate();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Success...");
    alert.setHeaderText("Record Saved ");

    alert.showAndWait();
     display();
      
            txtid.setText("");
           txtsource .setText("");
            txtdest.setText("");
          
        
              } catch (ClassNotFoundException | SQLException ex) {
                  
              Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Warning ...");
    alert.setHeaderText("Something Wrong. please try Again ");
             
              
    
        }
    }
    public void clear(){
     txtid.setText("");
           txtsource .setText("");
            txtdest.setText("");
    }

    @FXML
    public void mouseDataFilling(MouseEvent event) {
        
           table.setOnMouseClicked( e-> {
        shipmentclass obj = table.getItems().get(table.getSelectionModel().getSelectedIndex());        
            txtid.setText(obj.getID());
            txtsource.setText(obj.getSource());
            txtdest.setText(obj.getDestination()); 
    
            
     });
    
    }
    
}
