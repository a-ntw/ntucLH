using System;
using System.IO;

namespace HandlingExceptions
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello World!");
            ExceptionTest();
        }

        private static void ExceptionTest()
        {
            StreamReader sr = null;
            try
            {
                sr = File.OpenText(@"/Users/antw/ntucVS/mtaFun01/data.txt");
                Console.WriteLine(sr.ReadToEnd());
            }
            catch (FileNotFoundException fnfe)
            {
                Console.WriteLine(fnfe.Message);
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
        }

    }
}
