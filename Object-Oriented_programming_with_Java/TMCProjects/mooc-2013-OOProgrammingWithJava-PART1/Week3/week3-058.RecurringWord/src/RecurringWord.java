
import java.util.ArrayList;
import java.util.Scanner;

public class RecurringWord {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        // create here the ArrayList
        ArrayList<String> list = new ArrayList<String>();
        String result = "";
        while(true) {
            System.out.print("Type a word: ");
            String text = reader.nextLine();
            if(list.contains(text)) {
                result = text;
                 break;
            }
            list.add(text);
        }

        System.out.println("You gave the word " + result + " twice");
    }
}
