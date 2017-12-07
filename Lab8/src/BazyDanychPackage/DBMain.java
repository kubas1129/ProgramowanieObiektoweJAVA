package BazyDanychPackage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by kubas on 01.12.2017.
 */
public class DBMain extends Application {

    public static void main(String[] args)
    {
        launch(args);
    }


    @Override
    public void start(Stage stage) throws Exception
    {
        try
        {
            Parent dbInStage = FXMLLoader.load(this.getClass().getResource("dbApp.fxml"));
            Scene dbInScene = new Scene(dbInStage);

            stage.setTitle("Logowanie");
            stage.setScene(dbInScene);
            stage.show();
        } catch (IOException e) {e.printStackTrace();}



    }
}
