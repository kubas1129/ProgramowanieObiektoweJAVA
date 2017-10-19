package PeselPackage;

public class Pesel {
    private String pesel;
    private int[] validationTable = {1,3,7,9,1,3,7,9,1,3,1};

    public Pesel(String pesel_) {pesel = pesel_;}

    public boolean Check()
    {
        if(pesel.length() != 11) return false;

        int validationSum = 0;
        for(int i = 0; i < 11; i++)
        {
            validationSum += Integer.parseInt(pesel.substring(i, i+1)) * validationTable[i];
        }

        if(validationSum%10 == 0)
            return true;
        else
            return false;
    }
}
