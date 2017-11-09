package ShapePackage;

import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class Rectangle extends Shape {
    public void draw(VBox layout)
    {
        if(layout.getChildren().size() > 4) layout.getChildren().remove(4);
        javafx.scene.shape.Rectangle rec = new javafx.scene.shape.Rectangle(100,20,150,100);
        rec.setFill(Color.SADDLEBROWN);
        layout.getChildren().add(rec);
        System.out.println("RECTANGLE");
    }
}
