package ImageSortPackage;

import io.indico.Indico;
import io.indico.api.results.IndicoResult;
import io.indico.api.utils.IndicoException;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class IndicoSort {

    public static Map<String, String> StartSorting(String sourcePath)
    {
        System.out.println("WAIT...");
        RemoveDir(sourcePath);
        Map<String, String> prediction = new HashMap<String, String>();

        try{
            Indico indico = new Indico("2b1df4e065316a10e6d6d07dc553cc89");

            String[] paths = GetPathsName(sourcePath);

            IndicoResult[] results = new IndicoResult[paths.length];

            Map<String, String> outPrediction = new HashMap<String, String>();

            for(int i = 0; i < results.length;i++)
            {
                results[i] = indico.imageRecognition.predict(new File(paths[i]));

                //Compare and choose one best value
                double higherValue = -9999.f;
                String predict="";
                for(Map.Entry<String, Double> entry : results[i].getImageRecognition().entrySet())
                {
                    if(entry.getValue() > higherValue)
                    {
                        higherValue = entry.getValue();
                        predict = entry.getKey();
                    }
                }
                outPrediction.put(paths[i],predict);

            }

            //Sort to appropriate folder
            for(Map.Entry<String, String> entry : outPrediction.entrySet())
            {


                boolean success = (new File(sourcePath + "\\SortedImages\\" + entry.getValue() + "\\")).mkdirs();
                if(success)
                {
                    //Copy image to folder

                    File source = new File(entry.getKey());

                    String pattern = "(\\w+.jpg)";
                    Pattern r = Pattern.compile(pattern);
                    Matcher m = r.matcher(entry.getKey());
                    if (m.find())
                    {
                        File dest = new File(sourcePath + "\\SortedImages\\" + entry.getValue() + "\\" + m.group(0));
                        System.out.println(entry.getKey());
                        try {
                            Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.COPY_ATTRIBUTES);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            prediction = outPrediction;
        } catch (IndicoException | IOException e) {e.printStackTrace();}
        return prediction;
    }

    //Get paths
    private static String[] GetPathsName(String dir) throws NullPointerException
    {

        File folder = new File(dir);
        File[] listOfFiles = folder.listFiles();
        if(listOfFiles == null) throw new NullPointerException("Folder doesn't exists!"); //exception handle
        String[] paths = new String[listOfFiles.length];

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                paths[i] =  dir + "\\" + listOfFiles[i].getName();
            }
        }

        return paths;
    }

    public static void RemoveDir(String path)
    {
        //Usuwanie folderu
        File directory = new File(path + "\\SortedImages");
        try {
            //Deleting the directory recursively using FileUtils.
            FileUtils.deleteDirectory(directory);
            System.out.println("Folder usuniety!");
        } catch (IOException e) {
            System.out.println("Problem z usuwaniem : " + directory);
            e.printStackTrace();
        }
    }

}
