/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx.cargo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class NavController implements Initializable {

    @FXML
    private BorderPane bp;
    @FXML
    private Button nav;
    @FXML
    private Button oncustomer;
    @FXML
    private Button onemployee;
    @FXML
    private Button oncargo;
    @FXML
    private Button onship;
    @FXML
    private Button onshipment;
    @FXML
    private Button onport;
    @FXML
    private AnchorPane ap;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    public void nav(MouseEvent event) {
        bp.setCenter(ap);
        
    }

    @FXML
    public void Customer(MouseEvent event) {
        loadpage("customers");
    }

    @FXML
    public void Employee(MouseEvent event) {
         loadpage("Employment");
        
         
           
    }

    @FXML
    public void Cargo(MouseEvent event) {
        loadpage("Cargo");
    }

    @FXML
    public void Ship(MouseEvent event) {
        loadpage("ship");
    }

    @FXML
    public void Shipment(MouseEvent event) {
        loadpage("Shipment");
    }

    @FXML
    public void Port(MouseEvent event) {
        loadpage("Port");
        
    }
    
   
            
    private void loadpage(String page){
    Parent root = null ;
        try {
            root= FXMLLoader.load(getClass().getResource(page+".fxml"));
            
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
       bp.setCenter(root);
       
     
    } 
    
}
