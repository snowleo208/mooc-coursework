
import java.util.Scanner;


public class UpToCertainNumber {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Up to what number? ");
        int start = 1;
        int number = Integer.parseInt(reader.nextLine());
        
        // Write your code here
        while (start <= number) {
            System.out.println(start);
            start++;
        }
        
    }
}
