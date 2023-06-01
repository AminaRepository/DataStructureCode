import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileUtils {

    public static ArrayList<String> readFile(String filePath) throws IOException {
        ArrayList<String> stringArray = new ArrayList<String>(); // array holding strings
        BufferedReader bf = new BufferedReader(new FileReader(filePath)); // load data from file
        String line = bf.readLine(); // read line as string
        // checking for end of file
        while (line != null) {
            stringArray.add(line);
            line = bf.readLine();
        }
        // closing buffer reader object
        bf.close();
        return stringArray;
    }
}