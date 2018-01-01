package JSonParserPackage;


import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by kubas on 26.12.2017.
 */


public class JSonParser {

    public static void main(String[] args)
    {
        String data = "{\"coord\":{\"lon\":19.94,\"lat\":50.06},\"weather\":[{\"id\":701,\"main\":\"Mist\",\"description\":\"mist\",\"icon\":\"50d\"}],\"base\":\"stations\",\"main\":{\"temp\":272.15,\"pressure\":1000,\"humidity\":92,\"temp_min\":272.15,\"temp_max\":272.15},\"visibility\":2000,\"wind\":{\"speed\":3.6,\"deg\":40},\"clouds\":{\"all\":0},\"dt\":1514363400,\"sys\":{\"type\":1,\"id\":5352,\"message\":0.0191,\"country\":\"PL\",\"sunrise\":1514356723,\"sunset\":1514385868},\"id\":3094802,\"name\":\"Krakow\",\"cod\":200}";

        DeserializeJSon(data);
    }


    public static void DeserializeJSon(String dataJSon)
    {
        if(dataJSon.length() > 0)
        {

            Pattern p6 = Pattern.compile("\"id\":([0-9]*\\.{0,1}[0-9]*),\"name\":\"(.*)\",\"cod\":([0-9]*\\.{0,1}[0-9]*)");
            Matcher m6 = p6.matcher(dataJSon);
            if(m6.find())
            {
                System.out.println(m6.group(1));
                System.out.println(m6.group(2));
                System.out.println(m6.group(3));
            }
            else
                System.out.println("NONE");



        }
    }
}
