import java.util.Scanner;
import java.io.*;

public class Printer {
    private File filename;

    public Printer (String filename) throws Exception {
        this.filename = new File(filename);
    }

    public void printLinesWhichContain(String word) throws Exception {
        Scanner reader = new Scanner(this.filename, "UTF-8");

        while (reader.hasNext()) {
            String nextWord = reader.nextLine();

            // if word is empty, print all contents
            if(word.isEmpty()) {
                System.out.println(nextWord);
                continue;
            }

            // if word is not empty, print all contents that contains that word
            if (!word.isEmpty() && nextWord.indexOf(word) >= 0) {
                System.out.println(nextWord);
            }
        }
    }
}