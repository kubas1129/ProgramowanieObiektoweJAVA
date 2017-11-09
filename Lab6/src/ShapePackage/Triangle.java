package ShapePackage;

import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class Triangle extends Shape {
    public void draw(VBox layout)
    {
        if(layout.getChildren().size() > 4) layout.getChildren().remove(4);
        javafx.scene.shape.Polygon tr = new javafx.scene.shape.Polygon(0,0,0,100,100,100);
        tr.setFill(Color.BLUE);
        layout.getChildren().add(tr);
        System.out.println("TRIANGLE");
    }
}
