package home;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BackController implements Initializable {

    @FXML
    private Button btnOverview;

    @FXML
    private Button btnOrders;

    @FXML
    private Button btnSettings;

    @FXML
    private Button btnSignout;
    
    @FXML
    private Pane pnlOverview;

    @FXML
    private Button btnUsers;
    @FXML
    private Button btnEvents;
    @FXML
    private Button btnProducts;
    @FXML
    private Button btnSugg;
    @FXML
    private Button btnBlogs;
    @FXML
    private Pane pnlUsers;
    @FXML
    private Pane pnlEvents;
    @FXML
    private Pane pnlProducts;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        Node[] nodes = new Node[10];
//        for (int i = 0; i < nodes.length; i++) {
//            try {
//
//                final int j = i;
//                //nodes[i] = FXMLLoader.load(getClass().getResource("Item.fxml"));
//
//                //give the items some effect
//
//                nodes[i].setOnMouseEntered(event -> {
//                    nodes[j].setStyle("-fx-background-color : #0A0E3F");
//                });
//                nodes[i].setOnMouseExited(event -> {
//                    nodes[j].setStyle("-fx-background-color : #02030A");
//                });
//                pnItems.getChildren().add(nodes[i]);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }


    @FXML
    public void handleClicks(ActionEvent actionEvent) {
        if (actionEvent.getSource() == btnUsers) {
            pnlUsers.setStyle("-fx-background-color : #ebe8f9");
            pnlUsers.toFront();
        }
        if (actionEvent.getSource() == btnEvents) {
            pnlEvents.setStyle("-fx-background-color : #ebe8f9");
            pnlEvents.toFront();
        }
        if (actionEvent.getSource() == btnOverview) {
            pnlOverview.setStyle("-fx-background-color : #ffffff");
            pnlOverview.toFront();
        }
        if(actionEvent.getSource()==btnProducts)
        {
            pnlProducts.setStyle("-fx-background-color : #ebe8f9");
            pnlProducts.toFront();
        }
    }
}
