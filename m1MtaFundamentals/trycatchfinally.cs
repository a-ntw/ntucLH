using System;
using System.IO;

namespace trycatchfinally
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello World!");
            TryCatchFinallyTest();
        }

        private static void TryCatchFinallyTest()
        {
            StreamReader sr = null;
            try
            {
                sr = File.OpenText("/Users/antw/ntucVS/data.txt");
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
            finally
            {
                if (sr != null)
                {
                    sr.Close();
                }
            }
        }

    }
}
