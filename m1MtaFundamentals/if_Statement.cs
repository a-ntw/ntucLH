using System;

namespace if_Statement
{
    class Program
    {
        static void Main(string[] args)
        {
            int number1 = 10;
            int number2 = 20;
            if (number2 > number1)
                Console.WriteLine("number2 is greater than number1");

            TestIfElse(12);
        }

        public static void TestIfElse(int n)
        {
            if (n < 10)
            {
                Console.WriteLine("n is less than 10");
            }
            else if (n < 20)
            {
                Console.WriteLine("n is less than 20");
            }
            else if (n < 30)
            {
                Console.WriteLine("n is less than 30");
            }
            else
            {
                Console.WriteLine("n is greater than or equal to 30");
            }
        }
    }
}
