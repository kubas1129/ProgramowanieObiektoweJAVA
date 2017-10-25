package Exercise4Package;

public class Polibius implements Algorithm {
    private static final int[] code = {11,12,13,14,15,21,22,23,24,25,31,32,33,34,35,41,42,43,44,45,51,52,53,54,55};
    private static final char[] alphabet = {'A','B','C','D','E','F','G','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

    public String crypt(String source)
    {
        String out = "";
        source = source.toUpperCase();
        for (char e : source.toCharArray()) {
            if(e >= 'A' && e <= 'Z')
            {
                if(e == 'I' || e == 'J')
                    out += "24 ";
                else if(e > 'J')
                    out += String.valueOf(code[(e - 'A' - 1)]) + " ";
                else
                    out += String.valueOf(code[(e - 'A')]) + " ";
            }

        }
        return out;
    }

    public String decrypt(String source)
    {
        String out = "";
        String temp = "";
        for(char e : source.toCharArray())
        {
            if(e == ' ' && temp.length() ==  2)
            {
                int k = Integer.parseInt(String.valueOf(temp.charAt(0)));
                int m = Integer.parseInt(String.valueOf(temp.charAt(1)));
                temp = "";
                out += alphabet[k*5 - (6-m)];
            }
            else if(e != ' ')
            {
                temp += e;
            }
        }
        return out;
    }
}
