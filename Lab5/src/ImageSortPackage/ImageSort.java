package ImageSortPackage;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by kubas on 10.11.2017.
 */
public class ImageSort extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        try
        {
            Parent root = FXMLLoader.load(this.getClass().getResource("sortWindow.fxml"));

            Scene scene = new Scene(root);

            primaryStage.setTitle("Indico App");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {e.printStackTrace();}
    }
}
