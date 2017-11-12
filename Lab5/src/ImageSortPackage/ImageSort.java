package ImageSortPackage;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;

import io.indico.Indico;
import io.indico.api.custom.CollectionData;
import io.indico.api.custom.IndicoCollection;
import io.indico.api.results.IndicoResult;
import io.indico.api.results.BatchIndicoResult;
import io.indico.api.utils.IndicoException;
import io.indico.Indico;
import org.apache.commons.io.FileUtils;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import javax.imageio.ImageIO;


/**
 * Created by kubas on 10.11.2017.
 */
public class ImageSort {
    public static void main(String[] args)
    {
        try{
            Indico indico = new Indico("2b1df4e065316a10e6d6d07dc553cc89");

            //String pathToFolder = args[0];
            String pathToFolder = "F:\\AGH\\InfaSemestr3\\PO\\Projects\\Lab5\\src\\ImageSortPackage\\foto";
            String[] paths = GetPathsName(pathToFolder);

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
                Path path = Paths.get(pathToFolder + "\\" + entry.getValue());
                if(Files.notExists(path))
                {
                    boolean success = (new File(pathToFolder + "\\" + entry.getValue())).mkdir();
                    if(success)
                    {
                        //Copy image to folder
                        File source = new File(entry.getKey());
                        File dest = new File(pathToFolder + "\\" + entry.getValue());
                        try{
                            Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
                        } catch (IOException e) {e.printStackTrace();}

                        //System.out.println("Folder created!");

                    }
                    else
                    {
                        //System.out.println("Failed to create folder!");
                    }
                }
                else
                {
                    //System.out.println("Folder existed!");
                    //Copy image to folder
                    File source = new File(entry.getKey());
                    File dest = new File(pathToFolder + "\\" + entry.getValue());
                    try{
                        Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    } catch (IOException e) {e.printStackTrace();}
                }
            }



        } catch (IndicoException | IOException e) {e.printStackTrace();}
    }


    //Get paths
    private static String[] GetPathsName(String dir) throws NullPointerException
    {
        try
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
        finally {

        }
    }

}
