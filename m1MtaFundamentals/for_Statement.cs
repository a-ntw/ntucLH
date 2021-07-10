using System;

namespace for_Statement
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello World!");
            ForTest();
        }

        private static void ForTest()
        {
            for (int i = 1; i <= 5; i++)
            {
                Console.WriteLine("The value of i = {0}", i);
            }
        }
    }
}
