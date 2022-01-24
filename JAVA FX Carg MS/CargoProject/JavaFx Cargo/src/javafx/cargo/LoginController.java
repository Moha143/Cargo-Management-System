/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx.cargo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class LoginController implements Initializable {

    @FXML
    private Button login;
    @FXML
    private PasswordField txtpassword;
    @FXML
    private TextField txtusername;

    /**
     * Initializes the controller class.
     */
    
     public void login(ActionEvent event) throws IOException {
        
         if(txtusername.getText().equals("Moo") &&txtpassword.getText().equals("123") )
         {
          Pane root =  FXMLLoader.load(getClass().getResource("Nav.fxml"));
        Scene scene = new Scene(root);
        Stage secondStage = new Stage();
        secondStage.setScene(scene);
        secondStage.setResizable(false); //diseable resize window
        secondStage.setTitle("Navigation Bar"); //window title
        secondStage.show();

        ((Node)event.getSource()).getScene().getWindow().hide();//hide the current window
         
         }
        //this function is open the second window.
         else 
         {
         
              Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Failed...");
    alert.setHeaderText("Invalid Username or password");
   
    alert.showAndWait();
    
         }

    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


   
    
}
