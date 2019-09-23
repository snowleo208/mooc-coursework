package dictionary;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException,IOException {
        // Test your dictionary here
        MindfulDictionary dict = new MindfulDictionary("src/words.txt");
        dict.load();

        System.out.println( dict.translate("apina") );
        System.out.println( dict.translate("ohjelmointi") );
        System.out.println( dict.translate("alla oleva") );
        
        dict.save();
    }
}
