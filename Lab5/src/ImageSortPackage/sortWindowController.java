package ImageSortPackage;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class sortWindowController {

    private boolean isStartApp=false;
    private String currentPath="";
    private Map<String,String> pred = new HashMap<String, String>();

    @FXML
    private TextField pathField;
    @FXML
    private TreeView<String> treeView;
    @FXML
    private ImageView imageView;
    @FXML
    private Label predictionLabel;

    @FXML
    public void Exit()
    {
        System.exit(0);
    }

    @FXML
    public void StartIndico()
    {
        if(isStartApp)
            if(pathField.getText().length() > 0)
            {
                RefreshList(IndicoSort.StartSorting(pathField.getText()));
                currentPath = pathField.getText();
            }

    }

    @FXML
    public void RefreshList(Map<String,String> prediction)
    {
        TreeItem<String> root = new TreeItem<String>("IMAGE PREDICTION");
        pred=prediction;
        for(Map.Entry<String, String> entry : prediction.entrySet())
        {
            String pattern = "(\\w+.jpg)";
            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(entry.getKey());
            if (m.find())
            {
                TreeItem<String> item = new TreeItem<String>(m.group(0));
                root.getChildren().add(item);
            }
        }
        treeView.setRoot(root);

        treeView.getSelectionModel().selectedItemProperty()
                .addListener(new ChangeListener<TreeItem<String>>() {

                    @Override
                    public void changed(
                            ObservableValue<? extends TreeItem<String>> observable,
                            TreeItem<String> old_val, TreeItem<String> new_val) {
                        TreeItem<String> selectedItem = new_val;
                        ImageSet(selectedItem.getValue());
                    }
                });
    }

    @FXML
    public void ImageSet(String name)
    {
        File f = new File(currentPath + "\\" + name);
        try
        {
            Image im = new Image(f.toURI().toURL().toString());
            imageView.setImage(im);
            imageView.setPreserveRatio(true);

            for(Map.Entry<String, String> entry : pred.entrySet())
            {
                String pattern = "(\\w+.jpg)";
                Pattern r = Pattern.compile(pattern);
                Matcher m = r.matcher(entry.getKey());
                if (m.find() && name.equals(m.group(0)))
                {
                    predictionLabel.setText(entry.getValue());
                }
            }
        }catch (MalformedURLException e) {e.printStackTrace();}
    }


    @FXML
    void initialize()
    {
        isStartApp=true;
    }
}

    //E:\AGH\SemestrIII\PO_Repository\Lab5\src\ImageSortPackage\foto