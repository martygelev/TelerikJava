using System;
using System.Collections.Generic;
using System.Linq;
namespace Crossword
{
    class Program
    {
        static int rows;
        static int cols;
        static char[,] matrix;
        static void Main(string[] args)
        {
            int[] inputArr = Console.ReadLine().Split(new char[] { ' ' },
                                                      StringSplitOptions.RemoveEmptyEntries)
                                   .Select(int.Parse).ToArray();

            rows = inputArr[0];
            cols = inputArr[1];

            matrix = new char[rows, cols];

            // enter values 
            for (int row = 0; row < rows; row++)
            {
                char[] elements = Console.ReadLine().ToCharArray();


                for (int col = 0; col < cols; col++)
                {
                    matrix[row, col] = elements[col];
                }
            }

            // split cols

            char[] columns;

            string changeCol = "";
            List<string> columnsWords = new List<string>();

            for (int i = 0; i <cols ; i++)
            {
                columns =GetColumn(matrix,i);

                changeCol = "" + String.Join("",columns);
                columnsWords.Add(changeCol);
            }

            // split Rows
            char[] rowsArr;

            string changeRow = "";
            List<string> rowsWords = new List<string>();

            for (int i = 0; i < rows; i++)
            {
                rowsArr = GetRow(matrix, i);

                changeRow = "" + String.Join("",rowsArr);
                rowsWords.Add(changeRow);

            }

            // foreach(string word in columnsWords)
            //  {
            //     Console.WriteLine(word);
            //  }

            List<string> rowSplitedWords = SplitAndCheckRows(rowsWords);

            List<string> colsSplitedWords = SplitAndCheckCols(columnsWords);

            colsSplitedWords = colsSplitedWords.Concat(rowSplitedWords).ToList();

            string min = colsSplitedWords[0];
            foreach (var item  in colsSplitedWords)
            {
                min = FindSmallestWord(min, item);
            }

            Console.Write(min.TrimEnd());
        }

        public static string FindSmallestWord(string min,string word)
        {
            if (String.Compare(min, word) < 0)
            {
                // str1 is less than str2
                return min;
            }
            else
            {
                // str11 is greater than str2, and String.Compare returned a value greater than 0
                return word;
            }
        }
        public static List<string> SplitAndCheckCols(List<string> col)
        {
            string w = "";
            List<string> res = new List<string>();
            for (int i = 0; i < col.Count; i++)
            {
                List<string> temp = col[i].Split(new char[] { '#' }).ToList();

                for (int z = 0; z < temp.Count; z++)
                {
                     w = ""+ temp[z];
                    if (w.Length>=2)
                    {
                        res.Add(w);
                    }
                }
            }
            return res;
        }

        public static List<string> SplitAndCheckRows( List<string> row)
        {
            string w = "";
            List<string> res = new List<string>();

            for (int i = 0; i < row.Count; i++)
            {
                List<string> temp = row[i].Split(new char[] { '#' }).ToList();

                for (int z = 0; z < temp.Count; z++)
                {
                    w = "" + temp[z];
                    if (w.Length >= 2)
                    {
                        res.Add(w);
                    }
                }
            }
            return res;
        }

        public static char[] GetColumn(char[,] matrix, int columnNumber)
        {
            return Enumerable.Range(0, matrix.GetLength(0))
                    .Select(x => matrix[x, columnNumber])
                    .ToArray();
        }

        public  static char[] GetRow(char[,] matrix, int rowNumber)
        {
            return Enumerable.Range(0, matrix.GetLength(1))
                    .Select(x => matrix[rowNumber, x])
                    .ToArray();
        }


    }
}
