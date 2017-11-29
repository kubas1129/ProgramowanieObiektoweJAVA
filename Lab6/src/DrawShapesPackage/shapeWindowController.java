package DrawShapesPackage;

import ShapePackage.Circle;
import ShapePackage.Shape;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

/**
 * Created by kubas on 24.11.2017.
 */
public class shapeWindowController {

    @FXML
    private Pane panePanel;

    public void DrawRect()
    {
        Rectangle rect = new Rectangle(100,100,new Color(0.2,0.3,0.5,1.0));
        panePanel.getChildren().add(rect);
    }

    public void OnDragShape()
    {
        System.out.println("drag");
        if(panePanel.getChildren().size() > 0)
        {
            Node nd = panePanel.getChildren().get(0);
            nd.setTranslateX(nd.getTranslateX()+2);

        }
    }


    void initialize()
    {

    }



}
