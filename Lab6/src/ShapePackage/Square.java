package ShapePackage;

import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class Square extends Shape{
    public void draw(VBox layout)
    {
        if(layout.getChildren().size() > 4) layout.getChildren().remove(4);
        javafx.scene.shape.Rectangle sq = new javafx.scene.shape.Rectangle(100,100,100,100);
        sq.setFill(Color.DARKMAGENTA);
        layout.getChildren().add(sq);
        System.out.println("SQUARE");
    }

}
