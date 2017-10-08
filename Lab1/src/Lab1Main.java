import JInPackage.JIn;
import MatrixPackage.matrix;

public class Lab1Main {
    public static void main(String[] arg)
    {
        matrix myMatrixM =  new matrix(2,2, new int[]{1,1,1,1});
        matrix myMatrixN = new matrix(2,2, new int[]{2,0,2,0});

        //myMatrixM.ShowMatrixContent();
        //myMatrixN.ShowMatrixContent();

        matrix myAddMatrix = myMatrixM.Add(myMatrixN);
        //myAddMatrix.ShowMatrixContent();

        matrix mySubMatrix = myMatrixM.Sub(myMatrixN);
        mySubMatrix.ShowMatrixContent();
    }
}
