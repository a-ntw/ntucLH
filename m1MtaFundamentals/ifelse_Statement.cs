using System;

namespace ifelse_Statement
{
    class Program
    {
        static void Main(string[] args)
        {
            if (n < 10)
            {
                Console.WriteLine(“n is less than 10”);
            }
            else if (n < 20)
            {
                Console.WriteLine(“n is less than 20”);
            }
            else if (n < 30)
            {
                Console.WriteLine(“n is less than 30”);
            }
            else
            {
                Console.WriteLine(“n is greater than or equal to 30”);
            }
        }
    }
}
