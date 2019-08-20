import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        // implement your program here
        // do not put all to one method/class but rather design a proper structure to your program
        Database db = new Database();
        
        // Your program should use only one Scanner object, i.e., it is allowed to call 
        // new Scanner only once. If you need scanner in multiple places, you can pass it as parameter
        System.out.println("Type exam scores, -1 completes:");
        while(true) {
            int point = Integer.parseInt(reader.nextLine());
            if(point == -1) {
                break;
            }

            Grade score = new Grade(point);
            db.add(score);
        }

        ArrayList<Grade> arr = db.getList();
        System.out.println("Grade distribution: ");
        db.getDistribution();

        System.out.println("Acceptance percentage: " + String.format( "%.2f", db.getAcceptances() ) );
    }
}
