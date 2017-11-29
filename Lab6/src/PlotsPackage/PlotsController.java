package PlotsPackage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.util.List;


public class PlotsController {

    @FXML
    private TextField stopien;
    @FXML
    private VBox factorBox;
    @FXML
    private Pane mainPane;

    NumberAxis yAxis = new NumberAxis();
    NumberAxis xAxis = new NumberAxis();

    LineChart<Number,Number> lineChart = new LineChart<Number,Number>(xAxis,yAxis);

    public void UpdateList()
    {
        int level = Integer.parseInt(stopien.getText());

        factorBox.getChildren().clear();

        for(int i=0;i<level;i++)
        {
            TextField node = new TextField();
            node.setPromptText("Factor " + String.valueOf(level));
            node.setPadding(new Insets(5,0,5,0));
            node.setText("0");
            node.setMaxWidth(20);

            Label text = new Label();
            text.setText(" *   x^" + i);
            text.setTextAlignment(TextAlignment.CENTER);
            text.setPadding(new Insets(5,0,5,10));

            HBox box = new HBox();
            box.getChildren().add(node);
            box.getChildren().add(text);

            factorBox.getChildren().add(box);
        }

        Button draw = new Button();
        draw.setText("Rysuj");
        draw.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DrawPlot();
            }
        });
        factorBox.getChildren().add(draw);

    }


    public void DrawPlot()
    {
        if(factorBox.getChildren().size() > 1)
        {
            lineChart.getData().clear();

            XYChart.Series series = new XYChart.Series();
            for(int arg=0;arg<=20;arg++)
            {
                System.out.println("Value:" + ComputeValueOfFunction(arg) + " of arg: " + arg);
                series.getData().add(new XYChart.Data(arg,ComputeValueOfFunction(arg)));
            }
            lineChart.getData().add(series);
            if(mainPane.getChildren().size() == 0) mainPane.getChildren().add(lineChart);
        }
    }

    private int ComputeValueOfFunction(int arg)
    {
        int value=0;
        int square=0;
        for(Node e : factorBox.getChildren())
        {
            if(e instanceof HBox)
            {
                TextField tf = ((TextField)((HBox) e).getChildren().get(0));

                value += Math.pow(arg,square)*Integer.valueOf( tf.getText());
                square++;
            }

        }
        return value;
    }



    public void initialize()
    {
        lineChart.setMaxHeight(300);
        lineChart.setMaxWidth(450);
    }




}
