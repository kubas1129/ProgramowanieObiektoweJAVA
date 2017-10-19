package PeselPackage;

import java.io.*;

public class PeselMain {
    public static void main(String[] arg)
    {
        String strPesel = "";

        try{
            System.out.print("Wpisz numer pesel: ");
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            strPesel = bf.readLine();
        } catch(IOException e) {e.printStackTrace();}

        Pesel pesel = new Pesel(strPesel);

        if(pesel.Check())
            System.out.println("Pesel poprawny!");
        else
            System.out.println("Pesel niepoprawny!");
    }
}
