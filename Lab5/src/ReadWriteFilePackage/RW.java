package ReadWriteFilePackage;

import java.io.*;


public class RW {
    public static String ReadFromFile(String fileName)
    {
        String content = "";

        try{
            FileReader fileReader = new FileReader(fileName);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while((line = bufferedReader.readLine()) != null){
                content += line;
            }

            bufferedReader.close();
        }
        catch (FileNotFoundException e) {e.printStackTrace();}
        catch (IOException e) {e.printStackTrace();}

        return content;
    }

    public static void SaveToFile(String fileName, String content)
    {
        try {
            FileWriter fileWriter = new FileWriter(fileName);

            BufferedWriter bufferWriter = new BufferedWriter(fileWriter);

            bufferWriter.write(content);
            bufferWriter.newLine();

            bufferWriter.close();
        } catch (IOException e) {e.printStackTrace();}
    }
}
