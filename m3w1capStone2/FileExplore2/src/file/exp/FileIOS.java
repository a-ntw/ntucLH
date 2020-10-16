/* main: FileExplore2.java */
package file.exp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class FileIOS {

    public static String fileName = "";
    public static File file;
    public static Scanner myObj = new Scanner(System.in);

    public static void readWrite() {
        try {
            File f = new File("/Users/antw/ntuc/cp2/FileExplore2/TestFolder");
            // File f = new File("C:\\SGUS\\CP2\\FileExplorer\\TestFolder\\");      // Windows version
            // working directory - all my operation henceforth will happen here....
            //  Fixed path at the start of the program 
            if (f.exists()) {
                System.out.print(" Enter file name to create and then write 2 it :: ");
                fileName = myObj.nextLine();
                System.out.println(" File Name Entered is : " + fileName);
                file = new File(f.getAbsolutePath() + "/" + fileName);
                //file = new File(f.getAbsolutePath() + "\\" + fileName);             // Windows version
                if (file.exists()) {
                    System.out.println(" File already exists");
                    System.exit(0);
                }
                if (file.createNewFile()) {

                    FileOutputStream fos = new FileOutputStream(file);
                    //new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

                    System.out.println(" Enter File Content [quit] to stop");
                    String newLine = "";
                    do {
                        fos.write((newLine + "\n").getBytes());
                        newLine = (myObj.nextLine());
                    } while (!(newLine.equals("quit") || newLine.equals("QUIT") || newLine.equals("Quit")));
                    fos.close();
                    System.out.print(" Do you want to display the file contents [Y/N] : ");
                    String resp = myObj.nextLine();
                    if (resp.equals("Y") || resp.equals("y")) {
                        FileInputStream fis = new FileInputStream(file);

                        int ch = fis.read();
                        while (ch != -1) {
                            System.out.print((char) ch);
                            ch = fis.read();
                        }
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

antw@Mac-mini FileExplore2 % . ./sng.sh file.exp.FileIOS      
 Enter file name to create and then write 2 it :: test1501.txt
 File Name Entered is : test1501.txt
 Enter File Content [quit] to stop
123
quit
 Do you want to display the file contents [Y/N] : N
antw@Mac-mini classes % 
*/