package MatrixPackage;

import ReadWriteFilePackage.RW;

public class matrix {
    public int rows;
    public int columns;

    public int[][] matrixContent;

    public matrix(int r, int c, int[] table)
    {
        if(table.length == r*c)
        {
            rows = r;
            columns = c;
            matrixContent = new int[r][c];
            int count = 0;
            for(int i = 0; i < r;i++)
            {
                for(int j = 0; j < c;j++)
                {
                    matrixContent[i][j] = table[count];
                    count++;
                }
            }
        }
        else
        {
            System.out.println("Dlugosc tablicy i podane dane nie zgadzaja sie!");
        }
    }

    public matrix(int r, int c)
    {
        rows = r;
        columns = c;
        matrixContent = new int[r][c];
        for(int i = 0; i < r;i++) {
            for (int j = 0; j < c; j++) {
                matrixContent[i][j] = 0;
            }
        }
    }

    public matrix(String sourceFile)
    {
        String in = RW.ReadFromFile(sourceFile);

        String temp = "";

        int[][] table;
        int rows = 0,columns = 0;

        //TODO get rows and columns from table

        table = new int[rows][columns];

    }

    public void ShowMatrixContent()
    {
        System.out.println("Macierz wynosi: ");
        for(int i = 0; i < rows;i++)
        {
            for (int j = 0; j < columns; j++)
            {
                System.out.print(matrixContent[i][j]);
                if(j < columns -1) System.out.print(",");
            }
            System.out.println("");
        }
    }

    public matrix Add(matrix A) throws InvalidMatrixDimnesion
    {

        if(this.columns != A.rows) throw new InvalidMatrixDimnesion("Niepoprawne wymiary macierzy!");
        matrix out = new matrix(this.rows,this.columns);

        if(this.columns == A.columns && this.rows == A.rows)
        {
            for(int i = 0; i < rows;i++)
            {
                for(int j = 0;j < columns;j++)
                {
                    out.matrixContent[i][j] = this.matrixContent[i][j] + A.matrixContent[i][j];
                }
            }
        }
        else
        {
            System.out.println("Operacja na macierzy niedozwolona!");
            return out;
        }
        return out;
    }

    public matrix Sub(matrix A) throws InvalidMatrixDimnesion
    {

        if(this.columns != A.rows) throw new InvalidMatrixDimnesion("Niepoprawne wymiary macierzy!");
        matrix out = new matrix(this.rows,this.columns);

        if(this.columns == A.columns && this.rows == A.rows)
        {
            for(int i = 0; i < rows;i++)
            {
                for(int j = 0;j < columns;j++)
                {
                    out.matrixContent[i][j] = this.matrixContent[i][j] - A.matrixContent[i][j];
                }
            }
        }
        else
        {
            System.out.println("Operacja na macierzy niedozwolona!");
            return out;
        }
        return out;
    }

    public matrix Mul(matrix A) throws InvalidMatrixDimnesion
    {
        matrix out = new matrix(this.rows, A.columns);

        if(this.columns != A.rows) throw new InvalidMatrixDimnesion("Niepoprawne wymiary macierzy!");

        return out;
    }


}
