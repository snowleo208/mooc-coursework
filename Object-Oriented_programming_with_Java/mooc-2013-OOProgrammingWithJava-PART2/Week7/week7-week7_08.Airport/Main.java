import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Write your main program here. Implementing your own classes will be useful.
        Scanner reader = new Scanner(System.in);
        TextInterface textUI = new TextInterface(reader);

        textUI.start();
    }
}
