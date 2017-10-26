package MicroDVDPackage;


public class MicroDVDException extends Exception{
    public MicroDVDException(String message, int line) { System.out.println(message + "\nLine:" + line);}
}

class IllegalCharException extends MicroDVDException{
    public IllegalCharException(String message, int line) {super(message, line);}
}

class FirstTimeGreaterThanSecondException extends MicroDVDException{
    public FirstTimeGreaterThanSecondException(String message, int line) {super(message,line);}
}

class NegativeFrames extends MicroDVDException{
    public NegativeFrames(String message, int line) {super(message, line);}
}
