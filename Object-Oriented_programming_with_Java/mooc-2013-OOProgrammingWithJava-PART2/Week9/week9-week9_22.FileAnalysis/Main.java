import file.Analysis;
import java.io.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, Exception  {
        // test your code here

        File file = new File("testfile.txt");
        Analysis analysis = new Analysis(file);
        System.out.println("Lines: " + analysis.lines());
        System.out.println("Characters: " + analysis.characters());
    }
}
