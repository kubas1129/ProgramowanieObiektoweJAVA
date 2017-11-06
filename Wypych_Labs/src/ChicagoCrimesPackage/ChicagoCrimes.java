package ChicagoCrimesPackage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * Created by kubas on 05.11.2017.
 */
public class ChicagoCrimes {
    private List<String> data;

    public ChicagoCrimes(String file) {

        try
        {
            BufferedReader bf = new BufferedReader(new FileReader(file));
            String line = bf.readLine();
            String columnNames = line;
            line = bf.readLine();

            while(line != null)
            {
                data.add(line);
                line = bf.readLine();
            }

            bf.close();

        } catch (IOException e) { e.printStackTrace();}

    }



}
