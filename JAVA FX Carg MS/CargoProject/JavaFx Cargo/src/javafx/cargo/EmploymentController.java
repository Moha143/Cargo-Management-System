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
public class EmploymentController implements Initializable {
   public ObservableList<empclass> list;
 Connection con1;
      PreparedStatement insert;
    @FXML
    private TextField emp_id;
    @FXML
    private TextField emp_name;
    @FXML
    private TextField emp_tell;
    @FXML
    private TextField emp_address;
    @FXML
    private TextField combogender;
    @FXML
    private TextField txtsalary;
    @FXML
    private Button btnupdate;
    @FXML
    private Button btndelete;
    @FXML
    private Button btnclose;
    @FXML
    private Button btnsave;
    @FXML
    private TableView<empclass> table;
    @FXML
    private TableColumn<empclass, String> CID;
    @FXML
    private TableColumn<empclass, String> CName;
    @FXML
    private TableColumn<empclass, String> CPhone;
    @FXML
    private TableColumn<empclass, String> CAddress;
    @FXML
    private TableColumn<empclass, String> CGender;
    @FXML
    private TableColumn<empclass, String> CSalary;
String ID, Name,Address,Phone ,Gender, Salary;

     public void id(){
      String id= emp_id.getText();
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
      String id= emp_tell.getText();
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
      public void salary(){
      String id= emp_tell.getText();
        if(id.matches("^[0-9]*$"))
        {
           
        } 
        
        else
        {
            
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText("Salary");
                alert.setContentText("Salary : Only Numbers are Allowed");
                alert.showAndWait();
        }
    }  
        @FXML
    public void insert(){                                         
        // TODO add your handling code here:
        id();
        phone();
        salary();
        String id= emp_id.getText();
        
        String name= emp_name.getText();
        String phone= emp_tell.getText();
        String address= emp_address.getText();
       String combo=combogender.getText();
        String salary= txtsalary.getText();
        

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost/cargo","root","");
            insert = con1.prepareStatement("insert into employee (emp_id ,emp_name,emp_tell, emp_address,Gender,Salary )values(?,?,?,?,?,?)");
            insert.setString(1,id);
            insert.setString(2,name);
            insert.setString(3,phone);
            insert.setString(4,address);
            insert.setString(5,combo);
            insert.setString(6,salary);
            insert.executeUpdate();
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Success...");
    alert.setHeaderText("Record Saved ");

    alert.showAndWait();
     display();
         
            emp_id.setText("");
            emp_name.setText("");
            emp_tell.setText("");
            emp_address.setText("");
           combogender.setText("");
            txtsalary.setText("");
            emp_id.requestFocus();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EmploymentController.class.getName()).log(Level.SEVERE, null, ex);

        }

    }  
    
    public void clear(){
     emp_id.setText("");
            emp_name.setText("");
            emp_tell.setText("");
            emp_address.setText("");
           combogender.setText("");
            txtsalary.setText("");
            emp_id.requestFocus();
    }
         
    @FXML
        public void Update() {
          id();
        phone();
        salary();
        if (emp_id.getText() .equals("") ) {

            //alert information
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setContentText("You must fill All ID textBox to Delete.");
            alert.setHeaderText(null);
            alert.showAndWait();
        }
        else {

            


            try {
                int ids = Integer.parseInt(emp_id.getText());
                String name = emp_name.getText();
                int phone = Integer.parseInt(emp_tell.getText());

                String address = emp_address.getText();
                String combo = combogender.getText();
                int salary = Integer.parseInt(txtsalary.getText());

              Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost/cargo","root","");
     
String sql = "update employee set emp_name= '" + name + "',emp_tell= '" + phone+ "',emp_address='"+address + "',Gender='"+combo +  "',Salary='"+salary +     "' WHERE emp_id ='" + ids + "' ";

          
                PreparedStatement pst;
                pst = con1.prepareStatement(sql);
                pst.execute();
                list.clear();
           

            emp_id.setText("");
            emp_name.setText("");
            emp_tell.setText("");
            emp_address.setText("");
           combogender.setText("");
            txtsalary.setText("");
            emp_id.requestFocus();

                //alert information
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setContentText("The Record Updated");
                alert.setHeaderText(null);
                alert.showAndWait();
  
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
               
            String sql = "select * from employee";
            PreparedStatement pst = con1.prepareStatement(sql);

            ResultSet rs =pst.executeQuery(sql);
            list.clear();

               while (rs.next()) {
                ID =rs.getString(1);
                Name =rs.getString(2);
                Address= rs.getString(3);
                Phone= rs.getString(4);  
                Gender= rs.getString(5); 
                Salary= rs.getString(6);
               list.add(new empclass(ID, Name,Phone,Address ,Gender, Salary));
               //String ;
              
            }
            table.setItems(list);
            rs.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
     
    @FXML
      public void mouseDataFilling(){
    
    table.setOnMouseClicked( e-> {
        empclass obj = table.getItems().get(table.getSelectionModel().getSelectedIndex());        
          emp_id  .setText(obj.getID());
          emp_name.setText(obj.getName());
          emp_tell.setText(obj.getPhone()); 
            
            emp_address.setText(obj.getAddress()); 
            combogender.setText(obj.getGender()); 
            txtsalary.setText(obj.getSalary()); 
          
            
     });
    
   
            } 
      
    @FXML
           public void delete(){
 id();
        phone();
        salary();
        if (emp_id.getText() .equals("") ) {

            //alert information
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setContentText("You must fill All ID textBox to Delete.");
            alert.setHeaderText(null);
            alert.showAndWait();
        }
        else {

            int id = Integer.parseInt(emp_id.getText());
            


            try {
              Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost/cargo","root","");
                String sql = "DELETE FROM Employee WHERE emp_id ='" + id + "' ";

                PreparedStatement pst;

                pst = con1.prepareStatement(sql);
                pst.execute();
                list.clear();

emp_id.setText("");
            emp_name.setText("");
            emp_tell.setText("");
            emp_address.setText("");
           combogender.setText("");
            txtsalary.setText("");
            emp_id.requestFocus();
                //alert information
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setContentText("The Row was Deleted");
                alert.setHeaderText(null);
                alert.showAndWait();

             
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
            CPhone.setCellValueFactory(new PropertyValueFactory<>("Phone"));
            CAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
             CGender.setCellValueFactory(new PropertyValueFactory<>("Gender"));
             CSalary.setCellValueFactory(new PropertyValueFactory<>("Salary"));
          //   ID, Name,Address,Phone ,Gender, Salary;//
            display();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmploymentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
