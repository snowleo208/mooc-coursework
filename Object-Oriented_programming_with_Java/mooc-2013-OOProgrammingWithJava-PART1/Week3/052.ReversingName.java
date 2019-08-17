import java.util.Scanner;

public class ReversingName {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Type your name: ");
        String text = reader.nextLine();
        int n = text.length() - 1;
        String result = "";

        while(n >= 0) {
            result += text.charAt(n);
            n--;
        }
        System.out.println("In reverse order: " + result);
    }
}
