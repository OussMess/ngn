package sample;

import RTP.Receive;
import RTP.Send;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;


import java.util.*;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller  implements Initializable{





    SipClient sipClient = new SipClient(this);

    @FXML
    private Button appeler;
    @FXML
    private TextArea recu;

    @FXML
    private Button raccrocher;

    @FXML
    private TextArea envoyer;

    @FXML
    private TextField localadr;
    @FXML
    private TextField destadr;
    static Receive receive = null;
    static Send send = null;



    public void initialize(URL location, ResourceBundle resources) {
        this.sipClient.onOpen(localadr);
    }



    public void appler(ActionEvent actionEvent) {
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