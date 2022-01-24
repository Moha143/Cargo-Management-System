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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;



/**
 * FXML Controller class
 *
 * @author HP
 */
public class PortController implements Initializable {

    @FXML
    private TextField txtid;
    @FXML
    private TextField txtname;
    @FXML
    private TextField district;
    @FXML
    private TextField region;
    @FXML
    private TextField country;
    @FXML
    private TableView<portclass> table;
    @FXML
    private TableColumn<portclass, String> CID;
    @FXML
    private TableColumn<portclass, String>CName;
    @FXML
    private TableColumn<portclass, String>CCountry;
    @FXML
    private TableColumn<portclass, String> CRegion;
    @FXML
    private TableColumn<portclass, String> CDistrict;

     public ObservableList<portclass> list;
Connection con1;
PreparedStatement insert;
      String ID , Name,Country,Region , District;
      
       public void id(){
      String id= txtid.getText();
        if(id.matches("^[0-9]*$"))
        {
           
        } 
        
        else
        {
            
             Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Information");
                alert.setHeaderText("ID");
                alert.setContentText("ID : Only Numbers are Allowed");
                alert.showAndWait();
        }
    } 
    @FXML
          public void insert(){
      
               if (txtid.getText().equals("")  && txtname.getText().equals("") && country.getText().equals("") && district.getText().equals("") ) {
                 Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Warning");
    alert.setHeaderText("You must fill all fill blanks ");
    alert.showAndWait();
               }
              else{
         id();
         String id= txtid.getText();
       String name= txtname.getText();
        String dis= district.getText();
        String reg =region.getText();
         String co= country.getText();
         
        
       try {
               
         Class.forName("com.mysql.cj.jdbc.Driver");
         con1 = DriverManager.getConnection("jdbc:mysql://localhost/cargo","root","");
         insert = con1.prepareStatement("insert into port (port_id ,port_name, country , region,district )values(?,?,?,?,?)");
         insert.setString(1,id);
            insert.setString(2,name);
            
            insert.setString(3,co);
             insert.setString(4,reg);
             insert.setString(5,dis);
             
            insert.executeUpdate();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Success...");
    alert.setHeaderText("Record Saved ");
    alert.showAndWait();
   display();
            txtid.setText("");
            txtname.setText("");
            district.setText("");
            region.setText("");
            country.setText("");
            
           
         
   
              } catch (ClassNotFoundException | SQLException ex) {
             Logger.getLogger(PortController.class.getName()).log(Level.SEVERE, null, ex);
            
            
        }
                 }
      }   
          
          
           public void delete(){
                id();

       
           
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
            


            try {
              Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost/cargo","root","");
                String sql = "DELETE FROM port WHERE port_id ='" + id + "' ";

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
            country.setText("");
            region.setText("");
            district.setText("");
                display();

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        }

        

  
     }
           public void clear(){
             txtid.setText("");
            txtname.setText("");
            country.setText("");
            region.setText("");
            district.setText("");
           }
           public void display() throws ClassNotFoundException     {
        
        try {
             Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost/cargo","root","");
               
            String sql = "select * from port";
            PreparedStatement pst = con1.prepareStatement(sql);

            ResultSet rs =pst.executeQuery(sql);
            list.clear();

            while (rs.next()) {
                ID =rs.getString(1);
                Name =rs.getString(2);
                Country= rs.getString(3);
                Region= rs.getString(4);  
                District= rs.getString(5); 
               list.add(new portclass( ID, Name, Country,Region, District));
            }
            table.setItems(list);
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
            
            list = FXCollections.observableArrayList();
            CID.setCellValueFactory(new PropertyValueFactory<>("ID"));
            CName.setCellValueFactory(new PropertyValueFactory<>("Name"));
            CCountry.setCellValueFactory(new PropertyValueFactory<>("Country"));
            CRegion.setCellValueFactory(new PropertyValueFactory<>("Region"));
             CDistrict.setCellValueFactory(new PropertyValueFactory<>("District"));
            display();
           
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CargoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    public void mouseDataFilling(MouseEvent event) {
         table.setOnMouseClicked( e-> {
        portclass obj = table.getItems().get(table.getSelectionModel().getSelectedIndex());        
            txtid.setText(obj.getID());
            txtname.setText(obj.getName());
            country.setText(obj.getCountry()); 
            region.setText(obj.getRegion()); 
            district.setText(obj.getDistrict()); 
            
            
     });
    
    }
    
         public void update(){
 id();
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
                if (txtid.getText().equals("")  && txtname.getText().equals("") && country.getText().equals("") && district.getText().equals("") ) {

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
            String  c =country.getText();
            
            String reg =region.getText(); 
            String dis =district.getText(); 
            
               Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost/Cargo","root","");
              
                String sql = "update port set port_name= '" + name + "',country= '" + c + "',region='"+reg +  "',district='"+dis +  "' WHERE port_id ='" + ids + "' ";

         
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
                country.clear();
                 region.clear();
                
                 district.clear();

            } }
            catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        }



    }  
}
