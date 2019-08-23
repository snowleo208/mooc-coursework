import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class TextUI {
    private Scanner reader;
    private int round;
    private ArrayList<Participant> list;

    public TextUI (Scanner reader) {
        this.reader = reader;
        this.round = 1;
        this.list = new ArrayList<Participant>();
    }

    public void start() {
        System.out.println("Kumpula ski jumping week");
        System.out.println("");
        System.out.println("Write the names of the participants one at a time; an empty string brings you to the jumping phase.");

        // get new participants
        while(true) {
            System.out.print("  Participant name: ");
            String name = reader.nextLine();
            if(name.isEmpty()) {
                break;
            }

            Participant newcomer = new Participant(name);
            this.list.add(newcomer);
        }

        // start tournament
        this.startTournament();

        // end of tournament
        System.out.println("Thanks!");
        System.out.println("");
        System.out.println("Tournament results: ");
        System.out.println("Position    Name");
    }

    public void startTournament() {
        System.out.println("The tournament begins!");

        while(true) {
            System.out.print("Write \"jump\" to jump; otherwise you quit: ");
            String command = reader.nextLine();

            if(command.equals("jump")) {
                System.out.print("Round ");
                System.out.print(this.getRound());
                System.out.println("");

                System.out.println("Jumping order:");
                for (int i = 0; i < this.list.size(); i++) {
                    System.out.println((i + 1) + ": " + this.list.get(i));
                }

                System.out.print("Results of round ");
                System.out.print(this.getRound());
                System.out.println("");

                this.round += 1;

                // start round
                for (Participant p : this.list) {
                    p.jump();

                    System.out.println("  " + p.getName());
                    System.out.println("    length: " + p.getLength());

                    StringBuilder sb = new StringBuilder();
                    for (Integer number : p.getCurrentRoundScores()) {
                        sb.append(number != null ? number.toString() + ", " : "");
                    }
                    System.out.println("    judge votes: [" + sb.toString() +"]");
                }

            } else if(command.equals("quit")) {
                break;
            }
        }
    }

    public int getRound() {
        return round;
    }
}