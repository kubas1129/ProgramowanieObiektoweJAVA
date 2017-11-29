package DrawShapesPackage;


import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 * Created by kubas on 24.11.2017.
 */
public class shapeWindowController {

    @FXML
    private Pane panePanel;
    @FXML
    private Shape shape;

    private double orgMouseX, orgMouseY;
    private double orgShapeX, orgShapeY;

    private EventHandler<MouseEvent> onShapeMousePressedHandler = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            orgMouseX = event.getSceneX();
            orgMouseY = event.getSceneY();
            orgShapeX = ((Shape)(event.getSource())).getTranslateX();
            orgShapeY = ((Shape)(event.getSource())).getTranslateY();
        }
    };

    private EventHandler<MouseEvent> onShapeMouseDragHandler = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            double offsetX = event.getSceneX() - orgMouseX;
            double offsetY = event.getSceneY() - orgMouseY;
            double newTranslateX = orgShapeX + offsetX;
            double newTranslateY = orgShapeY + offsetY;

            ((Shape)(event.getSource())).setTranslateX(newTranslateX);
            ((Shape)(event.getSource())).setTranslateY(newTranslateY);
        }
    };

    private void DrawShape(Shape sh)
    {
        if(shape != null) panePanel.getChildren().remove(shape);
        shape = sh;
        shape.setOnMousePressed(onShapeMousePressedHandler);
        shape.setOnMouseDragged(onShapeMouseDragHandler);
        panePanel.getChildren().add(shape);
    }


    public void DrawRect()
    {
        DrawShape(new Rectangle(100,200,new Color(0.2,0.3,0.5,1.0)));
    }

    public void DrawSquare()
    {
        DrawShape(new Rectangle(100,100,new Color(0.2,0.5,0.7,1.0)));
    }

    public void DrawTriangle()
    {
        Polygon pl = new Polygon();
        pl.getPoints().addAll(new Double[]{
                10.0, 10.0,
                10.0, 200.0,
                250.0, 200.0,
        });
        pl.setFill(new Color(0.5412, 0, 1, 1));
        DrawShape(pl);
    }

    public void DrawRound()
    {
        DrawShape(new Circle(50.0,50.0,50.0,new Color(0.2431, 0.702, 0.1216, 1)));
    }



    void initialize()
    {

    }



}
