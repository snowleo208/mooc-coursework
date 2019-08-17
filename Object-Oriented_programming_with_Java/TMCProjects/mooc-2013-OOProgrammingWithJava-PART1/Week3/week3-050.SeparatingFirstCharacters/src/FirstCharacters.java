import java.util.Scanner;

public class FirstCharacters {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Type your name: ");
        String text = reader.nextLine();
        if(text.length() >= 3) {
            int n = 0;
            while(n < 3) {
                System.out.println((n + 1) + ". character: " + text.charAt(n));
                n++;
            }
        }
    }
}
