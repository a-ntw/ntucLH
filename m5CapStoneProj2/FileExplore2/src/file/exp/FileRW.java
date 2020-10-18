/* main: FileExplore2.java */
package file.exp;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class FileRW{

    public static String fileName = "";

    public static Scanner myObj = new Scanner(System.in);

    //public static void main(String[] args) {
    public static void ReadWrite() {
        try {
            File f = new File("/Users/antw/ntuc/cp2/FileExplore2/TestFolder");
            //File f = new File("C:\\SGUS\\CP2\\FileExplorer\\TestFolder\\"); // Windows version
            // working directory - all my operation henceforth will happen here....
            //  Fixed path at the start of the program 
            if (f.exists()) {
                System.out.print(" Enter file name to create and then write 2 it :: ");
                fileName = myObj.nextLine();
                System.out.println(" File Name Entered is : " + fileName);
                File newF = new File(f.getAbsolutePath() + "/" + fileName);
                //File newF = new File(f.getAbsolutePath() + "\\" + fileName); //Window version
                if (newF.exists()) {
                    System.out.println(" File already exists");
                    System.exit(0);
                }
                if (newF.createNewFile()) {
                    System.out.println(" File Created with the following details ");
                    System.out.println(newF.getName());
                    //System.out.println(newF.getParent());
                    //System.out.println("Is this a file " + newF.isFile());
                    //System.out.println(newF.getAbsolutePath());
                    //ystem.out.println(newF.getAbsoluteFile());
                    //System.out.println(newF.canWrite());
                    //System.out.println(newF.getFreeSpace());
                    //System.out.println(newF.canRead());
                    //System.out.println(newF.canExecute());
                    //System.out.println(newF.delete());

                    FileWriter fw = new FileWriter(newF);
                    //new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

                    System.out.println(" Enter File Content [quit] to stop");
                    String newLine = "";
                    do {

                        fw.write(newLine + "\n");
                        newLine = myObj.nextLine();

                    } while (!newLine.equals("quit"));
                    fw.close();
                    System.out.println(" Do you want to display the file contents [Y/N] ");
                    String resp = myObj.nextLine();
                    if (resp.equals("Y") || resp.equals("y")) {
                        FileReader fr = new FileReader(newF);

                        int i = 0;
                        while ((i = fr.read()) != -1) {
                            System.out.print((char) i);
                        }
                        fr.close();
                    }
                }

            }

        } catch (Exception e) {
            // handle - understand the exception
            // do corrective measures 
            // but no then 
            // at least log it 

        }
    }

    public static void main(String[] args) {
        ReadWrite();
    }
}
/*
// package file.exp;
antw@Mac-mini exp % pwd              
/Users/antw/ntuc/cp2/FileExplore2/src/file/exp
antw@Mac-mini exp % javac FileRW.java
antw@Mac-mini exp % java FileRW      
 Enter file name to create and then write 2 it :: testing16Oct1050.txt
 File Name Entered is : testing16Oct1050.txt
 File Created with the following details 
testing16Oct1050.txt
 Enter File Content [quit] to stop
testing
quit
 Do you want to display the file contents [Y/N] 
Y

testing
antw@Mac-mini exp % 
 */
