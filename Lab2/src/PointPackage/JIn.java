package PointPackage;

import java.io.*;

/**
 * Created by kubas on 13.10.2017.
 */
public class JIn {
    public static String GetInput()
    {
        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            return bf.readLine();
        } catch(IOException e) {e.printStackTrace();}
        return "";
    }
}
