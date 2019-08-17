
import java.util.Scanner;

public class SeparatingCharacters {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Type your name: ");

        String text = reader.nextLine();
        int n = 0;
        while(n < text.length()) {
            System.out.println((n + 1) + ". character: " + text.charAt(n));
            n++;
        }
    }
}
