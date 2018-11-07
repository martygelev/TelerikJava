using System;
using System.Collections.Generic;
using System.Linq;

class TowerOfHanoi
{
    private static int steps = 0;
    private static Stack<int> source;
    private static readonly Stack<int> destination = new Stack<int>();
    private static readonly Stack<int> spare = new Stack<int>();

    public static void Main()
    {
       // Console.Write("Please enter desired number of disks: ");
        int numberOfDisks = int.Parse(Console.ReadLine());

        //int numberOfDisks = 4;
        //var range = Enumerable.Range(1, n);

        source = new Stack<int>(Enumerable.Range(1, numberOfDisks).Reverse());
        //Stack<int> destination = new Stack<int>();
        //Stack<int> spare = new Stack<int>();
        PrintRods();
        MoveDisks(numberOfDisks, source, destination, spare);
    }

    private static void MoveDisks(int bottomDisk, Stack<int> sourceRod, Stack<int> destinationRod, Stack<int> spareRod)
    {
        if (bottomDisk < 1)
        {
            return;
        }
        else if (bottomDisk == 1)
        {
            steps++;
            destinationRod.Push(sourceRod.Pop());
            Console.WriteLine($"Step #{steps}: Moved disk {bottomDisk}");
            PrintRods();
            return;
        }
        else
        {
            MoveDisks(bottomDisk - 1, sourceRod, spareRod, destinationRod);
            steps++;
            destinationRod.Push(sourceRod.Pop());
            Console.WriteLine($"Step #{steps}: Moved disk {bottomDisk}");
            PrintRods();
            MoveDisks(bottomDisk - 1, spareRod, destinationRod, sourceRod);
        }
    }

    private static void PrintRods()
    {
        Console.WriteLine("Source: {0}", string.Join(", ", source.Reverse()));
        Console.WriteLine("Destination: {0}", string.Join(", ", destination.Reverse()));
        Console.WriteLine("Spare: {0}", string.Join(", ", spare.Reverse()));
        Console.WriteLine();
    }
}