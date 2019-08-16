
import java.util.Scanner;

public class WordInsideWord {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Type the first word: ");
        String text1 = reader.nextLine();
        System.out.print("Type the second word: ");
        String text2 = reader.nextLine();

        if(text1.indexOf(text2) >= 0) {
            System.out.println("The word '" + text2 + "' is found in the word '" + text1 +"'.");
        } else {
            System.out.println("The word '" + text2 + "' is not found in the word '" + text1 +"'.");
        }
    }
}
