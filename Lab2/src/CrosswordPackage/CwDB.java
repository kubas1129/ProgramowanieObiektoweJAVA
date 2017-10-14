package CrosswordPackage;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;


/**
 * Created by kubas on 14.10.2017.
 */

public class CwDB {
    //vars

    protected LinkedList<Entry> dict = new LinkedList<Entry>();


    //Constructors

    public CwDB(String filename)
    {
        if(filename.length() > 0)
            createDB(filename);

        /*
        for(Entry en : dict)
            System.out.println(en.getWord() + " [-] " + en.getClue());
        */
    }

    //Methods

    public void add(String word, String clue)
    {
        add(word,clue);
    }

    public Entry get(String word)
    {
        for(Entry en : dict)
        {
            if(en.getWord() == word)
                return en;
        }
        System.out.println("Word not found!");
        return null;
    }

    public void remove(String word)
    {
        for(Entry en : dict)
        {
            if(en.getWord() == word)
                dict.remove(en);
                break;
        }
    }

    public void saveDB(String filename)
    {
        try
        {
            PrintWriter out = new PrintWriter(filename);
            String text = "";

            for(Entry en : dict)
                text += en.getWord() + "\n" + en.getClue() + "\n";

            out.println(text);
            out.close();

        } catch (FileNotFoundException f) {f.printStackTrace();}

    }

    public int getSize() { return dict.size(); }

    protected void createDB(String filename)
    {
        Scanner scan = new Scanner(getClass().getResourceAsStream(filename));

        while(scan.hasNextLine())
        {
            //TODO secure reading file when number of line is odd
            dict.add(new Entry(scan.nextLine(), scan.nextLine()));
        }
    }
}
