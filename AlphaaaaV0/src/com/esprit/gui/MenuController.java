/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class MenuController implements Initializable {

    @FXML
    private Button Cbutton;
    @FXML
    private Button Fbutton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Commande(ActionEvent event) throws IOException {
       Stage stage;
       Parent root;
       
        if(event.getSource()==Cbutton){
            stage = (Stage) Cbutton.getScene().getWindow();
            FXMLLoader loader =  new FXMLLoader(getClass().getResource("Commande.fxml"));
            root = FXMLLoader.load(getClass().getResource("Commande.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    CommandesController lc = loader.getController();
    }
    }

    @FXML
    private void front(ActionEvent event) {
    }
}
