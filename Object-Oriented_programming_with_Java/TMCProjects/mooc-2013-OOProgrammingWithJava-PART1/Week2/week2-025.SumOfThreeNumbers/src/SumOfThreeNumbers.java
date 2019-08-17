
import java.util.Scanner;

public class SumOfThreeNumbers {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int sum = 0;
        int read; // store numbers read form user in this variable


        // Write your program here
        // Use only variables sum and read
        
        System.out.print("Type the first number: ");
        int a = Integer.parseInt(reader.nextLine());
        
        System.out.print("Type the second number: ");
        int b = Integer.parseInt(reader.nextLine());
        
        System.out.print("Type the third number: ");
        int c = Integer.parseInt(reader.nextLine());
        
        sum = a + b + c;

        System.out.println("Sum: " + sum);
    }
}
