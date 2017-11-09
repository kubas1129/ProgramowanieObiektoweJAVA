package ShapePackage;

import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class Circle extends Shape {
    public void draw(VBox layout)
    {
        if(layout.getChildren().size() > 4) layout.getChildren().remove(4);
        javafx.scene.shape.Circle cr = new javafx.scene.shape.Circle(50,50,50);
        cr.setFill(Color.KHAKI);
        layout.getChildren().add(cr);
        System.out.println("CIRCLE");
    }
}
