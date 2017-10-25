package Exercise4Package;

public class ROT11 implements Algorithm {
    static final String alphabet = "abcdefghijklmnopqrtsuvwxyz";
    static final int rot = 11;

    @Override
    public String crypt(String word) {
        String out = "";
        for (char e : word.toCharArray())
        {
            if(e > 111)
                out += Character.toString((char) ( e - 15));
            else
                out += Character.toString((char) (e + 11));
        }
        return out;
    }

    @Override
    public String decrypt(String cryptWord) {
        String out = "";
        for (char e : cryptWord.toCharArray())
        {
            if(e > 111)
                out += Character.toString((char) ( e - 11));
            else
                out += Character.toString((char) (e + 15));
        }
        return out;
    }
}
