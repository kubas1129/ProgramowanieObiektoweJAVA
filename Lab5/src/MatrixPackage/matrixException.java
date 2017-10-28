package MatrixPackage;

/**
 * Created by kubas on 27.10.2017.
 */
public class matrixException extends Exception{
    public matrixException(String message) { System.out.println(message);}
}

class InvalidMatrixDimnesion extends matrixException{
    InvalidMatrixDimnesion(String message) { super(message);}
}
