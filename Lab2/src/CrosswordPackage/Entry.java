package CrosswordPackage;

/**
 * Created by kubas on 14.10.2017.
 */

public class Entry {
    //vars

    private String word;
    private String clue;

    //Methods

    public Entry(String word_, String clue_)
    {
        word = word_;
        clue = clue_;
    }

    public String getWord() { return word; }
    public String getClue() { return clue; }

}
