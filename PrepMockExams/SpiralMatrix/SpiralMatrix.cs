using System;

static class SpiralMatrix
{
    static int colStart = 0;
    static int rowStart = 0;
    static int colEnd = 0;
    static int rowEnd = 0;
    static int[,] myMatrix = new int[0, 0];
    static int counter = 1;

    static void Main(string[] args)
    {
        Console.WriteLine("Enter the matrix size");
        int n = int.Parse(Console.ReadLine());

        colStart = 0;
        rowStart = 0;
        colEnd = n - 1;
        rowEnd = n - 1;

        myMatrix = new int[n, n];
        counter = 1;

        while (counter <= n * n)
        {
            MoveRight();        //Invoke the methods right, down, left, up. Every time in the method the counter is incresed with 1
            MoveDown();         //until it reaches n*n    
            MoveLeft();
            MoveUp();
        }

        PrintMatrix(myMatrix);
    }

    //Print the matrix
    static void PrintMatrix(int[,] matrix)
    {
        for (int row = 0; row < matrix.GetLength(0); row++)
        {
            for (int col = 0; col < matrix.GetLength(1); col++)
            {
                Console.Write("{0,3}", matrix[row, col]);
            }
            Console.WriteLine();
        }
    }
    //Move right
    static void MoveRight()
    {
        for (int col = colStart; col <= colEnd; col++)
        {
            myMatrix[rowStart, col] = counter;
            counter++;
        }
        rowStart++;
    }
    //Move down
    static void MoveDown()
    {
        for (int row = rowStart; row <= rowEnd; row++)
        {
            myMatrix[row, colEnd] = counter;
            counter++;
        }
        colEnd--;
    }
    //Move left
    static void MoveLeft()
    {
        for (int row = colEnd; row >= colStart; row--)
        {
            myMatrix[rowEnd, row] = counter;
            counter++;
        }
        rowEnd--;
    }
    //Move up
    static void MoveUp()
    {
        for (int col = rowEnd; col >= rowStart; col--)
        {
            myMatrix[col, colStart] = counter;
            counter++;
        }
        colStart++;
    }
}