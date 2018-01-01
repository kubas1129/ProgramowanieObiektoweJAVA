package BazaPracownikowPackage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by kubas on 08.12.2017.
 */
public class BazaPracownikowMain extends Application {

    public static void main(String[] args) {launch(args);}

    @Override
    public void start(Stage stage) throws Exception {


        try
        {

            Parent root  = FXMLLoader.load(this.getClass().getResource("bazaMainPage.fxml"));

            Scene scene = new Scene(root);

            stage.setTitle("Main page");
            stage.setScene(scene);
            stage.show();


        }catch(IOException e){e.printStackTrace();}

    }
}
