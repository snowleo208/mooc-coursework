
import phone.domain.Person;
import phone.logic.PhoneSearch;

import phone.domain.TextInterface;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Start your program here
        // ATTENTION: In your program, you can create only one instance of class Scanner!
        Scanner reader = new Scanner(System.in);

        TextInterface ui = new TextInterface(reader);
        ui.start();
    }
}
