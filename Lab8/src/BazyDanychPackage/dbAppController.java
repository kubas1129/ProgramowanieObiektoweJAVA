package BazyDanychPackage;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class dbAppController {

    @FXML
    private AnchorPane mainStage;
    @FXML
    private TextField userField;
    @FXML
    private PasswordField passField;

    public void ChangeScene()
    {
        Stage primaryStage = (Stage) mainStage.getScene().getWindow();

        try
        {
            Parent menu = FXMLLoader.load(this.getClass().getResource("dbMenu.fxml"));

            Scene menuScene = new Scene(menu);

            primaryStage.setScene(menuScene);
            primaryStage.setTitle("Baza danych - menu");
            DB.ConnectToDB(userField.getText(),passField.getText());

        } catch (IOException e) {e.printStackTrace();}


    }




}
