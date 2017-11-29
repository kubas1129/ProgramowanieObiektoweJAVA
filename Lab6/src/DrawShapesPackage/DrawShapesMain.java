package DrawShapesPackage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;

public class DrawShapesMain extends Application{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        try
        {
            Parent root = FXMLLoader.load(this.getClass().getResource("shapeWindow.fxml"));

            Scene scene = new Scene(root);

            primaryStage.setScene(scene);
            primaryStage.setTitle("Shapes");
            primaryStage.show();
        } catch(IOException e) {e.printStackTrace();}
    }
}
