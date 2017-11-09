package ShapePackage;

import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public abstract class Shape {
    public String name;

    public abstract void draw(VBox layout);
}
