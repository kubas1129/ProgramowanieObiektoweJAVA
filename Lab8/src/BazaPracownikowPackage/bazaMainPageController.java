package BazaPracownikowPackage;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.ArrayList;

/**
 * Created by kubas on 08.12.2017.
 */
public class bazaMainPageController {

    @FXML
    private TextField fname;
    @FXML
    private TextField sname;
    @FXML
    private TextField pesel;
    @FXML
    private ListView listView;

    private DBPracwonicy dbp = new DBPracwonicy(); //polaczenie z baza

    public void AddToBase()
    {
        dbp.InsertPool(fname.getText(),sname.getText(),pesel.getText());
        RefreshList();
    }

    public void RefreshList()
    {
        ArrayList<dataBaseStruct> ls = dbp.listNames();

        listView.getItems().clear();

        for (Object e : ls.toArray())
        {
            if(e instanceof dataBaseStruct)
            {
                dataBaseStruct d = (dataBaseStruct)e;
                listView.getItems().add(new Label(d.firstname + "," + d.lastname + "," + String.valueOf(d.pesel)));
            }
        }
    }


    public void initialize()
    {
        dbp.connect();
        RefreshList();
    }



}
