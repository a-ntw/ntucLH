using System;

namespace RecursiveFactorial
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("5 Factorial is {0}", Factorial(5));
        }

        public static int Factorial(int n)
        {
            if (n == 0)
            {
                return 1; //base case
            }
            else
            {

                return n * Factorial(n - 1); //recursive case
            }
        }

    }
}
