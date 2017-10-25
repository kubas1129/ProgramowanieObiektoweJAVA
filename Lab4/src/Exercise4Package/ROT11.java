package Exercise4Package;

public class ROT11 implements Algorithm {
    static final char[] alphabet = { 'a', 'b', 'c', 'd', 'e',
            'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
            's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E',
            'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
            'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    static final int rot = 11;

    @Override
    public String crypt(String word) {
        String out = "";
        for (char e : word.toCharArray())
        {
            if(e >= 'a' && e <= 'z')
            {
                if(e > 'o')
                    out += Character.toString((char) ( 'a' + (e - 'p')));
                else
                    out += Character.toString((char) (e + rot));
            }
            else if(e >= 'A' && e <= 'Z')
            {
                if(e > 'O')
                    out += Character.toString((char) ( 'A' + (e - 'P')));
                else
                    out += Character.toString((char) (e + rot));
            }

        }
        return out;
    }

    @Override
    public String decrypt(String cryptWord) {
        String out = "";
        for (char e : cryptWord.toCharArray())
        {
            if(e >= 'a' && e <= 'z')
            {
                if(e > 'k')
                    out += Character.toString((char) (e - rot));
                else
                    out += Character.toString((char) ('p' + (e - 'a')));
            }
            else if(e >= 'A' && e <= 'Z')
            {
                if(e > 'K')
                    out += Character.toString((char) (e - rot));
                else
                    out += Character.toString((char) ('P' + (e - 'A')));
            }

        }
        return out;
    }
}
