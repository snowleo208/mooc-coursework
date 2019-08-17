
import java.util.Scanner;

public class Password {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String password = "carrot"; // Use carrot as password when running tests.

        // Write your code here
        while(true) {
            System.out.print("Type the password: ");
            String text = reader.nextLine();
            if(!text.equals(password)) {
                System.out.print("Wrong!\n");
            } else {
                System.out.print("Right! \n\n");
                System.out.print("The secret is: jryy qbar!");
                break;
            }
        }
    }
}
