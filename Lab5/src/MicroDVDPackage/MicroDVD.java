package MicroDVDPackage;

import ReadWriteFilePackage.*;





public class MicroDVD {

    public static void delay(String source, String fileToSave, int delay, int framerate)
    {
        int delayInFramerate = (framerate * delay)/10;
        String out = "";
        String in  = RW.ReadFromFile(source);
        String tempA = "", tempB = "";

        System.out.println(delayInFramerate);

        try {
            for(int i = 0; i < in.length();i++)
            {
                if(in.charAt(i) == '{')
                {
                    i++;
                    while(in.charAt(i) != '}')
                    {
                        if(in.charAt(i) == '-') throw new NegativeFrames("Wykryto ujemne klatki!",new Throwable().getStackTrace()[0].getLineNumber());
                        if(in.charAt(i) > '9' || in.charAt(i) < '0') throw new IllegalCharException("Wykryto literę: " + "'{.." + in.charAt(i) + "..}'" + " - timing obsługuje tylko cyfry!",
                                new Throwable().getStackTrace()[0].getLineNumber());
                        tempA += in.charAt(i);
                        i++;
                    }
                    out += '{' + String.valueOf(Integer.parseInt(tempA) + delayInFramerate) + '}';

                    i++;
                    if(in.charAt(i) == '{')
                    {
                        i++;
                        while(in.charAt(i) != '}')
                        {
                            if(in.charAt(i) == '-') throw new NegativeFrames("Wykryto ujemne klatki!",new Throwable().getStackTrace()[0].getLineNumber());
                            if(in.charAt(i) > '9' || in.charAt(i) < '0') throw new IllegalCharException("Wykryto literę: " + "'{.." + in.charAt(i) + "..}'" + " - timing obsługuje tylko cyfry!",
                                    new Throwable().getStackTrace()[0].getLineNumber());
                            tempB += in.charAt(i);
                            i++;
                        }
                        out += '{' + String.valueOf(Integer.parseInt(tempB) + delayInFramerate) + '}';

                    }

                    if(Integer.parseInt(tempA) > Integer.parseInt(tempB)) throw new FirstTimeGreaterThanSecondException("Niepoprawny timing napisów: {" + tempA + "}{" + tempB + "}",
                            new Throwable().getStackTrace()[0].getLineNumber());

                    tempA="";
                    tempB="";
                }
                else
                {
                    out += in.charAt(i);
                }
            }
        }

        catch (FirstTimeGreaterThanSecondException | IllegalCharException | NegativeFrames e) {
            e.printStackTrace();
        }

        RW.SaveToFile(fileToSave,out);
    }
}
