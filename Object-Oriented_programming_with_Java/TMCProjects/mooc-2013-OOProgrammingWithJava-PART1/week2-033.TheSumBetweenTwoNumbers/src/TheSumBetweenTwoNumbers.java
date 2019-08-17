
import java.util.Scanner;


public class TheSumBetweenTwoNumbers {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("First: ");
        int first = Integer.parseInt(reader.nextLine());
        System.out.println("Last: ");
        int end = Integer.parseInt(reader.nextLine());
        
        int result = 0;
        
        while (first <= end) {
            result += first;
            first++;
        }
        
        System.out.println("Sum is: " + result);
        
    }
}
