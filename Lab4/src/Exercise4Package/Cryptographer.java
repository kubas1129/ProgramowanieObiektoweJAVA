package Exercise4Package;

import ReadWriteFilePackage.RW;

interface Algorithm{
    public String crypt(String word);
    public String decrypt(String cryptWord);
}


public class Cryptographer {

    public static void cryptfile(String fileToCrypt, String fileToSave, Algorithm algo)
    {
        String content = RW.ReadFromFile(fileToCrypt);
        String crypted = algo.crypt(content);
        RW.SaveToFile(fileToSave, crypted);
    }

    public static void decryptfile(String fileToDecrypt, String fileToSave, Algorithm algo)
    {
        String content = RW.ReadFromFile(fileToDecrypt);
        String decrypted = algo.decrypt(content);
        RW.SaveToFile(fileToSave, decrypted);
    }
}
