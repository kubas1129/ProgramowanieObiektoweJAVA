package BazyDanychPackage;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Created by kubas on 01.12.2017.
 */
public class DBMain extends Application {

    public static void main(String[] args)
    {
        launch(args);
    }


    @Override
    public void start(Stage stage) throws Exception
    {
        DB dBase = new DB("japalka","b0MSik9rM8YJW9bB");
        dBase.listNames();
        System.out.println("dzial");


    }
}
