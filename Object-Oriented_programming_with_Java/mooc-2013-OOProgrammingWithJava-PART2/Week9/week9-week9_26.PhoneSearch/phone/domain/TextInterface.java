package phone.domain;
import phone.domain.Person;
import phone.logic.PhoneSearch;

import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class TextInterface {
    private Scanner reader;
    private PhoneSearch db;

    public TextInterface (Scanner reader) {
        this.reader = reader;
        this.db = new PhoneSearch();
    }

    public void instructions() {
        System.out.println("phone search");
        System.out.println("available operations:");
        System.out.println(" 1 add a number");
        System.out.println(" 2 search for a number");
        System.out.println(" 3 search for a person by phone number");
        System.out.println(" 4 add an address");
        System.out.println(" 5 search for personal information");
        System.out.println(" 6 delete personal information");
        System.out.println(" 7 filtered listing");
        System.out.println(" x quit");
    }

    public void startSearch() {

        while(true) {
            System.out.print("command: ");
            String command = this.reader.nextLine();
            if(command.equals("x")) {
                break;
            }

            if(command.equals("1")) {
                // add name and phone number from user input
                System.out.print("whose number: ");
                String name = this.reader.nextLine();
                System.out.println("number: ");
                String number = this.reader.nextLine();

                // create a new set for phone numbers
                Set<String> phoneBook = new HashSet<String>();
                phoneBook.add(number);
                Set<String> address = new HashSet<String>();

                Person newPerson = new Person(name, address, phoneBook);

                // add person to db
                this.db.add(newPerson);
            }

            if(command.equals("2")) {
                // find phone numbers by name
                System.out.print("whose number: ");
                String name = this.reader.nextLine();

                if(this.db.searchByName(name)) {
                    // print all numbers if exist
                    for(String n : this.db.getPerson(name).getPhoneNumber()) {
                        System.out.println(" " + n);
                    }
                    System.out.println("");

                } else {
                    System.out.println("  not found");
                    System.out.println("");
                }
            }

            if(command.equals("3")) {
                // search for a person by phone number
                System.out.print("number: ");
                String number = this.reader.nextLine();

                if(this.db.searchByNumber(number).equals("")) {
                    System.out.println(" not found");
                    System.out.println("");
                } else {
                    System.out.println(" " + this.db.searchByNumber(number));
                    System.out.println("");
                }
            }

            if(command.equals("4")) {
                // add address
                System.out.print("whose address: ");
                String name = this.reader.nextLine();

                System.out.print("street: ");
                String street = this.reader.nextLine();

                System.out.print("city: ");
                String city = this.reader.nextLine();

                // create a new set for address
                Set<String> phoneBook = new HashSet<String>();
                Set<String> address = new HashSet<String>();
                address.add(street + " " + city);

                Person newPerson = new Person(name, address, phoneBook);
                this.db.add(newPerson);
                System.out.println("");

            }

            if(command.equals("5")) {
                // get information
                System.out.print("whose information: ");
                String name = this.reader.nextLine();

                if(this.db.searchByName(name)) {
                    Person person = this.db.getPerson(name);
                    this.printPerson(person);

                } else {
                    System.out.println(" not found");
                }
            }

            if(command.equals("6")) {
                // remove information from db
                System.out.print("whose information: ");
                String name = this.reader.nextLine();

                if(this.db.searchByName(name)) {
                    this.db.removePerson(name);
                }
                System.out.println("");
            }

            if(command.equals("7")) {
                // filtered listing
                System.out.print("keyword (if empty, all listed): ");
                String keyword = this.reader.nextLine();

                if(keyword.equals("")) {
                    // show all users when keyword is empty
                    for(String p : this.db.getList().keySet()) {
                        System.out.println(" " + p);
                        Person person = this.db.getPerson(p);
                        this.printPerson(person);
                    }

                } else if(!keyword.equals("")) {
                    // search keyword and not found
                    if(this.db.searchByKeyWord(keyword).size() <= 0) {
                        System.out.println(" keyword not found");
                        System.out.println("");

                    } else {
                        // search keyword and found results
                        Set<String> result = this.db.searchByKeyWord(keyword);
                        List<String> sortedResult = new ArrayList<String>(result);
                        Collections.sort(sortedResult);

                        for (String name : sortedResult) {
                            Person record =  this.db.getPerson(name);
                            System.out.println(" " + record.getName());
                            this.printPerson(record);
                        }
                    }

                }
            }
        }
    }

    public void printPerson(Person person) {

        // get address
        if(person.getAddress().size() <= 0) {
            System.out.println("  address unknown");
        } else {
            System.out.println("  address: ");
            for(String a : person.getAddress()) {
                System.out.println("  " + a);
            }
        }

        // get phone
        if(person.getPhoneNumber().size() <= 0) {
            System.out.println("  phone number not found");
        } else {
            System.out.println("  phone numbers:");
            for(String n : person.getPhoneNumber()) {
                System.out.println("  " + n);
            }
        }
        System.out.println("");
    }

    public void start() {
        this.instructions();
        this.startSearch();
    }
}