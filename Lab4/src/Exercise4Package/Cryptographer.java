package Exercise4Package;

import ReadWriteFilePackage.RW;

interface Algorithm{
    public String crypt(String word);
    public String decrypt(String cryptWord);
}


public class Cryptographer {
    public static void cryptfile(String fileToCrypt, String fileToSave, Algorithm algo)
    {


    }
}
