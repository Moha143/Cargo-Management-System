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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class HomeController implements Initializable {

    @FXML
    private Button oncustomer;
    @FXML
    private Button onemployee;
    @FXML
    private Button oncargo;
    @FXML
    private Button onship;
    @FXML
    private Button onport;
    @FXML
    private Button onshipment;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Customer(MouseEvent event) {
        
    }

    @FXML
    private void Employee(MouseEvent event) {
    }

    @FXML
    private void Cargo(MouseEvent event) {
    }

    @FXML
    private void Ship(MouseEvent event) {
    }

    @FXML
    private void Port(MouseEvent event) {
    }

    @FXML
    private void Shipment(MouseEvent event) {
    }
    private void loadpage(String page){
    Parent root = null;
    
        try {
            root= FXMLLoader.load(getClass().getResource(page+".fxml"));
            
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root);
        Stage secondStage = new Stage();
        secondStage.setScene(scene);
        secondStage.setResizable(false); //diseable resize window
        secondStage.setTitle("Home"); //window title
        secondStage.show();
    } 
}
