import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

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

        System.out.println("");

        // start tournament
        this.startTournament();

        // end of tournament
        System.out.println("Thanks!");
        System.out.println("");
        System.out.println("Tournament results: ");
        System.out.println("Position    Name");

        Collections.sort(this.list);
        Collections.reverse(this.list);

        // print sorted results
        for (int i = 0; i < this.list.size(); i++) {
            Participant p = this.list.get(i);

            System.out.println(Integer.toString((i+1)) + "           " + p);
            System.out.print("            jump lengths: ");

            int j = 0;
            while(j < p.getLengthList().size()) {
                System.out.print(p.getLengthList().get(j));
                System.out.print(" m");
                if(j < p.getLengthList().size() -1) {
                    System.out.print(", ");
                }
                j++;
            }

            System.out.println("");
        }

    }

    public void startTournament() {
        System.out.println("The tournament begins!");
        System.out.println("");

        while(true) {
            System.out.println("Write \"jump\" to jump; otherwise you quit: ");
            String command = reader.nextLine();
//            System.out.println("");

            if(command.equals("jump")) {
                System.out.print("Round ");
                System.out.print(this.getRound());
                System.out.println("");
                System.out.println("");

                System.out.println("Jumping order:");

                Collections.sort(this.list);
                for (int i = 0; i < this.list.size(); i++) {
                    System.out.print("  ");
                    System.out.print((i + 1) + ". " + this.list.get(i));
                    System.out.println("");
                }
                System.out.println("");

                System.out.print("Results of round ");
                System.out.print(this.getRound());
                System.out.println("");

                this.round += 1;

                // start round
                for (Participant p : this.list) {
                    p.jump();

                    System.out.println("  " + p.getName());
                    System.out.println("    length: " + p.getLength());

                    System.out.println("    judge votes: " + Arrays.toString(p.getCurrentRoundScores()));
                }
                System.out.println("");

            } else if(command.equals("quit")) {
                break;
            }
        }
    }

    public int getRound() {
        return round;
    }
}