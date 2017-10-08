package MatrixPackage;

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

    public matrix Add(matrix A)
    {
        matrix out = new matrix(this.rows,this.columns, new int[]{1,1,1,1});
        if(this.columns == A.columns && this.rows == A.rows)
        {
            for(int i = 0; i < rows;i++)
            {
                for(int j = 0;j < columns;j++)
                {
                    out.matrixContent[i][j] = this.matrixContent[i][j] + A.matrixContent[i][j];
                }
            }
            return out;
        }
        else
        {
            System.out.println("Operacja na macierzy niedozwolona!");
            return out;
        }
    }

    public matrix Sub(matrix A)
    {
        matrix out = new matrix(this.rows,this.columns, new int[]{1,1,1,1});
        if(this.columns == A.columns && this.rows == A.rows)
        {
            for(int i = 0; i < rows;i++)
            {
                for(int j = 0;j < columns;j++)
                {
                    out.matrixContent[i][j] = this.matrixContent[i][j] - A.matrixContent[i][j];
                }
            }
            return out;
        }
        else
        {
            System.out.println("Operacja na macierzy niedozwolona!");
            return out;
        }
    }
}
