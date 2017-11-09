package DrawShapesPackage;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import ShapePackage.*;

public class DrawShapesMain extends Application{

    Stage window;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;
        VBox layout = new VBox();
        layout.setSpacing(5);

        //Buttons to draw Shapes
        Button rectangleButton = new Button("Prostokat");
        rectangleButton.setOnAction(e -> {
            Rectangle s = new Rectangle();
            s.draw(layout);
        });
        Button squareButton = new Button("Kwadrat");
        squareButton.setOnAction(e -> {
            Square s = new Square();
            s.draw(layout);
        });
        Button circleButton = new Button("Koło");
        circleButton.setOnAction(e -> {
            Circle s = new Circle();
            s.draw(layout);
        });
        Button triangleButton = new Button("Trojkat");
        triangleButton.setOnAction(e -> {
            Triangle s = new Triangle();
            s.draw(layout);
        });


        //Window setup
        layout.getChildren().addAll(rectangleButton, squareButton, circleButton, triangleButton);
        Scene scene = new Scene(layout,300,300);
        window.setTitle("Shapes");
        window.setScene(scene);
        window.show();

    }
}
