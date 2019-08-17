import java.util.Scanner;

public class LoopsEndingRemembering {
    public static void main(String[] args) {
        // program in this project exercises 36.1-36.5
        // actually this is just one program that is split in many parts
        
        Scanner reader = new Scanner(System.in);
        float result = 0;
        int times = 0;
        int odd = 0;
        int even = 0;
        System.out.println("Type numbers: ");
        while(true) {
            int i = Integer.parseInt(reader.nextLine());
            
            if(i == -1) {
                break;
            } else {
                result += i;
                times++;
            }
            
            if(i % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        
        System.out.println("Thank you and see you later!");
        System.out.println("The sum is: " + (int)result);
        System.out.println("How many numbers: "+ times);
        System.out.println("Average: " + (result / times));
        System.out.println("Even numbers: " + even);
        System.out.println("Odd numbers: " + odd);
    }
}
