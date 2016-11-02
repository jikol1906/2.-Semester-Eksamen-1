package Presentation.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    @FXML
    public Button loginButton;
    public Button cancelButton;
    public Label messageLabel;
    public Button noButton;


    @FXML
    public void clickLogin(ActionEvent actionEvent) throws IOException {
        handleButtonAction(actionEvent);
    }

    @FXML
    public void clickCancel(ActionEvent actionEvent) throws IOException {
        handleButtonAction(actionEvent);
    }

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        Stage stage = null;
        Parent root = null;
        boolean check = true;

        if(event.getSource()==loginButton){
            //get reference to the button's stage
            stage=(Stage) loginButton.getScene().getWindow();
            //load up OTHER FXML document
            root = FXMLLoader.load(getClass().getResource("GUI/pageAfterLogin.fxml"));
        }
        else if(event.getSource()==cancelButton){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ALERT");
            alert.setHeaderText("Sup");
            alert.setContentText("You cant leave!");
            alert.showAndWait();
            check = false;
        }
        else if(event.getSource()==noButton){
            System.exit(0);
        }
        if(check) {
            //create a new scene with root and set the stage
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    public void noButton(ActionEvent actionEvent) throws IOException {
        handleButtonAction(actionEvent);
    }
}
