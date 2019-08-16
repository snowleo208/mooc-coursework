import java.util.ArrayList;
import java.util.Scanner;

public class Words {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        ArrayList<String> words = new ArrayList<String>();
        while(true) {
            System.out.print("Type a word: ");
            String text = reader.nextLine();
            if(text.isEmpty()) {
                break;
            } else {
                words.add(text);
            }
        }

        System.out.println("You typed the following words:");
        int n = 0;
        while(n < words.size()) {
            System.out.println(words.get(n));
            n++;
        }
    }
}
