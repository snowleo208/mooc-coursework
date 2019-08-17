
import java.util.Scanner;

public class TheSumOfSetOfNumbers {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Until what? ");
        int number = Integer.parseInt(reader.nextLine());
        int i = 0;
        int result = 0;
        
        while (i <= number) {
            result += i;
            i++;
        }
        
        System.out.println("Sum is: " + result);

    }
}
