import java.util.ArrayList;

public class Phonebook {
    private ArrayList<Person> list;

    public Phonebook() {
        this.list = new ArrayList<Person>();
    }

    public void add(String name, String number) {
        this.list.add(new Person(name, number));
    }

    public void printAll() {
        for (Person p: this.list) {
            System.out.println(p);
        }
    }

    public String searchNumber(String name) {
        String number = "";
        for (Person p: this.list) {
            if(p.getName().contains(name)) {
                number = p.getNumber();
            }
        }

        if(number.isEmpty()) {
            return "number not known";
        } else {
            return number;
        }

    }
}