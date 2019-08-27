import java.io.*;
import wordinspection.WordInspection;

public class Main {

    public static void main(String[] args) throws Exception, FileNotFoundException {
        // test your code here

        File file = new File("shortList.txt");
        // all words are in file src/wordList.txt

        WordInspection db = new WordInspection(file);

        System.out.println(db.wordCount());
        System.out.println(db.wordsContainingZ());
        System.out.println(db.wordsEndingInL());
        System.out.println(db.palindromes());
        System.out.println(db.wordsWhichContainAllVowels());
    }
}
