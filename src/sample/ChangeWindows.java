package sample;/* Created by Oussama on 13/01/2018. */

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class ChangeWindows {

    public static ControllerInvite controllerInvite;

    public static void incomingCall(String desc, boolean type){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Pane root = null;
                try {

                    FXMLLoader loader = new FXMLLoader(
                            getClass().getResource(
                                    "invite.fxml"
                            )
                    );

                    Pane pane = (Pane) loader.load();

                    ChangeWindows.controllerInvite =
                            loader.<ControllerInvite>getController();
                    ChangeWindows.controllerInvite.descCaller.setText(desc);
                    ChangeWindows.controllerInvite.type(type);
                    Main.stage.setScene(new Scene(pane, 300, 550));

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


    }
}
