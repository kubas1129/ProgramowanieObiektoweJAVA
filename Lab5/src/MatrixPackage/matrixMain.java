package MatrixPackage;

/**
 * Created by kubas on 27.10.2017.
 */
public class matrixMain {
    public static void main(String[] arg)
    {
        matrix m = new matrix(2,2, new int[] {1,1,1,1});
        matrix n = new matrix(2,2, new int[] {2,5,3,1});

        try{
            matrix o = m.Mul(n);
            o.ShowMatrixContent();
        } catch (InvalidMatrixDimnesion e) {e.printStackTrace();}

    }
}
