
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class temp {

    public static List<Employee> loadEmpFromFile() {
        List<Employee> employees = new ArrayList<>();
        //String fileName = "C:\\SGUS\\Java_SE_II\\Collectors\\src\\empDetails.txt"; // Windows version
        String fileName = "/Users/antw/ntuc/m9JavaSe2/ConcurrencyNStreams/Collectors/src/empDetails.txt"; //??
        File f = new File(fileName);
        if (f.exists()) {
            System.out.println(" File Indeed exists !!!!");
            try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
                stream.forEach(System.out::println);
                // stream.forEach( p -> employees.add ...... ????
            } catch (IOException e) {
                System.out.println(" Exception in reading from file " + e.getMessage());
            }
        }

        return employees;
    }

    public static void main(String[] args) {
        System.out.println(" Starting here ......");

        //loadEmpFromFile();
        System.out.println(loadEmpFromFile().toString()); //??

    }
}
