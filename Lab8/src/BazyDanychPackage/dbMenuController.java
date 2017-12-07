package BazyDanychPackage;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class dbMenuController {

    @FXML
    private AnchorPane mainStage;
    @FXML
    private Label connectionStatus;
    @FXML
    private TextField searchingName;
    @FXML
    private ListView<Label> listView;

    private int count = 0;

    public void RefreshStatus()
    {
        count++;
        connectionStatus.setText("Status: " + (DB.connected == true ? "Connected":"Disconnected"));
        if(count == 4 && !DB.connected)
        {
            Stage primaryStage = (Stage) mainStage.getScene().getWindow();

            try
            {
                Parent logowanie = FXMLLoader.load(this.getClass().getResource("dbApp.fxml"));

                Scene logowanieScene = new Scene(logowanie);

                primaryStage.setScene(logowanieScene);
                primaryStage.setTitle("logowanie");

            } catch (IOException e) {e.printStackTrace();}
        }
    }

    public void FindName()
    {
        if(DB.connected)
        {
            if(!searchingName.getText().equals(""))
            {
                ArrayList<dataBaseStruct> ls = new ArrayList<dataBaseStruct>(DB.listFound(searchingName.getText()));

                listView.getItems().clear();

                for(Object e : ls.toArray())
                {
                    if(e instanceof dataBaseStruct)
                    {
                        dataBaseStruct dbs = (dataBaseStruct)e;
                        listView.getItems().add(new Label(dbs.title + "," + dbs.author + "," + String.valueOf(dbs.year)));
                    }
                }
            }
            else
            {
                System.out.println("ww");
                ArrayList<dataBaseStruct> ls = new ArrayList<dataBaseStruct>(DB.listNames());

                listView.getItems().clear();


                for(Object e : ls.toArray())
                {
                    if(e instanceof dataBaseStruct)
                    {
                        dataBaseStruct dbs = (dataBaseStruct)e;
                        listView.getItems().add(new Label(dbs.title + "," + dbs.author + "," + String.valueOf(dbs.year)));
                    }
                }
            }

        }
    }


    public void initialize()
    {
        RefreshStatus();
        Timeline checkingStatus = new Timeline(new KeyFrame(Duration.seconds(2), new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                RefreshStatus();
            }
        }));
        checkingStatus.setCycleCount(Timeline.INDEFINITE);
        checkingStatus.play();
    }


}
