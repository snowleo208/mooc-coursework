import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class WordsInReverseOrder {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        // create here an ArrayList
        ArrayList<String> list = new ArrayList<String>();

        while(true) {
            System.out.print("Type a word: ");
            String text = reader.nextLine();
            if(text.equals("")) {
                break;
            }
            list.add(text);
        }

        // get reversed list
        int n = list.size() - 1;
        System.out.println("You typed the following words: ");
        while(n >= 0) {
            System.out.println(list.get(n));
            n--;
        }
    }
}
