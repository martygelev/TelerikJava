using System;
using System.Linq;
class LargestAreaInMatrixRECURSIVE
{
    static bool[,] visited;
    static int[,] matrix;
    static short maxCount;
    static short currentCount;
    static int rows;  
    static int cols; 

    static void Main()
    {
        int[] matrixRange = Console.ReadLine().Split(new char[] { ' ' },
                                                      StringSplitOptions.RemoveEmptyEntries)
                                   .Select(int.Parse).ToArray();

        rows = matrixRange[0];
        cols = matrixRange[1];

        //RECURSIVE>>-0?

        matrix = new int[rows, cols];

        // enter the values into the matrix
        for (int row = 0; row < rows; row++) 
        {
            int[] elements = Console.ReadLine().Split(new char[] { ' ' },
                                                     StringSplitOptions.RemoveEmptyEntries)
                                  .Select(int.Parse).ToArray();

            for (int col = 0; col < cols; col++) 
            {
                matrix[row, col] = elements[col];
            }
        }

        // the bool matrix
        visited = new bool[rows, cols];

        // largest area check
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                FindTheArea(i, j, matrix[i, j]);

                if (maxCount < currentCount)
                {
                    maxCount = currentCount;
                }

                currentCount = 0;
            }
        }

        Console.WriteLine(maxCount);
    }

     static void FindTheArea(int row, int col, int currentElement)
    {
        //out of the matrix  
        if ((row < 0) || (row >= rows)
            || (col < 0) || (col >= cols)) 
        {
            return;
        }

        //diff element
        if (currentElement != matrix[row, col])
        {
            return;
        }

        // check if visited
        if (visited[row, col])
        {
            return;
        }

        visited[row, col] = true;

        currentCount++;

        FindTheArea(row - 1, col, currentElement); // up
        FindTheArea(row + 1, col, currentElement); // down    
        FindTheArea(row, col - 1, currentElement); // left        
        FindTheArea(row, col + 1, currentElement); // right    
    }

}