/* main: FileExplore2.java */
package file.exp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class FileBufferIOS {

    public static String fileName = "";
    public static File file;
    public static Scanner myObj = new Scanner(System.in);

    public static void readWrite() {
        try {
            File f = new File("/Users/antw/ntuc/cp2/FileExplore2/TestFolder");
            // File f = new File("C:\\SGUS\\CP2\\FileExplorer\\TestFolder\\"); // Windows varion
            // working directory - all my operation henceforth will happen here....
            //  Fixed path at the start of the program 
            if (f.exists()) {
                System.out.print(" Enter file name to create and then write 2 it :: ");
                fileName = myObj.nextLine();
                System.out.println(" File Name Entered is : " + fileName);
                file = new File(f.getAbsolutePath() + "\\" + fileName);
                // file = new File(f.getAbsolutePath() + "\\" + fileName); // Windows version
                if (file.exists()) {
                    System.out.println(" File already exists");
                    System.exit(0);
                }
                if (file.createNewFile()) {

                    FileOutputStream fos = new FileOutputStream(file);
                    BufferedOutputStream bos = new BufferedOutputStream(fos);
                    System.out.println(" Enter File Content [quit] to stop");
                    String newLine = "";
                    do {
                        newLine = (myObj.nextLine());
                        bos.write((newLine + "\n").getBytes());
                    } while (!(newLine.equals("quit") || newLine.equals("QUIT") || newLine.equals("Quit")));
                    bos.flush();
                    bos.close();
                    System.out.print(" Do you want to display the file contents [Y/N] : ");
                    String resp = myObj.nextLine();
                    if (resp.equals("Y") || resp.equals("y")) {
                        FileInputStream fis = new FileInputStream(file);
                        BufferedInputStream bis = new BufferedInputStream(fis);

                        int ch = 0;
                        while ((ch = bis.read()) != -1) {
                            System.out.print((char) ch);
                        }
                        bis.close();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        readWrite();
    }
}
/*
antw@Mac-mini FileExplore2 % pwd
/Users/antw/ntuc/cp2/FileExplore2
antw@Mac-mini FileExplore2 % cat sng.sh
javac -d build/classes src/file/exp/*.java 
sleep 4
cd build/classes
java $1 $2
sleep 4

antw@Mac-mini FileExplore2 % . ./sng.sh file.exp.FileBufferIOS
 Enter file name to create and then write 2 it :: test1425.txt
 File Name Entered is : test1425.txt
 Enter File Content [quit] to stop
testing
quit
 Do you want to display the file contents [Y/N] : Y
testing
quit
antw@Mac-mini classes % 
*/