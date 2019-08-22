import java.util.Scanner;

public class TextUserInterface{
    private Scanner reader;
    private Dictionary dict;

    public TextUserInterface(Scanner reader, Dictionary dictionary) {
        this.reader = reader;
        this.dict = dictionary;
    }

    public void start() {
        System.out.println("Statements:");
        System.out.println("add - adds a word pair to the dictionary");
        System.out.println("translate - asks a word and prints its translation");
        System.out.println("quit - quit the text user interface");
        System.out.println("");

        while(true) {
            System.out.println("Statement: ");
            String command = this.reader.nextLine().trim();

            if(command.equalsIgnoreCase("add")) {
                System.out.print("In Finnish: ");
                String word = this.reader.nextLine();
                System.out.print("Translation: ");
                String translated = this.reader.nextLine();
                this.dict.add(word, translated);
                System.out.println("");

            } else if(command.equalsIgnoreCase("translate")) {
                System.out.print("Give a word: ");
                String word = this.reader.nextLine();
                System.out.println("Translation: " + this.dict.translate(word));
                System.out.println("");

            } else if(command.equalsIgnoreCase("quit")) {
                System.out.println("Cheers!");
                break;

            } else {
                System.out.println("Unknown statement");
            }
        }
    }


}