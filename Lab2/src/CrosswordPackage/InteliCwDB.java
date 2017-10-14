package CrosswordPackage;

import java.util.*;
import java.util.regex.*;

/**
 * Created by kubas on 14.10.2017.
 */

public class InteliCwDB extends CwDB{

    //Constructors

    public InteliCwDB(String filename)
    {
        //super(filename);

        //Using add methods from InteliCwDB, manual adding
        super("");

        Scanner scan = new Scanner(getClass().getResourceAsStream(filename));

        while(scan.hasNextLine())
            add(scan.nextLine(), scan.nextLine());

        for(Entry en : dict)
            System.out.println(en.getWord() + " [-] " + en.getClue());
    }

    //Methods

    public LinkedList<Entry> findAll(String pattern)
    {
        LinkedList<Entry> found = new LinkedList<Entry>();

        //regular expression
        String regPattern = ("\\b(" + pattern + ")+(.*)");
        Pattern r = Pattern.compile(regPattern);

        for(Entry en : dict)
        {
            Matcher m = r.matcher(en.getClue());
            if(m.find())
                found.add(new Entry(en.getWord(), en.getClue()));
        }
        return found;
    }

    public Entry getRandom()
    {
        //Random number
        Random  rn = new Random();
        int i = rn.nextInt(dict.size());

        return dict.get(i);
    }

    public Entry getRandom(int length)
    {
        LinkedList<Entry> found = new LinkedList<Entry>();

        for(Entry en : dict)
        {
            if(en.getWord().length() == length)
                found.add(new Entry(en.getWord(), en.getClue()));
        }

        //Random number
        Random  rn = new Random();
        int i = rn.nextInt(found.size());

        return found.get(i);
    }

    public Entry getRandom(String pattern)
    {
        LinkedList<Entry> found = new LinkedList<Entry>();

        //regular expression
        String regPattern = ("\\b(" + pattern + ")+(.*)");
        Pattern r = Pattern.compile(regPattern);

        for(Entry en : dict)
        {
            Matcher m = r.matcher(en.getClue());
            if(m.find())
                found.add(new Entry(en.getWord(), en.getClue()));
        }
        //Random number
        Random  rn = new Random();
        int i = rn.nextInt(found.size());

        return found.get(i);
    }

    public void add(String word, String clue)
    {
        dict.add(new Entry(word,clue));
        dict.sort(Comparator.comparing(Entry::getWord));
    }
}
