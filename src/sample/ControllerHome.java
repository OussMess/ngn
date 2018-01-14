package sample;

import RTP.Receive;
import RTP.Send;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;


import java.io.IOException;
import java.util.*;
import java.net.URL;
import java.util.ResourceBundle;


public class ControllerHome implements Initializable{





    SipClient sipClient = new SipClient(this);

    @FXML
    private Button appeler;
    @FXML
    private Button raccrocher;
    @FXML
    private TextField localadr;
    @FXML
    private TextField destadr;

    static Receive receive = null;
    static Send send = null;



    public void initialize(URL location, ResourceBundle resources) {
        this.sipClient.onOpen(localadr);
    }



    public void appler(ActionEvent actionEvent) throws IOException {
        Alert alert = new Alert(Alert.AlertType.WARNING,"",ButtonType.YES,ButtonType.NO);
        alert.setTitle("Appel");
        alert.setHeaderText("Appel from:");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.YES){
            this.sipClient.onInvite( destadr );
        } else {
            this.sipClient.onBye();
        }




    }

    public void raccrocher(ActionEvent actionEvent) {
        this.sipClient.onBye();
    }





}