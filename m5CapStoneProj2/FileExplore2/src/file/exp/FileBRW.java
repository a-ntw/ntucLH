/* main: FileExplore2.java */
package file.exp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class FileBRW extends FileExplore2 {

    public static String fileName = "";
    public static File file;
    public static Scanner myObj = new Scanner(System.in);

    public static void readWrite() {
        try {
            File f = new File("/Users/antw/ntuc/cp2/FileExplore2/TestFolder");
            // File f = new File("C:\\SGUS\\CP2\\FileExplorer\\TestFolder\\"); // Windows version
            //  Fixed path at the start of the program 
            if (f.exists()) {
                System.out.print(" Enter file name to create and then write 2 it :: ");
                fileName = myObj.nextLine();
                System.out.println(" File Name Entered is : " + fileName);
                file = new File(f.getAbsolutePath() + "/" + fileName);
                //file = new File(f.getAbsolutePath() + "\\" + fileName); // windows version
                if (file.exists()) {
                    System.out.println(" File already exists");
                    System.exit(0);
                }
                if (file.createNewFile()) {
                    FileWriter fw = new FileWriter(file);
                    BufferedWriter bw = new BufferedWriter(fw);
                    System.out.println(" Enter File Content [quit] to stop");
                    String newLine = "";
                    do {
                        bw.write(newLine + "\n");
                        newLine = (myObj.nextLine());
                    } while (!(newLine.equals("quit") || newLine.equals("QUIT") || newLine.equals("Quit")));
                    bw.flush(); // **************** must
                    bw.close(); // **************** must
                    fw.close(); // **************** must
                    System.out.print(" Do you want to display the file contents [Y/N] : ");
                    String resp = myObj.nextLine();
                    if (resp.equals("Y") || resp.equals("y")) {
                        FileReader fr = new FileReader(file);
                        BufferedReader br = new BufferedReader(fr);

                        String line = br.readLine();
                        while (line != null) {
                            System.out.println(line);
                            line = br.readLine();
                        }
                        br.close(); // **************** must
                        fr.close(); // **************** must
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/*
    BankAcc(){
        System.out.println(" 0-Arg Constructor ");
    }
 */
