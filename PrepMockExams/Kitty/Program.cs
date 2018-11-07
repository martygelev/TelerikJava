using System;
using System.Linq;
namespace Kitty
{
    class Program
    {
        static void Main(string[] args)
        {
            var path = Console.ReadLine().ToCharArray();
            var moves = ("0 " + Console.ReadLine())
                .Split(new[] { " " }, StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse)
                .ToArray();
            int foodCount = 0;
            int soulsCount = 0;
            int deadLock = 0;
            int kittyPos = 0;
            for (int i = 0; i < moves.Length; i++)
            {
                int move = moves[i];

                if (move > 0) //right
                {
                    kittyPos += move;
                    while (kittyPos > path.Length - 1)
                    {
                        kittyPos -= path.Length;
                    }
                }

                if (move < 0) //left
                {
                    kittyPos += move;
                    while (kittyPos < 0)
                    {
                        kittyPos += path.Length;
                    }
                }
                switch (path[kittyPos])
                {
                    case '@':
                        soulsCount++;
                        path[kittyPos] = '0';
                        break;
                    case '*':
                        foodCount++;
                        path[kittyPos] = '0';
                        break;
                    case 'x':
                        if (kittyPos % 2 == 0)
                        {
                            if (soulsCount > 0)
                            {
                                soulsCount--;
                                deadLock++;
                                path[kittyPos] = '@';
                            }
                            else
                            {
                                Console.WriteLine("You are deadlocked, you greedy kitty!");
                                Console.WriteLine("Jumps before deadlock: {0}", i);
                                return;
                            }
                        }
                        else
                        {
                            if (foodCount > 0)
                            {
                                foodCount--;
                                deadLock++;
                                path[kittyPos] = '*';
                            }
                            else
                            {
                                Console.WriteLine("You are deadlocked, you greedy kitty!");
                                Console.WriteLine("Jumps before deadlock: {0}", i);
                                return;
                            }
                        }

                        break;
                    default: break;
                }
            }

            Console.WriteLine("Coder souls collected: {0}", soulsCount);
            Console.WriteLine("Food collected: {0}", foodCount);
            Console.WriteLine("Deadlocks: {0}", deadLock);
        }
    }
}
