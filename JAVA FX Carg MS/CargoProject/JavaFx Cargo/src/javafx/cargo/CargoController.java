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
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.Vector;
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
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javax.swing.table.DefaultTableModel;
import static jdk.nashorn.internal.objects.NativeString.search;

/**
 * FXML Controller class
 *
 * @author HP
 */

public class CargoController implements Initializable {

    public ObservableList<Cargoclass> list;
    @FXML
    private TextField txtid;
    @FXML
    private TextField txtname;
    @FXML
    private TextField txtitem;
    @FXML
    private TextField txtkg;
    @FXML
    private Button btnsave;
     @FXML
    private Button btnUpdate;
    @FXML
    private TableView<Cargoclass> table;
    @FXML
    private TableColumn<Cargoclass, String> CID;
    @FXML
    private TableColumn<Cargoclass, String> CName;
    @FXML
    private TableColumn<Cargoclass, String> CItem;
    @FXML
    private TableColumn<Cargoclass, String> Ckg;
 
      Connection con1;
      PreparedStatement insert;
        String ID, Name, Item,Kg, pay;
    @FXML
    private TableColumn<Cargoclass, String> cpay;
    @FXML
    private TextField txtsearch;
       
    public void cargoid(){
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
 
       public void cargoit(){
      String id= txtitem.getText();
        if(id.matches("^[0-9]*$"))
        {
           
        } 
        
        else
        {
            
             Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Information");
                alert.setHeaderText("ITEMS");
                alert.setContentText("ITEMS: Only Numbers are Allowed");
                alert.showAndWait();
        }
    }  
        
        public void cargokg(){
      String id= txtkg.getText();
        if(id.matches("^[0-9]*$"))
        {
           
        } 
        
        else
        {
            
              Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Information");
                alert.setHeaderText("KG");
                alert.setContentText("KG: Only Numbers are Allowed");
                alert.showAndWait();
        }
    } 
    @FXML
        public void update(){
cargoid();
cargoit();
cargokg();
        if (txtid.getText().equals("") && txtitem.getText().equals("") && txtkg.getText().equals("")){

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
            String  it =txtitem.getText();
            
            String kg =txtkg.getText(); 
            
            
                double val1 = Double.parseDouble(it);
               double val2 =Double.parseDouble(kg); 
               double total =val1*val2*0.70;
               
               

               Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost/Cargo","root","");
              
                String sql = "update cargo set cargo_name= '" + name + "',cargo_item= '" + it + "',Payment='"+total +  "' WHERE cargo_id ='" + ids + "' ";

          
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
                txtitem.clear();
                 txtkg.clear();
                
                

            } }
            catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        }



    }
    
    @FXML
    public void insert() throws ClassNotFoundException, SQLException {
         cargoid();
        cargoit();
        cargokg();
        
          if (txtid.getText().equals("") && txtitem.getText().equals("") && txtkg.getText().equals("")){
   
       Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Warning ...");
    alert.setHeaderText("Please fill blank fields ");
   }
    else 
    {
      

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost/cargo", "root", "");

            double val1 = Double.parseDouble(Item);
            double val2 = Double.parseDouble(Kg);
            double total = val1 * val2 * 0.70;

            insert = con1.prepareStatement("insert into cargo (cargo_id ,cargo_name, cargo_item,nkg , Payment)values(?,?,?,?,?)");
            int id = Integer.parseInt(txtid.getText());
            String name = txtname.getText();
            int it = Integer.parseInt(txtitem.getText());
            int kg = Integer.parseInt(txtkg.getText());
            insert.setInt(1, id);
            insert.setString(2, name);
            insert.setInt(3, it);
            insert.setInt(4, kg);
            insert.setDouble(5, total);

            insert.executeUpdate();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success...");
            alert.setHeaderText("Record Saved ");

            alert.showAndWait();
            display();

            txtid.setText("");
            txtname.setText("");
            txtitem.setText("");
            txtkg.setText("");

        } catch (ClassNotFoundException | SQLException ex) {

        }

    
    }
      

    }   
      
      public void clear(){     
          txtid.setText("");
            txtname.setText("");
            txtitem.setText("");
            txtkg.setText("");}
    public void display() throws ClassNotFoundException     {
        
        try {
             Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost/cargo","root","");
               
            String sql = "select * from cargo";
            PreparedStatement pst = con1.prepareStatement(sql);

            ResultSet rs =pst.executeQuery(sql);
            list.clear();

            while (rs.next()) {
                ID =rs.getString(1);
                Name =rs.getString(2);
                Item= rs.getString(3);
                Kg= rs.getString(4);  
                pay= rs.getString(5); 
               list.add(new Cargoclass( ID, Name, Item,Kg, pay));
            }
            table.setItems(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    //Delete
    @FXML
     public void delete(){

        cargoid();
       cargoit();
       cargokg();
            String Name = txtname.getText();
            int Item =Integer.parseInt(txtitem.getText());
            int Kg =Integer.parseInt(txtkg.getText()); 
        if (txtid.getText() .equals("") ) {

            //alert information
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setContentText("Please. enter ID number.");
            alert.setHeaderText(null);
            alert.showAndWait();
        }
        else {

            int id = Integer.parseInt(txtid.getText());
            id = Integer.parseInt(txtid.getText());


            try {
              Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost/cargo","root","");
                String sql = "DELETE FROM cargo WHERE cargo_id ='" + id + "' ";

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
            txtitem.setText("");
            txtkg.setText("");
                display();

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        }


  
     }
    
    
    @FXML
  public void mouseDataFilling(){
    
    table.setOnMouseClicked( e-> {
        Cargoclass obj = table.getItems().get(table.getSelectionModel().getSelectedIndex());        
            txtid.setText(obj.getID());
            txtname.setText(obj.getName());
            txtitem.setText(obj.getItem()); 
            txtkg.setText(obj.getKg()); 
          
            
     });
    
   
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
            CItem.setCellValueFactory(new PropertyValueFactory<>("Item"));
            Ckg.setCellValueFactory(new PropertyValueFactory<>("Kg"));
             cpay.setCellValueFactory(new PropertyValueFactory<>("pay"));
            display();
           
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CargoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
