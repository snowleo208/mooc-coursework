import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Type a number: ");
        int i = Integer.parseInt(reader.nextLine());
        int n = 1;
        int result = 1;
        
        while(n <= i) {
            result *= n;
            n++;
        }
        
        System.out.println("Factorial is " + result);
    }
}
