/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class FrontController implements Initializable {
    
    @FXML
    private Button btnSettings;
    @FXML
    private Button btnSignout;
    @FXML
    private Button btnHome;
    @FXML
    private Button btnOurEvents;
    @FXML
    private Pane OurEvents;
    @FXML
    private Pane Home;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleClicks(ActionEvent event) {
        if (event.getSource() == btnOurEvents) {
            OurEvents.setStyle("-fx-background-color : #ebe8f9");
            OurEvents.toFront();
        }
        if (event.getSource() == btnHome) {
            Home.setStyle("-fx-background-color : #ffffff");
            Home.toFront();
        }
    }
    
}
