import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class TextInterface {
    private Scanner reader;
    private ArrayList<Flight> flightList;
    private HashMap<String,Airplane> planeList;

    public TextInterface(Scanner reader) {
        this.reader = reader;
        this.flightList = new ArrayList<Flight>();
        this.planeList = new HashMap<String,Airplane>();
    }

    public void start() {
        this.airportPanel();
        this.flightPanel();
    }

    public void airportInstructions() {
        System.out.println("Choose operation: ");
        System.out.println("[1] Add airplane");
        System.out.println("[2] Add flight");
        System.out.println("[x] Exit");
    }

    public void flightInstructions() {
        System.out.println("Choose operation: ");
        System.out.println("[1] Print planes");
        System.out.println("[2] Print flights");
        System.out.println("[3] Print plane info");
        System.out.println("[x] Quit");
    }

    public void airportPanel() {
        System.out.println("Airport panel");
        System.out.println("--------------------");
        System.out.println("");

        while(true) {
            this.airportInstructions();
            System.out.print("> ");
            String command = this.reader.nextLine();

            if(command.equals("x")) {
                break;
            }

            if(command.equals("1")) {
                System.out.print("Give plane ID: ");
                String name = this.reader.nextLine();
                System.out.print("Give plane capacity: ");
                int capacity = Integer.parseInt(this.reader.nextLine());
                Airplane airplane = new Airplane(name, capacity);
                this.planeList.put(name, airplane);
            }

            if(command.equals("2")) {
                System.out.print("Give plane ID: ");
                String name = this.reader.nextLine();
                System.out.print("Give departure airport code: ");
                String dep = this.reader.nextLine();
                System.out.print("Give destination airport code: ");
                String des = this.reader.nextLine();
                Flight newFlight = new Flight(this.planeList.get(name), dep, des);
                this.flightList.add(newFlight);
            }
        }
    }

    public void flightPanel() {
        System.out.println("Flight service");
        System.out.println("------------");
        System.out.println("");

        while(true) {
            this.flightInstructions();
            System.out.print("> ");
            String command = this.reader.nextLine();

            if(command.equals("x")) {
                break;
            }

            if(command.equals("1")) {
                for(String p : this.planeList.keySet()) {
                    System.out.println(this.planeList.get(p));
                }
            }

            if(command.equals("2")) {
                for(Flight f : this.flightList) {
                    System.out.println(f);
                }
                System.out.println("");
            }

            if(command.equals("3")) {
                System.out.print("Give plane ID: ");
                String name = this.reader.nextLine();
                System.out.println(this.planeList.get(name));
                System.out.println("");
            }

        }
    }


}