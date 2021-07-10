using System;

namespace foreach_Statement
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello World!");
            ForEachTest();
        }

        private static void ForEachTest()
        {
            int[] numbers = { 1, 2, 3, 4, 5 };
            foreach (int i in numbers)
            {
                Console.WriteLine("The value of i = {0}", i);
            }
        }

    }
}
